
package clases;

import java.io.FileNotFoundException;

/**
 * Crea una función DividePorCero.
 * Esta, debe generar una excepción ("throws") a su
 * llamante del tipo ArithmeticException que será capturada
 * por su llamante (desde "main", por ejemplo).
 * Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
 * Finalmente, mostraremos en cualquier caso: "Demo de código".
 */
public class PuntoSiete {
    public static void main(String[] args) {

        try {
            int i= dividePorCero();
        }catch (ArithmeticException e){
            System.out.println("Esto no puede hacerse");
        }finally {
            System.out.println("Demo de código");
        }
    }

    /**
     *
     * Como tengo un solo error no es necesario gestionarlos
     * agregando "throw new Exc..."
     * @return indeterminacion
     * @throws ArithmeticException
     */
    public static int dividePorCero() throws ArithmeticException {
        return  1/0;
    }
}
