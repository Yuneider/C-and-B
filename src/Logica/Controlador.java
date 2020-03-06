package Logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//Autor Jhony Caro

public class Controlador{
    
    public static void main(String[] args) {
    }
    
    public static void Guardar(){
        int xd = 5;
        ArrayList<Perfil> perfiles = new ArrayList<Perfil>();
        for (int i =0;i<xd;i++){
            perfiles.add(new Perfil());
            perfiles.get(i).nombre= "Jhony Alejandro Caro Umbariba";
            perfiles.get(i).correo = "Jhonycaro1998@gmail.com";    
        }
        
        String archivo = "Usuarios.txt";
        try{
            ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(archivo));
            ob.writeObject(perfiles);
            ob.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public static void Recuperar(){
        String archivo = "Usuarios.txt";
        ArrayList<Perfil> perfiles2 = new ArrayList<Perfil>();
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(archivo));
            perfiles2 = (ArrayList<Perfil>) is.readObject(); 
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } 
        System.out.println(perfiles2.get(0).fecha_nacimiento);
        /*  for (int f =0;f < perfiles2.size();f++){
            System.out.println(perfiles2.get(f).nombre);
            System.out.println(perfiles2.get(f).apellido);    
            System.out.println(perfiles2.get(f).correo);
        }*/
    }

    public void IniciarSesion(){
        //revisar q la base de datos (usuarios) no esté vacia, xq si lo está, la unica opcion sera registrarse
        //llamar el entorno grafico
        //contrastar this.nombre y this.contrasena en la base de datos
        
    }
    
    public static void Registrarse(){}
    public static void EliminarCuenta(){}
    public static void CambiarContrasenas(){}
    public static void VerInfoPersonal(){}
    public static void RecuperarContrasena(){}
}

