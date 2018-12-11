
package grafica;

import game.Juego;
import game.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;



public class VentanaTurnos extends JFrame implements ActionListener  {
    private int contador;
    
    
    public VentanaTurnos(Juego juego, Jugador jugador, int subIndice){
        this.contador = subIndice;
        definirAtributos();
        agregarPaneles(juego,jugador);
    }
    
    private void definirAtributos(){
        this.setDefaultCloseOperation(3);
        this.setSize(800, 600);
        this.setResizable(false);        
        this.setLocationRelativeTo(null);        
        this.setVisible(true);
        
    }
    
    private void agregarPaneles(Juego juego, Jugador jugador){
        PanelOpciones panelOpciones = new PanelOpciones(juego,jugador,this.contador,this);       
        this.add(panelOpciones);
        PanelDatos panelDatos = new PanelDatos(juego.getJugadores());        
        this.add(panelDatos);
        
        
    }
    
    public int getContador(){
        return this.contador;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
