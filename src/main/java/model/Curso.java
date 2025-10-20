package main.java.model;

public class Curso extends BaseEntity {
    private String nome;
    private int carga_horaria;

    //Construtor sem arg
    public Curso() {}

    //Construtor principal
    public Curso(String nome, int carga_horaria) {
        this.nome = nome;
        this.carga_horaria = carga_horaria;
    }
    
    public Curso(String id, String nome, int carga_horaria) {
        super(id);
        this.nome = nome;
        this.carga_horaria = carga_horaria;
    }

    @Override
    public void mostrarDados() {
        System.out.println("=== Curso ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Carga horária: " + carga_horaria);
    }

    //Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getCargaHoraria() { return carga_horaria; }
    public void setCargaHoraria(int carga_horaria) { this.carga_horaria = carga_horaria; }
}