
package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Tablero tablero;
    private Podio podio;
    private Guardian guardian;
    

    public Juego(int numeroCasillas, String nombreJugador) {        
        Jugador jugador1= new Jugador(nombreJugador,1);
        this.jugadores.add(jugador1);
        this.tablero = new Tablero(numeroCasillas);
        this.podio = new Podio(this.jugadores);

    }        
    
    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }
    
    public Tablero getTablero(){
        return this.tablero;
    }
    
    public Podio getPodio(){
        return this.podio;
    }
    
    //metodos referentes a los jugadores
    public void agregarMago(String nombreJugador, ArrayList<Jugador> jugadores){
        int subIndice = jugadores.size()+1;
        Mago jugador = new Mago(nombreJugador,subIndice);
        jugadores.add(jugador);
        
    }
    
    public void agregarGuerrero(String nombreJugador, ArrayList<Jugador> jugadores){
        int subIndice = jugadores.size()+1;
        Guerrero jugador = new Guerrero(nombreJugador,subIndice);
        jugadores.add(jugador);
        
    }
    
    public Jugador buscarJugador(int subIndice, ArrayList<Jugador> jugadores){
        Jugador jugador = new Jugador();
        for(Jugador item:jugadores){
            if(item.getSubIndice()==subIndice){
                jugador = item;
            }
        }
        return jugador;
    }
    
    public void mostrarTablaJugadores(ArrayList<Jugador> jugadores) {
        for (Jugador item:jugadores) {
            System.out.println("Jugador: " + item.getNombre());
            System.out.println("Puntos de vida: " + item.getVida());
            System.out.println("Posicion: " + item.getPosicion());
            System.out.println("Opciones de meditar restantes: " + item.getMeditar());
        }
    }

    //metodos referentes al tablero
    public Casilla[] generarTablero() {
        int numeroCasillas = tablero.getNumeroCasillas();
        this.tablero = new Tablero(numeroCasillas);
        char casillaPartida = 'i';
        char casillaBlanco = 'b';
        char casillaPortal = 'p';
        char casillaSalud = 's';
        char casillaDesafio = 'd';
        char casillaFinal = 'f';
        Casilla[] casillas = new Casilla[numeroCasillas];
        char[] variables = {casillaBlanco, casillaPortal, casillaSalud, casillaDesafio};
        casillas[0] = tablero.generarCasilla(casillaPartida, 1);
        casillas[1] = tablero.generarCasilla(casillaPortal, 2);
        casillas[numeroCasillas - 2] = tablero.generarCasilla(casillaPortal, numeroCasillas - 1);
        casillas[numeroCasillas - 1] = tablero.generarCasilla(casillaFinal, numeroCasillas);
        for (int i = 2; i < casillas.length - 2; i++) {
            int valorCasilla = (int) Math.floor(Math.random() * 4);
            casillas[i] = tablero.generarCasilla(variables[valorCasilla], i + 1);
        }
        tablero.setCasillas(casillas);
        return tablero.getCasillas();
    }

}
