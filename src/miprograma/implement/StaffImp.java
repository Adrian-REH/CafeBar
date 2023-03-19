package miprograma.implement;

import miprograma.clases.Customer;
import miprograma.clases.People;
import miprograma.clases.Staff;
import miprograma.interfaces.StaffInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class StaffImp implements StaffInterface {
    private static String  ARCHIVO_NAME= "Staff.txt";

    private static int  STAFF_LENGTH= 96;

    @Override
    public void save(ArrayList<Staff> staff)throws IllegalArgumentException {
        try(RandomAccessFile raf=new RandomAccessFile(ARCHIVO_NAME,"rws")) {
            for (Staff st: staff){
                raf.writeChars(st.getName());
                raf.writeChars(st.getLastName());
                raf.writeChars(st.getDni());
                raf.writeInt(st.getIdEmpleado());
          /*      for (Customer listC:st.getListClientes()){
                    raf.writeChars(listC.getDni());
                    raf.writeInt(listC.getIdCustomer());
                    raf.writeInt(listC.getNumCard());
                    for (String list:listC.getListConsumption()){
                        raf.writeChars(list);
                    }
                    raf.writeInt(listC.getPrice());
                    raf.writeInt(listC.getTable().getNumCustomer());

                }*/
                raf.writeInt(st.getDineroGenerado());
                raf.writeInt(st.getGanancia());

            }



        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public ArrayList<Staff> findAll() {

        ArrayList<Staff> staff=new ArrayList<>();
        try(RandomAccessFile raf=new RandomAccessFile(ARCHIVO_NAME,"rw")) {


            for (int j=0;j<raf.length()/STAFF_LENGTH;j++){
                Staff newStaff=new Staff();

                String value="";
                for (int i=0;i<6;i++){
                    value+= raf.readChar();
                }
                newStaff.setName(value);
                value="";

                for (int i=0;i<6;i++){
                    value+= raf.readChar();
                }
                newStaff.setLastName(value);

                value="";
                for (int i=0;i<6;i++){
                    value+= raf.readChar();
                }
                newStaff.setDni(value);
                newStaff.setIdEmpleado(raf.readInt());
                newStaff.setDineroGenerado(raf.readInt());
                newStaff.setGanancia(raf.readInt());

                staff.add(newStaff);
            }//52



        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return staff;
    }
}
