package Logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;

// Autor Jhony Caro
public abstract class  Perfil implements Serializable{
    
    // Atributos 
    public String nombre;
    public String apellido;
    public Date fecha_nacimiento;
    public String correo;
    public String Contraseña;
    public int rol;
    
    // Constructor parametrico
    public Perfil(String nombre, String apellido, Date fecha_nacimiento, String correo, String Contraseña, int rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.Contraseña = Contraseña;
        this.rol = rol;
    }
  
// Consytructor por defecto
    public Perfil() {
        this.nombre = "";
        this.apellido = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.fecha_nacimiento = sdf.parse("01-01-1998");
        } catch (ParseException ex) {
            Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.correo = "";
        this.Contraseña = "";
        this.rol = 1;
    }
    
     public void IniciarSesion() {
    }

    public abstract void Registrarse();

    public abstract void EliminarCuenta();

    public abstract void CambiarContrasena();

    public abstract void VerInfoPersonal();

    public abstract void RecuperarContrasena();
  
    
    



}
