package Logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

//Autor Jhony Caro
public class Controlador{
    
    //ARREGLO DE PERFILES RECUPERADOS
    private static ArrayList<Perfil> perfiles;
    private static int tamano=1;
    
    public static void main(String[] args) {
        //CREAR ADMI
        Guardar("Jhony Alejandro Caro Umbariba","Jhonycaro1998@gmail.com","20191020055",new GregorianCalendar(2001,Calendar.OCTOBER,22),true);
        Registrarse("Yune","yune@holi.com","123",new GregorianCalendar(2001,Calendar.OCTOBER,22));
        Recuperar();
        IniciarSesion("yune@holi.com","123");
        
        
        
        /*Calendar fecha = new GregorianCalendar(2001,Calendar.OCTOBER,22);
        System.out.println(fecha.get(Calendar.MONTH));*/    
    }    
    
    public static void Guardar(String nombre,String correo,String contrasena,Calendar fecha_nacimiento,boolean rol){
        ArrayList<Perfil> perfiles1 = new ArrayList<Perfil>();
        for (int i =0;i<tamano;i++){
            perfiles1.add(new Perfil());
            perfiles1.get(i).nombre=nombre;
            perfiles1.get(i).correo=correo;   
            perfiles1.get(i).Contrasena=contrasena;
            perfiles1.get(i).fecha_nacimiento = fecha_nacimiento;
            perfiles1.get(i).rol=rol;
        }
        
        String archivo = "Usuarios.txt";
        try{
            ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(archivo));
            ob.writeObject(perfiles1);
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

    public static void IniciarSesion(String correo, String contrasena){
        int posicion = BuscarPorCorreo(correo);
        if(perfiles.get(posicion).Contrasena.equals(contrasena)){
            //PUEDE INGRESAR A LA CUENTA
            System.out.println("INGRESASTE");
        }else{
            //NO PUEDE INGRESAR A LA CUENTA XQ NO EL CORREO NGRESADO NO SE ENCUENTRA 
            //O LA CONTRASEÑA ES INCORRECTA
            //INTENTARLO DE NUEVO
            System.out.println("NO INGRESASTE");
        }
    }
    
    //BUSCA LA POSOCION DEL PERFIL Q TENGA EL MISMO CORREO
    public static int BuscarPorCorreo(String correo){
        int result=0;
        for (int i =0;i<tamano;i++){
            if(perfiles.get(i).correo.equals(correo)){
                result=i;
            }
        }
        return result;
    }
    
    //JHONY AQUÍ HAY UN PROBLEMA, ME SALE ERROR AL PONER EL ARRAYLIST DE PREFERENCIAS 
    public static void Registrarse(String nombre,String correo,String contrasena,Calendar fecha_nacimiento/*,ArrayList<boolean> preferencias*/){
        tamano++;
        Guardar(nombre,correo,contrasena,fecha_nacimiento,false);
    }
    
    public static void EliminarCuenta(){}
    
    public static void CambiarContrasenas(){}
    
    public static void VerInfoPersonal(){}
    
    public static void RecuperarContrasena(){}
}

