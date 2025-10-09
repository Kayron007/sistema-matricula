package main.model;

import java.time.Year;

public class Turma extends BaseEntity {
    private Year ano;
    private int semestre;
    private String id_curso;

    //Construtor vazio
    public Turma() { super(); }

    //Construtor full
    public Turma(String id, Year ano, int semestre, String id_curso) {
        super(id);
        this.ano = ano;
        this.semestre = semestre;
        this.id_curso = id_curso;
    }

    //public void mostrarDados() {}

    //Getters e Setters
    public Year getAno() { return ano; }
    public void setAno(Year ano) { this.ano = ano; }

    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    public String getIdcurso() { return id_curso; }
    public void setIdcurso(String id_curso) { this.id_curso = id_curso; }
}