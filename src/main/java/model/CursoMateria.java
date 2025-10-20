package main.java.model;

public class CursoMateria extends BaseEntity{
    private Curso cursoId; //FK para Curso
    private Materia materiaId; //FK para Matricula

    // Construtor sem arg
    public CursoMateria() {}

    // Construtor principal
    public CursoMateria(String id, Curso cursoId, Materia materiaId) {
        super(id);
        this.cursoId = cursoId;
        this.materiaId = materiaId;
    }

    public void mostrarDados() {
        System.out.println("=== Curso e Matrícula ===");
        System.out.println("Curso vinculado (ID): " + cursoId);
        System.out.println("Matrícula vinculada (ID): " + materiaId);
    }

    // Getters e Setters
    
    
    public Curso getCursoId() { return cursoId; }
    public void setCursoId(Curso cursoId) { this.cursoId = cursoId; }

    public Materia getMateriaId() { return materiaId; }
    public void setMateriaId(Materia materiaId) { this.materiaId = materiaId; }
    
}