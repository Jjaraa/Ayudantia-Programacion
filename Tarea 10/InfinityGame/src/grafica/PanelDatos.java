
package grafica;

import game.Juego;
import game.Jugador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class PanelDatos extends JPanel implements ActionListener {
    
    ArrayList<JLabel> nombresJugadores = new ArrayList<>();
    JLabel etiquetaTitulo;
    int contador = 50;
    
    public PanelDatos(ArrayList<Jugador> jugadores){
        definirAtributos();
        definirLabels(jugadores);
        mostrarLabels();
    }
    
    private void definirAtributos(){
        this.setSize(400, 800);         
        this.setLayout(null);
        this.setVisible(true);
        
    }
    
    private void definirLabels(ArrayList<Jugador> jugadores){
        for(Jugador item:jugadores){
            JLabel nombreJugador = new JLabel("Jugador: "+item.getNombre());
            nombreJugador.setBackground(Color.BLUE);
            JLabel vidaJugador = new JLabel("Vida: "+item.getVida());
            JLabel posicionJugador = new JLabel("Posicion: "+item.getPosicion());
            JLabel meditarJugador = new JLabel("Meditaciones restantes: "+item.getMeditar());
            JLabel energiaJugador = new JLabel("Energia; ");
            nombresJugadores.add(nombreJugador);
            nombresJugadores.add(vidaJugador);
            nombresJugadores.add(posicionJugador);
            nombresJugadores.add(energiaJugador);
            nombresJugadores.add(meditarJugador);
        }
        
    }
    
    private void mostrarLabels(){
        
        for(JLabel item1:nombresJugadores){
            item1.setBounds(500, contador, 200, 20);
            this.add(item1);
            contador+=30;
        }
        JLabel etiquetaTitulo = new JLabel("Estadisticas de los jugadores");
        etiquetaTitulo.setBounds(500, 0, 500, 20);
        this.add(etiquetaTitulo);        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
