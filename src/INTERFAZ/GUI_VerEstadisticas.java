package INTERFAZ;

import Logica.Estadisticas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_VerEstadisticas extends JFrame {

    private JLabel lbl_titulo1;
    private JLabel lbl_titulo2;
    private JLabel lbl_titulo3;
    private JLabel lbl_estadisticas;
    private JLabel lbl_categorias;
    private JLabel lbl_errores;
    private JLabel lbl_generales;
    private JLabel lbl_edades;
    private JButton btn_volver;
    private JPanel jp_1;
    private JPanel jp_2;
    private JPanel jp_3;
    private JPanel jp_4;
    
    private Estadisticas estad;
    public int estado=0;
    
    public GUI_VerEstadisticas(Estadisticas es){
        estad=es;
        
        //Creacion de colores
        Color color_griso=new Color(49,49,49);
        Color color_grisc=new Color(166,166,166);
        Color color_rojo=new Color(180,8,8);
        Color color_azul=new Color(82,113,255);
        Color color_grism=new Color(60,63,65);
        
        //Propiedades de la ventana
        this.setTitle("C&B-App");
        this.setLayout(null);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(color_griso);
        
        //Logo
        JLabel lbl_logo = new JLabel();
        lbl_logo.setBounds(-20,-30,200,150);
        ImageIcon icon_logo = new ImageIcon("C:/Users/USUARIO/Documents/NetBeansProjects/C-and-B/LOGO.png");
        Icon icono = new ImageIcon(icon_logo.getImage().getScaledInstance(lbl_logo.getWidth(),lbl_logo.getHeight(), Image.SCALE_DEFAULT));
        lbl_logo.setIcon(icono);
        lbl_logo.repaint();
        
        jp_2 = new JPanel();
        jp_1 = new JPanel();
        jp_3 = new JPanel();
        jp_4 = new JPanel();
        jp_1.setLayout(null);
        jp_2.setLayout(null);
        jp_3.setLayout(null);
        jp_4.setLayout(null);
        lbl_titulo1 = new JLabel("COMPARE");
        lbl_titulo2 = new JLabel("&");
        lbl_titulo3 = new JLabel("BUY");
        lbl_estadisticas = new JLabel("ESTADISTICAS DEL ADMINISTRADOR");
        lbl_categorias = new JLabel("Categorias");
        lbl_errores = new JLabel("Errores al");
        lbl_generales = new JLabel("Otros datos");
        lbl_edades = new JLabel("Edades");
        btn_volver = new JButton("Volver al perfil");
        
        lbl_titulo1.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_titulo2.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_titulo3.setFont(new Font("Berlin Sans FB",Font.PLAIN,26));
        lbl_estadisticas.setFont(new Font("Berlin Sans FB",Font.PLAIN,23));
        lbl_categorias.setFont(new Font("Berlin Sans FB",Font.HANGING_BASELINE,23));
        lbl_errores.setFont(new Font("Berlin Sans FB",Font.HANGING_BASELINE,23));
        lbl_generales.setFont(new Font("Berlin Sans FB",Font.HANGING_BASELINE,23));
        lbl_edades.setFont(new Font("Berlin Sans FB",Font.HANGING_BASELINE,23));
        btn_volver.setFont(new Font("Berlin Sans FB",Font.PLAIN,17));
        
        lbl_titulo1.setBounds(270, 30, 120, 30);
        lbl_titulo2.setBounds(400, 30, 20, 30);
        lbl_titulo3.setBounds(430, 30, 50, 30);
        lbl_categorias.setBounds(120, 5, 240, 30);
        lbl_edades.setBounds(150,5, 240, 30);
        lbl_generales.setBounds(120, 5, 240, 30);
        lbl_errores.setBounds(140,5, 240, 30);
        lbl_estadisticas.setBounds(200, 70, 400, 40);
        btn_volver.setBounds(630, 520, 150, 30);
        jp_1.setBounds(17, 110, 360, 195);
        jp_2.setBounds(400, 110, 370, 195);
        jp_3.setBounds(17, 320, 360, 215);
        jp_4.setBounds(400, 320, 370, 180);
        
        lbl_titulo1.setForeground(color_azul);
        lbl_titulo2.setForeground(color_grisc);
        lbl_titulo3.setForeground(color_rojo);
        lbl_categorias.setForeground(Color.WHITE);
        lbl_edades.setForeground(Color.WHITE);
        lbl_errores.setForeground(Color.WHITE);
        lbl_generales.setForeground(Color.WHITE);
        lbl_estadisticas.setForeground(Color.WHITE);
        btn_volver.setBackground(color_grisc);
        btn_volver.setForeground(Color.BLACK);
        jp_1.setBackground(color_grism);
        jp_2.setBackground(color_grism);
        jp_3.setBackground(color_grism);
        jp_4.setBackground(color_grism);
        
        btn_volver.addActionListener(volver);
        
        jp_1.add(lbl_edades);
        jp_2.add(lbl_errores);
        jp_3.add(lbl_categorias);
        jp_4.add(lbl_generales);
        this.add(jp_1);
        this.add(jp_2);
        this.add(jp_3);
        this.add(jp_4);
        this.add(lbl_logo);
        this.add(lbl_titulo1);
        this.add(lbl_titulo2);
        this.add(lbl_titulo3);
        this.add(lbl_estadisticas);
        this.add(btn_volver);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    ActionListener volver = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            dispose();
            estado=1;
        }
    };

    public void paint(Graphics g){
        super.paint(g);
        //GRAFICA CATEGORIAS
        int int_1 = estad.estad_Categorias[0];
        int int_2 = estad.estad_Categorias[1];
        int int_3 = estad.estad_Categorias[2];
        int int_4 = estad.estad_Categorias[3];
        int int_5 = estad.estad_Categorias[4];
        int int_6 = estad.estad_Categorias[5];

        int total = int_1+int_2+int_3+int_4+int_5+int_6;
        if (total!=0){
            int grados_cel = int_1 * 360 / total;
            int grados_veh = int_2 * 360 / total;
            int grados_dep = int_3 * 360 / total;
            int grados_vid = int_4 * 360 / total;
            int grados_com = int_5 * 360 / total;
            int grados_ofi = 360-grados_cel-grados_veh-grados_dep-grados_vid-grados_com;

            g.setColor(new Color(170,216,196));
            g.fillArc(45, 380, 165, 165, 0, grados_cel);
            g.fillRect(240, 400, 15, 15);

            g.setColor(new Color(89,193,151));
            g.fillArc(45, 380, 165, 165, grados_cel, grados_veh);
            g.fillRect(240, 420, 15, 15);

            g.setColor(new Color(31,180,83));
            g.fillArc(45, 380, 165, 165, grados_cel+grados_veh,grados_dep);
            g.fillRect(240, 440, 15, 15);

            g.setColor(new Color(5,133,88));
            g.fillArc(45, 380, 165, 165, grados_cel+grados_veh+grados_dep,grados_vid);
            g.fillRect(240, 460, 15, 15);

            g.setColor(new Color(20,100,46));
            g.fillArc(45, 380, 165, 165, grados_cel+grados_veh+grados_dep+grados_vid,grados_com);
            g.fillRect(240, 480, 15, 15);

            g.setColor(new Color(17,47,24));
            g.fillArc(45, 380, 165, 165, grados_cel+grados_veh+grados_dep+grados_vid+grados_com,grados_ofi);
            g.fillRect(240, 500, 15, 15);

            g.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
            g.setColor(Color.white);
            g.drawString("Celulares "+int_1, 260, 412);
            g.drawString("Vehículos "+int_2, 260, 432);
            g.drawString("Deportes "+int_3, 260, 452);
            g.drawString("Video Juegos "+int_4, 260, 472);
            g.drawString("Computación "+int_5, 260, 492);
            g.drawString("Oficina "+int_6, 260, 512);
        }
        else{
            g.setColor(new Color(166,166,166));
            g.fillArc(45, 380, 165, 165, 0, 360);
            
            g.setColor(new Color(170,216,196));
            g.fillRect(240, 400, 15, 15);

            g.setColor(new Color(32,177,128));
            g.fillRect(240, 420, 15, 15);

            g.setColor(new Color(31,180,83));
            g.fillRect(240, 440, 15, 15);

            g.setColor(new Color(5,133,88));
            g.fillRect(240, 460, 15, 15);

            g.setColor(new Color(20,100,46));
            g.fillRect(240, 480, 15, 15);

            g.setColor(new Color(17,47,24));
            g.fillRect(240, 500, 15, 15);

            g.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
            g.setColor(Color.white);
            g.drawString("Celulares "+int_1, 260, 412);
            g.drawString("Vehículos "+int_2, 260, 432);
            g.drawString("Deportes "+int_3, 260, 452);
            g.drawString("Video Juegos "+int_4, 260, 472);
            g.drawString("Computación "+int_5, 260, 492);
            g.drawString("Oficina "+int_6, 260, 512);
        }
        //GRAFICA EDADES
        int_1 = estad.estad_Edades[0];
        int_2 = estad.estad_Edades[1];
        int_3 = estad.estad_Edades[2];
        int_4 = estad.estad_Edades[3];
        int_5 = estad.estad_Edades[4];

        total = int_1+int_2+int_3+int_4+int_5;
        if (total!=0){
            int grados_i = int_1 * 360 / total;
            int grados_a1 = int_2 * 360 / total;
            int grados_j = int_3 * 360 / total;
            int grados_a2 = int_4 * 360 / total;
            int grados_m = 360-grados_i-grados_a1-grados_j-grados_a2;

            g.setColor(new Color(66,163,247));
            g.fillArc(45, 165, 150, 150, 0, grados_i);
            g.fillRect(210, 200, 15, 15);

            g.setColor(new Color(8,130,240));
            g.fillArc(45, 165, 150, 150, grados_i, grados_a1);
            g.fillRect(210, 220, 15, 15);

            g.setColor(new Color(4,107,189));
            g.fillArc(45, 165, 150, 150, grados_a1+grados_i,grados_j);
            g.fillRect(210, 240, 15, 15);

            g.setColor(new Color(4,93,168));
            g.fillArc(45, 165, 150, 150, grados_j+grados_i+grados_a1,grados_a2);
            g.fillRect(210, 260, 15, 15);

            g.setColor(new Color(3,55,101));
            g.fillArc(45, 165, 150, 150, grados_a2+grados_i+grados_a1+grados_j,grados_m);
            g.fillRect(210, 280, 15, 15);

            g.setFont(new Font("Berlin Sans FB",Font.PLAIN,14));
            g.setColor(Color.white);
            g.drawString("Infancia "+int_1, 230, 212);
            g.drawString("Adolescencia "+int_2, 230, 232);
            g.drawString("Juventud "+int_3, 230, 252);
            g.drawString("Adultez "+int_4, 230, 272);
            g.drawString("Adulto Mayor "+int_5, 230, 292);
        }
        else{
            g.setColor(new Color(166,166,166));
            g.fillArc(45, 165, 150, 150, 0, 360);
            
            g.setColor(new Color(66,163,247));
            g.fillRect(210, 200, 15, 15);

            g.setColor(new Color(8,130,240));
            g.fillRect(210, 220, 15, 15);

            g.setColor(new Color(4,107,189));
            g.fillRect(210, 240, 15, 15);

            g.setColor(new Color(4,93,168));
            g.fillRect(210, 260, 15, 15);

            g.setColor(new Color(3,55,101));
            g.fillRect(210, 280, 15, 15);

            g.setFont(new Font("Berlin Sans FB",Font.PLAIN,14));
            g.setColor(Color.white);
            g.drawString("Infancia "+int_1, 230, 212);
            g.drawString("Adolescencia "+int_2, 230, 232);
            g.drawString("Juventud "+int_3, 230, 252);
            g.drawString("Adultez "+int_4, 230, 272);
            g.drawString("Adulto Mayor "+int_5, 230, 292);
        }
        //GRAFICA ERRORES
        int_1 = estad.estad_Errores[0];
        int_2 = estad.estad_Errores[1];
        int_3 = estad.estad_Errores[2];
        int_4 = estad.estad_Errores[3];
        int_5 = estad.estad_Errores[4];
        total = int_1+int_2+int_3+int_4+int_5;
        
        if (total!=0){
            int grados_1 = int_1 * 360 / total;
            int grados_2 = int_2 * 360 / total;
            int grados_3 = int_3 * 360 / total;
            int grados_4 = int_4 * 360 / total;
            int grados_5 = 360-grados_1-grados_2-grados_3-grados_4;

            g.setColor(new Color(255,127,126));
            g.fillArc(430, 170, 150, 150, 0, grados_1);
            g.fillRect(600, 190, 15, 15);

            g.setColor(new Color(255,43,42));
            g.fillArc(430,170, 150, 150, grados_1, grados_2);
            g.fillRect(600, 210, 15, 15);

            g.setColor(new Color(213,1,0));
            g.fillArc(430,170, 150, 150, grados_1+grados_2,grados_3);
            g.fillRect(600, 230, 15, 15);

            g.setColor(new Color(128,0,0));
            g.fillArc(430,170, 150, 150, grados_1+grados_2+grados_3,grados_4);
            g.fillRect(600, 250, 15, 15);

            g.setColor(new Color(42,0,1));
            g.fillArc(430,170, 150, 150, grados_1+grados_2+grados_3+grados_4,grados_5);
            g.fillRect(600, 270, 15, 15);

            g.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
            g.setColor(Color.white);
            g.drawString("Ingresar "+int_1, 620, 202);
            g.drawString("Registrarse "+int_2, 620, 222);
            g.drawString("Restablecer cuenta "+int_3, 620, 242);
            g.drawString("Eliminar cuenta "+int_4, 620, 262);
            g.drawString("Cambiar contraseña "+int_5, 620, 282);
        }
        else{
            g.setColor(new Color(166,166,166));
            g.fillArc(430,170, 150, 150, 0, 360);
            
            g.setColor(new Color(255,127,126));
            g.fillRect(600, 190, 15, 15);

            g.setColor(new Color(255,43,42));
            g.fillRect(600, 210, 15, 15);

            g.setColor(new Color(213,1,0));
            g.fillRect(600, 230, 15, 15);

            g.setColor(new Color(128,0,0));
            g.fillRect(600, 250, 15, 15);

            g.setColor(new Color(42,0,1));
            g.fillRect(600, 270, 15, 15);

            g.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
            g.setColor(Color.white);
            g.drawString("Ingresar "+int_1, 620, 202);
            g.drawString("Registrarse "+int_2, 620, 222);
            g.drawString("Restablecer cuenta "+int_3, 620, 242);
            g.drawString("Eliminar cuenta "+int_4, 620, 262);
            g.drawString("Cambiar contraseña "+int_5, 620, 282);
        }
        //GRAFICA DATOS GENERALES
        int_1 = estad.estad_Generales[0];
        int_2 = estad.estad_Generales[1];
        int_3 = estad.estad_Generales[2];
        total = int_1+int_2+int_3;
        if (total!=0){
            int grados_1 = int_1 * 360 / total;
            int grados_2 = int_2 * 360 / total;
            int grados_3= 360-grados_1-grados_2;
            
            g.setColor(new Color(5,5,5));
            g.fillArc(430, 380, 120, 120, 0, grados_1);
            g.fillRect(600, 410, 15, 15);

            g.setColor(new Color(27,27,27));
            g.fillArc(430, 380, 120, 120, grados_1, grados_2);
            g.fillRect(600, 430, 15, 15);

            g.setColor(new Color(189,189,189));
            g.fillArc(430, 380, 120, 120, grados_1+grados_2,grados_3);
            g.fillRect(600, 450, 15, 15);

            g.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
            g.setColor(Color.white);
            g.drawString("Correos enviados "+int_1, 620, 422);
            g.drawString("Usuarios activos "+int_2, 620, 442);
            g.drawString("Usuarios eliminados "+int_3, 620, 462);
        }
        else{
            g.setColor(new Color(166,166,166));
            g.fillArc(430,380, 120, 120, 0, 360);
            
            g.setColor(new Color(5,5,5));
            g.fillRect(600, 410, 15, 15);

            g.setColor(new Color(27,27,27));
            g.fillRect(600, 430, 15, 15);

            g.setColor(new Color(189,189,189));
            g.fillRect(600, 450, 15, 15);

            g.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
            g.setColor(Color.white);
            g.drawString("Correos enviados "+int_1, 620, 422);
            g.drawString("Usuarios activos "+int_2, 620, 442);
            g.drawString("Usuarios eliminados "+int_3, 620, 462);
        }
        
    }
}    
