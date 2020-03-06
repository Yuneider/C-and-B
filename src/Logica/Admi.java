package Logica;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admi extends Perfil{

    //Constructor por defecto
    public Admi(){
    this.nombre = "";
        try {
            this.fecha_nacimiento = sdf.parse("01-01-1998");
        } catch (ParseException ex) {
            Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.correo = "";
        this.Contraseña = "";
        this.rol = false;
    }
    
    //Constructor parametrico
    public Admi(String nombre, Date fecha_nacimiento, String correo, String Contraseña, boolean rol) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.Contraseña = Contraseña;
        this.rol = rol;
    }
}
