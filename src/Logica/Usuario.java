package Logica;

import java.util.Calendar;

public class Usuario extends Perfil{

    // Constructor parametrico
    public Usuario(String nombre, Calendar fecha_nacimiento, String correo, String Contrasena) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.contrasena = Contrasena;
        this.rol = false;
        preferencias = new boolean[7];
        for (int i=0;i<preferencias.length;i++){
            this.preferencias[i]=false;
        }
    }
    
}
    