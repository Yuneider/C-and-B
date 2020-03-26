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
    public boolean[] preferencias = new boolean[7];
    
    public Perfil(String nombre, Calendar fecha_nacimiento, String correo, String Contrasena, boolean rol) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.contrasena = Contrasena;
        this.rol = rol;
        for (int i=0;i<this.preferencias.length;i++){
            this.preferencias[i]=false;
        }
    }
    
    public Perfil() {
        this.nombre = "";
        this.fecha_nacimiento = new GregorianCalendar(1,Calendar.JANUARY,2000);
        this.correo = "";
        this.contrasena = "";
        this.rol = false;
        for (int i=0;i<this.preferencias.length;i++){
            this.preferencias[i]=false;
        }
    }
    
    public int CalcularEdad(){
        Calendar actual = Calendar.getInstance();
        int edad;
        
        edad =actual.get(Calendar.YEAR)-this.fecha_nacimiento.get(Calendar.YEAR);
        if(this.fecha_nacimiento.get(Calendar.MONTH)>actual.get(Calendar.MONTH)){
            --edad;
        }
        else{
            if(this.fecha_nacimiento.get(Calendar.MONTH)==actual.get(Calendar.MONTH)){
                if(this.fecha_nacimiento.get(Calendar.DATE)>actual.get(Calendar.DATE)){
                    --edad;
                }
            }
        }
        return edad;
    }
    
    public String ToString_fn(){
        return this.fecha_nacimiento.get(Calendar.DATE)+"/"+(this.fecha_nacimiento.get(Calendar.MONTH)+1)+"/"+this.fecha_nacimiento.get(Calendar.YEAR);
    }
    
}
