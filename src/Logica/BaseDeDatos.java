package Logica;

import INTERFAZ.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BaseDeDatos {
        
    private static ArrayList<Perfil> perfiles;
    private static int pos_u;
    
    public BaseDeDatos() throws InterruptedException{
        Recuperar();
        IniciarSesion("","");
    }
    
    public static void IniciarSesion(String correo,String contrasena) throws InterruptedException{
        GUI_inicio IS = new GUI_inicio(correo,contrasena);
        int posicion;
        do{
            Thread.sleep(100);
        }while(IS.estado==0);
        posicion = BuscarPorCorreo(IS.correo);
        if(IS.estado==1){    
            if (posicion!=-1){
                if (IS.contrasena.equals(perfiles.get(posicion).contrasena)){
                    pos_u= posicion;
                    if (perfiles.get(posicion).rol==true){
                        InformacionA(perfiles.get(pos_u));
                    }
                    else{   
                        InformacionC(perfiles.get(pos_u));
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null , "La contraseña no coincide" , "ERROR DE INGRESO" , JOptionPane.ERROR_MESSAGE);
                    IniciarSesion(correo,contrasena);
                }
            }
            else{
                JOptionPane.showMessageDialog(null , "El correo ingresado no existe" , "ERROR DE INGRESO" , JOptionPane.ERROR_MESSAGE);
                IniciarSesion(correo,contrasena);
            }
        }
        else{
            Registrarse();
        }
    }    
    
    //BUSCA LA POSOCION DEL PERFIL Q TENGA EL MISMO CORREO
    public static int BuscarPorCorreo(String correo){
        int result=-1;
        for (int i =0;i<perfiles.size();i++){
            if(perfiles.get(i).correo.equals(correo)){
                result=i;
            }
        }
        return result;
    }
    
    public static void Registrarse() throws InterruptedException{
        GUI_registrar r = new GUI_registrar();
        int posicion;
        do{
            Thread.sleep(100);
        }while(r.estado==0);
        posicion = BuscarPorCorreo(r.correo);
        if(r.estado==1){
            if (posicion==-1){
                if(r.contrasena_1.equals(r.contrasena_2)){
                    perfiles.add(new Usuario(r.nombre,r.fecha_nacimiento,r.correo,r.contrasena_1));
                    Guardar();
                    IniciarSesion(r.correo,r.contrasena_1);
                }else{
                    JOptionPane.showMessageDialog(null , "Las contraseñas no coinciden" , "ERROR DE REGISTRO" , JOptionPane.ERROR_MESSAGE);
                    Registrarse();
                }   
            }
            else{
                JOptionPane.showMessageDialog(null , "El correo ingresado ya se encuentra registrado" , "ERROR DE REGISTRO" , JOptionPane.ERROR_MESSAGE);
                IniciarSesion("","");
            }
        }else{
            IniciarSesion("","");
        }
    }
    
    public static void InformacionC(Perfil p) throws InterruptedException{
        GUI_cliente c = new GUI_cliente(perfiles.get(pos_u));
        do{
            Thread.sleep(100);
        }while(c.estado==0);
        if (c.estado==1){
            IniciarSesion(c.correo,"");
        }
    }
    
    public static void InformacionA(Perfil p){
        GUI_administrador a = new GUI_administrador(perfiles.get(pos_u));
    }
    
    public static void EliminarCuenta(String correo){
        int posicion = BuscarPorCorreo(correo);
        perfiles.remove(posicion);
        Guardar();
    }
    
    public static void CambiarContrasena(){
           
        
    }
    
    public static String GenerarNumeroAleatorio(){
        String cod="";
        for(int i=1;i<=5;i++){
            cod+=String.valueOf((int) (Math.random()*10));
        }
        return cod;
    }
    
    
    
     //UTILIZA VARIOS MÉTODOS DE ABAJO PARA Q NO QUEDE TAN LARGO EN UN SOLO LADO 
 /*   public static void RecuperarContrasena(){
        RecuperarContraseña rc = new RecuperarContraseña();
        String correo=rc.correo;
        int posicion = BuscarPorCorreo(correo);
        String codigo = GenerarNumeroAleatorio();
        String mensaje ="";//FALTA LLENAR MENSAJE
        String asunto="Codigo de veridifcacion";
        EnviarCorreo(correo,mensaje,asunto);
        RecuperarContrasena_2 rc_2 = new RecuperarContrasena_2();
        String cod =rc_2.codigo_verificacion;
        if(cod.equals(codigo)){
            CambiarContrasena();
            //ESTOS 2 VAN EN CAMBIARCONTRASENA
            //String nuevaContrasena ="";//retornado por la interfaz
            //perfiles.get(posicion).Contrasena=nuevaContrasena;
        }else{
            RecuperarContrasena();
        }
         
    }*/
    
    public static void Guardar(){
        String archivo = "Usuarios.txt";
        try{
            ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(archivo));
            ob.writeObject(perfiles);
            ob.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }   
    }
    
    public static void Recuperar(){
        String archivo = "Usuarios.txt";
        perfiles = new ArrayList<Perfil>();
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(archivo));
            perfiles = (ArrayList<Perfil>) is.readObject(); 
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }    
    }
}
