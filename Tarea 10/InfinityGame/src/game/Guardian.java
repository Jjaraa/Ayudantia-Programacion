package game;

import java.util.ArrayList;

public class Guardian {
	private int salud;

	public Guardian(ArrayList<Jugador> jugadores) {
            this.salud = jugadores.size()*15;
	}
        
        public void activarFuria(ArrayList<Jugador> jugadores){
            int valorRandom = (int)Math.random()*51+1;
            if(valorRandom==1){
                System.out.println("Se ha activado la habilidad especial del guardian! todos pierden un punto de vida");
                for(Jugador item:jugadores){
                    item.setVida(item.getVida()-1);
                }
            }
        }
        
        public void disminuirVidaNormal(Jugador jugador, Podio podio, ArrayList<Jugador> jugadores){
            this.salud--;
            if(this.salud<1){
                System.out.println("El guardian ha muerto");
                podio.agregarGanador(jugador,jugadores);
            }
        }
        
        public void disminuirVidaTriple(Jugador jugador, Podio podio, ArrayList<Jugador> jugadores){
            this.salud-=3;
            if(this.salud<1){
                System.out.println("El guardian ha muerto");
                podio.agregarGanador(jugador, jugadores);
            }
        }
        
	public int getSalud() {
		return this.salud;
	}

	public void setSalud(int aSalud) {
		this.salud = aSalud;
	}
}