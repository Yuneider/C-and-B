package INTERFAZ;

import Logica.Perfil;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_administrador extends JFrame{

    private JPanel jp_eliminar;
    private JButton btn_eliminar;
    private JButton btn_salir;
    private JButton btn_si;
    private JButton btn_no;        
    private JButton btn_estadisticas;        
    private JButton btn_escarbar;        
    private JButton btn_enviar;        
    private JButton btn_info;        
    private JLabel lbl_titulo1;
    private JLabel lbl_titulo2;
    private JLabel lbl_titulo3;
    private JLabel lbl_eliminar;
    private JLabel lbl_nombre;
    private JTextField jtf_eliminar;
    
    public String correo;
    public int estado = 0;
    public String correo_eliminar;
    
    public GUI_administrador(Perfil p){
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
        jp_eliminar = new JPanel();
        jp_eliminar.setLayout(null);
        btn_eliminar = new JButton("Eliminar cuenta");
        btn_salir = new JButton("Cerrar Sesion");
        btn_escarbar = new JButton("Activar scraping");
        btn_enviar = new JButton("<html>Enviar notificaciones a los usuarios<html>");
        btn_si = new JButton("Si");
        btn_no = new JButton("No"); 
        btn_estadisticas = new JButton("Ver estadisticas");        
        btn_info = new JButton("Ver lista de clientes");
        lbl_titulo1 = new JLabel("COMPARE");
        lbl_titulo2 = new JLabel("&");
        lbl_titulo3 = new JLabel("BUY");
        lbl_eliminar = new JLabel("Eliminar cuenta de usuario");
        lbl_nombre = new JLabel("Administrador: "+p.nombre);
        jtf_eliminar = new JTextField();
        
        //Fuente de los elementos
        btn_eliminar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_salir.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_si.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_no.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_estadisticas.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_escarbar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_info.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_enviar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_titulo1.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_titulo2.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_titulo3.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_eliminar.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));
        lbl_nombre.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jtf_eliminar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        
        //Posicion de los elementos
        btn_eliminar.setBounds(50, 100, 200, 30);
        btn_estadisticas.setBounds(80, 150, 200, 60);
        btn_enviar.setBounds(80, 450, 200, 60);
        btn_escarbar.setBounds(80, 350, 200, 60);
        btn_info.setBounds(80, 250, 200, 60);
        btn_si.setBounds(50, 100, 60, 30);
        btn_no.setBounds(200, 100, 60, 30);
        btn_salir.setBounds(500,480,150,50);
        jp_eliminar.setBounds(350, 180, 300, 150);
        lbl_nombre.setBounds(50, 90, 400, 30);
        lbl_eliminar.setBounds(40, 10, 240, 30);
        lbl_titulo1.setBounds(270, 30, 120, 30);
        lbl_titulo2.setBounds(400, 30, 20, 30);
        lbl_titulo3.setBounds(430, 30, 50, 30);
        jtf_eliminar.setBounds(30, 50, 240, 30);
        
        //Colores de los elementos
        btn_eliminar.setBackground(color_grisc);
        btn_estadisticas.setBackground(color_grisc);
        btn_enviar.setBackground(color_grisc);
        btn_escarbar.setBackground(color_grisc);
        btn_info.setBackground(color_grisc);
        btn_si.setBackground(color_grisc);
        btn_no.setBackground(color_grisc);
        lbl_nombre.setForeground(Color.WHITE);
        lbl_titulo1.setForeground(color_azul);
        lbl_titulo2.setForeground(color_grisc);
        lbl_titulo3.setForeground(color_rojo);
        lbl_eliminar.setForeground(Color.WHITE);
        jp_eliminar.setBackground(color_grism);
        jtf_eliminar.setBackground(color_grisc);
        btn_salir.setForeground(color_rojo);
        btn_salir.setBackground(color_grisc);
        
        //Visibilidad componentes
        btn_si.setVisible(false);
        btn_no.setVisible(false);
        
        //Agregar elementos a la ventana
        jp_eliminar.add(jtf_eliminar);
        jp_eliminar.add(lbl_eliminar);
        jp_eliminar.add(btn_eliminar);
        jp_eliminar.add(btn_si);
        jp_eliminar.add(btn_no);
        this.add(jp_eliminar);
        this.add(lbl_logo);
        this.add(btn_salir);
        this.add(btn_estadisticas);
        this.add(btn_escarbar);
        this.add(btn_enviar);
        this.add(btn_info);
        this.add(lbl_nombre);
        this.add(lbl_titulo1);
        this.add(lbl_titulo2);
        this.add(lbl_titulo3);
       
        //Botones
        btn_si.addActionListener(si);
        btn_no.addActionListener(no);
        btn_salir.addActionListener(salir);
        btn_eliminar.addActionListener(eliminar);
        btn_estadisticas.addActionListener(mostrar);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    

    
    ActionListener mostrar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            dispose();
            estado=3;
        }
    };
    ActionListener salir = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            dispose();
            estado=4;
        }
    };
    ActionListener eliminar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            btn_si.setVisible(true);
            btn_no.setVisible(true);
            lbl_eliminar.setBounds(20, 10, 260, 70);
            lbl_eliminar.setText("<html>Esta seguro que desea eliminar la cuenta "+jtf_eliminar.getText()+"<html>");
            jtf_eliminar.setVisible(false);
            btn_eliminar.setVisible(false);
        }
    };
    ActionListener no = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            btn_si.setVisible(false);
            btn_no.setVisible(false);
            lbl_eliminar.setBounds(40, 10, 240, 30);
            lbl_eliminar.setText("Eliminar cuenta de usuario");
            jtf_eliminar.setVisible(true);
            jtf_eliminar.setText("");
            btn_eliminar.setVisible(true);
        }
    };
    ActionListener si = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            dispose();
            correo_eliminar=jtf_eliminar.getText();
            estado=1;
        }
    };
    
}
