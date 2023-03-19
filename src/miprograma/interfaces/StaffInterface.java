package miprograma.interfaces;

import miprograma.clases.People;
import miprograma.clases.Staff;

import java.util.ArrayList;
import java.util.List;

public interface StaffInterface {


    void save(ArrayList<Staff> staff)throws IllegalArgumentException;

    public ArrayList<Staff> findAll();
}
