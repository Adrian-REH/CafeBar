package miprograma.clases;

import java.util.HashMap;

public class Menu {
    int priceCafe;
    int priceSandwich;
    int priceBeer;
    int priceWater;
    int priceCake;

    public Menu(){

    }
    public Menu(int priceCafe, int priceSandwich, int priceBeer, int priceWater, int priceCake) {
        this.priceCafe = priceCafe;
        this.priceSandwich = priceSandwich;
        this.priceBeer = priceBeer;
        this.priceWater = priceWater;
        this.priceCake = priceCake;
    }

    public int getPriceCafe() {
        return priceCafe;
    }

    public void setPriceCafe(int priceCafe) {
        this.priceCafe = priceCafe;
    }

    public int getPriceSandwich() {
        return priceSandwich;
    }

    public void setPriceSandwich(int priceSandwich) {
        this.priceSandwich = priceSandwich;
    }

    public int getPriceBeer() {
        return priceBeer;
    }

    public void setPriceBeer(int priceBeer) {
        this.priceBeer = priceBeer;
    }

    public int getPriceWater() {
        return priceWater;
    }

    public void setPriceWater(int priceWater) {
        this.priceWater = priceWater;
    }

    public int getPriceCake() {
        return priceCake;
    }

    public void setPriceCake(int priceCake) {
        this.priceCake = priceCake;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "priceCafe=" + priceCafe +
                ", priceSandwich=" + priceSandwich +
                ", priceBeer=" + priceBeer +
                ", priceWater=" + priceWater +
                ", priceCake=" + priceCake +
                '}';
    }
}
