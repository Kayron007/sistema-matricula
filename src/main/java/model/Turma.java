package model;

import java.time.Year;

public class Turma extends BaseEntity {
    private int ano;
    private int semestre;
    private Curso id_curso; //FK

    //Construtor sem arg
    public Turma() {}

    //Construtor principal
    public Turma(String id, int ano, int semestre, Curso id_curso) {
        super(id);
        this.ano = ano;
        this.semestre = semestre;
        this.id_curso = id_curso;
    }

    @Override
    public void mostrarDados() {
        System.out.println("=== Turma ===");
        System.out.println("ID: " + id);
        System.out.println("Ano: " + ano);
        System.out.println("Semestre: " + semestre);
        System.out.println("Curso vinculado (ID): " + id_curso);
    }

    //Getters e Setters
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    public Curso getIdcurso() { return id_curso; }
    public void setIdcurso(Curso id_curso) { this.id_curso = id_curso; }
}
