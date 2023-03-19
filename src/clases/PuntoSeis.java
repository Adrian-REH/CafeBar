
package clases;

import java.util.ArrayList;

/**
 *  Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10.
 *  A continuación, con otro bucle, recórrelo y elimina los numeros pares. Por último,
 *  vuelve a recorrerlo y muestra el ArrayList final. Si te atreves,
 *  puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.
 */
public class PuntoSeis {
    public static void main(String[] args) {

        // 1. defino variables
        ArrayList<Integer> arrayList= new ArrayList<>();
        int i =1;

        // 2. lleno el ArrayList
        while (i<=10){
            arrayList.add(i++);
        }

        // 3. Resuelvo el dolor de cabeza
        i=0;
        while (i<6) {
            try {
                if (arrayList.get(i)%2==0) {
                    arrayList.remove(i);
                }else {
                    i++;
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("Ya no hay mas numeros pares");
                i++;

            }

        }

        // 4. imprimo numeros impares
        for (Integer entero:arrayList){
            System.out.println(entero);
        }

    }
}
