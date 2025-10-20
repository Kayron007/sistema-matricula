package main.model;

public abstract class Superclasse {
    protected String id;

    //Construtor sem arg
    public Superclasse() {}

    //Construtor principal
    public Superclasse(String id) {
        this.id = id;
    }

    //Getter e setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public abstract void mostrarDados();
}
