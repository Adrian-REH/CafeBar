package miprograma.clases;

public class Table {
    int idTable;
    int numCustomer;
    int numChair;

    public Table(){

    }

    public Table(int idTable, int numCustomer, int numChair) {
        this.idTable = idTable;
        this.numCustomer = numCustomer;
        this.numChair = numChair;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public int getNumCustomer() {
        return numCustomer;
    }

    public void setNumClient(int numClient) {
        this.numCustomer = numClient;
    }

    public int getNumChair() {
        return numChair;
    }

    public void setNumChair(int numChair) {
        this.numChair = numChair;
    }

    @Override
    public String toString() {
        return "Table{" +
                "idTable=" + idTable +
                ", numClient=" + numCustomer +
                ", numChair=" + numChair +
                '}';
    }
}
