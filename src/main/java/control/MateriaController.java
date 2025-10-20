package main.java.control;

import java.util.List;
import java.util.Scanner;
import main.java.model.DAO.CursoDAO;
import main.java.model.Materia;
import main.java.model.DAO.MateriaDAO;

public class MateriaController {
    private final MateriaDAO dao = new MateriaDAO();

    public void menu(Scanner sc) {
        boolean run = true;
        while (run) {
            System.out.println("\n--- MATÉRIAS ---");
            System.out.println("1 - Cadastrar matéria");
            System.out.println("2 - Listar matérias");
            System.out.println("3 - Atualizar matéria");
            System.out.println("4 - Deletar matéria");
            System.out.println("0 - Voltar");
            int opt = sc.nextInt(); sc.nextLine();
            switch(opt) {
                case 1: criar(sc); break;
                case 2: listar(); break;
                case 3: atualizar(sc); break;
                case 4: deletar(sc); break;
                case 0: run=false; break;
            }
        }
    }

    public void criar(Scanner sc) {
        Materia m = new Materia();
        CursoDAO C = new CursoDAO();
        System.out.print("ID matéria: "); m.setId(sc.nextLine());
        System.out.print("Nome matéria: "); m.setNome(sc.nextLine());
        System.out.print("ID Curso: "); String id = sc.nextLine();
        m.setIdcurso(C.buscarPorId(id));
        dao.inserir(m);
        System.out.println("Matéria inserida.");
    }

    public void listar() {
        try {
            List<Materia> l = dao.listar();
            for (Materia m : l) System.out.printf("%s - %s\n", m.getId(), m.getNome());
        } catch (Exception e) {
            System.out.println("Implementar listar() no MateriaDAO.");
        }
    }

    public void atualizar(Scanner sc) {
        System.out.print("ID matéria: "); String id=sc.nextLine();
        Materia m = dao.buscarPorId(id);
        if (m==null) { System.out.println("Não encontrada."); return; }
        System.out.print("Nome ["+m.getNome()+"]: "); String s=sc.nextLine(); if(!s.isEmpty()) m.setNome(s);
        dao.atualizar(m);
    }

    public void deletar(Scanner sc) {
        System.out.print("ID matéria a deletar: "); String id=sc.nextLine();
        Materia m = new Materia(); m.setId(id);
        dao.deletar(m);
    }
}