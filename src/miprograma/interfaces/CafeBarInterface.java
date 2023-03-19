package miprograma.interfaces;

import miprograma.clases.CafeBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface CafeBarInterface {

    public void save(List<CafeBar> cafeBar) throws IllegalArgumentException;
    public ArrayList<CafeBar> findAll();

}
