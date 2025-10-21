package control;

import java.util.List;
import java.util.Scanner;
import model.DAO.CursoDAO;
import model.Turma;
import model.DAO.TurmaDAO;

public class TurmaController {
    private final TurmaDAO dao = new TurmaDAO();

    public void menu(Scanner sc) {
        boolean run = true;
        while (run) {
            System.out.println("\n--- TURMAS ---");
            System.out.println("1 - Cadastrar turma");
            System.out.println("2 - Listar turmas");
            System.out.println("3 - Atualizar turma");
            System.out.println("4 - Deletar turma");
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

    public void criar(Scanner sc){
        Turma t = new Turma();
        CursoDAO C = new CursoDAO();
        System.out.print("ID turma: "); t.setId(sc.nextLine());
        System.out.print("Ano: "); t.setAno(Integer.parseInt(sc.nextLine()));
        System.out.print("Semestre: "); t.setSemestre(Integer.parseInt(sc.nextLine()));
        System.out.print("ID Curso: "); String id = sc.nextLine();
        t.setIdcurso(C.buscarPorId(id));
        dao.inserir(t);
    }

    public void listar() {
        try {
            List<Turma> l = dao.listar();
            System.out.println("\n=== TURMAS ===");
            for (Turma t : l) System.out.printf("%s | %d/%d\n", t.getId(), t.getAno(), t.getSemestre());
        } catch (Exception e) {
            System.out.println("Implemente listar() em TurmaDAO.");
        }
    }

    public void atualizar(Scanner sc) {
        System.out.print("ID turma: "); String id = sc.nextLine();
        Turma t = dao.buscarPorId(id);
        if (t==null) { System.out.println("Não encontrada"); return; }
        System.out.print("Ano ["+t.getAno()+"]: "); String s = sc.nextLine(); if(!s.isEmpty()) t.setAno(Integer.parseInt(s));
        System.out.print("Semestre ["+t.getSemestre()+"]: "); s = sc.nextLine(); if(!s.isEmpty()) t.setSemestre(Integer.parseInt(s));
        dao.atualizar(t);
    }

    public void deletar(Scanner sc) {
        System.out.print("ID turma: "); String id=sc.nextLine();
        Turma t = new Turma(); t.setId(id);
        dao.deletar(t);
    }
}