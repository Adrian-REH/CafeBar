
package miprograma;

import miprograma.clases.*;
import miprograma.implement.CafeBarImp;
import miprograma.implement.CustomerImp;
import miprograma.implement.StaffImp;
import miprograma.interfaces.CafeBarInterface;
import miprograma.interfaces.CustomerInterface;
import miprograma.interfaces.StaffInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Sorpréndenos creando un programa de tu elección
 * que utilice InputStream, PrintStream, excepciones,
 * un HashMap y un ArrayList, LinkedList o array.
 *
 * Balance de una cafeteria
 * Ganancia de una cafeteria respecto al numero de clientes
 * y el numero de venta de articulos, reduciendo
 * el gasto por administracion y articulos. Resultado: Utilidad Neta, Propinas, Consumo por persona, ganancia por camarero
 */
public class Main {
   private static InputStream fileIn;
   private static BufferedInputStream bufferFile;
    static CafeBarInterface cafeBarInterface =  new CafeBarImp();
    static CustomerInterface customerInterface =  new CustomerImp();
    static StaffInterface staffInterface =  new StaffImp();


    public static void main(String[] args)  {

        try {
            generateDB();

            utilidadNeta(staffInterface.findAll(),customerInterface.findAll(),cafeBarInterface.findAll());

        }catch (IllegalArgumentException e){
            System.out.println("IllegalArgumentException: "+e.getMessage());

        }catch (NullPointerException e){
            System.out.println("NullPointerException: "+e.getMessage());

        }catch (IOException e){
            System.out.println("IOException: "+e.getMessage());
        }


    }

    public static void generateDB(){

        cafeBarInterface.save(cafeBarDato());
        customerInterface.save(customerDato());
        staffInterface.save(staffDato(customerDato()));


    }


    public static ArrayList<Staff> staffDato(ArrayList<Customer> listClientes){
        ArrayList<Staff> listCustomer =new ArrayList<>();


        Staff staff=new Staff("Dexter","Hernandez","ff344d",2,listClientes,35,2+5);

        listCustomer.add(staff);
        listCustomer.add(staff);

        return listCustomer;
    }

    public static ArrayList<Customer> customerDato(){
        ArrayList<Customer> listCustomer =new ArrayList<>();
        List<String> listConsumo =new ArrayList<>();

        listConsumo.add("cafe");
        listConsumo.add("cafe");
        listConsumo.add("cafe");
        listConsumo.add("cake");
        listConsumo.add("cake");
        listConsumo.add("beer");
        listConsumo.add("beer");
        listConsumo.add("beer");
        listConsumo.add("sandwich");
        Table table= new Table(1,3,4);
        Customer customer=new Customer("Eliass","Zelaya","42121008",1,4453,listConsumo,33,table);

        listCustomer.add(customer);
        listCustomer.add(customer);

        return listCustomer;
    }
    public static ArrayList<CafeBar> cafeBarDato(){
        ArrayList<CafeBar> listCafeBar =new ArrayList<>();

        Menu menu=new Menu(2,3,4,5,6);
        CafeBar cafeBar=new CafeBar("Malaga","Revers",0.21,menu);

        listCafeBar.add(cafeBar);

        return listCafeBar;
    }

    /**
     * Supongamos
     * 1- que el iva es de 0.21
     * 2- Suponemos que la ganancia de cada articulo es del 60%
     * 3- y cada 1 hora se le paga 5 al empleado
     *
     * @throws IOException
     */
    public static void utilidadNeta(ArrayList<Staff> staff,ArrayList<Customer> customers,ArrayList<CafeBar> cafeBar)throws IOException{
        //Supongo que se vendio 8 objetos de la tienda

        // 1. Defino constantes
        int NUM_ARTICULOS_VENDIDOS=8;
        double GANANCIA_POR_VENTA = 0.6;
        int COSTO_HORA_CAMARERO = 5;
        double COSTO_HORA_TABLE = 1.4d;


        // 2. Defino variables
        int dineroCamarero=staff.get(0).getGanancia();//Dinero que se lleva el camarero
        int generadoStaff=staff.get(0).getDineroGenerado();//dinero recogido por el camarero
        int iPActividad=customers.get(0).getPrice();//Ingreso Procedente de la actividad
        int numCustomer=customers.get(0).getTable().getNumCustomer(); //numero de clientes
        double iva=cafeBar.get(0).getIva(); //iva

        // 3. propina para el camamarero
        int pCamarero=-iPActividad+generadoStaff;//Propina del camarero

        // 4. costo por reposicion de articulos
        double reposicion= 1-GANANCIA_POR_VENTA;
        // 5. utilidad bruta por venta
        double uBrutaVenta=  iPActividad - iPActividad*(reposicion);
        // 6. utilidad operativa
        double uOperativa=  uBrutaVenta - COSTO_HORA_CAMARERO;
        // 7. utilidad antes que impuestos
        double uAntesImpuestos=  uOperativa-COSTO_HORA_TABLE;
        double uNeta=  uAntesImpuestos*(-iva+1);


        String resultado="Utilidad Neta: "+ uNeta +
                " Propina: "+pCamarero +
                " Consumo por persona: "+iPActividad/numCustomer+
                " Ganancia del camarero: "+dineroCamarero+
                "";


        try {
            // 1. creo inicio.txt
            PrintStream createFileIn = new PrintStream("inicio.txt");
            createFileIn.print(resultado);
            createFileIn.close();

            // 2. abro inicio.txt y los guardo en un grupo de array
            fileIn = new FileInputStream("inicio.txt");
            bufferFile = new BufferedInputStream(fileIn);

            // 3. imprimo el valor
            int dato = bufferFile.read();

            while (dato !=-1){
                System.out.print((char)dato);
                dato = bufferFile.read();
            }





        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: "+e.getMessage());
        } finally {
            // 5. finalmente cierro ambos archivos
            bufferFile.close();
            fileIn.close();
        }
    }
}
