
package game;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int posicion;
    private int vida;
    private int meditar;
    private int lugar;
    private int subIndice;
    private Juego juego;
   

    public Jugador(String nombre, int subIndice) {
        this.nombre = nombre;
        this.vida = 15;
        this.meditar = 5;
        this.posicion = 1;
        this.lugar = 0;
        this.subIndice = subIndice;
    }
    
    public void definirJuego(Juego juego){
        this.juego = juego;
    }
    
    public int lanzarDados(Guardian guardian, Podio podio, ArrayList<Jugador> jugadores){
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        dado1.lanzarDado();
        dado2.lanzarDado();       
        int resultado = dado1.getCaraDado()+dado2.getCaraDado();
        return resultado;
        
    }
    
    public void resolucionDados(int resultado, Guardian guardian, Podio podio, ArrayList<Jugador> jugadores){
        int posicionAnterior = this.getPosicion();
        int tamañoTablero = this.juego.getTablero().getCasillas().length;
        if(posicionAnterior+resultado<tamañoTablero){
            this.setPosicion(posicionAnterior+resultado);
            if(this.getPosicion()==tamañoTablero-1){
                podio.agregarGanador(this,jugadores);
            }
        }
        else{
            this.setPosicion((posicionAnterior+resultado)%tamañoTablero);
        }
        
        Casilla[] casillas = juego.getTablero().getCasillas();
        Casilla casilla = casillas[this.getPosicion()-1];
            if((resultado == 12)&&(casilla.getTipoCasilla()=='s')){
                Reliquia reliquia = new Reliquia(true,true);
                reliquia.activarReliquia(this);
                guardian.disminuirVidaTriple(this, podio,jugadores);
            }
            if((resultado!=12)&&(casilla.getTipoCasilla()=='s')){
                Reliquia reliquia = new Reliquia(false,true);
                reliquia.activarReliquia(this);
                guardian.disminuirVidaNormal(this, podio,jugadores);
            }
            if((resultado != 12)&&(casilla.getTipoCasilla()!='s')){
                Reliquia reliquia = new Reliquia(false,false);
                reliquia.activarReliquia(this);
                guardian.disminuirVidaNormal(this, podio,jugadores);
            }
            casillas[this.getPosicion()-1].activarCasilla(juego.getTablero(), this, jugadores, podio);
        
        
    }
    
    
    public void meditarOpcion1(Jugador jugador, int valorMover){
        hacerMeditacion(jugador,valorMover);
    }
    
    public void meditarOpcion2(Jugador jugador){
        int vidaAnterior = jugador.getVida();
            jugador.setVida(vidaAnterior-1);
    }
    
    private void calcularMeditar(Jugador jugador){
        if(jugador.getMeditar()<0){
            jugador.setMeditar(0);
        }
    }
    
    private void hacerMeditacion(Jugador jugador, int valorMover){
        int posicionAnterior = jugador.getPosicion();
        jugador.setPosicion(posicionAnterior+valorMover);
        int meditarAnterior = jugador.getMeditar();
        jugador.setMeditar(meditarAnterior-1);
        int vidaAnterior = jugador.getVida();
        jugador.setVida(vidaAnterior+1);
        calcularMeditar(jugador);    
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicion() {
        return this.posicion;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return this.vida;
    }

    public void setMeditar(int meditar) {
        this.meditar = meditar;
    }

    public int getMeditar() {
        return this.meditar;
    }

    public void setLugar(int lugar) {
        this.lugar = lugar;
    }

    public int getLugar() {
        return this.lugar;
    }

    public int getSubIndice(){
        return this.subIndice;
    }
    
    public void setSubIndice(int subIndice){
        this.subIndice= subIndice;
    }
}
