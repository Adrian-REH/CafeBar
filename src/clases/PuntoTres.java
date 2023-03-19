package clases;

import java.util.Vector;

/**
 * Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos.
 * Elimina el 2o y 3er elemento y muestra el resultado final.
 */
public class PuntoTres {
    public static void main(String[] args) {
        Vector<Character> vector = new Vector<>();
        // 1. lleno el vector
        vector.add(0,'E');
        vector.add(1,'L');
        vector.add(2,'I');
        // 1.1 lleno el vector
        vector.add('A');
        vector.add('S');

        // 2. elimino 2o y 3er elemento
        vector.remove(2); //Segundo elemento de 5
        vector.remove(2); //Segundo elemento de 4 que es el 3er de 5


        // 3. resultado
        for (Character c: vector){
            System.out.print(c);
        }



    }
}
