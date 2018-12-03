
package game;


public class Mago extends Jugador {
    private int mana;
    
    public Mago(String nombre, int subIndice){
        super(nombre, subIndice);
        this.mana = 4;
        super.setMeditar(7);
    }
    
    public void acntivarConcentracion(Guardian guardian){
        guardian.setSalud(guardian.getSalud()-2);
    }
    
    public int getMana(){
        return this.mana;
    }
    
    public void setMana(int mana){
        this.mana = mana;
    }
}
