package Logica;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
    
public class Admi extends Perfil{
    
    //Constructor por defecto
    public Admi(){
        this.nombre = "";
        this.fecha_nacimiento = new GregorianCalendar(1,Calendar.JANUARY,1);
        this.correo = "";
        this.Contraseña = "";
        this.rol = true;
    }
    
    //Constructor parametrico
    public Admi(String nombre, Calendar fecha_nacimiento, String correo, String Contraseña) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.Contraseña = Contraseña;
        this.rol = true;
    }
}
