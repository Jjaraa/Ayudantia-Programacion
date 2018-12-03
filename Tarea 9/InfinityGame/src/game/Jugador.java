
package game;

public class Jugador {

    private String nombre;
    private int posicion;
    private int vida;
    private int meditar;
    private int lugar;
    private int subIndice;

    public Jugador() {
        this.nombre = "jugador";
        this.vida = 15;
        this.meditar = 5;
        this.posicion = 1;
        this.subIndice = 0;
        this.lugar = 0; //al principio todos los jugadores no tienen un lugar en el podio, por eso por defecto su lugar será 0
    }

    public Jugador(String nombre, int subIndice) {
        this.nombre = nombre;
        this.vida = 15;
        this.meditar = 5;
        this.posicion = 1;
        this.lugar = 0;
        this.subIndice = subIndice;
    }
    
    public int lanzarDados(Guardian guardian, Casilla casilla, Podio podio){
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        dado1.lanzarDado();
        dado2.lanzarDado();       
        int resultado = dado1.getCaraDado()+dado2.getCaraDado();
            if((resultado == 12)&&(casilla.getTipoCasilla()=='s')){
                Reliquia reliquia = new Reliquia(true,true);
                reliquia.activarReliquia(this);
                guardian.disminuirVidaTriple(this, podio);
            }
            if((resultado!=12)&&(casilla.getTipoCasilla()=='s')){
                Reliquia reliquia = new Reliquia(false,true);
                reliquia.activarReliquia(this);
                guardian.disminuirVidaNormal(this, podio);
            }
            if((resultado != 12)&&(casilla.getTipoCasilla()!='s')){
                Reliquia reliquia = new Reliquia(false,false);
                reliquia.activarReliquia(this);
                guardian.disminuirVidaNormal(this, podio);
            }
        return resultado;
        
    }
    
    public void meditar(Jugador jugador){
        if(jugador.getMeditar()>0){
            System.out.println("Escoja un numero entre -3 al- 3 para moverse esa cantidad de espacios.");
            Lector lector = new Lector();
            int valorMover = lector.leerInt();
            while((valorMover>3)||(valorMover<-3)){
                System.out.println("No puede moverse ese numero de casillas. Intentelo de nuevo");
                valorMover = lector.leerInt();
            }
            hacerMeditacion(jugador,valorMover);
            
        }
        else{
            System.out.println("No quedan opciones de meditar. Pasarás turno y perderás un punto de vida");
            int vidaAnterior = jugador.getVida();
            jugador.setVida(vidaAnterior-1);
        }
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
