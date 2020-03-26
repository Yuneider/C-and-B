package Logica;

import java.util.Calendar;
    
public class Administrador extends Perfil{
    //Constructor parametrico
    public Administrador(String nombre,Calendar fecha_nacimiento,String correo, String contrasena) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = true;
        preferencias = new boolean[7];
        for (int i=0;i<preferencias.length;i++){
            this.preferencias[i]=false;
        }
    }

}
