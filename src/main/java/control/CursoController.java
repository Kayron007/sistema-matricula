package control;

import java.util.List;
import java.util.Scanner;
import model.Curso;
import model.DAO.CursoDAO;

public class CursoController {
    private final CursoDAO dao = new CursoDAO();

    public void menu(Scanner sc) {
        boolean run = true;
        while (run) {
            System.out.println("\n--- CURSOS ---");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Listar cursos");
            System.out.println("3 - Atualizar curso");
            System.out.println("4 - Deletar curso");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            int opt = sc.nextInt(); sc.nextLine();
            switch(opt) {
                case 1: criarCurso(sc); break;
                case 2: listarCursos(); break;
                case 3: atualizarCurso(sc); break;
                case 4: deletarCurso(sc); break;
                case 0: run=false; break;
                default: System.out.println("Opção inválida");
            }
        }
    }

    public void criarCurso(Scanner sc) {
        Curso c = new Curso();
        System.out.print("ID do curso: "); c.setId(sc.nextLine());
        System.out.print("Nome do curso: "); c.setNome(sc.nextLine());
        System.out.print("Carga Horaria do curso: "); c.setCargaHoraria(sc.nextInt());
        dao.inserir(c);
        System.out.println("Curso inserido (via DAO).");
    }

    public void listarCursos() {
        try {
            List<Curso> list = dao.listar();
            System.out.println("\n=== CURSOS ===");
            for (Curso c: list) {
                System.out.printf("%s | %s - %s\n", c.getId(), c.getNome(), c.getCargaHoraria());
            }
        } catch (Exception e) {
            System.out.println("Implemente listar() em CursoDAO.");
        }
    }

    public void atualizarCurso(Scanner sc) {
        System.out.print("ID curso: "); String id=sc.nextLine();

        Curso c = dao.buscarPorId(id);
        if (c==null) { System.out.println("Curso não encontrado"); return; }
        System.out.print("Nome ["+c.getNome()+"]: "); String s=sc.nextLine(); if(!s.isEmpty()) c.setNome(s);
        dao.atualizar(c);
        System.out.println("Curso atualizado.");
    }

    public void deletarCurso(Scanner sc) {
        System.out.print("ID curso a deletar: "); String id=sc.nextLine();
        Curso c = new Curso(); c.setId(id);
        dao.deletar(c);
        System.out.println("Pedido de remoção enviado ao DAO.");
    }
}