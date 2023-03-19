package miprograma.clases;

import java.util.List;

public class Customer extends People {

    int idCustomer;
    int numCard;
    List<String> listConsumption;
    int price;
    Table table;

    public Customer(){

    }

    public Customer(int idCustomer, int numCard, List<String> listConsumption, int price, Table table) {
        this.idCustomer = idCustomer;
        this.numCard = numCard;
        this.listConsumption = listConsumption;
        this.price = price;
        this.table = table;
    }

    public Customer(String name, String lastName, String dni, int idCustomer, int numCard, List<String> listConsumption, int price, Table table) {
        super(name, lastName, dni);
        this.idCustomer = idCustomer;
        this.numCard = numCard;
        this.listConsumption = listConsumption;
        this.price = price;
        this.table = table;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getNumCard() {
        return numCard;
    }

    public void setNumCard(int numCard) {
        this.numCard = numCard;
    }

    public List<String> getListConsumption() {
        return listConsumption;
    }

    public void setListConsumption(List<String> listConsumption) {
        this.listConsumption = listConsumption;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", numCard=" + numCard +
                ", listConsumption=" + listConsumption +
                ", price=" + price +
                ", table=" + table +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
