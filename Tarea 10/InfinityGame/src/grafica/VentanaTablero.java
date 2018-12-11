
package grafica;

import game.Casilla;
import game.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class VentanaTablero extends JFrame implements ActionListener {
    JButton botonAceptar;
    JLabel etiqueta;
    ArrayList<JButton> botones = new ArrayList<>();
    int contador = 50;
    
    public VentanaTablero(Juego juego){
        definirAtributos();
        generarCasillas(juego);
        definirLabel();
        definirButton();
    }
    
    private void definirAtributos(){
        this.setDefaultCloseOperation(3);
        this.setSize(300, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }
    
    private void ocultarFrame(){
        this.setVisible(false);
    }
    
    private void generarCasillas(Juego juego){
        Casilla[] casillas = juego.getTablero().getCasillas();
        for(int i=0; i<casillas.length;i++){
            JButton boton = new JButton((i+1)+":       "+String.valueOf(casillas[i].getTipoCasilla()));
            botones.add(boton);
        }
        definirCasillas();
    }
    //Al definir las casillas, se redimensionará el tamaño de la ventana, pero si las casillas son muchas, puede no verse completamente
    private void definirCasillas(){
        for(JButton item:botones){
            item.setBounds(100, contador, 100, 20);
            this.add(item);
            contador += 20;
        }
        this.setSize(300, contador+100);
    }
    
    private void definirLabel(){
        etiqueta = new JLabel("Tablero de juego");
        etiqueta.setBounds(100, 0, 500, 20);
        this.add(etiqueta);        
    }
    
    private void definirButton(){
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(100, contador+30, 100, 20);
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ocultarFrame();
            }
        });
        this.add(botonAceptar);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
