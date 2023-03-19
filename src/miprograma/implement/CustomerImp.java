package miprograma.implement;


import miprograma.clases.Customer;
import miprograma.clases.People;
import miprograma.clases.Staff;
import miprograma.clases.Table;
import miprograma.interfaces.CustomerInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class CustomerImp implements CustomerInterface {
    private static String  ARCHIVO_NAME= "Customer.txt";
    private static int  CUSTOMER_LENGTH= 148;

    @Override
    public void save(ArrayList<Customer> customer) throws IllegalArgumentException{
        try(RandomAccessFile raf=new RandomAccessFile(ARCHIVO_NAME,"rws")) {
            for (Customer people: customer){
                raf.writeChars(people.getName());
                raf.writeChars(people.getLastName());
                raf.writeChars(people.getDni());
                raf.writeInt(people.getIdCustomer());
                raf.writeInt(people.getNumCard());
/*                for (String listC:people.getListConsumption()){
                    raf.writeChars(listC);

                }*/
                raf.writeInt(people.getPrice());
                raf.writeInt(people.getTable().getIdTable());
                raf.writeInt(people.getTable().getNumCustomer());
                raf.writeInt(people.getTable().getNumChair());
            }



        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ArrayList<Customer> findAll() {

        ArrayList<Customer> customer=new ArrayList<>();

        try(RandomAccessFile raf=new RandomAccessFile(ARCHIVO_NAME,"rw")) {


            //System.out.println(raf.length());

            for (int j=0;j<raf.length()/CUSTOMER_LENGTH;j++){
                Customer newCustomer=new Customer();
                Table newTable=new Table();

                String value="";
                for (int i=0;i<6;i++){
                    value+= raf.readChar();
                }
                newCustomer.setName(value);

                value="";
                for (int i=0;i<6;i++){
                    value+= raf.readChar();
                }
                newCustomer.setLastName(value);

                value="";
                for (int i=0;i<6;i++){
                    value+= raf.readChar();
                }
                newCustomer.setDni(value);

                newCustomer.setIdCustomer(raf.readInt());
                newCustomer.setNumCard(raf.readInt());
                newCustomer.setPrice(raf.readInt());
                 newTable.setIdTable(raf.readInt());
                 newTable.setNumClient(raf.readInt());
                 newTable.setNumChair(raf.readInt());
                newCustomer.setTable(newTable);
                customer.add(newCustomer);

            }//52

        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return customer;
    }
}
