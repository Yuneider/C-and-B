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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_cliente extends JFrame{

    public String correo; 
    public int estado=0;
    public boolean[] preferencias = new boolean[7];
    
    private JPanel jp_info_p;
    private JCheckBox jcb_notificacion;
    private JCheckBox jcb_celulares;
    private JCheckBox jcb_vehiculos;
    private JCheckBox jcb_deportes;
    private JCheckBox jcb_videojuegos;
    private JCheckBox jcb_computacion;
    private JCheckBox jcb_oficina;
    private JButton btn_modificar_con;
    private JButton btn_salir;        
    private JButton btn_preferencias;
    private JButton btn_guardar;
    private JLabel lbl_mensaje;
    private JLabel lbl_titulo1;
    private JLabel lbl_titulo2;
    private JLabel lbl_titulo3;
    private JLabel lbl_preferencias;
    private JLabel lbl_nombre;
    private JLabel lbl_correo;
    private JLabel lbl_fecha_nacimiento;
    private JLabel lbl_info_p;

    public GUI_cliente(Perfil p){
        correo=p.correo;
        preferencias=p.preferencias;
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
        jp_info_p = new JPanel();
        jp_info_p.setLayout(null);
        jcb_notificacion = new JCheckBox("Recibir notificaciones");
        jcb_celulares = new JCheckBox("Celulares y Smartphones");
        jcb_vehiculos = new JCheckBox("Vehículos");
        jcb_deportes = new JCheckBox("Deportes");
        jcb_videojuegos = new JCheckBox("Videojuegos");
        jcb_computacion = new JCheckBox("Computación");
        jcb_oficina = new JCheckBox("Oficina");
        btn_modificar_con = new JButton("Cambiar contraseña");
        btn_salir = new JButton("Cerrar Sesion");        
        btn_preferencias = new JButton("<html>Modificar Preferencias<html>");
        btn_guardar = new JButton("Guardar");
        lbl_mensaje = new JLabel("<html>Al aceptar recibir notificaciones se le enviarán correos electrónicos con los productos descatados de las categorías (preferencias) que haya seleccionado anteriormente.<html>");
        lbl_titulo1 = new JLabel("COMPARE");
        lbl_titulo2 = new JLabel("&");
        lbl_titulo3 = new JLabel("BUY");
        lbl_preferencias = new JLabel("Preferencias");
        lbl_nombre = new JLabel("Nombre:                      "+p.nombre);
        lbl_correo = new JLabel("Email:                          "+p.correo);
        lbl_fecha_nacimiento = new JLabel("Fecha de nacimiento:   "+p.ToString_fn()+" ( "+p.CalcularEdad()+" años )");
        lbl_info_p = new JLabel("INFORMACION PERSONAL");
       
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
        btn_modificar_con.setBounds(400,110,190,25);
        btn_salir.setBounds(500,480,150,50);
        btn_preferencias.setBounds(200,250,130,50);
        btn_guardar.setBounds(200,500,120,40);
        
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
        ValidarSeleccionE();
        jcb_notificacion.setEnabled(false);
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
        jp_info_p.add(btn_modificar_con);
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
        this.add(btn_preferencias);
        this.add(btn_guardar);
        
        btn_guardar.addActionListener(guardar);
        btn_preferencias.addActionListener(habilitar);
        btn_salir.addActionListener(salir);
        btn_modificar_con.addActionListener(modificar);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
    
    ActionListener salir = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            dispose();
            estado=2;
        }
    };
        ActionListener modificar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            dispose();
            estado=3;
        }
    };
    ActionListener habilitar = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            btn_preferencias.setVisible(false);
            jcb_celulares.setEnabled(true);
            jcb_vehiculos.setEnabled(true);
            jcb_deportes.setEnabled(true);
            jcb_videojuegos.setEnabled(true);
            jcb_computacion.setEnabled(true);
            jcb_oficina.setEnabled(true);
            jcb_notificacion.setEnabled(true);
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
            jcb_notificacion.setEnabled(false);
            btn_guardar.setVisible(false);
            lbl_preferencias.setVisible(false);
            ValidarSeleccionS();
            estado=1;
        }
    };         
    private void ValidarSeleccionS() {
           if(jcb_celulares.isSelected()){
               preferencias[0]=true;
           }
           else{
               preferencias[0]=false;
           }
           if(jcb_vehiculos.isSelected()){
               preferencias[1]=true;
           }
           else{
               preferencias[1]=false;
           }
           if(jcb_deportes.isSelected()){
               preferencias[2]=true;
           }
           else{
               preferencias[2]=false;
           }
           if(jcb_videojuegos.isSelected()){
               preferencias[3]=true;
           }
           else{
               preferencias[3]=false;
            }
           if(jcb_computacion.isSelected()){
               preferencias[4]=true;
           }
           else{
               preferencias[4]=false;
           }
           if(jcb_oficina.isSelected()){
               preferencias[5]=true;
           }
           else{
               preferencias[5]=false;
           }
           if(jcb_notificacion.isSelected()){
               preferencias[6]=true;
           }
           else{
               preferencias[6]=false;
           }
       }
       private void ValidarSeleccionE() {
           if(preferencias[0]==true){
               jcb_celulares.doClick();
           }
           if(preferencias[1]==true){
               jcb_vehiculos.doClick();
           }
           if(preferencias[2]==true){
               jcb_deportes.doClick();
           }
           if(preferencias[3]==true){
               jcb_videojuegos.doClick();
           }
           if(preferencias[4]==true){
               jcb_computacion.doClick();
           }
           if(preferencias[5]==true){
               jcb_oficina.doClick();
           }
           if(preferencias[6]==true){
               jcb_notificacion.doClick();
           }
       }

}



