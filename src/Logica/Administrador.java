package Logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

    
public class Administrador extends Perfil{
    //Constructor parametrico
    public Administrador(String nombre,Calendar fecha_nacimiento,String correo, String contrasena) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = true;
        preferencias = new boolean[6];
        for (int i=0;i<preferencias.length;i++){
            this.preferencias[i]=false;
        }
    }

    public ArrayList<Elements> ExtraerCategorias() throws IOException{
        //Extraer datos Smarphones
        Document docCelulares = Jsoup.connect("https://celulares.mercadolibre.com.co/").get();
        Elements searchCelulares = docCelulares.getElementsByClass("rowItem item highlighted item--stack new has-variations");
        Elements titulosCelulares = new Elements();
        Elements preciosCelulares = new Elements();
        for(Element element: searchCelulares){
            titulosCelulares = element.getElementsByClass("main-title");
            preciosCelulares = element.getElementsByClass("price__fraction");
        }
        //Extraer datos vehiculos
        Document docVehiculos = Jsoup.connect("https://vehiculos.mercadolibre.com.co/").get();    
        Elements searchVehiculos = docVehiculos.getElementsByClass("rowItem item highlighted item--grid new ");
        Elements titulosVehiculos = new Elements();
        Elements preciosVehiculos = new Elements();
        for(Element element: searchVehiculos) {
            titulosVehiculos = element.getElementsByClass("item__title list-view-item-title ");
            preciosVehiculos = element.getElementsByClass("item__price");
        }
        //Extraer datos deportes
        Document docDeportes = Jsoup.connect("https://deportes.mercadolibre.com.co/").get();    
        Elements searchDeportes = docDeportes.getElementsByClass("results-item highlighted article stack ");
        Elements titulosDeportes = new Elements();
        Elements preciosDeportes = new Elements();
        for(Element element: searchDeportes) {
            titulosDeportes = element.getElementsByClass("item__title list-view-item-title");
            preciosDeportes = element.getElementsByClass("price__fraction");
        }
        //Extraer datos videojuegos
        Document docVideojuegos = Jsoup.connect("https://videojuegos.mercadolibre.com.co/").get();    
        Elements searchVideojuegos = docVideojuegos.getElementsByClass("results-item highlighted article stack ");
        Elements titulosVideojuegos = new Elements();
        Elements preciosVideojuegos = new Elements();
        for(Element element: searchVideojuegos) {
            titulosVideojuegos = element.getElementsByClass("main-title");
            preciosVideojuegos = element.getElementsByClass("price__fraction");
        }
        //Extraer datos computacion
        Document docComputacion = Jsoup.connect("https://computacion.mercadolibre.com.co/").get();    
        Elements searchComputacion = docComputacion.getElementsByClass("results-item highlighted article stack ");
        Elements titulosComputacion = new Elements();
        Elements preciosComputacion = new Elements();
        for(Element element: searchComputacion) {
            titulosComputacion = element.getElementsByClass("main-title");
            preciosComputacion = element.getElementsByClass("price__fraction");
        }
        //Extraer datos oficina
        Document docOficina = Jsoup.connect("https://listado.mercadolibre.com.co/industrias-y-oficinas/equipamiento/").get();    
        Elements searchOficina = docOficina.getElementsByClass("results-item highlighted article stack ");
        Elements titulosOficina = new Elements();
        Elements preciosOficina = new Elements();
        for(Element element: searchOficina) {
            titulosOficina = element.getElementsByClass("main-title");
            preciosOficina = element.getElementsByClass("price__fraction");
        }
        ArrayList<Elements> Lista = new ArrayList<Elements>();
        Lista.add(0,titulosCelulares);
        Lista.add(1,preciosCelulares);
        Lista.add(2,titulosVehiculos);
        Lista.add(3,preciosVehiculos);
        Lista.add(4,titulosDeportes);
        Lista.add(5,preciosDeportes);
        Lista.add(6,titulosVideojuegos);
        Lista.add(7,preciosVideojuegos);
        Lista.add(8,titulosComputacion);
        Lista.add(9,preciosComputacion);
        Lista.add(10,titulosOficina);
        Lista.add(11,preciosOficina);
        return Lista;
    }
    
    
}
