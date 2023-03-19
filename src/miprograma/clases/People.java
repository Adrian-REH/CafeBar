package miprograma.clases;

public  class People {
    String name;
    String lastName;
    String dni;

    public People(){

    }
    public People(String name, String lastName, String dni) {
        this.name = buffer(name);
        this.lastName = buffer(lastName);
        this.dni = buffer(dni);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = buffer(name);

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = buffer(lastName);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = buffer(dni);
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
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
