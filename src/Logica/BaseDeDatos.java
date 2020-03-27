package Logica;

import INTERFAZ.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BaseDeDatos {
        
    private ArrayList<Perfil> perfiles;
    private int pos_u;
    public ArrayList<Elements> lista;
    public Estadisticas estad = new Estadisticas();
    
    public BaseDeDatos() throws InterruptedException, IOException{
        Recuperar();
        MostrarPerfiles();
        IniciarSesion("","");
    }
    
    public void MostrarPerfiles(){
        for(int i=0;i<perfiles.size();i++){
            System.out.println(perfiles.get(i).correo);
            System.out.println(perfiles.get(i).contrasena);
            System.out.println(perfiles.get(i).rol);
            System.out.println("");
        }
    }
    
    public void IniciarSesion(String correo,String contrasena) throws InterruptedException, IOException{
        GUI_inicio IS = new GUI_inicio(correo,contrasena);
        int posicion;
        do{
            Thread.sleep(100);
        }while(IS.estado==0);
        posicion = BuscarPorCorreo(IS.correo);
        switch (IS.estado){
            case 1:
                if (posicion!=-1){
                    if (IS.contrasena.equals(perfiles.get(posicion).contrasena)){
                        if (perfiles.get(posicion).rol==true){
                            InformacionA(perfiles.get(pos_u));
                        }
                        else{   
                            InformacionC(perfiles.get(pos_u));
                        }
                    }
                    else{
                        estad.estad_Errores[0]++;
                        JOptionPane.showMessageDialog(null , "La contraseña no coincide" , "ERROR DE INGRESO" , JOptionPane.ERROR_MESSAGE);
                        IniciarSesion(IS.correo,"");
                    }
                }
                else{
                    estad.estad_Errores[0]++;
                    JOptionPane.showMessageDialog(null , "El correo ingresado no existe" , "ERROR DE INGRESO" , JOptionPane.ERROR_MESSAGE);
                    IniciarSesion("","");
                }
            break;    
            case 2:
                Registrarse("","","");
            break;
            case 3:
                RecuperarContrasena();
            break;    
        }
    }    
    
    //BUSCA LA POSOCION DEL PERFIL Q TENGA EL MISMO CORREO
    public int BuscarPorCorreo(String correo){
        int result=-1;
        for (int i =0;i<perfiles.size();i++){
            if(perfiles.get(i).correo.equals(correo)){
                result=i;
            }
        }
        pos_u=result;
        return result;
    }
    
    public void Registrarse(String nombre,String apellido,String correo) throws InterruptedException, IOException{
        GUI_registrar r = new GUI_registrar(nombre,apellido,correo);
        int posicion;
        do{
            Thread.sleep(100);
        }while(r.estado==0);
        posicion = BuscarPorCorreo(r.correo);
        if(r.estado==1){
            if(r.correo.equals("") || r.contrasena_1.equals("") || r.contrasena_2.equals("") || r.nombre.equals("")){
                estad.estad_Errores[1]++;
                JOptionPane.showMessageDialog(null , "Faltan campos obligatorios" , "ERROR DE REGISTRO" , JOptionPane.ERROR_MESSAGE);
                Registrarse(r.nombre,r.apellido,r.correo);
            }
            else{
                if (posicion==-1){
                    boolean validar= ValidarFechas(r.dia_nacimiento,r.mes_nacimiento,r.anno_nacimiento);
                    if(validar==false){
                        estad.estad_Errores[1]++;
                        JOptionPane.showMessageDialog(null , "La fecha ingresada no existe" , "ERROR DE REGISTRO" , JOptionPane.ERROR_MESSAGE);
                        Registrarse(r.nombre,r.apellido,r.correo);
                    }
                    if(r.contrasena_1.equals(r.contrasena_2)){
                        perfiles.add(new Usuario(r.nombre,OrganizarCalendar(r.dia_nacimiento,r.mes_nacimiento,r.anno_nacimiento),r.correo,r.contrasena_1));
                        estad.estad_Generales[1]++;
                        Guardar();
                        IniciarSesion(r.correo,r.contrasena_1);
                    }else{
                        estad.estad_Errores[1]++;
                        JOptionPane.showMessageDialog(null , "Las contraseñas no coinciden" , "ERROR DE REGISTRO" , JOptionPane.ERROR_MESSAGE);
                        Registrarse(r.nombre,r.apellido,r.correo);
                    }   
                }
                else{
                    estad.estad_Errores[1]++;
                    JOptionPane.showMessageDialog(null , "El correo ingresado ya se encuentra registrado" , "ERROR DE REGISTRO" , JOptionPane.ERROR_MESSAGE);
                    IniciarSesion(r.correo,"");
                }         
            }    
        }
        if(r.estado==2){
            IniciarSesion("","");
        }
    }
    
    public void InformacionC(Perfil p) throws InterruptedException, IOException{
        GUI_cliente c = new GUI_cliente(perfiles.get(pos_u));
        do{    
            do{
                Thread.sleep(100);
            }while(c.estado==0);
            switch (c.estado){
                case 1:
                    Guardar();
                break;    
                case 2:
                    IniciarSesion(c.correo,"");
                break;
                case 3:
                    CambiarContrasena("");
                break;    
            }
            c.estado=0;
        }while(c.estado!=2);    
    }
    
    public void InformacionA(Perfil p) throws InterruptedException, IOException{
        GUI_administrador a = new GUI_administrador(perfiles.get(pos_u));
        do{
            Thread.sleep(100);
        }while(a.estado==0);
        switch(a.estado){
            case 1://ELIMINAR USUARIO   
                EliminarCuenta(a.correo_eliminar);
                pos_u=BuscarPorCorreo(a.correo);
                InformacionA(perfiles.get(pos_u));
                break;
            case 2://SCRAPEAR
                Extractor e = new Extractor();
                lista=e.Lista;
                InformacionA(perfiles.get(pos_u));
                break;
            case 3://VER ESTADISTICAS
                RecuperarEstadisticas();
                GUI_VerEstadisticas ve = new GUI_VerEstadisticas(estad.estad_Edades, estad.estad_Categorias, estad.estad_Errores, estad.estad_Generales);
                InformacionA(perfiles.get(pos_u));
                break;
            case 4://CERRAR SESION
                IniciarSesion(a.correo,"");
                break;
            case 5://ENVIAR CORREOS
                break;
            case 6://RECOLECTAR ESTADISTICAS
                estad.RecolectarEstadisticas(perfiles);
                GuardarEstadisticas();
                break;
        }
    }
    
    public void EliminarCuenta(String correo){
        int posicion = BuscarPorCorreo(correo);
        if (posicion==-1){
            estad.estad_Errores[3]++;
            JOptionPane.showMessageDialog(null , "El correo "+correo+" no se encuentra en la base de datos." , "ELIMINAR USUARIO" , JOptionPane.ERROR_MESSAGE);
        }
        else{
            perfiles.remove(posicion);
            estad.estad_Generales[2]++;
            JOptionPane.showMessageDialog(null , "La cuenta "+correo+" fue eliminada satisfactoriamente." , "ELIMINAR USUARIO" , JOptionPane.ERROR_MESSAGE);
            Guardar();
        }
    }
    
    public void CambiarContrasena(String ca) throws InterruptedException, IOException, IOException{
        GUI_CambiarContrasena cc = new GUI_CambiarContrasena(ca);
        do{
            Thread.sleep(100);
        }while(cc.estado==0);
        if(cc.contrasena_a.equals(perfiles.get(pos_u).contrasena)){
            if(cc.contrasena1.equals(cc.contrasena2)){
                perfiles.get(pos_u).contrasena=cc.contrasena1;
                JOptionPane.showMessageDialog(null , "La contraseña se modifico correctaente" , "CAMBIO DE CONTRASEÑA" , JOptionPane.PLAIN_MESSAGE);   
                Guardar();
                IniciarSesion(perfiles.get(pos_u).correo,"");
            }
            else{
                estad.estad_Errores[4]++;
                JOptionPane.showMessageDialog(null , "Las contraseñas ingresadas no coinciden" , "ERROR DE VERIFICACIÓN" , JOptionPane.ERROR_MESSAGE);
                CambiarContrasena(ca);
            }    
        }    
        else{
            estad.estad_Errores[4]++;
            JOptionPane.showMessageDialog(null , "La contraseña anterior no coincide" , "ERROR DE AUTENTICACION" , JOptionPane.ERROR_MESSAGE);
            CambiarContrasena("");
        }    
    }
    
    public String GenerarNumeroAleatorio(){
        String cod="";
        for(int i=1;i<=5;i++){
            cod+=String.valueOf((int) (Math.random()*10));
        }
        return cod;
    }
    
    public void RecuperarContrasena() throws InterruptedException, IOException{
        GUI_RecuperarContrasena rc = new GUI_RecuperarContrasena();
        do{
            Thread.sleep(100);
        }while(rc.estado==0);
        int posicion = BuscarPorCorreo(rc.correo);
        String codigo = GenerarNumeroAleatorio();
        if (posicion!=-1){
            EnviarCorreo(rc.correo,"Apreciado usuario.\n\nSu código de verificación es: "+codigo+"\n\nFavor ingreselo en la App para recuperar su cuenta","C&B-Olvide mi contraseña");
            do{
                do{    
                    Thread.sleep(100);
                }while(rc.estado==1);
                if(rc.codigo_verificacion.equals(codigo)){
                    rc.dispose();
                    CambiarContrasena(perfiles.get(pos_u).contrasena);
                }
                else{
                    estad.estad_Errores[2]++;
                    JOptionPane.showMessageDialog(null , "El código de verificacion no coincide" , "ERROR DE VERIFICACIÓN" , JOptionPane.ERROR_MESSAGE);
                    rc.estado=1;
                }
            }while(!rc.codigo_verificacion.equals(codigo)); 
        }
        else{
            estad.estad_Errores[2]++;
            JOptionPane.showMessageDialog(null , "El correo ingresado no existe en la base de datos" , "ERROR DE AUTENTICACIÓN" , JOptionPane.ERROR_MESSAGE);
            rc.dispose();
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
            
            estad.estad_Generales[0]++;
            
            //JOptionPane.showMessageDialog(null, "Listo, revise su correo","PROCESO CULMINADO",JOptionPane.PLAIN_MESSAGE);
            
        } catch (MessagingException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Guardar(){
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
    
    public void Recuperar(){
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

    public boolean ValidarFechas(String d, String m, String a){
        boolean fecha=true;
        switch(m){
            case "Febrero":
                if ((Integer.parseInt(a)%4==0) && ((Integer.parseInt(a)%100!=0) || (Integer.parseInt(a)%400==0))){
                    if(Integer.parseInt(d)<=29){
                        fecha=true;
                    }else{
                        fecha=false;
                    }
                }else{
                    if(Integer.parseInt(d)<=28){
                        fecha=true;
                    }else{
                        fecha=false;
                    }
                }
                break;
            case "Abril":
                if(Integer.parseInt(d)<=30){
                        fecha=true;
                    }else{
                        fecha=false;
                    }
                break;
            case "Junio":
                if(Integer.parseInt(d)<=30){
                        fecha=true;
                    }else{
                        fecha=false;
                    }
                break;    
            case "Septiembte":
                if(Integer.parseInt(d)<=30){
                        fecha=true;
                    }else{
                        fecha=false;
                    }
                break;
            case "Noviembre":
                if(Integer.parseInt(d)<=30){
                        fecha=true;
                    }else{
                        fecha=false;
                    }
                break;   
        }
        return fecha;
    }
    
    public Calendar OrganizarCalendar(String d, String m, String a){
        Calendar fecha_nacimiento= new GregorianCalendar(2000,Calendar.JANUARY,1);
        switch(m){
            case "Enero":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.JANUARY,Integer.parseInt(d));
                break;
            case "Febrero":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.FEBRUARY,Integer.parseInt(d));
                break;
            case "Marzo":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.MARCH,Integer.parseInt(d));
                break;
            case "Abril":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.APRIL,Integer.parseInt(d));
                break;
            case "Mayo":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.MAY,Integer.parseInt(d));
                break;
            case "Junio":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.JUNE,Integer.parseInt(d));
                break;    
            case "Julio":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.JULY,Integer.parseInt(d));
                break;    
            case "Agosto":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.AUGUST,Integer.parseInt(d));
                break;
            case "Septiembte":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.SEPTEMBER,Integer.parseInt(d));
                break;
            case "Octubre":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.OCTOBER,Integer.parseInt(d));
                break;
            case "Noviembre":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.NOVEMBER,Integer.parseInt(d));
                break;
            case "Diciembre":
                fecha_nacimiento = new GregorianCalendar(Integer.parseInt(a),Calendar.DECEMBER,Integer.parseInt(d));
                break;    
        }
        return fecha_nacimiento;
    }    
    
    public void GuardarEstadisticas(){
        String archivo = "Estadisticas.txt";
        try{
            ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(archivo));
            ob.writeObject(estad);
            ob.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }   
    }
    
    public void RecuperarEstadisticas(){
        String archivo = "Estadisticas.txt";
        estad = new Estadisticas();
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(archivo));
            estad = (Estadisticas) is.readObject(); 
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }    
    }
    
    //CONVENCIONES DE ERRORES
//    0=errores de Ingreso
//    1=errores de Registro
//    2=errores de RecuperarContrasena
//    3=errores de EliminarCorreo
//    4=errores de CambiarContrasena
    
    //CONVENCIONES DE EDADES
//    0=primera infancia
//    1=infancia
//    2=adolescencia
//    3=juventud
//    4=adultez  
//    5=persona mayor
    
    //CONVENCIONES DE CATEGORIAS
//    0=celulares
//    1=vehiculos
//    2=deportes
//    3=videojuegos
//    4=computacion
//    5=oficina
    
    //CONVENCIONES DE ESTADISTICAS GENEREALES
//    0= correos enviados tanto para recuperar contraseña cm para los q tienen la info de ML
//    1= usuarios registrados
//    2= usuarios eliminados   
}
