
package game;

import java.util.ArrayList;

public class Podio {

    private String[] lugares;
    
    public Podio(ArrayList<Jugador> jugadores) {
        int numeroJugadores = jugadores.size();
        this.lugares = new String[numeroJugadores];
    }
    
    public void agregarGanador(Jugador jugador){
        String nombre = jugador.getNombre();
        lugares[0] = nombre;
    }
    
    public void agregarJugadorMuerto(String nombreJugador, String[] lugares) {
        int contador = lugares.length;
        while (lugares[contador - 1] != null) {
            contador--;
        }
        lugares[contador - 1] = nombreJugador;
        mostrarLugar(lugares, contador);
    }

    public void mostrarLugar(String[] lugares, int lugar) {
        System.out.println(lugares[lugar] + " ha quedado en el lugar numero " + lugar);
    }

    public void mostrarPodio(String[] lugares) {
        for (int i = 0; i < lugares.length; i++) {
            System.out.println("Lugar numero " + (i + 1) + ": " + lugares[i]);
        }
    }

    public String[] getLugares() {
        return this.lugares;
    }
}
