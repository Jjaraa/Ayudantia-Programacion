
package gestorarchivos;

import game.Jugador;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class GestorArchivos {
    File f;
    FileWriter w;
    BufferedWriter bw;
    PrintWriter pw;
    
    public GestorArchivos(){}
    
    public void escribir(ArrayList<Jugador> jugadores){
        try{
        f= new File("Estadisticas.txt");
        w= new FileWriter(f);
        bw = new BufferedWriter(w);
        pw = new PrintWriter(bw);
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        
        pw.write("Estadisticas de los jugadores:");
        pw.write("/n");
        pw.write(date.format(now)+""+hour.format(now));
        pw.write("/n");
        
        for(Jugador item:jugadores){
            pw.write("Jugador: "+item.getNombre());
            pw.write("/n");
            pw.write("vida :"+item.getVida());
            pw.write("/n");
            pw.write("Meditaaciones restantes: "+item.getMeditar());
            pw.write("/n");
            pw.write("posicion :"+item.getPosicion());
        }
        pw.close();
        bw.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al escribir el archivo. Vuelva a intentarlo");
        }
    }
    
}
