# CafeBar
Un rapido y eficiente aprendizaje de las tecnicas basica de Java, me llevo a esta idea interesante, un programa para calcular la Utilidad neta de un CafeBar, teniendo en cuenta las Mesas, menu, personal y clientes.

Sencillamente use:
 Para la estructura de datos: Clases, Herencia, Objetos getter and Setter, constructores y toString para definir 6 Clases de datos.
 para la API: Interfaces e Implementacion
 para la base de datos: RandomAccessFile("rw", write() and read()) 
 para la Gestion de Errores: Try Catch finally, throws and Throw.
 y para trasladar los datos use ArrayList<>() y List<>
 
 ## Uso:
  Supongamos que tenemos una CafeBar y precisamos guardar su informacion teniendo en cuenta los atributos como **_Ubicacion, nombre, impuestos, Menu[Precios: cafe, Sandwich, Beer, Water, Cake]_** entonces para guardar estos datos primero defino la clase
 
  1  Modelo de datos: Ignorando los Setter y Getter y creando una funcion para que cuando el String del atributo sea mayor a 6 caracteres se elimine el resto, puedo definir de esta forma la Class:
  ```java
    public class CafeBar {
    String location;
    String name;
    double iva;
    Menu menu;

    public CafeBar(){

    }
    public CafeBar(String location, String name, double iva, Menu menu) {
        this.location = buffer(location);
        this.name = buffer(name);
        this.iva = iva;
        this.menu = menu;
    }


    public String buffer(String value){
        StringBuilder Validate= new StringBuilder();
        if (value.length()>5){
            for (int i = 0;i< 6;i++ ){
                Validate.append(value.split("(?<=\\G.{1})")[i]);
            }
        }else {
            Validate = new StringBuilder(value);
        }

        return Validate.toString();
    }

    @Override
    public  String toString() {
        return "CafeBar{" +
                "location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", iva=" + iva +
                ", menu=" + menu +
                '}';
    }
}
    
    ```
  2  Guardado de datos: es necesario que en los atributos los String no sobrepasen de un cierto numero de caracteres para poder interpretar el pedido y poder moverme dentro del archivo.
  Utilice List<CafeBar> para traer todos los CafeBar a guardar, y utilizar RandomAccessFile para guardar esos datos en CafeBar.txt usando "rws" para su lectura escritura, luego de eso uso write y el tipo de dato para guardar debidamente todo, siempre es necesario el uso de try catch throws para la gestion de errores al usar Files.
  CafeBarImp.java
  ```java
      private static String  ARCHIVO_NAME= "CafeBar.txt";
    private static int  CAFEBAR_LENGTH= 52;

    ArrayList<CafeBar> listCafeBar=new ArrayList<>();
    @Override
    public void save(List<CafeBar> cafeBar) throws IllegalArgumentException {

        try(RandomAccessFile raf=new RandomAccessFile(ARCHIVO_NAME,"rws")) {
            for (CafeBar cb: cafeBar){
                raf.writeChars(cb.getLocation());
                raf.writeChars(cb.getName());
                raf.writeDouble(cb.getIva());
                raf.writeInt(cb.getMenu().getPriceCafe());
                raf.writeInt(cb.getMenu().getPriceBeer());
                raf.writeInt(cb.getMenu().getPriceCake());
                raf.writeInt(cb.getMenu().getPriceSandwich());
                raf.writeInt(cb.getMenu().getPriceWater());
            }



        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }

  
  ```

 
  3  Pedido de todos los datos: Luego de llenar el archivo y cerrarlo, puedo ingresar nuevamente y pedir esos datos
  cuando sea necesario supongamos ahora mismo.
  
  Ahora siguiendo con el uso de try catch, trows y RandomAccessFile, usare read y el tipo de datos para leer linea a linea para recopilar la inforacion y enviarla al Main para resolver mis dudas empresariales. ahre
  
   ```java
       @Override
    public ArrayList<CafeBar> findAll() {

        ArrayList<CafeBar> cafeBars=new ArrayList<>();
        try(RandomAccessFile raf=new RandomAccessFile(ARCHIVO_NAME,"rw")) {
            CafeBar newCafeBar=new CafeBar();
            Menu newMenu=new Menu();


            for (int j=0;j<raf.length()/CAFEBAR_LENGTH;j++){
                String value="";
                for (int i=0;i<6;i++){
                    value+= raf.readChar();
                }
                newCafeBar.setLocation(value);
                value="";
                for (int i=0;i<6;i++){
                    value+= raf.readChar();
                }
                newCafeBar.setName(value);


                newCafeBar.setIva(raf.readDouble());
                  newMenu.setPriceCafe(raf.readInt());
                  newMenu.setPriceBeer(raf.readInt());
                  newMenu.setPriceCafe(raf.readInt());
                  newMenu.setPriceSandwich(raf.readInt());
                  newMenu.setPriceWater(raf.readInt());
                newCafeBar.setMenu(newMenu);
                cafeBars.add(newCafeBar);
            }//52



        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return cafeBars;
    }

   ```
   4  y Si deseo hacer un Back Up del resultado?: En este caso puedo usar el par PrintStream y FileInputStream,
   para escribir y crear un archivo y el otro leerlo mira como queda:
 
   ```java
    
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
     ```

 
