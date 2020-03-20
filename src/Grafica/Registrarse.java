package Grafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registrarse{

    public Registrarse() {
        
        //VENTANA
        JFrame ventana = new JFrame();

        //PANEL
        JPanel panel = new JPanel();
        
        //ETIQUETAS DE TEXTO
        JLabel registrarse_txt = new JLabel();
        JLabel nombre_txt  = new JLabel();
        JLabel correo_txt = new JLabel();
        JLabel fecha_nacimiento_txt = new JLabel();
        JLabel contraseña_txt = new JLabel();
    
        //BOTONES
        JButton borrar_btn= new JButton();
        JButton aceptar_btn= new JButton();
    
        //CAJAS DE TEXTO
        JTextField nombre_caja = new JTextField();
        JTextField correo_caja = new JTextField();
        JTextField fehca_nacimiento_caja = new JTextField();
        JTextField contrasena_caja = new JTextField();
    }
    
}
