
package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import game.Juego;
import game.Jugador;
import game.Guerrero;
import game.Mago;
import java.util.ArrayList;


public class VentanaPrincipal extends JFrame implements ActionListener {
    JLabel etiqueta1,etiqueta2;
    JButton boton1,boton2,boton3;
    boolean casillas = false;
    boolean jugador = false;
    int contador = 1;
    int numeroCasillas;
    ArrayList<Jugador> finalJugadores = new ArrayList<>();
    
    public VentanaPrincipal(){
        definirAtributos();
        definirLabels();
        definirButtons();
        
    }
    
    private void definirAtributos(){
        this.setDefaultCloseOperation(3);
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        
    }
    
    private void definirLabels(){
        etiqueta1 = new JLabel("Bienvenido a InfinityGame");       
        etiqueta1.setBounds(10, 20, 500, 50);
        this.add(etiqueta1);
        etiqueta2 = new JLabel("Elija una opcion:");
        etiqueta2.setBounds(10, 40, 500, 50);
        this.add(etiqueta2);
        
    }
    
    private void definirButtons(){
        boton1 = new JButton("Definir numero de casillas");
        boton1.setBounds(140, 90, 200, 20);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    int valor = Integer.parseInt(JOptionPane.showInputDialog("Defina el numero de casillas para el tablero"));
                    casillas = true;
                    numeroCasillas = valor;
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(boton1, "El dato ingresado es incorrecto. Vuelva a intentarlo");
                   
                }
            }
        });
        this.add(boton1);
        boton2 = new JButton("Agregar jugador");
        boton2.setBounds(140, 120, 200, 20);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    String[] tipoJugadores = {"Guerrero","Mago"};
                    String nombre = JOptionPane.showInputDialog("Escriba el nombre del jugador");
                    int respuesta = JOptionPane.showOptionDialog(boton1, "Seleccione el tipo de jugador que será", "Tipo de jugador", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipoJugadores, tipoJugadores[0]);                    
                    if(respuesta == 0){
                        Guerrero jugador1 = new Guerrero(nombre,contador);
                        finalJugadores.add(jugador1);
                        contador++;
                                
                    }else{
                        Mago jugador2 = new Mago(nombre,contador);
                        finalJugadores.add(jugador2);
                        contador++;}
                    
                    jugador = true;
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                    JOptionPane.showMessageDialog(boton1, "El dato ingresado es incorrecto. Vuelva a intentarlo");
                   
                }
            }
        });
        this.add(boton2);
        boton3 = new JButton("Comenzar a jugar");
        boton3.setBounds(140,150,200,20);        
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                if((casillas)&&(jugador)){                    
                    Juego juego = new Juego(numeroCasillas,finalJugadores);
                    juego.generarTablero(); 
                    for(Jugador item:juego.getJugadores()){
                        item.definirJuego(juego);
                    }                   
                    Jugador jugador = juego.buscarJugador(1, juego.getJugadores());
                    VentanaTurnos ventana1 = new VentanaTurnos(juego,jugador,1);
                    VentanaTablero ventana = new VentanaTablero(juego);
                    ocultarFrame();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Aun no puede iniciar el juego. Primero debe definir el numero de casillas e ingresar al menos un jugador");
                }
                
            }
        });
        this.add(boton3);
        
        
    }
    
        private void ocultarFrame(){
            this.setVisible(false);
        }

   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
