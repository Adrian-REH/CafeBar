
package clases;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Crea un ArrayList de tipo String, con 4 elementos.
 * Cópialo en una LinkedList.
 * Recorre ambos mostrando únicamente el valor de cada elemento.
 */
public class PuntoCinco {
    public static void main(String[] args) {

        // 1. creo un ArrayList
        ArrayList<String> arrayList=new ArrayList<>();

        // 2. lleno ArrayList
        arrayList.add("Adrian");
        arrayList.add("Ramon");
        arrayList.add("Elias");
        arrayList.add("Herrera");

        // 3. creo y parametrizo el LinkedList
        LinkedList<String> linkedList = new LinkedList<>(arrayList);

        // 4.1 recorro las list
        for (String list: linkedList){
            System.out.print("LinkedList: "+list);
        }
        System.out.print("\n");

        for (String list: arrayList){
            System.out.print("ArrayList: "+list);
        }
        System.out.print("\n");

        // 4.1 recorro las list
        for (int i=0; i<arrayList.size();i++){
            System.out.print("LinkedList: "+linkedList.get(i));
            System.out.print("\n");
            System.out.print("ArrayList: "+arrayList.get(i));
            System.out.print("\n");

        }


    }
}
