package Logica;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import javax.swing.text.Element;
import org.jsoup.Jsoup;
    
public class Admi extends Perfil{
    
    //Constructor por defecto
    public Admi(){
        this.nombre = "";
        this.fecha_nacimiento = new GregorianCalendar(1,Calendar.JANUARY,1);
        this.correo = "";
        this.Contrasena = "";
        this.rol = true;
    }
    
    //Constructor parametrico
    public Admi(String nombre, Calendar fecha_nacimiento, String correo, String Contrasena) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.Contrasena = Contrasena;
        this.rol = true;
    }

//    private ArrayList<Document> ScrapeandoAndo(){
//    
//    }
//
//    private void EnlistarElementos(ArrayList<Document> docCelulares, ArrayList<Document> docVehiculos, ArrayList<Document> docDeportes,ArrayList<Document> docVideojuegos,ArrayList<Document> docComputacion, ArrayList<Document> docOficina) throws IOException{
//        Elements searchCelulares = docCelulares.getElementsByClass("rowItem item highlighted item--stack new has-variations");
//        for(Element element: searchCelulares){
//            Elements titulosCelulares = element.getElementsByClass("main-title");
//            Elements preciosCelulares = element.getElementsByClass("price__fraction");
//        }
//    }
//    public void Extraer() throws IOException{
//        
////Extraer datos Smarphones
//    Document docCelulares = Jsoup.connect("https://celulares.mercadolibre.com.co/").get();
//        
//    Document docVehiculos = Jsoup.connect("https://vehiculos.mercadolibre.com.co/").get();    
//    Elements searchVehiculos = docVehiculos.getElementsByClass("rowItem item highlighted item--grid new ");
//    for(Element element: searchVehiculos) {
//	Elements titulosVehiculos = element.getElementsByClass("item__title list-view-item-title ");
//	Elements preciosVehiculos = element.getElementsByClass("item__price");
//    }
//    Document docDeportes = Jsoup.connect("https://deportes.mercadolibre.com.co/").get();    
//    Elements searchDeportes = docDeportes.getElementsByClass("results-item highlighted article stack ");
//    for(Element element: searchDeportes) {
//	Elements titulosDeportes = element.getElementsByClass("item__title list-view-item-title");
//	Elements preciosDeportes = element.getElementsByClass("price__fraction");
//    }
//    Document docVideojuegos = Jsoup.connect("https://videojuegos.mercadolibre.com.co/").get();    
//    Elements searchVideojuegos = docVideojuegos.getElementsByClass("results-item highlighted article stack ");
//    for(Element element: searchVideojuegos) {
//	Elements titulosVideojuegos = element.getElementsByClass("main-title");
//	Elements preciosVideojuegos = element.getElementsByClass("price__fraction");
//    }
//    Document docComputacion = Jsoup.connect("https://computacion.mercadolibre.com.co/").get();    
//    Elements searchComputacion = docComputacion.getElementsByClass("results-item highlighted article stack ");
//    for(Element element: searchComputacion) {
//	Elements titulosComputacion = element.getElementsByClass("main-title");
//	Elements preciosComputacion = element.getElementsByClass("price__fraction");
//    }
//    Document docOficina = Jsoup.connect("https://listado.mercadolibre.com.co/industrias-y-oficinas/equipamiento/").get();    
//    Elements searchOficina = docOficina.getElementsByClass("results-item highlighted article stack ");
//    for(Element element: searchOficina) {
//	Elements titulosOficina = element.getElementsByClass("main-title");
//	Elements preciosOficina = element.getElementsByClass("price__fraction");
//    }
//    
//}
}
