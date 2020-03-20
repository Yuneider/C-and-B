package Logica;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario extends Perfil{
    
    //Constructor por defecto
    public Usuario(){
        this.nombre="";
        this.Contrasena="";
        this.correo="";
        this.fecha_nacimiento = new GregorianCalendar(1,Calendar.JANUARY,1);
        this.rol=false;
    }
    
    // Constructor parametrico
    public Usuario(String nombre, Calendar fecha_nacimiento, String correo, String Contrasena) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.Contrasena = Contrasena;
        this.rol = false;
    }
    
}
    