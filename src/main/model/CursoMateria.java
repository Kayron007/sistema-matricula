package main.model;

public class CursoMateria {
    private String curso_id; // FK para Curso
    private String materia_id; // FK para Materia

    // Construtor sem arg
    public CursoMateria() {}

    // Construtor principal
    public CursoMateria(String curso_id, String materia_id) {
        this.curso_id = curso_id;
        this.materia_id = materia_id;
    }

    public void mostrarDados() {
        System.out.println("=== Curso e Matéria ===");
        System.out.println("Curso vinculado (ID): " + curso_id);
        System.out.println("Matéria vinculada (ID): " + materia_id);
    }

    // Getters e Setters
    public String getIdCurso() { return curso_id; }
    public void setIdCurso(String curso_id) { this.curso_id = curso_id; }

    public String getIdMateria() { return materia_id; }
    public void setIdMateria(String materia_id) { this.materia_id = materia_id; }
}
