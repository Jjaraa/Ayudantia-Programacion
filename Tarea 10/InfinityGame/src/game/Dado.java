
package game;

public class Dado {

    private int caraDado;

    public int getCaraDado() {
        return this.caraDado;
    }

    public void lanzarDado() {
        int valorDado = (int) Math.floor(Math.random() * 6 + 1);
        this.caraDado = valorDado;
    }
}
