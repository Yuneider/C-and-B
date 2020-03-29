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
import javax.swing.JTextField;

public class GUI_RecuperarContrasena extends JFrame {

    private JLabel lbl_titulo1;
    private JLabel lbl_titulo2;
    private JLabel lbl_titulo3;
    private JButton btn_enviar;
    private JButton btn_cancelar;
    private JTextField jtf;
    private JLabel lbl_correo;
    private JLabel lbl_mensaje;
    private JButton btn_validar;
    
    public String correo;
    public int estado=0;
    public String codigo_verificacion;
    
    public GUI_RecuperarContrasena(){
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
        btn_enviar = new JButton("Enviar correo electronico");
        btn_cancelar = new JButton("Cancelar");
        btn_validar = new JButton("Validar codigo");
        jtf = new JTextField();
        lbl_correo = new JLabel("Correo:");
        lbl_mensaje = new JLabel("<html>Se le enviara un email con un codigo de verificacion para que pueda restablecer su cuenta.<html>");
        
        //Fuente de los elementos
        lbl_titulo1.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_titulo2.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_titulo3.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));
        lbl_correo.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        lbl_mensaje.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        jtf.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_enviar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_validar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        btn_cancelar.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
        
        //Posicion de los elementos
        lbl_titulo1.setBounds(180, 30, 120, 30);
        lbl_titulo2.setBounds(290, 30, 20, 30);
        lbl_titulo3.setBounds(310, 30, 50, 30);
        lbl_correo.setBounds(30, 150, 150, 30);
        lbl_mensaje.setBounds(50, 60, 400, 100);
        btn_enviar.setBounds(50, 200, 230, 30);
        btn_cancelar.setBounds(310, 200, 120, 30);
        btn_validar.setBounds(120, 200, 250, 30);
        jtf.setBounds(130, 150, 280, 25);
        
        //Colores de los elementos
        lbl_titulo1.setForeground(color_azul);
        lbl_titulo2.setForeground(color_grisc);
        lbl_titulo3.setForeground(color_rojo);        
        lbl_correo.setForeground(Color.white);
        lbl_mensaje.setForeground(Color.white);
        jtf.setBackground(color_grisc);
        btn_enviar.setBackground(color_grisc);
        btn_validar.setBackground(color_grisc);
        btn_cancelar.setBackground(color_grisc);
        
        btn_validar.setVisible(false);
        
        //Agregar elementos a la ventana
        this.add(lbl_titulo1);
        this.add(lbl_titulo2);
        this.add(lbl_titulo3);
        this.add(lbl_correo);
        this.add(lbl_mensaje);
        this.add(btn_enviar);
        this.add(btn_validar);
        this.add(btn_cancelar);
        this.add(lbl_logo);
        this.add(jtf);
        
        //Acciones botones
        btn_enviar.addActionListener(enviar);
        btn_validar.addActionListener(validar);
        btn_cancelar.addActionListener(cancelar);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    ActionListener enviar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            correo=jtf.getText();
            estado=1;
            lbl_mensaje.setText("<html>Por favor ingrese el codigo de verificacion enviado al correo: "+correo+"<html>");
            lbl_correo.setText("Codigo de verificacion: ");
            lbl_correo.setBounds(30, 150, 250, 30);
            jtf.setBounds(220, 150, 150, 25);
            jtf.setText("");
            btn_validar.setVisible(true);
            btn_enviar.setVisible(false);
            btn_cancelar.setVisible(false);
        }
    };
    ActionListener validar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            codigo_verificacion=jtf.getText();
            estado=2;
        }
    };
    ActionListener cancelar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            estado=3;
            dispose();
        }
    };    
}
