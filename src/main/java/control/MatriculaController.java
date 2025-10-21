package control;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.Matricula;
import model.Aluno;
import model.Turma;
import model.DAO.MatriculaDAO;

public class MatriculaController {

    private final MatriculaDAO dao = new MatriculaDAO();

    public void menu(Scanner sc) {
        boolean run = true;
        while (run) {
            System.out.println("\n--- MATRÍCULAS ---");
            System.out.println("1 - Matricular aluno");
            System.out.println("2 - Listar matrículas");
            System.out.println("3 - Atualizar matrícula");
            System.out.println("4 - Cancelar matrícula");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            int opt = sc.nextInt(); sc.nextLine();
            switch (opt) {
                case 1 -> matricular(sc);
                case 2 -> listar();
                case 3 -> atualizar(sc);
                case 4 -> deletar(sc);
                case 0 -> run = false;
                default -> System.out.println("Opção inválida");
            }
        }
    }

    public void matricular(Scanner sc) {
        Matricula m = new Matricula();

        System.out.print("ID do aluno: ");
        String idAluno = sc.nextLine();
        Aluno a = new Aluno();
        a.setId(idAluno);
        m.setIdAluno(a);

        System.out.print("ID da turma: ");
        String idTurma = sc.nextLine();
        Turma t = new Turma();
        t.setId(idTurma);
        m.setIdTurma(t);

        m.setStatus(true);
        m.setDataMatricula(LocalDate.now());

        dao.inserir(m);
        System.out.println("Matrícula criada com sucesso!");
    }

    public void listar() {
        List<Matricula> lista = dao.listar();
        System.out.println("\n=== MATRÍCULAS ===");
        for (Matricula m : lista) {
            System.out.printf("ID: %s | Aluno: %s | Turma: %s | Status: %s | Data: %s\n",
                    m.getId(),
                    m.getIdAluno().getId(),
                    m.getIdTurma().getId(),
                    m.isStatus() ? "Ativa" : "Inativa",
                    m.getDataMatricula());
        }
    }

    public void atualizar(Scanner sc) {
        System.out.print("Informe o ID da matrícula: ");
        String id = sc.nextLine();
        Matricula m = dao.buscarPorId(id);
        if (m == null) {
            System.out.println("Matrícula não encontrada.");
            return;
        }

        System.out.print("Deseja alterar o status? (s/n): ");
        String opt = sc.nextLine();
        if (opt.equalsIgnoreCase("s")) {
            m.setStatus(!m.isStatus());
        }

        dao.atualizar(m);
        System.out.println("Matrícula atualizada com sucesso!");
    }

    public void deletar(Scanner sc) {
        System.out.print("Informe o ID da matrícula para excluir: ");
        String id = sc.nextLine();
        Matricula m = new Matricula();
        m.setId(id);
        dao.deletar(m);
        System.out.println("Matrícula removida com sucesso!");
    }
}