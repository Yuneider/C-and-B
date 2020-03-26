package Logica;

import INTERFAZ.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
import org.jsoup.select.Elements;

public class BaseDeDatos {
        
    private static ArrayList<Perfil> perfiles;
    private static int pos_u;
    private static ArrayList<Elements> Lista;
    
    public BaseDeDatos() throws InterruptedException, IOException{
        Recuperar();
        MostrarPerfiles();
        IniciarSesion("","");
    }
    
    public static void MostrarPerfiles(){
        for(int i=0;i<perfiles.size();i++){
            System.out.println(perfiles.get(i).correo);
            System.out.println(perfiles.get(i).contrasena);
            System.out.println(perfiles.get(i).rol);
            System.out.println("");
        }
    }
    
    public static void IniciarSesion(String correo,String contrasena) throws InterruptedException, IOException{
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
    
    public static void Registrarse() throws InterruptedException, IOException{
        GUI_registrar r = new GUI_registrar();
        int posicion;
        do{
            Thread.sleep(100);
        }while(r.estado==0);
        posicion = BuscarPorCorreo(r.correo);
        if(r.fecha==false){
            Registrarse();
        }
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
        }
        if(r.estado==2){
            IniciarSesion("","");
        }
    }
    
    public static void InformacionC(Perfil p) throws InterruptedException, IOException{
        GUI_cliente c = new GUI_cliente(perfiles.get(pos_u));
        do{
            Thread.sleep(100);
        }while(c.estado==0);
        if (c.estado==1){
            IniciarSesion(c.correo,"");
        }
    }
    
    //REVISA ESTO PORFA JHONY
    public static void InformacionA(Perfil p) throws InterruptedException, IOException{
        GUI_administrador a = new GUI_administrador(perfiles.get(pos_u));
        do{
            Thread.sleep(100);
        }while(a.estado==0);
        switch(a.estado){
            case 1://ELIMINAR USUARIO   
                EliminarCuenta(a.correo_eliminar);
                InformacionA(perfiles.get(pos_u));
                break;
            case 2://SCRAPEAR
                Extractor e = new Extractor();
                Lista=e.Lista;
                InformacionA(perfiles.get(pos_u));
                break;
            case 3://VER ESTADISTICAS
                GUI_VerEstadisticas ve = new GUI_VerEstadisticas();
                InformacionA(perfiles.get(pos_u));
                break;
            case 4://CERRAR SESION
                IniciarSesion(a.correo,"");
                break;
        }
    }
    
    public static void EliminarCuenta(String correo){
        int posicion = BuscarPorCorreo(correo);
        perfiles.remove(posicion);
        Guardar();
    }
    
    public static void CambiarContrasena() throws InterruptedException, IOException, IOException{
        GUI_CambiarContrasena cc = new GUI_CambiarContrasena();
        if(cc.contrasena1.equals(cc.contrasena2)){
            perfiles.get(pos_u).contrasena=cc.contrasena1;
            JOptionPane.showMessageDialog(null , "Su contraseña ha sido modificada" , "PROCESO CULMINADO" , JOptionPane.PLAIN_MESSAGE);
            InformacionC(perfiles.get(pos_u));
        }else{
            JOptionPane.showMessageDialog(null , "las contraseñas ingresadas no coinciden" , "ERROR DE VERIFICACIÓN" , JOptionPane.ERROR_MESSAGE);
            CambiarContrasena();
        }
    }
    
    public static String GenerarNumeroAleatorio(){
        String cod="";
        for(int i=1;i<=5;i++){
            cod+=String.valueOf((int) (Math.random()*10));
        }
        return cod;
    }
    
    //UTILIZA VARIOS MÉTODOS DE ABAJO PARA Q NO QUEDE TAN LARGO EN UN SOLO LADO 
    public void RecuperarContrasena() throws InterruptedException, IOException{
        Controlador c = new Controlador();
        GUI_RecuperarContrasena rc = new GUI_RecuperarContrasena();
        String correo=rc.correo;
        int posicion = BuscarPorCorreo(correo);
        String codigo = GenerarNumeroAleatorio();
        String mensaje ="Apreciado usuario.\n\nSu código de verificación es el siguiente: "+codigo+"\n\nQue tenga un buen día.";
        String asunto="Codigo de veridifcacion";
        EnviarCorreo(correo,mensaje,asunto);
        JOptionPane.showMessageDialog(null , "Porfavor revise su correo" , "PROCESO CULMINADO" , JOptionPane.PLAIN_MESSAGE);
        GUI_RecuperarContrasena_2 rc_2 = new GUI_RecuperarContrasena_2();
        String cod =rc_2.codigo_verificacion;
        if(cod.equals(codigo)){
            CambiarContrasena();
        }else{
            JOptionPane.showMessageDialog(null , "El código ingresado no coincide con el que fué enviado a su correo" , "ERROR DE VERIFICACIÓN" , JOptionPane.ERROR_MESSAGE);
            RecuperarContrasena();
        }
         
    }
    
    public void EnviarCorreo(String correo,String mensaje, String asunto){
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
            
            JOptionPane.showMessageDialog(null, "Listo, revise su correo","PROCESO CULMINADO",JOptionPane.PLAIN_MESSAGE);
            
        } catch (MessagingException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    //REVISA ESTO PORFA JHONY
    public static void RecuperarScraper(){
        String archivo = "Scraping.txt";
        Lista = new ArrayList<Elements>();
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(archivo));
            Lista = (ArrayList<Elements>) is.readObject(); 
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }    
    }
}
