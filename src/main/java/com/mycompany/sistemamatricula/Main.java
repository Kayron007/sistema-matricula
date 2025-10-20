package com.mycompany.sistemamatricula;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.time.LocalDate;
import model.DAO.CursoDAO;
import model.*;
import model.DAO.AlunoDAO;
import model.DAO.CursoMateriaDAO;
import model.DAO.MateriaDAO;
import model.DAO.MatriculaDAO;
import model.DAO.TurmaDAO;


public class Main {

    public static void main(String[] args) {
        System.out.println("view.Main.main()");
        AlunoDAO a = new AlunoDAO();
        CursoDAO c = new CursoDAO();
        MateriaDAO m = new MateriaDAO();
        TurmaDAO t = new TurmaDAO();
        MatriculaDAO ma = new MatriculaDAO();
        CursoMateriaDAO cm = new CursoMateriaDAO();
        
        Aluno A = new Aluno("123", "Mano", "mano@gmail.com", "11111111111", "ali", "22222222222");
        Curso C = new Curso("2", "Bio", 15000);
        Curso Ca = new Curso("3", "Veterinaria", 12000);
        Curso Cb =  new Curso("5", "Eng", 10000);
        Materia M = new Materia("123","materiaDeVet", Ca);
        Turma T = new Turma("123", 2026, 1, Ca);
        LocalDate date = LocalDate.now(); 
        Matricula Ma = new Matricula("123", A, T, false, date);
        CursoMateria Cm = new CursoMateria("111",Ca, M);
        
        
        c.inserir(Cb);
        System.out.println("FIM");
    }
} 