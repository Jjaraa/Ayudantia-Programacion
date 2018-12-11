
package game;

import java.util.ArrayList;

public class Podio {

    private String[] lugares;
    
    public Podio(ArrayList<Jugador> jugadores) {
        int numeroJugadores = jugadores.size();
        this.lugares = new String[numeroJugadores];
    }
    
    public void agregarGanador(Jugador jugador, ArrayList<Jugador> jugadores){
        String nombre = jugador.getNombre();
        this.lugares[0] = nombre;
        agregarLugares(jugadores);
    }
    
    private void agregarLugares(ArrayList<Jugador> jugadores){
        int contador = 1;
        for(Jugador item:jugadores){
            if(item.getNombre()!=lugares[0]){
               this.lugares[contador] = item.getNombre();
            }
        }
        
        
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
