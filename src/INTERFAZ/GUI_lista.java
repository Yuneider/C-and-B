
package INTERFAZ;

import Logica.Perfil;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI_lista extends JFrame{
    
    private JLabel lbl_titulo1;
    private JLabel lbl_titulo2;
    private JLabel lbl_titulo3;
    private JLabel lbl_usuarios;
    private JLabel lbl_nombre;
    private JLabel lbl_recibe;
    private JButton btn_volver;
    
    public int estado=0; 
    
    public GUI_lista(ArrayList<Perfil> p){
        //Creacion de colores
        Color color_griso=new Color(49,49,49);
        Color color_grisc=new Color(166,166,166);
        Color color_rojo=new Color(180,8,8);
        Color color_azul=new Color(82,113,255);
        
        //Propiedades de la ventana
        this.setTitle("C&B-App");
        this.setLayout(null);
        this.setSize(600,700);
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
        lbl_usuarios = new JLabel("USUARIOS");
        lbl_nombre = new JLabel("Nombre (edad)");
        lbl_recibe = new JLabel("Estado Notificaciones");
        btn_volver = new JButton("Volver al perfil");

        //Fuente de los elementos
        lbl_titulo1.setFont(new Font("Berlin Sans FB",Font.PLAIN,21));
        lbl_titulo2.setFont(new Font("Berlin Sans FB",Font.PLAIN,21));
        lbl_titulo3.setFont(new Font("Berlin Sans FB",Font.PLAIN,21));        
        lbl_usuarios.setFont(new Font("Berlin Sans FB",Font.PLAIN,24));        
        lbl_nombre.setFont(new Font("Berlin Sans FB",Font.PLAIN,22));        
        lbl_recibe.setFont(new Font("Berlin Sans FB",Font.PLAIN,22));        
        btn_volver.setFont(new Font("Berlin Sans FB",Font.PLAIN,17));
        
        //Posicion de los elementos
        lbl_titulo1.setBounds(5, 80, 120, 30);
        lbl_titulo2.setBounds(100, 80, 20, 30);
        lbl_titulo3.setBounds(118, 80, 50, 30);        
        lbl_usuarios.setBounds(230, 50, 200, 30);        
        lbl_nombre.setBounds(100, 130, 180, 30);        
        lbl_recibe.setBounds(375, 130, 250, 30);        
        btn_volver.setBounds(400, 620, 150, 30);
        
        //Colores de los elementos
        lbl_titulo1.setForeground(color_azul);
        lbl_titulo2.setForeground(color_grisc);
        lbl_titulo3.setForeground(color_rojo);
        lbl_usuarios.setForeground(Color.WHITE);
        lbl_nombre.setForeground(color_grisc);
        lbl_recibe.setForeground(color_grisc);
        btn_volver.setBackground(color_grisc);
        btn_volver.setForeground(Color.BLACK);
        
        btn_volver.addActionListener(volver);
        
        int y=140,num=0;
        for (int i=0;i<p.size();i++){
            if(p.get(i).rol==false){
                y=y+30;
                JLabel lbl_usuario = new JLabel(++num+"- "+p.get(i).nombre+" ("+p.get(i).CalcularEdad()+" años)");
                JLabel lbl_estado = new JLabel();
                lbl_usuario.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
                lbl_estado.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
                lbl_usuario.setBounds(20, y, 400, 30);
                lbl_estado.setBounds(465, y, 100, 30);
                lbl_usuario.setForeground(Color.WHITE);
                if (p.get(i).preferencias[6]==true){
                    lbl_estado.setText("Activo");
                    lbl_estado.setForeground(color_azul);
                }
                else{
                    lbl_estado.setText("Inactivo");
                    lbl_estado.setForeground(color_rojo);
                }
                this.add(lbl_usuario);
                this.add(lbl_estado);
            }
        }
        
        this.add(lbl_titulo1);
        this.add(lbl_titulo2);
        this.add(lbl_titulo3);
        this.add(lbl_logo);
        this.add(lbl_usuarios);
        this.add(lbl_nombre);
        this.add(lbl_recibe);
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
    
}
