package main.model;

public class Curso extends BaseEntity {
    private String nome;
    private int carga_horaria;

    public Curso() { super(); }

    public Curso(String id, String nome, int carga_horaria) {
        super(id);
        this.nome = nome;
        this.carga_horaria = carga_horaria;
    }

    //public void mostrarDados() {}

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getCargaHoraria() { return carga_horaria; }
    public void setCargaHoraria(int carga_horaria) { this.carga_horaria = carga_horaria; }
}