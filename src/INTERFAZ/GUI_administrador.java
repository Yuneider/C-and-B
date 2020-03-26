package INTERFAZ;

import Logica.Perfil;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI_administrador extends JFrame{

    //ATRIBUTOS
    public String correo;
    public int estado = 0;
    public String correo_eliminar;
    //Estado 1 = Eliminar usuario 
    //Estado 2 = Scrapear
    //Estado 3 = Ver estadisticas
    //Estado 4 = Cerrarsesion
    
    
    public GUI_administrador(Perfil p){
        //Creacion de colores
        Color color_griso=new Color(49,49,49);
        Color color_grisc=new Color(166,166,166);
        Color color_rojo=new Color(180,8,8);
        Color color_azul=new Color(82,113,255);
        
        //Propiedades de la ventana
        this.setTitle("C&B-App");
        this.setLayout(null);
        this.setSize(700,600);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(color_griso);
        
        //Logo
        JLabel lbl_logo = new JLabel();
        lbl_logo.setBounds(-20,-30,200,150);
        ImageIcon icon_logo = new ImageIcon("C:/Users/USUARIO/Documents/NetBeansProjects/C-and-B/LOGO.png");
        Icon icono = new ImageIcon(icon_logo.getImage().getScaledInstance(lbl_logo.getWidth(),lbl_logo.getHeight(), Image.SCALE_DEFAULT));
        lbl_logo.setIcon(icono);
        lbl_logo.repaint();
        
        //Crear elementos de la ventana
        JLabel lbl_titulo1 = new JLabel("COMPARE");
        JLabel lbl_titulo2 = new JLabel("&");
        JLabel lbl_titulo3 = new JLabel("BUY");
        
        //Fuente de los elementos
        lbl_titulo1.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_titulo2.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_titulo3.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        
        //Posicion de los elementos
        lbl_titulo1.setBounds(270, 30, 120, 30);
        lbl_titulo2.setBounds(400, 30, 20, 30);
        lbl_titulo3.setBounds(430, 30, 50, 30);
        
        //Colores de los elementos
        lbl_titulo1.setForeground(color_azul);
        lbl_titulo2.setForeground(color_grisc);
        lbl_titulo3.setForeground(color_rojo);
        
        //Agregar elementos a la ventana
        this.add(lbl_logo);
        this.add(lbl_titulo1);
        this.add(lbl_titulo2);
        this.add(lbl_titulo3);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}
