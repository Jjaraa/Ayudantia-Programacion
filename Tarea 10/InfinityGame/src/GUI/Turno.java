
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Turno extends JFrame implements ActionListener {

    JLabel etiqueta1,etiqueta2;
    JButton boton1,boton2,boton3;
    
    public Turno(){
        this.setDefaultCloseOperation(3);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        etiqueta1 = new JLabel("Turno del Jugador");
        etiqueta1.setBounds(10, 20, 500, 50);
        this.add(etiqueta1);
        etiqueta2 = new JLabel("Eliga una opción:");
        etiqueta2.setBounds(10, 40, 500, 50);
        this.add(etiqueta2);
        boton1 = new JButton("Lanzar dados");
        boton1.setBounds(140, 90, 200, 20);        
        this.add(boton1);
        boton2 = new JButton("Meditar");
        boton2.setBounds(140, 120, 200, 20);                       
        this.add(boton2);
        boton3= new JButton("Usar habilidad");
        boton3.setBounds(140, 150, 200, 20);
        this.add(boton3);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==boton1){
            JOptionPane.showMessageDialog(this, "Se han lanzado los dados");
        }
        if(ae.getSource()==boton2){
            JOptionPane.showMessageDialog(this, "El jugador está meditando");
        }
        if(ae.getSource()==boton3){
            JOptionPane.showMessageDialog(this, "El jugador ha usado su habilidad especial");
        }
        
    }
    
}
