package miprograma.clases;

import java.nio.charset.StandardCharsets;

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


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = buffer(location);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {


        this.name = buffer(name);
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
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
