
package grafica;

import gestorarchivos.GestorArchivos;
import game.Juego;
import game.Jugador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class PanelOpciones extends JPanel implements ActionListener {
    JButton botonDados,botonHabilidad,botonMeditar,botonSalir,botonTablero;
    JLabel etiquetaTitulo,etiquetaSubtitulo; 
    
    public PanelOpciones(Juego juego, Jugador jugador, int subIndice, VentanaTurnos ventana){
        definirAtributos();
        definirButton(juego,jugador,ventana,juego.getJugadores());
        definirLabel(jugador);
    }
    
    private void definirAtributos(){       
        this.setSize(450, 800);               
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
        this.setVisible(true);
        
    }

    private void definirButton(Juego juego, Jugador jugador, VentanaTurnos ventana, ArrayList<Jugador> jugadores){
        JButton botonDados = new JButton("Lanzar dados");
        botonDados.setBounds(30, 150, 200, 20);
        botonDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              int resultado = jugador.lanzarDados(juego.getGuardian(), juego.getPodio(),jugadores);
              JOptionPane.showMessageDialog(null, "El resultado de los dados es "+resultado);
              jugador.resolucionDados(resultado, juego.getGuardian(), juego.getPodio(), jugadores);
                pasarTurno(juego, ventana);
            }
        });
        this.add(botonDados);
        JButton botonHabilidad = new JButton("Usar Habilidad Especial");
        botonHabilidad.setBounds(30, 180, 200, 20);
        botonHabilidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "No tienes energia para usar una habilidad");
            }
        });
        this.add(botonHabilidad);
        JButton botonMeditar = new JButton("Meditar");
        botonMeditar.setBounds(30, 210, 200, 20);
        botonMeditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(jugador.getMeditar()>1){
                try{
                    int opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoja un numero entre -3 al 3 para moverse esa cantidad de espacios."));
                    while((opcion>3)||(opcion<-3)){
                        JOptionPane.showMessageDialog(null, "Valor incorrecto. Recuerde que los numeros deben ser entre -3 y 3");
                        opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoja un numero entre -3 al 3 para moverse esa cantidad de espacios."));
                    }
                    jugador.meditarOpcion1(jugador, opcion);
                    JOptionPane.showMessageDialog(null, "Meditacion completa");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Ha introducido un valor no valido. Intentelo otra vez");
                }
                }else{
                    JOptionPane.showMessageDialog(null, "No quedan opciones de meditar. Pasarás turno y perderás un punto de vida");
                    jugador.meditarOpcion2(jugador);
                }
                pasarTurno(juego, ventana);
            }
        });
        this.add(botonMeditar);
        JButton botonSalir = new JButton("Salir");
        botonSalir.setBounds(30, 550, 200, 20);
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GestorArchivos nuevo = new GestorArchivos();
                nuevo.escribir(jugadores);
                System.exit(0);
            }
        });
        this.add(botonSalir);
        JButton botonTablero = new JButton("Mostrar tablero");
        botonTablero.setBounds(250, 0, 200, 20);
        botonTablero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaTablero ventanaTablero = new VentanaTablero(juego);
            }
        });
        this.add(botonTablero);
    }
        
    
    private void definirLabel(Jugador jugador){
        etiquetaTitulo = new JLabel("Es el turno del jugador "+jugador.getNombre());
        etiquetaTitulo.setBounds(30, 0, 200, 20);
        this.add(etiquetaTitulo);
        etiquetaSubtitulo = new JLabel("Eliga una de las siguientes opciones:");
        etiquetaSubtitulo.setBounds(30, 20, 300, 20);
        this.add(etiquetaSubtitulo);
    }
    
    private void pasarTurno(Juego juego,VentanaTurnos ventana){        
        preguntarGanador(juego);
        int contador = ventana.getContador();
        int contadorNuevo = 0;
        if(contador+1<=juego.getJugadores().size()){
            contadorNuevo = contador+1;
        }else{
            contadorNuevo = 1;
        }
        Jugador jugador = juego.buscarJugador(contadorNuevo, juego.getJugadores());
        ocultarFrame(ventana);
        VentanaTurnos ventanaNueva = new VentanaTurnos(juego,jugador,contadorNuevo);
    }
    
    private void preguntarGanador(Juego juego){
        String[] podio = juego.getPodio().getLugares();
        if(podio[0]!=null){
            JOptionPane.showMessageDialog(null, "El jugador "+podio[0]+" es el ganador!! Felicidades");
            System.exit(0);
        }
    }
    
    private void ocultarFrame(VentanaTurnos ventana){
        ventana.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setLayout(float LEFT_ALIGNMENT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
