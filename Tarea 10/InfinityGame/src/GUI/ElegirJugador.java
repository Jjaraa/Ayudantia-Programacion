
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ElegirJugador extends JFrame implements ActionListener {
   
    JLabel etiqueta1;
    JButton boton1,boton2;
    
    public ElegirJugador(){
        this.setDefaultCloseOperation(3);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        etiqueta1 = new JLabel("¿Que clase de jugador será?");
        etiqueta1.setBounds(10, 20, 500, 50);
        this.add(etiqueta1);
        boton1 = new JButton("Guerrero");
        boton1.setBounds(140, 90, 200, 20);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                 
                ElegirGuerrero ventana = new ElegirGuerrero();
                
            }
        });             
        this.add(boton1);
        boton2 = new JButton("Mago");
        boton2.setBounds(140, 120, 200, 20);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                 
                ElegirMago ventana2 = new ElegirMago();
                
            }
        });      
        this.add(boton2);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
