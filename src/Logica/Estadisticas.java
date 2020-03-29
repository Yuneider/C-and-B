package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Estadisticas implements Serializable{
    
    public int[] estad_Errores = new int[5];
    public int[] estad_Edades = new int[5];
    public int[] estad_Categorias = new int[6];
    public int[] estad_Generales = new int[3];
    public Calendar actualizacion; 
    
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
        actualizacion = Calendar.getInstance();
    }
 
    public void RecolectarInfo(ArrayList<Perfil> p){
        for(int j=0;j<5;j++){
            estad_Edades[j]=0;
        }
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
        estad_Categorias[0]=0;
        estad_Categorias[1]=0;
        estad_Categorias[2]=0;
        estad_Categorias[3]=0;
        estad_Categorias[4]=0;
        estad_Categorias[5]=0;
        for(int i=0;i<p.size();i++){
            if(p.get(i).rol==false){
                if(p.get(i).preferencias[0]==true){
                    estad_Categorias[0]++;
                }
                if(p.get(i).preferencias[1]==true){
                    estad_Categorias[1]++;
                }
                if(p.get(i).preferencias[2]==true){
                    estad_Categorias[2]++;
                }
                if(p.get(i).preferencias[3]==true){
                    estad_Categorias[3]++;
                }
                if(p.get(i).preferencias[4]==true){
                    estad_Categorias[4]++;
                }
                if(p.get(i).preferencias[5]==true){
                    estad_Categorias[5]++;
                }
            }
        }
        estad_Generales[1]=0;
        for(int i=0;i<p.size();i++){
            if(p.get(i).rol==false){
                estad_Generales[1]++;
            }
        }
    }    
    public String EscribirFecha(){
        String fecha_actual = "";
        if(actualizacion.get(Calendar.DATE)<10){
            fecha_actual+="0";
        }
        fecha_actual+=actualizacion.get(Calendar.DATE)+"/";
        if(actualizacion.get(Calendar.MONTH)<10){
            fecha_actual+="0";
        }
        fecha_actual+=(actualizacion.get(Calendar.MONTH)+1)+"/";
        fecha_actual+=actualizacion.get(Calendar.YEAR)+" - ";
        if(actualizacion.get(Calendar.HOUR)<10){
            fecha_actual+="0";
        }
        fecha_actual+=actualizacion.get(Calendar.HOUR_OF_DAY)+":";
        if(actualizacion.get(Calendar.MINUTE)<10){
            fecha_actual+="0";
        }
        fecha_actual+=actualizacion.get(Calendar.MINUTE)+":";
        if(actualizacion.get(Calendar.SECOND)<10){
            fecha_actual+="0";
        }
        fecha_actual+=actualizacion.get(Calendar.SECOND)+".";
        return fecha_actual;
    }
}
