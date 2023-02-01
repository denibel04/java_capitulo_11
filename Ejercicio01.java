/*
 * Capítulo 10 - colecciones y diccionarios
 * Ejercicio 1: Escribe un programa que guarde en un fichero con nombre primos.dat los números primos que hay entre 1 y 500.
 *
 * → @author Denisa Ramona Belean
 *   https://github.com/denibel04 ☆
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Ejercicio01 {
    public static void main (String[] args) {
        boolean primo;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("primos.dat"));
            for (int i = 1; i<=500; i++) {
                primo = true;
                for(int j = 2; j<i; j++) {
                    if (i%j==0) {
                        primo = false;
                    }
                }
                if (primo) {
                    bw.write(String.valueOf(i) + "\n");
                }
            }
            bw.close();
        } catch (IOException ioe) {
            System.out.println("Error de escritura");
        }
    }
}
