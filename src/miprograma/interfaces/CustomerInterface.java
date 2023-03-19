package miprograma.interfaces;

import miprograma.clases.CafeBar;
import miprograma.clases.Customer;
import miprograma.clases.People;

import java.util.ArrayList;
import java.util.List;

public interface CustomerInterface {

    public void save(ArrayList<Customer> customer) throws IllegalArgumentException;
    public ArrayList<Customer> findAll();
}
