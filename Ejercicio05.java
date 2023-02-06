import java.io.*;

/*
 * Capítulo 10 - colecciones y diccionarios
 * Ejercicio 5: Escribe un programa capaz de quitar los comentarios de un programa de Java.
 * Se utilizaría de la siguiente manera:
 * quita_commentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO
 * Por ejemplo:
 * quita_comentarios hola.java holav2.java
 * crea un fichero con nombre holav2.java que contiene el código de hola.java pero sin los comentarios.
 *
 * → @author Denisa Ramona Belean
 *   https://github.com/denibel04 ☆
 */
public class Ejercicio05 {
    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));

            String lineaOrigen = "";
            String lineaDestino = "";
            boolean comentarioDeBloque = false;
            int i = 0;

            while ((lineaOrigen = br.readLine()) != null) {

                int l = lineaOrigen.length();
                lineaDestino = lineaOrigen;

                // Detecta inicio de comentario de bloque
                if ((i = lineaOrigen.indexOf("/*")) != -1) {
                    lineaDestino = "";
                    for(int cont = 0; cont < lineaOrigen.length(); cont++){
                        if(lineaOrigen.charAt(cont)=='/' && lineaOrigen.charAt(cont+1)=='*'){
                            comentarioDeBloque=true;
                            cont++;
                        }
                        else if(lineaOrigen.charAt(cont)=='*' && lineaOrigen.charAt(cont+1)=='/'){
                            comentarioDeBloque=false;
                            cont++;
                        }
                        else if(!comentarioDeBloque && lineaOrigen.charAt(cont)=='/'){
                            break;
                        }
                        else if(!comentarioDeBloque){
                            lineaDestino+=lineaOrigen.charAt(cont);
                        }
                    }
                    lineaOrigen = lineaDestino;
                }

                // Detecta fin de comentario de bloque
                if (comentarioDeBloque && (i = lineaOrigen.indexOf("*/")) != -1) {
                    lineaDestino = "";
                    for(int cont = 0; cont < lineaOrigen.length(); cont++){
                        if(lineaOrigen.charAt(cont)=='/' && lineaOrigen.charAt(cont+1)=='*'){
                            comentarioDeBloque=true;
                            cont++;
                        }
                        else if(lineaOrigen.charAt(cont)=='*' && lineaOrigen.charAt(cont+1)=='/'){
                            comentarioDeBloque=false;
                            cont++;
                        }
                        else if(!comentarioDeBloque && lineaOrigen.charAt(cont)=='/' && lineaOrigen.charAt(cont)=='/'){
                            break;
                        }
                        else if(!comentarioDeBloque){
                            lineaDestino+=lineaOrigen.charAt(cont);
                        }
                    }
                    lineaOrigen = lineaDestino;
                }
                // Detecta comentario de línea
                if (((i = lineaOrigen.indexOf("//")) != -1) && !comentarioDeBloque) {
                    lineaDestino = lineaOrigen.substring(0, i);
                }

                if (!comentarioDeBloque) {
                    bw.write(lineaDestino + "\n");
                }
            }

            br.close();
            bw.close();

        } catch (IOException ioe) {
            System.out.println("Error de lectura o escritura");
        }
    }
}
