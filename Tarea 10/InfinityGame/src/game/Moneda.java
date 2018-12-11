
package game;

import javax.swing.JOptionPane;

/* Cree esta clase para que se encargue de la aleatoriedad del juego. Siempre que hayan
dos opciones aleatorias, se creará una moneda para decidir cual de las dos opciones se llevará
a cabo */
public class Moneda {

    private boolean moneda;

    public Moneda() {
        this.moneda = true;
    }

    public boolean getMoneda() {
        return moneda;
    }

    private void lanzarMoneda() {
        int valorRandom = (int) Math.floor(Math.random() * 2);

        if (valorRandom == 0) {
            this.moneda = false;
        } else {
            this.moneda = true;
        }
    }

    public void mostrarMoneda() {
        JOptionPane.showMessageDialog(null, "Se lanzará una moneda!!");
        lanzarMoneda();
        if (this.moneda == true) {
            JOptionPane.showMessageDialog(null, "Ha salido cara!!");
           
        } else {
            JOptionPane.showMessageDialog(null, "Ha salido cruz!!");
           
        }
    }
}
