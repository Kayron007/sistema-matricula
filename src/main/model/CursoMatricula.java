package main.model;

public class CursoMatricula {
    private String cursoId;
    private String matriculaId;

    // Construtor sem arg
    public CursoMatricula() {}

    // Construtor principal
    public CursoMatricula(String cursoId, String matriculaId) {
        this.cursoId = cursoId;
        this.matriculaId = matriculaId;
    }

    //public void mostrarDados() {}

    // Getters e Setters
    public String getCursoId() { return cursoId; }
    public void setCursoId(String cursoId) { this.cursoId = cursoId; }

    public String getMatriculaId() { return matriculaId; }
    public void setMatriculaId(String matriculaId) { this.matriculaId = matriculaId; }
}