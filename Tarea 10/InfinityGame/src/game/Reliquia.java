package game;

import javax.swing.JOptionPane;

public class Reliquia {	
        private boolean probabilidadAlta;
        private boolean salud;

	public Reliquia(boolean booleano, boolean salud) {
            this.probabilidadAlta = booleano;
            this.salud = salud;
	}
        
        public void activarReliquia(Jugador jugador){
            if((this.probabilidadAlta)&&(this.salud==false)){
                activarSoloAlta(jugador);
            }
            if((this.probabilidadAlta==false)&&(this.salud)){
                activarSoloSalud(jugador);
            }
            if((this.probabilidadAlta)&&(this.salud)){
                activarSoloAlta(jugador);
                activarSoloSalud(jugador);
            }
            if((this.probabilidadAlta==false)&&(this.salud==false)){
                activarBaja(jugador);
            }
        }
        
        private void activarSoloAlta(Jugador jugador){
            int valorRandom = (int)Math.random()*3+1;
            if(valorRandom==1){
                JOptionPane.showMessageDialog(null, "Se ha activado la reliquia! Toda tu vida será restaurada");                
                jugador.setVida(15);
            }
        }
        
        private void activarSoloSalud(Jugador jugador){
            int valorRandom = (int)Math.random()*21+1;
            if(valorRandom==1){
                JOptionPane.showMessageDialog(null, "Se ha activado la reliquia! Ganas un punto extra para meditar");               
                int meditarAnterior = jugador.getMeditar();
                jugador.setMeditar(meditarAnterior+1);
            }
        }
        
        private void activarBaja(Jugador jugador){
            int valorRandom = (int)Math.random()*101+1;
            if(valorRandom==1){
                JOptionPane.showMessageDialog(null, "Se ha activado la reliquia! Toda tu vida será restaurada");               
                jugador.setVida(15);
            }
        }
        
        public boolean getProbabilidadAlta(){
            return this.probabilidadAlta;
        }
        
        public void setProbabilidadAlta(boolean booleano){
            this.probabilidadAlta = booleano;
        }

	
}