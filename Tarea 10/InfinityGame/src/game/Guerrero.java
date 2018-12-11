
package game;

import java.util.ArrayList;


public class Guerrero extends Jugador {
    
    private int furia;
    
    public Guerrero(String nombre, int subIndice){
        super(nombre,subIndice);
        this.furia = 5;
        super.setVida(20);
    }
    
    public void activarEnfurecer(ArrayList<Jugador> jugadores, Guerrero guerrero){
        if(guerrero.getFuria()>0){
            for(Jugador item:jugadores){
            if(item.getSubIndice()!=super.getSubIndice()){
                item.setVida(item.getVida()-1); 
            }
            int furiaAnterior = guerrero.getFuria();
            guerrero.setFuria(furiaAnterior-1);
            }
        }else{
            System.out.println("No hay furia suficiente para realizar la habilidad");
        }
        
    }
    
    public int getFuria(){
        return this.furia;
    }
    
    public void setFuria(int furia){
        this.furia = furia;
    }
}
