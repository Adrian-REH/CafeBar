package clases;

public class PuntoUno {
    public static void main(String[] args) {
        String cadena= "Tipo de mensaje a resolver";
        int valorCadena= cadena.split(" ").length;

        // Lleno el array String
        String[] arrayString = new String[valorCadena];
        for (int i = 0 ; i< arrayString.length; i++){
            arrayString[i]= cadena.split(" ")[i];
        }

        // Imprimo el array String
        for (String array: arrayString){
            System.out.println(array);
        }

    }
}
