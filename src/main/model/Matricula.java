package main.model;

import java.time.LocalDate;

public class Matricula extends BaseEntity {
    private String id_aluno;
    private String id_turma;
    private boolean status;
    private LocalDate data_matricula;

    // Construtor sem-arg
    public Matricula() { super(); }

    // Construtor principal
    public Matricula(String id, String id_aluno, String id_turma, boolean status, LocalDate data_matricula) {
        super(id);
        this.id_aluno = id_aluno;
        this.id_turma = id_turma;
        this.status = status;
        this.data_matricula = data_matricula;
    }

    //public void mostrarDados() {}

    // Getters e Setters
    public String getIdAluno() { return id_aluno; }
    public void setIdAluno(String id_aluno) { this.id_aluno = id_aluno; }

    public String getIdturma() { return id_turma; }
    public void setIdturma(String id_turma) { this.id_turma = id_turma; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public LocalDate getData() { return data_matricula; }
    public void setData(LocalDate data_matricula) { this.data_matricula = data_matricula; }
}