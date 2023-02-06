
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**Ejercicio1 
 * Todo esto va a ser borrado 
 */
public class code {
    public static void main(String [] args){ //Esto también
        if(args.length!=2){
            System.out.println("El número de argumentos tiene que ser dos");
            return;
        }
        //Esto también /* */
        int minValue = 0;/* Esto también */
        int maxValue = 0;
        try {
            minValue = Integer.parseInt(args[0]);
            maxValue = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("Debe pasar dos argumentos de tipo entero");
            return;
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("primos.dat"));
            int primo = minValue;
            do {
                /*Esto también */primo =(primo /*Esto también */);//Esto también
                if(primo <= maxValue){
                    bw.write(String.format("%d\n",primo));
                }
            } while (primo <=maxValue);
            if(bw!=null)
                bw.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}   