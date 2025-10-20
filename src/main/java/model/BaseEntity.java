package main.java.model;

public abstract class BaseEntity {
    protected String id;

    //Construtor sem arg
    public BaseEntity() {}

    //Construtor principal
    public BaseEntity(String id) {
        this.id = id;
    }

    //Getter e setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public abstract void mostrarDados();
}