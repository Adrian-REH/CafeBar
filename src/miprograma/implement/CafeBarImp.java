package miprograma.implement;

import miprograma.clases.CafeBar;
import miprograma.clases.Menu;
import miprograma.clases.Staff;
import miprograma.interfaces.CafeBarInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CafeBarImp implements CafeBarInterface {


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
}
