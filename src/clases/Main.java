package clases;

public class Main {
    public static void main(String[] args) {
        String cadena= "Tipo de mensaje a resolver";
        reverse(cadena);


    }

    public static String reverse(String texto){
        StringBuilder  reverseTexto = new StringBuilder().append(texto).reverse();

        System.out.println(reverseTexto);
        return reverseTexto.toString();
    }

}