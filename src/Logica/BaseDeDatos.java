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
        
    private ArrayList<Perfil> perfiles;
    private int pos_u;
    private Estadisticas estadisticas;
    private Extractor extrac;
    
    public BaseDeDatos() throws InterruptedException, IOException{
        Recuperar();
        IniciarSesion("","");
    }

    public void IniciarSesion(String correo,String contrasena) throws InterruptedException, IOException{
        GUI_inicio IS = new GUI_inicio(correo,contrasena);
        int posicion;
        do{
            Thread.sleep(100);
        }while(IS.estado==0);
        switch (IS.estado){
            case 1:
                posicion = BuscarPorCorreo(IS.correo);
                if (posicion!=-1){
                    if (IS.contrasena.equals(perfiles.get(posicion).contrasena)){
                        if (perfiles.get(posicion).rol==true){
                            InformacionA(perfiles.get(pos_u),0,estadisticas);
                        }
                        else{   
                            InformacionC(perfiles.get(pos_u));
                        }
                    }
                    else{
                        estadisticas.estad_Errores[0]++;
                        Guardar();
                        JOptionPane.showMessageDialog(null , "La contraseña no coincide" , "ERROR DE INGRESO" , JOptionPane.ERROR_MESSAGE);
                        IniciarSesion(IS.correo,"");
                    }
                }
                else{
                    estadisticas.estad_Errores[0]++;
                    Guardar();
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
    
    public int BuscarPorCorreo(String correo){
        int result=-1;
        for (int i =0;i<perfiles.size();i++){
            if(perfiles.get(i).correo.equals(correo.toLowerCase())){
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
        if(r.estado==1){
            posicion = BuscarPorCorreo(r.correo);
            if(r.correo.equals("") || r.contrasena_1.equals("") || r.contrasena_2.equals("") || r.nombre.equals("")){
                estadisticas.estad_Errores[1]++;
                Guardar();
                JOptionPane.showMessageDialog(null , "Faltan campos obligatorios" , "ERROR DE REGISTRO" , JOptionPane.ERROR_MESSAGE);
                Registrarse(r.nombre,r.apellido,r.correo);
            }
            else{
                if (posicion==-1){
                    boolean validar= ValidarFechas(r.dia_nacimiento,r.mes_nacimiento,r.anno_nacimiento);
                    if(validar==false){
                        estadisticas.estad_Errores[1]++;
                        Guardar();
                        JOptionPane.showMessageDialog(null , "La fecha ingresada no existe" , "ERROR DE REGISTRO" , JOptionPane.ERROR_MESSAGE);
                        Registrarse(r.nombre,r.apellido,r.correo);
                    }
                    if(r.contrasena_1.equals(r.contrasena_2)){
                        perfiles.add(new Usuario(r.nombre+" "+r.apellido,OrganizarCalendar(r.dia_nacimiento,r.mes_nacimiento,r.anno_nacimiento),r.correo,r.contrasena_1));
                        Guardar();
                        IniciarSesion(r.correo,r.contrasena_1);
                    }else{
                        estadisticas.estad_Errores[1]++;
                        Guardar();
                        JOptionPane.showMessageDialog(null , "Las contraseñas no coinciden" , "ERROR DE REGISTRO" , JOptionPane.ERROR_MESSAGE);
                        Registrarse(r.nombre,r.apellido,r.correo);
                    }   
                }
                else{
                    estadisticas.estad_Errores[1]++;
                    Guardar();
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
    
    public void InformacionA(Perfil p,int e,Estadisticas es) throws InterruptedException, IOException{
        GUI_administrador a = new GUI_administrador(perfiles.get(pos_u),e,estadisticas);
        do{
            Thread.sleep(100);
        }while(a.estado==0);
        switch(a.estado){
            case 1:
                EliminarCuenta(a.correo_eliminar);
                pos_u=BuscarPorCorreo(a.correo);
                InformacionA(perfiles.get(pos_u),e,estadisticas);
            break;
            case 2:
                JOptionPane.showMessageDialog(null , "Espere aproximadamente un minuto\nhasta que se obtenga la informacion" , "SCRAPING" , JOptionPane.INFORMATION_MESSAGE);
                extrac = new Extractor();
                InformacionA(perfiles.get(pos_u),2,estadisticas);
            break;
            case 3:
                estadisticas.RecolectarInfo(perfiles);
                GUI_VerEstadisticas ve = new GUI_VerEstadisticas(estadisticas);
                do{
                    Thread.sleep(100);
                }while(ve.estado==0);
                InformacionA(perfiles.get(pos_u),e,estadisticas);
            break;
            case 4:
                IniciarSesion(a.correo,"");
            break;
            case 5:
                MensajesUsuarios();
                Guardar();
                InformacionA(perfiles.get(pos_u),e,estadisticas);
            break;
            case 6:
                GUI_lista lista = new GUI_lista(perfiles);
                do{
                    Thread.sleep(100);
                }while(lista.estado==0);
                InformacionA(perfiles.get(pos_u),e,estadisticas);
            break;    
        }
    }
    
    public void EliminarCuenta(String correo){
        int posicion = BuscarPorCorreo(correo);
        if (posicion==-1){
            estadisticas.estad_Errores[3]++;
            Guardar();
            JOptionPane.showMessageDialog(null , "El correo "+correo+" no se encuentra en la base de datos." , "ELIMINAR USUARIO" , JOptionPane.ERROR_MESSAGE);
        }
        else{
            perfiles.remove(posicion);
            estadisticas.estad_Generales[2]++;
            JOptionPane.showMessageDialog(null , "La cuenta "+correo+" fue eliminada satisfactoriamente." , "ELIMINAR USUARIO" , JOptionPane.ERROR_MESSAGE);
            Guardar();
        }
    }
    
    public void CambiarContrasena(String ca) throws InterruptedException, IOException, IOException{
        GUI_CambiarContrasena cc = new GUI_CambiarContrasena(ca);
        do{
            Thread.sleep(100);
        }while(cc.estado==0);
        if(cc.estado==2){
            InformacionC(perfiles.get(pos_u));
        }
        else{
            if(cc.contrasena_a.equals(perfiles.get(pos_u).contrasena)){
                if(cc.contrasena1.equals(cc.contrasena2)){
                    perfiles.get(pos_u).contrasena=cc.contrasena1;
                    JOptionPane.showMessageDialog(null , "La contraseña se modifico correctamente" , "CAMBIO DE CONTRASEÑA" , JOptionPane.PLAIN_MESSAGE);   
                    Guardar();
                    IniciarSesion(perfiles.get(pos_u).correo,"");
                }
                else{
                    estadisticas.estad_Errores[4]++;
                    Guardar();
                    JOptionPane.showMessageDialog(null , "Las contraseñas ingresadas no coinciden" , "ERROR DE VERIFICACIÓN" , JOptionPane.ERROR_MESSAGE);
                    CambiarContrasena(ca);
                }    
            }    
            else{
                estadisticas.estad_Errores[4]++;
                Guardar();
                JOptionPane.showMessageDialog(null , "La contraseña anterior no coincide" , "ERROR DE AUTENTICACION" , JOptionPane.ERROR_MESSAGE);
                CambiarContrasena("");
            }    
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
        if(rc.estado==3){
            IniciarSesion("","");
        }
        else{
            int posicion = BuscarPorCorreo(rc.correo);
            String codigo = GenerarNumeroAleatorio();
            if (posicion!=-1){
                EnviarCorreo(rc.correo,"Apreciado usuario.\n\nSu código de verificación es: "+codigo+"\n\nFavor ingreselo en la App para recuperar su cuenta","C&B-Olvide mi contraseña");
                do{
                    do{    
                        Thread.sleep(100);
                    }while(rc.estado==1);
                    if (perfiles.get(pos_u).rol==true){
                        JOptionPane.showMessageDialog(null , "Por la seguridad de C&B los Administradores\n no pueden reestablecer la contraseña" , "ERROR" , JOptionPane.ERROR_MESSAGE);
                        rc.dispose();
                        IniciarSesion(rc.correo,"");
                    }
                    else{
                        if(rc.codigo_verificacion.equals(codigo)){
                            rc.dispose();
                            CambiarContrasena(perfiles.get(pos_u).contrasena);
                        }
                        else{
                            estadisticas.estad_Errores[2]++;
                            Guardar();
                            JOptionPane.showMessageDialog(null , "El código de verificacion no coincide" , "ERROR DE VERIFICACIÓN" , JOptionPane.ERROR_MESSAGE);
                            rc.estado=1;
                        }
                    }
                }while(!rc.codigo_verificacion.equals(codigo)); 
            }
            else{
                estadisticas.estad_Errores[2]++;
                Guardar();
                JOptionPane.showMessageDialog(null , "El correo ingresado no existe en la base de datos" , "ERROR DE AUTENTICACIÓN" , JOptionPane.ERROR_MESSAGE);
                rc.dispose();
                RecuperarContrasena();
            }
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
            
            estadisticas.estad_Generales[0]++;
            Guardar();
            
        } catch (MessagingException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Guardar(){
        String archivo_u = "Usuarios.txt";
        String archivo_e = "Estadisticas.txt";
        try{
            ObjectOutputStream ob_u = new ObjectOutputStream(new FileOutputStream(archivo_u));
            ob_u.writeObject(perfiles);
            ob_u.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        try{
            ObjectOutputStream ob_e = new ObjectOutputStream(new FileOutputStream(archivo_e));
            ob_e.writeObject(estadisticas);
            ob_e.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void Recuperar(){
        String archivo_u = "Usuarios.txt";
        String archivo_e = "Estadisticas.txt";
        perfiles = new ArrayList<Perfil>();
        estadisticas = new Estadisticas();
        try{
            ObjectInputStream is_u = new ObjectInputStream(new FileInputStream(archivo_u));
            perfiles = (ArrayList<Perfil>) is_u.readObject(); 
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            ObjectInputStream is_e = new ObjectInputStream(new FileInputStream(archivo_e));
            estadisticas = (Estadisticas) is_e.readObject(); 
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

    public void MensajesUsuarios(){
        for(int i=0;i<perfiles.size();i++){
            if (perfiles.get(i).preferencias[6]==true && perfiles.get(i).rol==false){
                int total = ValidarNumeroPreferencias(perfiles.get(i)), cant=0,rand;   
                String mensajeF="Hola "+perfiles.get(i).nombre+", Para nosotros es un placer informarte que encontramos una lista de productos que podrian interesarte:";
                if (total==18 || total==15)
                    cant=3;
                if (total==16 || total==12)
                    cant=4;
                if(total==10)
                    cant=5;
                if(total==8)
                    cant=8;
                if(perfiles.get(i).preferencias[0]==true){
                    mensajeF+="\n\nCelulares:\n";
                    for (int j=0;j<cant;j++){
                        rand = extrac.NumeroRandom(extrac.celulares.size());
                        mensajeF+="\n"+(j+1)+") "+extrac.celulares.get(rand);
                    }
                }
                if(perfiles.get(i).preferencias[1]==true){
                    mensajeF+="\n\nVehiculos:\n";
                    for (int j=0;j<cant;j++){
                        rand = extrac.NumeroRandom(extrac.vehiculos.size());
                        mensajeF+="\n"+(j+1)+") "+extrac.vehiculos.get(rand);
                    }
                }
                if(perfiles.get(i).preferencias[2]==true){
                    mensajeF+="\n\nDeportes:\n";
                    for (int j=0;j<cant;j++){
                        rand = extrac.NumeroRandom(extrac.deportes.size());
                        mensajeF+="\n"+(j+1)+") "+extrac.deportes.get(rand);
                    }
                }
                if(perfiles.get(i).preferencias[3]==true){
                    mensajeF+="\n\nVideo juegos:\n";
                    for (int j=0;j<cant;j++){
                        rand = extrac.NumeroRandom(extrac.videojuegos.size());
                        mensajeF+="\n"+(j+1)+") "+extrac.videojuegos.get(rand);
                    }
                }            
                if(perfiles.get(i).preferencias[4]==true){
                    mensajeF+="\n\nComputación:\n";
                    for (int j=0;j<cant;j++){
                        rand = extrac.NumeroRandom(extrac.computacion.size());
                        mensajeF+="\n"+(j+1)+") "+extrac.computacion.get(rand);
                    }
                }        
                if(perfiles.get(i).preferencias[5]==true){
                    mensajeF+="\n\nOficina:\n";
                    for (int j=0;j<cant;j++){
                        rand = extrac.NumeroRandom(extrac.oficina.size());
                        mensajeF+="\n"+(j+1)+") "+extrac.oficina.get(rand);
                    }
                }                    
                mensajeF+="\n\nCOMPARE & BUY\n\n\nSi deseas dejar de recibir notificaciones ingresa a la App y deshabilita la opcion de \"Recibir notificaciones\", Gracias.";
                EnviarCorreo(perfiles.get(i).correo,mensajeF,"C&B-Notificacion de productos de interes");
                estadisticas.estad_Generales[0]++;
            }
        }
        Calendar actual = Calendar.getInstance();
        estadisticas.actualizacion=actual;
    }
    
    public int ValidarNumeroPreferencias(Perfil p){
        int cant=0,total=0;
        for(int i=0;i<6;i++){
            if(p.preferencias[i]==true){
                cant++;
            }
        }
        switch (cant){
            case 1:
                total=8;
            break;    
            case 2:
                total=10;
            break;
            case 3:
                total=12;
            break;
            case 4:
                total=12;
            break;
            case 5:
                total=15;
            break;
            case 6:
                total=18;
            break;
        }
        return total;
    }
        public void MostrarPerfiles(){
        for(int i=2;i<perfiles.size();i++){
            System.out.println("Correo: "+perfiles.get(i).correo);
            System.out.println("Contraseña: "+perfiles.get(i).contrasena);
        }
    }
}
