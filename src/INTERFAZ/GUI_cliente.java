package INTERFAZ;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI_cliente extends JFrame{

    public String nombre;
    public String correo;
    public Calendar fecha_nacimiento;
    public boolean[] preferencias; 
    
    public GUI_cliente(String n,String c,Calendar f,boolean[] p){
        nombre=n;
        correo=c;
        fecha_nacimiento=f;
        preferencias = new boolean[6];
        for (int i=0;i<p.length;i++){
            this.preferencias[i]=p[i];
        }
        
        //Creacion de colores
        Color color_griso=new Color(49,49,49);
        Color color_grisc=new Color(166,166,166);
        Color color_rojo=new Color(180,8,8);
        Color color_azul=new Color(82,113,255);    
        
        //Propiedades de la ventana
        this.setTitle("Perfil Cliente");
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
        JCheckBox jcb_celulares = new JCheckBox("Celulares y Smartphones");
        JCheckBox jcb_vehiculos = new JCheckBox("Vehiculos");
        JCheckBox jcb_deportes = new JCheckBox("Deportes");
        JCheckBox jcb_videojuegos = new JCheckBox("Videojuegos");
        JCheckBox jcb_computacion = new JCheckBox("Computacion");
        JCheckBox jcb_oficina = new JCheckBox("Oficina");
        JButton btn_preferencias = new JButton("<html>"+"Modificar Preferencias"+"<html>");
        JButton btn_guardar = new JButton("Guardar");
        JLabel lbl_titulo1 = new JLabel("COMPARE");
        JLabel lbl_titulo2 = new JLabel("&");
        JLabel lbl_titulo3 = new JLabel("BUY");
        JLabel lbl_preferencias = new JLabel("Preferencias");
        JLabel lbl_nombre = new JLabel("Nombre completo: "+nombre);
        JLabel lbl_correo = new JLabel("Correo electronico: "+correo);
        
        //Fuente de los elementos
        lbl_titulo1.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_titulo2.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_titulo3.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_preferencias.setFont(new Font("Berlin Sans FB",Font.PLAIN,22));
        lbl_nombre.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_correo.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_celulares.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_vehiculos.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_deportes.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_videojuegos.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_computacion.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_oficina.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_preferencias.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_guardar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        
        
        //Posicion de los elementos
        lbl_titulo1.setBounds(270, 30, 120, 30);
        lbl_titulo2.setBounds(400, 30, 20, 30);
        lbl_titulo3.setBounds(430, 30, 50, 30);
        lbl_nombre.setBounds(100, 100, 450, 30);
        lbl_correo.setBounds(100, 140, 450, 30);
        lbl_preferencias.setBounds(100,210,120,30);
        jcb_celulares.setBounds(50, 250, 240, 30);
        jcb_vehiculos.setBounds(50, 290, 240, 30);
        jcb_deportes.setBounds(50, 330, 240, 30);
        jcb_videojuegos.setBounds(50, 370, 240, 30);
        jcb_computacion.setBounds(50, 410, 240, 30);
        jcb_oficina.setBounds(50, 450, 240, 30);
        btn_preferencias.setBounds(100,190,130,50);
        btn_guardar.setBounds(100,500,100,30);
        
        //Colores de los elementos
        lbl_titulo1.setForeground(color_azul);
        lbl_titulo2.setForeground(color_grisc);
        lbl_titulo3.setForeground(color_rojo);
        lbl_nombre.setForeground(Color.white);
        lbl_correo.setForeground(Color.white);
        lbl_preferencias.setForeground(Color.white);
        jcb_celulares.setBackground(color_griso);
        jcb_celulares.setForeground(Color.white);
        jcb_vehiculos.setBackground(color_griso);
        jcb_vehiculos.setForeground(Color.white);
        jcb_deportes.setBackground(color_griso);
        jcb_deportes.setForeground(Color.white);
        jcb_videojuegos.setBackground(color_griso);
        jcb_videojuegos.setForeground(Color.white);
        jcb_computacion.setBackground(color_griso);
        jcb_computacion.setForeground(Color.white);
        jcb_oficina.setBackground(color_griso);
        jcb_oficina.setForeground(Color.white);
        btn_preferencias.setForeground(Color.BLACK);
        btn_preferencias.setBackground(color_grisc);
        btn_guardar.setForeground(Color.BLACK);
        btn_guardar.setBackground(color_grisc);
        
        //visibilidad componentes
        jcb_celulares.setEnabled(false);
        jcb_vehiculos.setEnabled(false);
        jcb_deportes.setEnabled(false);
        jcb_videojuegos.setEnabled(false);
        jcb_computacion.setEnabled(false);
        jcb_oficina.setEnabled(false);
        btn_guardar.setVisible(false);
        
        //Agregar elementos a la ventana
        this.add(lbl_titulo1);
        this.add(lbl_titulo2);
        this.add(lbl_titulo3);
        this.add(lbl_logo);
        this.add(lbl_preferencias);
        this.add(lbl_nombre);
        this.add(lbl_correo);
        this.add(jcb_celulares);
        this.add(jcb_vehiculos);
        this.add(jcb_deportes);
        this.add(jcb_videojuegos);
        this.add(jcb_computacion);
        this.add(jcb_oficina);
        this.add(btn_preferencias);
        this.add(btn_guardar);
        
        ActionListener habilitar = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                btn_preferencias.setVisible(false);
                jcb_celulares.setEnabled(true);
                jcb_vehiculos.setEnabled(true);
                jcb_deportes.setEnabled(true);
                jcb_videojuegos.setEnabled(true);
                jcb_computacion.setEnabled(true);
                jcb_oficina.setEnabled(true);
                btn_guardar.setVisible(true);
            }
        };
        ActionListener guardar = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                btn_preferencias.setVisible(true);
                jcb_celulares.setEnabled(false);
                jcb_vehiculos.setEnabled(false);
                jcb_deportes.setEnabled(false);
                jcb_videojuegos.setEnabled(false);
                jcb_computacion.setEnabled(false);
                jcb_oficina.setEnabled(false);
                btn_guardar.setVisible(false);
            }
        };
        btn_guardar.addActionListener(guardar);
        btn_preferencias.addActionListener(habilitar);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
    
    

    

}



