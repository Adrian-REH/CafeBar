package miprograma.clases;

import java.util.ArrayList;
import java.util.List;

public class Staff extends People {

    int idEmpleado;
    ArrayList<Customer> listClientes;
    int dineroGenerado;
    int ganancia;


    public  Staff(){}

    public Staff(int idEmpleado, ArrayList<Customer> listClientes, int dineroGenerado, int ganancia) {
        this.idEmpleado = idEmpleado;
        this.listClientes = listClientes;
        this.dineroGenerado = dineroGenerado;
        this.ganancia = ganancia;
    }

    public Staff(String name, String lastName, String dni, int idEmpleado, ArrayList<Customer> listClientes, int dineroGenerado, int ganancia) {
        super(name, lastName, dni);
        this.idEmpleado = idEmpleado;
        this.listClientes = listClientes;
        this.dineroGenerado = dineroGenerado;
        this.ganancia = ganancia;
    }


    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public ArrayList<Customer> getListClientes() {
        return listClientes;
    }

    public void setListClientes(ArrayList<Customer> listClientes) {
        this.listClientes = listClientes;
    }

    public int getDineroGenerado() {
        return dineroGenerado;
    }

    public void setDineroGenerado(int dineroGenerado) {
        this.dineroGenerado = dineroGenerado;
    }

    public int getGanancia() {
        return ganancia;
    }

    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
    }


    @Override
    public String toString() {
        return "Staff{" +
                "idEmpleado=" + idEmpleado +
                ", listClientes=" + listClientes +
                ", dineroGenerado=" + dineroGenerado +
                ", ganancia=" + ganancia +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
