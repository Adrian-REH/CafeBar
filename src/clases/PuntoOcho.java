
package clases;

import java.io.*;

/**
 * Utilizando InputStream y PrintStream,
 * crea una función que reciba dos parámetros: "fileIn" y "fileOut".
 * La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado en "fileOut".
 */
public class PuntoOcho {
    private static PrintStream fileOut;
   private static InputStream fileIn;
   private static BufferedInputStream bufferFile;


    public static void main(String[] args)  {
        try {
            trasladaDatos();
        }catch (IOException e){
            System.out.println("IOException: "+e.getMessage());
        }
    }

    /**
     *
     * @throws IOException
     */
    public static void trasladaDatos()throws IOException{
        try {
            // 1. creo inicio.txt
            PrintStream createFileIn = new PrintStream("inicio.txt");
            createFileIn.print("Hola chamaco");
            createFileIn.close();

            // 2. abro inicio.txt y los guardo en un grupo de array
            fileIn = new FileInputStream("inicio.txt");
            bufferFile = new BufferedInputStream(fileIn);

            // 3. creo y abro destino.txt
            fileOut = new PrintStream("destino.txt");

            // 4. muevo los datos de inicio.txt a destino.txt
            int dato = bufferFile.read();
            while (dato !=-1){
                fileOut.write(dato);
                dato = bufferFile.read();
            }

        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: "+e.getMessage());
        } finally {
            // 5. finalmente cierro ambos archivos
            bufferFile.close();
            fileIn.close();
            fileOut.close();
        }
    }
}
