package Logica;

import Grafica.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class BaseDeDatos {
        
    //ARREGLO DE PERFILES RECUPERADOS
    private static ArrayList<Perfil> perfiles;
    
    public BaseDeDatos(){
        Recuperar();
        System.out.println(perfiles.get(0).correo);
        System.out.println(perfiles.get(0).Contrasena);
        IniciarSesion();
    }
    
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
    
    public static void IniciarSesion(){
        boolean ingreso=false;
        do{
            int posicion=-1;
            IniciarSesion IS = new IniciarSesion();
            do{
                posicion = BuscarPorCorreo(IS.usuario);
            }while(IS.usuario==null || IS.contrasena==null);
            if (posicion!=-1){
                if(perfiles.get(posicion).Contrasena.equals(IS.contrasena)){
                    VerInfoPersonal vip = new VerInfoPersonal();
                    ingreso=true;
                }else{
                    JOptionPane.showMessageDialog(null , "La contraseña no coincide" , "ERROR DE INGRESO" , JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null , "El correo ingresado no existe" , "ERROR DE INGRESO" , JOptionPane.ERROR_MESSAGE);
            }
        }while(ingreso==false);
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
    
    //JHONY AQUÍ HAY UN PROBLEMA, ME SALE ERROR AL PONER EL ARRAYLIST DE PREFERENCIAS 
//    public static void Registrarse(String nombre,String correo,String contrasena,Calendar fecha_nacimiento/*,ArrayList<boolean> preferencias*/){
//        Guardar(nombre,correo,contrasena,fecha_nacimiento,false);
//    }
    
    public static void EliminarCuenta(String correo){
        int posicion = BuscarPorCorreo(correo);
        perfiles.remove(posicion);
    }
    
    //UTILIZA VARIOS MÉTODOS DE ABAJO PARA Q NO QUEDE TAN LARGO EN UN SOLO LADO 
    public static void CambiarContrasena(){
        //llamar a la interfaz para q el usuario meta el correo
        String correo="";//retornado por la interfaz
        int posicion = BuscarPorCorreo(correo);
        String codigo = GenerarNumeroAleatorio();
        String mensaje ="";
        String asunto="Codigo de veridifcacion";
        EnviarCorreo(correo,mensaje,asunto);
        //llamar interfaz para q meta el codigo
        String cod = "";//retornado por la intefaz
        if(cod.equals(codigo)){
            //llamar interfaz para meter nueva contraseña
            String nuevaContrasena ="";//retornado por la interfaz
            perfiles.get(posicion).Contrasena=nuevaContrasena;
        }else{
            //intentelo de nuevo
        }
            
        
    }
    
    public static String GenerarNumeroAleatorio(){
        String cod="";
        for(int i=1;i<=5;i++){
            cod+=String.valueOf((int) (Math.random()*10));
        }
        return cod;
    }
    
    public static void EnviarCorreo(String correo,String mensaje, String asunto){
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "compareandbuy2020@gmail.com";
        String contrasena = "compareandbuy";
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia,contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            
            JOptionPane.showMessageDialog(null, "Listo, revise su correo");
            
        } catch (MessagingException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void VerInfoPersonal(){
    }
    
    public static void RecuperarContrasena(){
    }
}
