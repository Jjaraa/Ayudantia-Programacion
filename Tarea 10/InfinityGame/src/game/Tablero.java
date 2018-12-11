
package game;

public class Tablero {

    private Casilla[] casillas;
    private int numeroCasillas;

    public Tablero(int casillas) {
        this.numeroCasillas = casillas;
    }

    public Casilla generarCasilla(char tipoCasilla, int posicion) {
        Casilla cas = new Casilla(tipoCasilla, posicion);
        return cas;
    }

    public void mostrarTablero(Casilla[] arrg) {
        for (int i = 0; i < arrg.length; i++) {
            System.out.println("Casilla numero " + arrg[i].getPosicion() + " : " + arrg[i].getTipoCasilla());
        }
    }

    public Casilla[] getCasillas() {
        return this.casillas;
    }

    public void setCasillas(Casilla[] arrg) {
        this.casillas = arrg;
    }

    public int getNumeroCasillas() {
        return this.numeroCasillas;
    }
}
