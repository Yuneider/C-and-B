
package Logica;

// Autor Jhony Caro

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Extractor {
 
    public ArrayList<Elements> lista = new ArrayList<Elements>();
    
    public Extractor() throws IOException{
        //Extraer datos Smarphones
        Document docCelulares = Jsoup.connect("https://celulares.mercadolibre.com.co/").get();
        Elements searchCelulares = docCelulares.getElementsByClass("results-item highlighted article stack product ");
        
        //Extraer datos vehiculos
        Document docVehiculos = Jsoup.connect("https://vehiculos.mercadolibre.com.co/").get();    
        Elements searchVehiculos = docVehiculos.getElementsByClass("rowItem item highlighted item--grid new ");
        
        //Extraer datos deportes
        Document docDeportes = Jsoup.connect("https://deportes.mercadolibre.com.co/").get();    
        Elements searchDeportes = docDeportes.getElementsByClass("results-item highlighted article stack ");
        
        //Extraer datos videojuegos
        Document docVideojuegos = Jsoup.connect("https://videojuegos.mercadolibre.com.co/").get();    
        Elements searchVideojuegos = docVideojuegos.getElementsByClass("results-item highlighted article stack ");
        
        //Extraer datos computacion
        Document docComputacion = Jsoup.connect("https://computacion.mercadolibre.com.co/").get();    
        Elements searchComputacion = docComputacion.getElementsByClass("results-item highlighted article stack ");
        
        //Extraer datos oficina
        Document docOficina = Jsoup.connect("https://listado.mercadolibre.com.co/industrias-y-oficinas/equipamiento/").get();    
        Elements searchOficina = docOficina.getElementsByClass("results-item highlighted article stack ");
        
       /* for (Element element: searchOficina){
            Elements titulosOficina = element.getElementsByClass("main-title");
            Elements preciosOficina = element.getElementsByClass("price__fraction");
            Elements linksOficina = docOficina.select("a.item__info-title");
            System.out.println(titulosOficina.text()+"  $"+preciosOficina.text()+"  "+linksOficina.attr("abs:href"));
        }*/
       
        lista.add(searchCelulares);
        lista.add(searchVehiculos);
        lista.add(searchDeportes);
        lista.add(searchVideojuegos);
        lista.add(searchComputacion);
        lista.add(searchOficina);
    }
    
}
