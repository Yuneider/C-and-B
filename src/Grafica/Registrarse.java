
package Grafica;

// Autor Jhony Caro
import Logica.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registrarse extends JFrame{
    
    private String nombre;
    private String correo;
    private String contraseña1;
    private String contraseña2;
    private String contraseñaf;
    private Calendar fecha_nacimiento;
    private boolean rol=false;
    
    public Registrarse(){
        //Creacion de colores
        Color color_griso=new Color(49,49,49);
        Color color_grisc=new Color(166,166,166);
        Color color_rojo=new Color(180,8,8);
        Color color_azul=new Color(82,113,255);
        
        //Propiedades de la ventana
        this.setTitle("Registrarme");
        this.setLayout(null);
        this.setSize(500,600);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(color_griso);
        
        //Logo
        JLabel lbl_logo = new JLabel();
        lbl_logo.setBounds(-20,-30,200,150);
        ImageIcon icon_logo = new ImageIcon("C:/Users/USUARIO/Documents/NetBeansProjects/C&B/LOGO.png");
        Icon icono = new ImageIcon(icon_logo.getImage().getScaledInstance(lbl_logo.getWidth(),lbl_logo.getHeight(), Image.SCALE_DEFAULT));
        lbl_logo.setIcon(icono);
        lbl_logo.repaint();
        
        //Crear elementos de la ventana
        JLabel lbl_titulo1 = new JLabel();
        JLabel lbl_titulo2 = new JLabel();
        JLabel lbl_titulo3 = new JLabel();
        JLabel lbl_nombre = new JLabel();
        JLabel lbl_apellido = new JLabel();
        JLabel lbl_contraseña = new JLabel();
        JLabel lbl_correo = new JLabel();
        JLabel lbl_confirmacion1 = new JLabel();
        JLabel lbl_confirmacion2 = new JLabel();
        JLabel lbl_fecha1 = new JLabel();
        JLabel lbl_fecha2 = new JLabel();
        JTextField jtf_nombre = new JTextField();
        JTextField jtf_apellido = new JTextField();
        JTextField jtf_correo = new JTextField();
        JPasswordField pwf1 = new JPasswordField();
        JPasswordField pwf2 = new JPasswordField();
        JButton btn_guardar = new JButton("Guardar Registro");
        JButton btn_cancelar = new JButton("Cancelar");
        JComboBox jcb_dia = new JComboBox<>();
        JComboBox jcb_mes = new JComboBox<>();
        JComboBox jcb_anno = new JComboBox<>();
        
        //Edicion de textos
        lbl_nombre.setText("Nombres:");
        lbl_apellido.setText("Apellidos: ");
        lbl_correo.setText("Correo: ");
        lbl_contraseña.setText("Contraseña: ");
        lbl_confirmacion1.setText("Confirmacion");
        lbl_confirmacion2.setText("Contraseña: ");
        lbl_titulo1.setText("COMPARE");
        lbl_titulo2.setText("&");
        lbl_titulo3.setText("BUY");
        lbl_fecha1.setText("Fecha de");
        lbl_fecha2.setText("Nacimiento: ");
        
        //Edicion de listas desplegables                
        jcb_dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
        jcb_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jcb_anno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010"}));
        
        //Fuente de los elementos
        btn_guardar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_cancelar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jtf_apellido.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jtf_correo.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jtf_nombre.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_apellido.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_titulo1.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_titulo2.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_titulo3.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_nombre.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_correo.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_confirmacion1.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_confirmacion2.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_contraseña.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_fecha1.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_fecha2.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        pwf1.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        pwf2.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_dia.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_mes.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_anno.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        
        //Posicion de los elementos
        lbl_titulo1.setBounds(180, 30, 120, 30);
        lbl_titulo2.setBounds(290, 30, 20, 30);
        lbl_titulo3.setBounds(310, 30, 50, 30);
        lbl_nombre.setBounds(20, 100, 150, 30);
        lbl_apellido.setBounds(20, 150, 150, 30);
        lbl_correo.setBounds(20, 200, 150, 30);
        lbl_contraseña.setBounds(20, 250, 150, 30);
        lbl_confirmacion1.setBounds(20, 300, 150, 30);
        lbl_confirmacion2.setBounds(50, 320, 150, 30);
        lbl_fecha1.setBounds(20, 370, 150, 30);
        lbl_fecha2.setBounds(50, 390, 150, 30);        
        btn_guardar.setBounds(50, 500, 200, 30);
        btn_cancelar.setBounds(270, 500, 130, 30);
        jtf_nombre.setBounds(150, 100, 200, 25);
        jtf_apellido.setBounds(150, 150, 200, 25);
        jtf_correo.setBounds(150, 200, 250, 25);
        pwf1.setBounds(150, 250, 200, 25);
        pwf2.setBounds(150, 310, 200, 25);
        jcb_dia.setBounds(150, 380, 50, 30);
        jcb_mes.setBounds(210, 380, 120, 30);
        jcb_anno.setBounds(340, 380, 80, 30);
        
        //Colores de los elementos
        lbl_titulo1.setForeground(color_azul);
        lbl_titulo2.setForeground(color_grisc);
        lbl_titulo3.setForeground(color_rojo);        
        lbl_nombre.setForeground(Color.white);
        lbl_apellido.setForeground(Color.white);
        lbl_correo.setForeground(Color.white);
        lbl_contraseña.setForeground(Color.white);
        lbl_confirmacion1.setForeground(Color.white);
        lbl_confirmacion2.setForeground(Color.white);
        lbl_fecha1.setForeground(Color.white);
        lbl_fecha2.setForeground(Color.white);
        jtf_nombre.setBackground(color_grisc);
        jtf_apellido.setBackground(color_grisc);
        jtf_correo.setBackground(color_grisc);
        pwf1.setBackground(color_grisc);
        pwf2.setBackground(color_grisc);
        btn_guardar.setBackground(color_grisc);
        btn_cancelar.setBackground(color_grisc);
        jcb_dia.setBackground(color_grisc);
        jcb_mes.setBackground(color_grisc);
        jcb_anno.setBackground(color_grisc);
        jcb_dia.setForeground(color_griso);
        jcb_mes.setForeground(color_griso);
        jcb_dia.setForeground(color_griso);
        
        //Agregar elementos a la ventana
        this.add(lbl_titulo1);
        this.add(lbl_titulo2);
        this.add(lbl_titulo3);
        this.add(lbl_nombre);
        this.add(lbl_apellido);
        this.add(lbl_correo);
        this.add(lbl_contraseña);
        this.add(lbl_confirmacion1);
        this.add(lbl_confirmacion2);
        this.add(lbl_fecha1);
        this.add(lbl_fecha2);
        this.add(lbl_logo);
        this.add(pwf1);
        this.add(pwf2);
        this.add(jtf_nombre);
        this.add(jtf_apellido);
        this.add(jtf_correo);
        this.add(btn_guardar);
        this.add(btn_cancelar);
        this.add(jcb_dia);
        this.add(jcb_mes);
        this.add(jcb_anno);
    
        ActionListener guardar = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {    
            
            }
        };
        
        btn_cancelar.addActionListener(cancelar);
        btn_guardar.addActionListener(guardar);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    ActionListener cancelar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {    
            dispose();
        }
    };
    
    
    
    
}
