/*
 * Capítulo 10 - colecciones y diccionarios
 * Ejercicio 4: Realiza un programa que sea capaz de ordenar alfabéticamente las palabras contenidas en un fichero de texto. El nombre del
 * fichero que contiene las palabras se debe pasar como argumento en la línea de comandos. El nombre del fichero resultado debe ser el mismo
 * que el original añadiendo la coletilla sort, por ejemplo palabras_sort.txt. Suponemos que cada palabra ocupa una línea.
 *
 * → @author Denisa Ramona Belean
 *   https://github.com/denibel04 ☆
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio04 {
    public static void main (String[] args) {
        int i = args[0].length();
        String nombre = args[0].substring(0, i - 4);
        String extension = args[0].substring(i - 4);

        String linea = "";
        ArrayList<String> palabras = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            while (linea!=null) {
                linea = br.readLine();
                if (linea!=null) {
                    palabras.add(linea);
                }
            }
            br.close();
            Collections.sort(palabras);
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombre + "_sort" + extension));
            for (String s : palabras) {
                bw.write(s + "\n");
            }
            bw.close();
        } catch (IOException ioe) {
            System.out.println("Error de lectura o escritura");
        }
    }
}
