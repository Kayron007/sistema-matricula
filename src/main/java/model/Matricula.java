package model;

import java.time.LocalDate;

public class Matricula extends BaseEntity {
    private Aluno id_aluno; //FK
    private Turma id_turma; //FK
    private boolean status;
    private LocalDate data_matricula;

    // Construtor sem arg
    public Matricula() {}

    // Construtor principal
    public Matricula(String id, Aluno id_aluno, Turma id_turma, boolean status, LocalDate data_matricula) {
        super(id);
        this.id_aluno = id_aluno;
        this.id_turma = id_turma;
        this.status = status;
        this.data_matricula = data_matricula;
    }

    @Override
    public void mostrarDados() {
        System.out.println("=== Matrícula ===");
        System.out.println("ID: " + id);
        System.out.println("Aluno (ID): " + id_aluno);
        System.out.println("Turma: (ID): " + id_turma);
        System.out.println("Status: " + (status ? "Ativa" : "Inativa"));
        System.out.println("Data da matrícula: " + data_matricula);
    }

    // Getters e Setters
    public Aluno getIdAluno() { return id_aluno; }
    public void setIdAluno(Aluno id_aluno) { this.id_aluno = id_aluno; }

    public Turma getIdTurma() { return id_turma; }
    public void setIdTurma(Turma id_turma) { this.id_turma = id_turma; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public LocalDate getDataMatricula() { return data_matricula; }
    public void setDataMatricula(LocalDate data_matricula) { this.data_matricula = data_matricula; }
}
