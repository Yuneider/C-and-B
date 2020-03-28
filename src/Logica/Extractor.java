
package Logica;

// Autor Jhony Caro

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Extractor {
 
    public ArrayList<String> TitulosCelulares = new ArrayList<String>();
    public ArrayList<String> PreciosCelulares = new ArrayList<String>();
    public ArrayList<String> LinksCelulares = new ArrayList<String>();
    public ArrayList<String> TitulosVehiculos = new ArrayList<String>();
    public ArrayList<String> PreciosVehiculos = new ArrayList<String>();
    public ArrayList<String> LinksVehiculos = new ArrayList<String>();
    public ArrayList<String> TitulosDeportes = new ArrayList<String>();
    public ArrayList<String> PreciosDeportes = new ArrayList<String>();
    public ArrayList<String> LinksDeportes = new ArrayList<String>();
    public ArrayList<String> TitulosVideoJuegos = new ArrayList<String>();
    public ArrayList<String> PreciosVideoJuegos = new ArrayList<String>();
    public ArrayList<String> LinksVideoJuegos = new ArrayList<String>();
    public ArrayList<String> TitulosComputacion = new ArrayList<String>();
    public ArrayList<String> PreciosComputacion = new ArrayList<String>();
    public ArrayList<String> LinksComputacion = new ArrayList<String>();
    public ArrayList<String> TitulosOficina = new ArrayList<String>();
    public ArrayList<String> PreciosOficina = new ArrayList<String>();
    public ArrayList<String> LinksOficina = new ArrayList<String>();
    
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
              
        Elements titulos=null;
        Elements precios=null;
        Elements links=null;
        for (Element element: searchCelulares){
            titulos = element.getElementsByClass("main-title");
            precios = element.getElementsByClass("price__fraction");
            links = docCelulares.select("a.item__info-title"); 
        }
        for(int i=0;i<searchCelulares.size();i++){
                TitulosCelulares.add(titulos.text());
                PreciosCelulares.add(precios.text());
                LinksCelulares.add(links.attr("abs:href"));
        }
        
        titulos=null;
        precios=null;
        links=null;
        for (Element element: searchVehiculos){
            titulos = element.getElementsByClass("main-title");
            precios = element.getElementsByClass("price__fraction");
            links = docVehiculos.select("a.item__info-title"); 
        }
        for(int i=0;i<searchVehiculos.size();i++){
                TitulosVehiculos.add(titulos.text());
                PreciosVehiculos.add(precios.text());
                LinksVehiculos.add(links.attr("abs:href"));
        }
        
        titulos=null;
        precios=null;
        links=null;
        for (Element element: searchDeportes){
            titulos = element.getElementsByClass("main-title");
            precios = element.getElementsByClass("price__fraction");
            links = docDeportes.select("a.item__info-title"); 
        }
        for(int i=0;i<searchDeportes.size();i++){
                TitulosDeportes.add(titulos.text());
                PreciosDeportes.add(precios.text());
                LinksDeportes.add(links.attr("abs:href"));
        }
        
        titulos=null;
        precios=null;
        links=null;
        for (Element element: searchVideojuegos){
            titulos = element.getElementsByClass("main-title");
            precios = element.getElementsByClass("price__fraction");
            links = docVideojuegos.select("a.item__info-title"); 
        }
        for(int i=0;i<searchVideojuegos.size();i++){
                TitulosVideoJuegos.add(titulos.text());
                PreciosVideoJuegos.add(precios.text());
                LinksVideoJuegos.add(links.attr("abs:href"));
        }
        
        titulos=null;
        precios=null;
        links=null;
        for (Element element: searchComputacion){
            titulos = element.getElementsByClass("main-title");
            precios = element.getElementsByClass("price__fraction");
            links = docComputacion.select("a.item__info-title"); 
        }
        for(int i=0;i<searchComputacion.size();i++){
                TitulosComputacion.add(titulos.text());
                PreciosComputacion.add(precios.text());
                LinksComputacion.add(links.attr("abs:href"));
        }
        
        titulos=null;
        precios=null;
        links=null;
        for (Element element: searchOficina){
            titulos = element.getElementsByClass("main-title");
            precios = element.getElementsByClass("price__fraction");
            links = docOficina.select("a.item__info-title"); 
        }
        for(int i=0;i<searchOficina.size();i++){
                TitulosOficina.add(titulos.text());
                PreciosOficina.add(precios.text());
                LinksOficina.add(links.attr("abs:href"));
        }
        
        String mensaje="CELULARES: \n\n";
        for(int i=0;i<searchCelulares.size();i++){
                mensaje+=TitulosCelulares.get(i)+"\n$"+PreciosCelulares.get(i)+"\n"+LinksCelulares.get(i)+"\n\n";
        }
    }
    
}
