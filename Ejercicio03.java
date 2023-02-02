/*
 * Capítulo 10 - colecciones y diccionarios
 * Ejercicio 3:
 *
 * → @author Denisa Ramona Belean
 *   https://github.com/denibel04 ☆
 */
import java.io.*;
import java.util.Scanner;
public class Ejercicio03 {
    public static void main (String[] args) {
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(args[0]));
            BufferedReader br2 = new BufferedReader(new FileReader(args[1]));
            BufferedWriter bw = new BufferedWriter(new FileWriter(args[2]));
            String linea1 = "";
            String linea2 = "";
            while (linea1!=null || linea2!=null) {
                linea1 = br1.readLine();
                if (linea1!=null) {
                    System.out.println(linea1);
                    bw.write(linea1 + "\n");
                }
                linea2 = br2.readLine();
                if (linea2!=null) {
                    System.out.println(linea2);
                    bw.write(linea2 + "\n");
                }
            }
            br1.close();
            br2.close();
            bw.close();
        } catch (IOException ioe) {
            System.out.println("Error de lectura");
        }
    }
}
