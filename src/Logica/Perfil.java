package Logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

// Autor Jhony Caro
public class  Perfil implements Serializable{
    
    // Atributos 
    public String nombre;
    public Calendar fecha_nacimiento;
    public String correo;
    public String Contrasena;
    public boolean rol; // True->Admi // False->Usuario
    
    // Constructor parametrico
    public Perfil(String nombre, Calendar fecha_nacimiento, String correo, String Contrasena, boolean rol) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.Contrasena = Contrasena;
        this.rol = rol;
    }
  
    // Consytructor por defecto
    public Perfil() {
        this.nombre = "";
        this.fecha_nacimiento = new GregorianCalendar(1,Calendar.JANUARY,1);// day=1 , mes=0 , año=1 es lo q se crea por defecto
        this.correo = "";
        this.Contrasena = "";
        this.rol = false;
    }
    
}
