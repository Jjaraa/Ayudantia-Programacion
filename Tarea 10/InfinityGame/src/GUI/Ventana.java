package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Ventana extends JFrame implements ActionListener{

    JLabel etiqueta1,etiqueta2;
    JButton boton1,boton2;
    
    
    public Ventana(){
        this.setDefaultCloseOperation(3);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        etiqueta1 = new JLabel("Bienvenido a Infinity Game");
        etiqueta1.setBounds(10, 20, 500, 50);
        this.add(etiqueta1);
        etiqueta2 = new JLabel("Eliga una opción:");
        etiqueta2.setBounds(10, 40, 500, 50);
        this.add(etiqueta2);
        boton1 = new JButton("Definir numero de casillas");
        boton1.setBounds(140, 90, 200, 20);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                NumeroCasillas ventana1 = new NumeroCasillas();
            } catch(Exception e){
                    
            }
            
            }
        });
        this.add(boton1);
        boton2 = new JButton("Agregar jugador");
        boton2.setBounds(140, 120, 200, 20);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                 
                ElegirJugador ventana2 = new ElegirJugador();
                
            }
        });               
        this.add(boton2);
       
    }   
           
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}