
package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class ElegirGuerrero extends JFrame {
    JLabel etiqueta1;
    JButton boton1;
    JTextField campo;
    
    public ElegirGuerrero(){
        this.setDefaultCloseOperation(3);
        this.setSize(400, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        etiqueta1 = new JLabel("Escriba el nombre del jugador");
        etiqueta1.setBounds(20, 20, 500, 50);
        this.add(etiqueta1);
        campo = new JTextField();
        campo.setBounds(200, 37, 100, 20);
        this.add(campo);
        boton1 = new JButton("Aceptar");
        boton1.setBounds(260, 90, 100, 20);
        this.add(boton1);
        
    }
}
