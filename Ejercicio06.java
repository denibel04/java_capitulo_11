import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Capítulo 10 - colecciones y diccionarios
 * Ejercicio 6: Realiza un programa que diga cuántas ocurrencias de una palabra hay en un fichero. Tanto el nombre del fichero como la palabra se
 * deben pasar como argumentos en la línea de comandos.
 *
 * → @author Denisa Ramona Belean
 *   https://github.com/denibel04 ☆
 */
public class Ejercicio06 {
    public static void main (String[] args) {
        String palabra = args[1];
        int i = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String linea = "";
            while ((linea = br.readLine()) != null){
                int j = 0;
                while ((j = linea.indexOf(palabra)) != -1) {
                    linea = linea.substring(j+palabra.length(), linea.length());
                    i++;
                }
            }
            if (i>0) {
                System.out.printf("La palabra aparece %d " + ((i==1)?"vez":"veces"), i);
            } else {
                System.out.println("Esa palabra no aparece");
            }
        } catch (IOException ioe) {
            System.out.println("Error de lectura o escritura");
        }
    }
}
