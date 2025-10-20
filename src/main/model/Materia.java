package main.model;

public class Materia extends Superclasse {
    private String nome;
    private String id_curso; //FK

    //Construtor sem arg
    public Materia() {}

    //Construtor principal
    public Materia(String id, String nome, String id_curso) {
        super(id);
        this.nome = nome;
        this.id_curso = id_curso;
    }

    @Override
    public void mostrarDados() {
        System.out.println("=== Matéria ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Curso vinculado (ID): " + id_curso);
    }

    //Getters e Setters
    public String getNome() { return nome; } 
    public void setNome(String nome) { this.nome = nome; }

    public String getIdCurso() { return id_curso; }
    public void setIdCurso(String id_curso) { this.id_curso = id_curso; }
}
