package Logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Estadisticas implements Serializable{
    
    //ATRIBUTOS
    public static int[] estad_Errores = new int[5];
    public static int[] estad_Edades = new int[6];
    public static int[] estad_Categorias = new int[6];
    public static int[] estad_Generales = new int[3];
    
    
    public Estadisticas(){
        for(int i=0;i<estad_Errores.length;i++){
            estad_Errores[i]=0;
        }
        for(int i=0;i<estad_Edades.length;i++){
            estad_Edades[i]=0;
        }
        for(int i=0;i<estad_Categorias.length;i++){
            estad_Categorias[i]=0;
        }
        for(int i=0;i<estad_Generales.length;i++){
            estad_Generales[i]=0;
        }
    }
 
    public void RecolectarEstadisticas(ArrayList<Perfil> perfiles){
        //edad y preferencias
        for(int i=0;i<perfiles.size();i++){
            int aux = perfiles.size()-1;
            for(int ii=0;ii<aux;ii++){
                if(perfiles.get(i).preferencias[i]){
                    estad_Categorias[i]++;
                }
                if(perfiles.get(i).CalcularEdad()>=0 && perfiles.get(i).CalcularEdad()<=5){
                    estad_Edades[0]++;
                }
                if(perfiles.get(i).CalcularEdad()>=6 && perfiles.get(i).CalcularEdad()<=11){
                    estad_Edades[1]++;
                }
                if(perfiles.get(i).CalcularEdad()>=12 && perfiles.get(i).CalcularEdad()<=18){
                    estad_Edades[2]++;
                }
                if(perfiles.get(i).CalcularEdad()>=19 && perfiles.get(i).CalcularEdad()<=26){
                    estad_Edades[3]++;
                }
                if(perfiles.get(i).CalcularEdad()>=27 && perfiles.get(i).CalcularEdad()<=59){
                    estad_Edades[4]++;
                }
                if(perfiles.get(i).CalcularEdad()>=60 && perfiles.get(i).CalcularEdad()<=100){
                    estad_Edades[5]++;
                }
            }
        }
    }
    
    
}
