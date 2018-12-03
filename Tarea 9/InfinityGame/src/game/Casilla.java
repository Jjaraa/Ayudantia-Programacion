
package game;

import java.util.ArrayList;

public class Casilla {
    
    private char tipoCasilla;   
    private int posicion;

    public Casilla(char tipoCasilla, int posicion) {
        this.tipoCasilla = tipoCasilla;
        this.posicion = posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicion() {
        return this.posicion;
    }

    public void setTipoCasilla(char tipoCasilla) {
        this.tipoCasilla = tipoCasilla;
    }

    public char getTipoCasilla() {
        return this.tipoCasilla;
    }

    public void casillaPortal(Casilla[] arrg, Jugador jugador, int indiceCasilla) {
        boolean bandera = true;
        while (bandera) {
            int contador = (int) Math.floor(Math.random() * arrg.length);
            if ((arrg[contador].getTipoCasilla() == 'p') && (contador != indiceCasilla)) {
                indiceCasilla = contador;
                bandera = false;
                jugador.setPosicion(contador);
            }
        }
        mostrarPortal(jugador);
    }

    public void mostrarPortal(Jugador jugador) {
        System.out.println(jugador.getNombre() + " ha usado un portal que lo llevó a la posicion " + jugador.getPosicion());
    }

    public void casillaSalud(Jugador jugador, Podio podio) {      
        Moneda aleatorio = new Moneda();
        aleatorio.mostrarMoneda();
        int nuevaVida = (int) Math.floor((Math.random() * 3) + 1);
        int viejaVida = jugador.getVida();
        if (aleatorio.getMoneda() == true) {
            jugador.setVida(viejaVida + nuevaVida);
        } else {
            jugador.setVida(viejaVida - nuevaVida);
        }
        mostrarSalud(jugador, nuevaVida, aleatorio.getMoneda());
        if (jugador.getVida() <= 0) {
            mostrarPerder(jugador.getNombre());
            podio.agregarJugadorMuerto(jugador.getNombre(), podio.getLugares());
        }
        
    }

    public void mostrarPerder(String nombre) {
        System.out.println("La vida de " + nombre + " ha llegado a 0");
        System.out.println(nombre + " ha perdido");
    }

    public void mostrarSalud(Jugador jugador, int salud, boolean aleatoriedad) {
        if (aleatoriedad == true) {
            System.out.println(jugador.getNombre() + " ha ganado " + salud + " puntos de vida");

        } else {
            System.out.println(jugador.getNombre() + " ha perdido " + salud + "puntos de vida");
        }
    }
    
    public void casillaDesafio(Jugador jugador, ArrayList<Jugador> jugadores){
        Moneda moneda = new Moneda();
        moneda.mostrarMoneda();
        if(moneda.getMoneda()){
            casillaDesafioPosicion(jugador,jugadores,moneda);  
        }else{
            casillaDesafioVida(jugador, jugadores, moneda);
        }
    }
    
    private void casillaDesafioPosicion(Jugador jugador, ArrayList<Jugador> jugadores, Moneda moneda){      
        System.out.println("Sera avanzarán o retrocederán casillas");
            int valorRandom = (int)Math.random()*6+1;
            moneda.mostrarMoneda();
            if(moneda.getMoneda()){
                System.out.println("Se avanzarán "+valorRandom+" casillas");
                jugador.setPosicion(jugador.getPosicion()+valorRandom);
            }else{
                System.out.println("Se retroncederán "+valorRandom+" casillas");
                jugador.setPosicion(jugador.getPosicion()-valorRandom);
            }
    }
    
    private void casillaDesafioVida(Jugador jugador, ArrayList<Jugador> jugadores, Moneda moneda){
        System.out.println("Los demas jugadores ganarán o perderán vida");           
            int valorRandom = (int)Math.random()*5+1;
            moneda.mostrarMoneda();
            if(moneda.getMoneda()){
                System.out.println("Los demas jugadores ganarán "+valorRandom+" puntos de vida");
                for(Jugador item:jugadores){
                    item.setVida(item.getVida()+valorRandom);
                    jugador.setVida(jugador.getVida()-valorRandom);
                }
            }else{
                System.out.println("Los demas jugadores perderán "+valorRandom+" puntos de vida");
                for(Jugador item:jugadores){
                    item.setVida(item.getVida()-valorRandom);
                    jugador.setVida(jugador.getVida()+valorRandom);
                }
            }
    }
}
