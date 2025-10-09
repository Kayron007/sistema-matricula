package main.model;

public class Materia extends BaseEntity {
    private String nome;
    private String id_curso;

    // Construtor sem arg
    public Materia() { super(); }

    public Materia(String id, String nome, String id_curso) {
        super(id);
        this.nome = nome;
        this.id_curso = id_curso;
    }

    //public void mostrarDados() {}

    // Getters e Setters
    public String getNome() { return nome; } 
    public void setNome(String nome) { this.nome = nome; }

    public String getIdcurso() { return id_curso; }
    public void setIdcurso(String id_curso) { this.id_curso = id_curso; }
}