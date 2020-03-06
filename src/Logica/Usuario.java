package Logica;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario extends Perfil{
    
    //Constructor por defecto
    public Usuario(){
        this.nombre="";
        this.Contraseña="";
        this.correo="";
        try {
            this.fecha_nacimiento = sdf.parse("01-01-1998");
        } catch (ParseException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.rol=false;
    }
    
    // Constructor parametrico
    public Usuario(String nombre, Date fecha_nacimiento, String correo, String Contraseña, boolean rol) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.Contraseña = Contraseña;
        this.rol = rol;
    }
    
}
    