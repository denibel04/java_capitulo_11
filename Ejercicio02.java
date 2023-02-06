/*
 * Capítulo 10 - colecciones y diccionarios
 * Ejercicio 2: Realiza un programa que lea el fichero creado en el ejercicio anterior y que muestre los números por pantalla.
 *
 * → @author Denisa Ramona Belean
 *   https://github.com/denibel04 ☆
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio02 {
    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("primos.dat"));
            String linea = "";
            while (linea!=null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (IOException ioe) {
            System.out.println("Error de lectura");
        }


    }
}
