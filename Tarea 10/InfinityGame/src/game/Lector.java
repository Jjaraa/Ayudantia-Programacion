
package game;

import java.util.Scanner;


public class Lector {
    
    public Lector(){
    
    }
    
    public int leerInt() {
        try {
            Scanner respuesta = new Scanner(System.in);
            int numeroRespuesta = respuesta.nextInt();
            return numeroRespuesta;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Numero ingresado no válido. Intentelo otra vez");
            leerInt();
            return 0;

        }
    }

    public String leerString() {
        try {
            Scanner respuesta = new Scanner(System.in);
            String stringRespuesta = respuesta.nextLine();
            return stringRespuesta;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Nombre ingresado no válido. Intentelo otra vez");
            leerString();
            return "0";

        }
    }
}
