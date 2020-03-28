package Logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Estadisticas implements Serializable{
    
    public int[] estad_Errores = new int[5];
    public int[] estad_Edades = new int[5];
    public int[] estad_Categorias = new int[6];
    public int[] estad_Generales = new int[3];
    
    
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
 
    public void RecolectarEstadisticas_edad(ArrayList<Perfil> p){
        for(int i=0;i<p.size();i++){
            if(p.get(i).rol==false){
                if(p.get(i).CalcularEdad()>=0 && p.get(i).CalcularEdad()<=11){
                    estad_Edades[0]++;
                }
                if(p.get(i).CalcularEdad()>=12 && p.get(i).CalcularEdad()<=18){
                    estad_Edades[1]++;
                }
                if(p.get(i).CalcularEdad()>=19 && p.get(i).CalcularEdad()<=26){
                    estad_Edades[2]++;
                }
                if(p.get(i).CalcularEdad()>=27 && p.get(i).CalcularEdad()<=59){
                    estad_Edades[3]++;
                }
                if(p.get(i).CalcularEdad()>=60 && p.get(i).CalcularEdad()<=100){
                    estad_Edades[4]++;
                }
            }
        }
    }
        public void RecolectarCantUsuarios(ArrayList<Perfil> p){
        for(int i=0;i<p.size();i++){
            if(p.get(i).rol==false){
                estad_Generales[1]++;
            }
        }
    }
    
}
