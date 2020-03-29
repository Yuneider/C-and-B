
package INTERFAZ;

// Autor Jhony Caro
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI_registrar extends JFrame{
    
    public String nombre;
    public String apellido;
    public String correo;
    public String contrasena_1;
    public String contrasena_2;
    public String dia_nacimiento;
    public String mes_nacimiento;
    public String anno_nacimiento;
    public int estado=0;  
    
    private JLabel lbl_titulo1;
    private JLabel lbl_titulo2;
    private JLabel lbl_titulo3;
    private JLabel lbl_mensaje;        
    private JLabel lbl_nombre;
    private JLabel lbl_apellido;
    private JLabel lbl_contrasena;
    private JLabel lbl_correo;
    private JLabel lbl_confirmacion1;
    private JLabel lbl_confirmacion2;
    private JLabel lbl_fecha1;
    private JLabel lbl_fecha2;
    private JTextField jtf_nombre;
    private JTextField jtf_apellido;
    private JTextField jtf_correo;
    private JPasswordField pwf1;
    private JPasswordField pwf2;
    private JButton btn_guardar;
    private JButton btn_cancelar;
    private JComboBox jcb_dia;
    private JComboBox jcb_mes;
    private JComboBox jcb_anno;
        
    public GUI_registrar(String n, String a, String c){
        //Creacion de colores
        Color color_griso=new Color(49,49,49);
        Color color_grisc=new Color(166,166,166);
        Color color_rojo=new Color(180,8,8);
        Color color_azul=new Color(82,113,255);
        Color color_grism=new Color(60,63,65);
        
        //Propiedades de la ventana
        this.setTitle("C&B-App");
        this.setLayout(null);
        this.setSize(550,600);
        this.setResizable(false);
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
        lbl_titulo1 = new JLabel("COMPARE");
        lbl_titulo2 = new JLabel("&");
        lbl_titulo3 = new JLabel("BUY");
        lbl_mensaje = new JLabel("<html>COMPARE & BUY es un aplicacion pensada para personas ocupadas, no hay necesidad de que busques en diversas paginas web algun producto que desees adquirir, COMPARE & BUY lo hace por ti. Trabajamos en sociedad con paginas web como Mercado Libre y OLX para encontrar el mejor precio de los productos.<html>");        
        lbl_nombre = new JLabel("Nombres: *");
        lbl_apellido = new JLabel("Apellidos: ");
        lbl_contrasena = new JLabel("Contraseña: *");
        lbl_correo = new JLabel("Correo: *");
        lbl_confirmacion1 = new JLabel("Confirmacion  *");
        lbl_confirmacion2 = new JLabel("Contraseña: ");
        lbl_fecha1 = new JLabel("Fecha de");
        lbl_fecha2 = new JLabel("Nacimiento: ");
        jtf_nombre = new JTextField(n);
        jtf_apellido = new JTextField(a);
        jtf_correo = new JTextField(c);
        pwf1 = new JPasswordField();
        pwf2 = new JPasswordField();
        btn_guardar = new JButton("Guardar Registro");
        btn_cancelar = new JButton("Cancelar");
        jcb_dia = new JComboBox<>();
        jcb_mes = new JComboBox<>();
        jcb_anno = new JComboBox<>();
        
        //Edicion de listas desplegables                
        jcb_dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
        jcb_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        for(int f=2020;f>=1920;f--) {
            jcb_anno.addItem(String.valueOf(f));
        }
        
        //Fuente de los elementos
        btn_guardar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_cancelar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jtf_apellido.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jtf_correo.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jtf_nombre.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_apellido.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_titulo1.setFont(new Font("Berlin Sans FB",Font.PLAIN,22));
        lbl_titulo2.setFont(new Font("Berlin Sans FB",Font.PLAIN,22));
        lbl_titulo3.setFont(new Font("Berlin Sans FB",Font.PLAIN,22));
        lbl_nombre.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_correo.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_confirmacion1.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_confirmacion2.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_contrasena.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_fecha1.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_fecha2.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_mensaje.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        pwf1.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        pwf2.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_dia.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_mes.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jcb_anno.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        
        //Posicion de los elementos
        lbl_mensaje.setBounds(180, -30, 330, 200);
        lbl_titulo1.setBounds(3, 80, 120, 30);
        lbl_titulo2.setBounds(105, 80, 20, 30);
        lbl_titulo3.setBounds(122, 80, 50, 30);
        lbl_nombre.setBounds(20, 160, 150, 30);
        lbl_apellido.setBounds(20, 210, 150, 30);
        lbl_correo.setBounds(20, 260, 150, 30);
        lbl_contrasena.setBounds(20, 310, 150, 30);
        lbl_confirmacion1.setBounds(20, 360, 150, 30);
        lbl_confirmacion2.setBounds(50, 380, 150, 30);
        lbl_fecha1.setBounds(20, 430, 150, 30);
        lbl_fecha2.setBounds(50, 450, 150, 30);        
        btn_guardar.setBounds(50, 500, 200, 30);
        btn_cancelar.setBounds(350, 500, 130, 30);
        jtf_nombre.setBounds(150, 160, 250, 25);
        jtf_apellido.setBounds(150, 210, 250, 25);
        jtf_correo.setBounds(150, 260, 300, 25);
        pwf1.setBounds(150, 310, 250, 25);
        pwf2.setBounds(150, 370, 250, 25);
        jcb_dia.setBounds(150, 440, 50, 30);
        jcb_mes.setBounds(210, 440, 120, 30);
        jcb_anno.setBounds(340, 440, 80, 30);
        
        //Colores de los elementos
        lbl_mensaje.setForeground(color_grisc);
        lbl_titulo1.setForeground(color_azul);
        lbl_titulo2.setForeground(color_grisc);
        lbl_titulo3.setForeground(color_rojo);        
        lbl_nombre.setForeground(Color.white);
        lbl_apellido.setForeground(Color.white);
        lbl_correo.setForeground(Color.white);
        lbl_contrasena.setForeground(Color.white);
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
        this.add(lbl_mensaje);
        this.add(lbl_titulo1);
        this.add(lbl_titulo2);
        this.add(lbl_titulo3);
        this.add(lbl_nombre);
        this.add(lbl_apellido);
        this.add(lbl_correo);
        this.add(lbl_contrasena);
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
        
        btn_cancelar.addActionListener(cancelar);
        btn_guardar.addActionListener(guardar);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    ActionListener cancelar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {    
            estado=2;
            dispose();
        }
    };
    
    ActionListener guardar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {    
            nombre=jtf_nombre.getText();
            apellido=jtf_apellido.getText();
            correo=jtf_correo.getText();
            contrasena_1=pwf1.getText();
            contrasena_2=pwf2.getText();
            dia_nacimiento=(String)jcb_dia.getSelectedItem();
            mes_nacimiento=(String)jcb_mes.getSelectedItem();
            anno_nacimiento=(String)jcb_anno.getSelectedItem();
            estado=1;
            dispose();
        }
    };
    
}
