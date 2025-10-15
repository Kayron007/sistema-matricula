package main.model;

public class CursoMatricula {
    private String cursoId; //FK para Curso
    private String matriculaId; //FK para Matricula

    // Construtor sem arg
    public CursoMatricula() {}

    // Construtor principal
    public CursoMatricula(String cursoId, String matriculaId) {
        this.cursoId = cursoId;
        this.matriculaId = matriculaId;
    }

    public void mostrarDados() {
        System.out.println("=== Curso e Matrícula ===");
        System.out.println("Curso vinculado (ID): " + cursoId);
        System.out.println("Matrícula vinculada (ID): " + matriculaId);
    }

    // Getters e Setters
    public String getCursoId() { return cursoId; }
    public void setCursoId(String cursoId) { this.cursoId = cursoId; }

    public String getMatriculaId() { return matriculaId; }
    public void setMatriculaId(String matriculaId) { this.matriculaId = matriculaId; }
}