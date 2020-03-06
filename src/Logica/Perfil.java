package Logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;

// Autor Jhony Caro
public class  Perfil implements Serializable{
    
    // Atributos 
    public String nombre;
    public Date fecha_nacimiento;
    public String correo;
    public String Contraseña;
    public boolean rol;
    public SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    // Constructor parametrico
    public Perfil(String nombre, Date fecha_nacimiento, String correo, String Contraseña, boolean rol) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.Contraseña = Contraseña;
        this.rol = rol;
    }
  
    // Consytructor por defecto
    public Perfil() {
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
    
}
