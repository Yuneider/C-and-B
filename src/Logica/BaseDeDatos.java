package Logica;

import Grafica.IniciarSesion;
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
    private static int tamano=1;
    
    public BaseDeDatos(){
        //Guardar("Yuneider","yune@holi.com","123",new GregorianCalendar(22,Calendar.OCTOBER,2001),true);
        Recuperar();
        IniciarSesion();
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

    public static void IniciarSesion(){
        IniciarSesion IS = new IniciarSesion();
        int posicion = BuscarPorCorreo(IS.usuario);
        if(perfiles.get(posicion).Contrasena.equals(IS.contrasena)){
             System.out.println("INGRESASTE");
        }else{
            System.out.println("NO INGRESASTE");
        }
    }
    
    //BUSCA LA POSOCION DEL PERFIL Q TENGA EL MISMO CORREO
    public static int BuscarPorCorreo(String correo){
        int result=0;
        for (int i =0;i<tamano;i++){
            if(perfiles.get(i).nombre.equals(correo)){
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
    
    public static void EliminarCuenta(String correo){
        tamano--;
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
