
package Logica;

// Autor Jhony Caro

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Extractor {
 
    public ArrayList<String> celulares = new ArrayList<String>();
    public ArrayList<String> vehiculos = new ArrayList<String>();
    public ArrayList<String> deportes = new ArrayList<String>();
    public ArrayList<String> videojuegos = new ArrayList<String>();
    public ArrayList<String> computacion = new ArrayList<String>();
    public ArrayList<String> oficina = new ArrayList<String>();
    
    public Extractor() throws IOException{
        
        //Extraer datos Smarphones
        Document docCelulares = Jsoup.connect("https://celulares.mercadolibre.com.co/").get();
        Elements searchCelulares = docCelulares.getElementsByClass("results-item highlighted article stack product ");
        for (Element element: searchCelulares){
            Elements titulosCelulares = element.getElementsByClass("main-title");
            Elements preciosCelulares = element.getElementsByClass("price__fraction");
            Elements linksCelulares = element.select("a.item__info-title");
            celulares.add(titulosCelulares.text()+"  $"+preciosCelulares.text()+" Link: "+linksCelulares.attr("abs:href"));
        }
        
        //Extraer datos vehiculos
        Document docVehiculos = Jsoup.connect("https://vehiculos.mercadolibre.com.co/").get();    
        Elements searchVehiculos = docVehiculos.getElementsByClass("rowItem item highlighted item--grid new ");
        for (Element element: searchVehiculos){
            Elements titulosVehiculos = element.getElementsByClass("main-title");
            Elements preciosVehiculos = element.getElementsByClass("price__fraction");
            Elements linksVehiculos = element.select("a.item-link");
            vehiculos.add(titulosVehiculos.text()+"  $"+preciosVehiculos.text()+" Link: "+linksVehiculos.attr("abs:href"));
        }
        //Extraer datos deportes
        Document docDeportes = Jsoup.connect("https://deportes.mercadolibre.com.co/").get();    
        Elements searchDeportes = docDeportes.getElementsByClass("results-item highlighted article stack ");
        for (Element element: searchDeportes){
            Elements titulosDeportes = element.getElementsByClass("main-title");
            Elements preciosDeportes = element.getElementsByClass("price__fraction");
            Elements linksDeportes = element.select("a.item__info-title");
            deportes.add(titulosDeportes.text()+"  $"+preciosDeportes.text()+" Link: "+linksDeportes.attr("abs:href"));
        }
        
        //Extraer datos videojuegos
        Document docVideojuegos = Jsoup.connect("https://videojuegos.mercadolibre.com.co/").get();    
        Elements searchVideojuegos = docVideojuegos.getElementsByClass("results-item highlighted article stack ");
        for (Element element: searchVideojuegos){
            Elements titulosVideojuegos = element.getElementsByClass("main-title");
            Elements preciosVideojuegos = element.getElementsByClass("price__fraction");
            Elements linksVideojuegos = element.select("a.item__info-title");
            videojuegos.add(titulosVideojuegos.text()+"  $"+preciosVideojuegos.text()+" Link: "+linksVideojuegos.attr("abs:href"));
        }
      
        //Extraer datos computacion
        Document docComputacion = Jsoup.connect("https://computacion.mercadolibre.com.co/").get();    
        Elements searchComputacion = docComputacion.getElementsByClass("results-item highlighted article stack ");
        for (Element element: searchComputacion){
            Elements titulosComputacion = element.getElementsByClass("main-title");
            Elements preciosComputacion = element.getElementsByClass("price__fraction");
            Elements linksComputacion = element.select("a.item__info-title");
            computacion.add(titulosComputacion.text()+"  $"+preciosComputacion.text()+" Link: "+linksComputacion.attr("abs:href"));
        }
        
        //Extraer datos oficina
        Document docOficina = Jsoup.connect("https://listado.mercadolibre.com.co/industrias-y-oficinas/equipamiento/").get();    
        Elements searchOficina = docOficina.getElementsByClass("results-item highlighted article stack ");
        for (Element element: searchOficina){
            Elements titulosOficina = element.getElementsByClass("main-title");
            Elements preciosOficina = element.getElementsByClass("price__fraction");
            Elements linksOficina = element.select("a.item__info-title");
            oficina.add(titulosOficina.text()+"  $"+preciosOficina.text()+" Link: "+linksOficina.attr("abs:href"));
        }
    }

    public int NumeroRandom(int f){
        double Aleatorio = Math.random()*(f-1)+1;
        int result = (int)Aleatorio;    
        return result;
    }
    
}
