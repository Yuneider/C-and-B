package INTERFAZ;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI_inicio extends JFrame{
    
    public String correo;
    public String contrasena;
    public int estado=0;

    private JLabel lbl_titulo1;
    private JLabel lbl_titulo2;
    private JLabel lbl_titulo3;
    private JButton btn_login;
    private JButton btn_registrar;
    private JButton btn_recuperar;
    private JPasswordField pwf;
    private JTextField jtf_usuario;
    private JLabel lbl_1;
    private JLabel lbl_2;

    public GUI_inicio(String c,String p){
        //Creacion de colores
        Color color_griso=new Color(49,49,49);
        Color color_grisc=new Color(166,166,166);
        Color color_rojo=new Color(180,8,8);
        Color color_azul=new Color(82,113,255);
        
        //Propiedades de la ventana
        this.setTitle("C&B-App");
        this.setLayout(null);
        this.setSize(500,300);
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
        btn_login = new JButton("Ingresar");
        btn_registrar = new JButton("Registrarme");
        btn_recuperar = new JButton("Olvide mi contraseña");
        btn_recuperar.setBorder(null);
        pwf = new JPasswordField(p);
        jtf_usuario = new JTextField(c);
        lbl_1 = new JLabel("Usuario:");
        lbl_2 = new JLabel("Contraseña: ");
        
        //Fuente de los elementos
        btn_recuperar.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        btn_registrar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_login.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_titulo1.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_titulo2.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_titulo3.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_1.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_2.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jtf_usuario.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        pwf.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        
        //Posicion de los elementos
        lbl_titulo1.setBounds(180, 30, 120, 30);
        lbl_titulo2.setBounds(290, 30, 20, 30);
        lbl_titulo3.setBounds(310, 30, 50, 30);
        lbl_1.setBounds(50, 90, 150, 30);
        lbl_2.setBounds(50, 130, 150, 30);
        btn_login.setBounds(50, 180, 120, 30);
        btn_recuperar.setBounds(20, 220, 200, 30);
        btn_registrar.setBounds(270, 180, 130, 30);        
        jtf_usuario.setBounds(150, 90, 240, 25);
        pwf.setBounds(150, 130, 150, 25);
        
        //Colores de los elementos
        lbl_titulo1.setForeground(color_azul);
        lbl_titulo2.setForeground(color_grisc);
        lbl_titulo3.setForeground(color_rojo);        
        lbl_1.setForeground(Color.white);
        lbl_2.setForeground(Color.white);
        jtf_usuario.setBackground(color_grisc);
        pwf.setBackground(color_grisc);
        btn_login.setBackground(color_grisc);
        btn_registrar.setBackground(color_grisc);
        btn_recuperar.setBackground(color_griso);
        btn_recuperar.setForeground(color_azul);
        
        //Agregar elementos a la ventana
        this.add(lbl_titulo1);
        this.add(lbl_titulo2);
        this.add(lbl_titulo3);
        this.add(lbl_1);
        this.add(lbl_2);
        this.add(btn_login);
        this.add(btn_recuperar); 
        this.add(btn_registrar);
        this.add(lbl_logo);
        this.add(pwf);
        this.add(jtf_usuario);
        
        //Boton de ingreso
        btn_login.addActionListener(ingresar);
        btn_registrar.addActionListener(registrarse);
        btn_recuperar.addActionListener(recuperar);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    ActionListener registrarse = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {    
            estado =2;
            dispose();
        }
    };
    
    ActionListener recuperar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {    
            estado =3;
            dispose();
        }
    };
    
    ActionListener ingresar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            estado=1;
            correo=jtf_usuario.getText();
            contrasena=pwf.getText();
            dispose();
        }
    };

}
