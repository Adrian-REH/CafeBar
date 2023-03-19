
package clases;

import java.util.Vector;

/**
 * Indica cuál es el problema de utilizar un Vector con la
 * capacidad por defecto si tuviésemos 1000 elementos para ser
 * añadidos al mismo.
 */
public class PuntoCuatro {
    public static void main(String[] args) {

        // 1. Defino los vectores 1 y 2 y una supuesta capacidad de 1000
        int capacidad= 1000;
        Vector<Integer> vector1 = new Vector<>(capacidad);
        Vector<Integer> vector2= new Vector<>();

        // 2. lleno los vectores 1 y 2
        for (int i=0; i<1000;i++){
            vector1.add(i);
            vector2.add(i);
        }

        // 3. Muestro la diferencia entre capacidad respecto al tamaño de cada vector
        System.out.println("Vector tamanio 1: "+ vector1.size()+" y capacidad 1: "+vector1.capacity());
        System.out.println("Vector tamanio 2: "+ vector2.size()+" y capacidad 2: "+vector2.capacity());


        /*
        * El proble es que el vector2 ocupa un 21.8% mas de
        * capacidad que el vector1 (si por defecto
        * al vector1 le agregamos 1000 de capacidad).
        */


        /*
        * Pero supongamos un error
        * del numero de capacidad para agregar en +/- 1 valor mas a
        * agregar al vector
        *
        * */

        //SUPOSICION DE ERROR +/- 1 VALOR
        // 4. Defino nuevamente los vectores Supuestos y los lleno
        int capacidadSupuesta= 1000;
        Vector<Integer> vector1SupuestoMasUno = new Vector<>(capacidadSupuesta);
        Vector<Integer> vector2SupuestoMasUno= new Vector<>();
        for (int i=0; i<1000;i++){
            vector1SupuestoMasUno.add(i);
            vector2SupuestoMasUno.add(i);
        }
        // 5. Supongamos que hay un error de +1 valor imprevisto luego de definir capacidad Supuesta de 1000
        vector1SupuestoMasUno.add(1);
        vector2SupuestoMasUno.add(1);
        // 6. Muestro la diferencia entre capacidad respecto al tamaño de cada vector
        System.out.println("Vector tamanio 1: "+ vector1SupuestoMasUno.size()+" y capacidad 1: "+vector1SupuestoMasUno.capacity());
        System.out.println("Vector tamanio 2: "+ vector2SupuestoMasUno.size()+" y capacidad 2: "+vector2SupuestoMasUno.capacity());


        // 7. Defino nuevamente los vectores Supuestos
        Vector<Integer> vector1SupuestoMenosUno = new Vector<>(capacidadSupuesta);
        Vector<Integer> vector2SupuestoMenosUno= new Vector<>();
        for (int i=0; i<1000;i++){
            vector1SupuestoMenosUno.add(i);
            vector2SupuestoMenosUno.add(i);
        }
        // 8. Supongamos que hay un error de -1 valor imprevisto luego de definir capacidad=1000
        vector1SupuestoMenosUno.remove(1);
        vector2SupuestoMenosUno.remove(1);
        // 9. Muestro la diferencia entre capacidad respecto al tamaño de cada vector
        System.out.println("Vector tamanio 1: "+ vector1SupuestoMenosUno.size()+" y capacidad 1: "+vector1SupuestoMenosUno.capacity());
        System.out.println("Vector tamanio 2: "+ vector2SupuestoMenosUno.size()+" y capacidad 2: "+vector2SupuestoMenosUno.capacity());


        //CONCLUSION
        /*
         * Respecto a la suposicion de error podemos concluir que si le agregamos una capacidad
         * inicial de 1000 a un vector y tenemos un error del 0.1% de la capacidad este vector1 ocupara un
         * 36% mas de capacidad que si dejamos al vector1 sin capacidad inicial, y en caso de
         * tener un error de -0.1% las capacidad del vector2 sera un 21.8% mas que la de vector1
         * igual que si no tuviesemos error. El problema viene si hay un error mayor a un elemento
         * imprevisto a la hora de agregar algun dato al vector ya que se ocupara mas memoria, algo
         * que podria prevenirse.
         *
         *
         *
         * */



    }
}
