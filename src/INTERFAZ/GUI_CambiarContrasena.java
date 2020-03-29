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

public class GUI_CambiarContrasena extends JFrame {

    private JLabel lbl_titulo1;
    private JLabel lbl_titulo2;
    private JLabel lbl_titulo3;
    private JButton btn_cambiar;
    private JButton btn_cancelar;
    private JPasswordField jpf_contrasena_a;
    private JPasswordField jpf_contrasena1;
    private JPasswordField jpf_contrasena2;
    private JLabel lbl_contrasena1;
    private JLabel lbl_contrasena2;
    private JLabel lbl_contrasena_a;
    
    public int estado=0;
    public String contrasena1;
    public String contrasena2;
    public String contrasena_a;
    
    public GUI_CambiarContrasena(String ca){
        //Creacion de colores
        Color color_griso=new Color(49,49,49);
        Color color_grisc=new Color(166,166,166);
        Color color_rojo=new Color(180,8,8);
        Color color_azul=new Color(82,113,255);
        
        //Propiedades de la ventana
        this.setTitle("C&B-App");
        this.setLayout(null);
        this.setSize(550,350);
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
        btn_cambiar = new JButton("Cambiar Contraseña");
        btn_cancelar = new JButton("Cancelar");
        jpf_contrasena_a = new JPasswordField(ca);
        jpf_contrasena1 = new JPasswordField();
        jpf_contrasena2 = new JPasswordField();
        lbl_contrasena_a = new JLabel("Contraseña anterior: ");
        lbl_contrasena1 = new JLabel("Contraseña nueva: ");
        lbl_contrasena2 = new JLabel("Confirmacion contraseña: ");        
        
        //Fuente de los elementos
        lbl_titulo1.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_titulo2.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_titulo3.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_contrasena_a.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_contrasena1.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_contrasena2.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jpf_contrasena_a.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jpf_contrasena1.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jpf_contrasena2.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_cambiar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_cancelar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        
        //Posicion de los elementos
        lbl_titulo1.setBounds(180, 30, 120, 30);
        lbl_titulo2.setBounds(290, 30, 20, 30);
        lbl_titulo3.setBounds(310, 30, 50, 30);
        lbl_contrasena_a.setBounds(20, 100, 200, 30);
        lbl_contrasena1.setBounds(20, 150, 200, 30);
        lbl_contrasena2.setBounds(20, 200, 200, 30);
        btn_cambiar.setBounds(60, 250, 230, 30);
        btn_cancelar.setBounds(320, 250, 120, 30);
        jpf_contrasena_a.setBounds(240, 100, 250, 25);
        jpf_contrasena1.setBounds(240, 150, 250, 25);
        jpf_contrasena2.setBounds(240, 200, 250, 25);
        
        //Colores de los elementos
        lbl_titulo1.setForeground(color_azul);
        lbl_titulo2.setForeground(color_grisc);
        lbl_titulo3.setForeground(color_rojo);        
        lbl_contrasena_a.setForeground(Color.white);
        lbl_contrasena1.setForeground(Color.white);
        lbl_contrasena2.setForeground(Color.white);
        jpf_contrasena_a.setBackground(color_grisc);
        jpf_contrasena1.setBackground(color_grisc);
        jpf_contrasena2.setBackground(color_grisc);
        btn_cambiar.setBackground(color_grisc);
        btn_cancelar.setBackground(color_grisc);
        
        //Agregar elementos a la ventana
        this.add(lbl_titulo1);
        this.add(lbl_titulo2);
        this.add(lbl_titulo3);
        this.add(lbl_contrasena_a);
        this.add(lbl_contrasena1);
        this.add(lbl_contrasena2);
        this.add(btn_cambiar);
        this.add(btn_cancelar);
        this.add(lbl_logo);
        this.add(jpf_contrasena_a);
        this.add(jpf_contrasena1);
        this.add(jpf_contrasena2);
        
        //Acciones botones
        btn_cancelar.addActionListener(cancelar);
        btn_cambiar.addActionListener(cambiar);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    ActionListener cambiar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            contrasena_a=jpf_contrasena_a.getText();
            contrasena1=jpf_contrasena1.getText();
            contrasena2=jpf_contrasena2.getText();
            estado=1;
            dispose();
        }
    };
    ActionListener cancelar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            estado=2;
            dispose();
        }
    };
        
}
