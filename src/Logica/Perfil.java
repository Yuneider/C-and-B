package Logica;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

// Autor Jhony Caro
public class  Perfil implements Serializable{
    
    // Atributos 
    public String nombre;
    public Calendar fecha_nacimiento;
    public String correo;
    public String contrasena;
    public boolean rol; // True->Admi // False->Usuario
    public boolean[] preferencias;
    
    public Perfil(String nombre, Calendar fecha_nacimiento, String correo, String Contrasena, boolean rol) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.contrasena = Contrasena;
        this.rol = rol;
        preferencias = new boolean[6];
        for (int i=0;i<preferencias.length;i++){
            this.preferencias[i]=false;
        }
    }
    
    public Perfil() {
        this.nombre = "";
        this.fecha_nacimiento = new GregorianCalendar(1,Calendar.JANUARY,2000);
        this.correo = "";
        this.contrasena = "";
        this.rol = false;
        
    }
    
    
    
}
