package INTERFAZ;

import Logica.Perfil;
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
import javax.swing.JPanel;

public class GUI_cliente extends JFrame{

    public String correo; 
    public int estado=0;
    
    public GUI_cliente(Perfil p){
        correo=p.correo;
        
        //Creacion de colores
        Color color_griso=new Color(49,49,49);
        Color color_grisc=new Color(166,166,166);
        Color color_rojo=new Color(180,8,8);
        Color color_azul=new Color(82,113,255);    
        Color color_grism=new Color(60,63,65);
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
        JPanel jp_info_p = new JPanel();
        jp_info_p.setLayout(null);
        JCheckBox jcb_notificacion = new JCheckBox("Recibir notificaciones");
        JCheckBox jcb_celulares = new JCheckBox("Celulares y Smartphones");
        JCheckBox jcb_vehiculos = new JCheckBox("Vehiculos");
        JCheckBox jcb_deportes = new JCheckBox("Deportes");
        JCheckBox jcb_videojuegos = new JCheckBox("Videojuegos");
        JCheckBox jcb_computacion = new JCheckBox("Computacion");
        JCheckBox jcb_oficina = new JCheckBox("Oficina");
        JButton btn_modificar_con = new JButton("Cambiar contraseña");
        JButton btn_salir = new JButton("Cerrar Sesion");        
        JButton btn_preferencias = new JButton("<html>Modificar Preferencias<html>");
        JButton btn_guardar = new JButton("Guardar");
        JLabel lbl_mensaje = new JLabel("<html>Al aceptar recibir notificaciones se te enviaran correos electronicos al email registrado con los productos descatados de las categorias (preferencias) que hayas seleccionado anteriormente.<html>");
        JLabel lbl_titulo1 = new JLabel("COMPARE");
        JLabel lbl_titulo2 = new JLabel("&");
        JLabel lbl_titulo3 = new JLabel("BUY");
        JLabel lbl_preferencias = new JLabel("Preferencias");
        JLabel lbl_nombre = new JLabel("Nombre:                      "+p.nombre);
        JLabel lbl_correo = new JLabel("Email:                          "+p.correo);
        JLabel lbl_fecha_nacimiento = new JLabel("Fecha de nacimiento:   "+p.ToString_fn()+" ( "+p.CalcularEdad()+" años )");
        JLabel lbl_info_p = new JLabel("INFORMACION PERSONAL");
       
        //Fuente de los elementos
        lbl_mensaje.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        lbl_info_p.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_titulo1.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_titulo2.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_titulo3.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_preferencias.setFont(new Font("Berlin Sans FB",Font.PLAIN,22));
        lbl_nombre.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_correo.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_fecha_nacimiento.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_notificacion.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_celulares.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_vehiculos.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_deportes.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_videojuegos.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_computacion.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_oficina.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_preferencias.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_guardar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_salir.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_modificar_con.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));

        //Posicion de los elementos
        jp_info_p.setBounds(40, 80, 600, 150);
        lbl_info_p.setBounds(170, 0, 400, 30);
        lbl_titulo1.setBounds(270, 30, 120, 30);
        lbl_titulo2.setBounds(400, 30, 20, 30);
        lbl_titulo3.setBounds(430, 30, 50, 30);
        lbl_nombre.setBounds(20, 45, 570, 25);
        lbl_correo.setBounds(20, 70, 570, 25);
        lbl_fecha_nacimiento.setBounds(20, 95, 570, 25);
        lbl_preferencias.setBounds(100,250,120,30);
        lbl_mensaje.setBounds(350,310,300,120);
        jcb_notificacion.setBounds(380,280,200,30);
        jcb_celulares.setBounds(50, 310, 240, 30);
        jcb_vehiculos.setBounds(50, 340, 240, 30);
        jcb_deportes.setBounds(50, 370, 240, 30);
        jcb_videojuegos.setBounds(50, 400, 240, 30);
        jcb_computacion.setBounds(50, 430, 240, 30);
        jcb_oficina.setBounds(50, 460, 240, 30);
        btn_modificar_con.setBounds(442,195,190,25);
        btn_salir.setBounds(500,480,150,50);
        btn_preferencias.setBounds(100,250,130,50);
        btn_guardar.setBounds(100,500,100,30);
        
        //Colores de los elementos
        lbl_mensaje.setForeground(color_grisc);
        lbl_info_p.setForeground(color_grisc);
        lbl_titulo1.setForeground(color_azul);
        lbl_titulo2.setForeground(color_grisc);
        lbl_titulo3.setForeground(color_rojo);
        lbl_nombre.setForeground(Color.white);
        lbl_correo.setForeground(Color.white);
        lbl_fecha_nacimiento.setForeground(Color.white);        
        lbl_preferencias.setForeground(Color.white);
        jcb_notificacion.setBackground(color_griso);
        jcb_notificacion.setForeground(Color.white);
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
        btn_modificar_con.setForeground(Color.BLACK);
        btn_modificar_con.setBackground(color_grisc);
        btn_salir.setForeground(color_rojo);
        btn_salir.setBackground(color_grisc);
        jp_info_p.setBackground(color_grism);
        
        //visibilidad componentes
        lbl_preferencias.setVisible(false);
        jcb_celulares.setEnabled(false);
        jcb_vehiculos.setEnabled(false);
        jcb_deportes.setEnabled(false);
        jcb_videojuegos.setEnabled(false);
        jcb_computacion.setEnabled(false);
        jcb_oficina.setEnabled(false);
        btn_guardar.setVisible(false);
        
        //Agregar elementos a la ventana
        jp_info_p.add(lbl_nombre);
        jp_info_p.add(lbl_correo);
        jp_info_p.add(lbl_fecha_nacimiento);
        jp_info_p.add(lbl_info_p);
        this.add(jp_info_p);
        this.add(lbl_mensaje);
        this.add(lbl_titulo1);
        this.add(lbl_titulo2);
        this.add(lbl_titulo3);
        this.add(lbl_logo);
        this.add(lbl_preferencias);
        this.add(jcb_notificacion);
        this.add(jcb_celulares);
        this.add(jcb_vehiculos);
        this.add(jcb_deportes);
        this.add(jcb_videojuegos);
        this.add(jcb_computacion);
        this.add(jcb_oficina);
        this.add(btn_salir);
        this.add(btn_modificar_con);
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
                lbl_preferencias.setVisible(true);
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
                lbl_preferencias.setVisible(false);
                        
            }
        };
        btn_guardar.addActionListener(guardar);
        btn_preferencias.addActionListener(habilitar);
        btn_salir.addActionListener(salir);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
    
    ActionListener salir = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            dispose();
            estado=1;
        }
    };

}



