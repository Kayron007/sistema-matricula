package control;

import java.util.List;
import java.util.Scanner;

import model.Aluno;
import model.DAO.AlunoDAO;

public class AlunoController{

    private final AlunoDAO dao;

    public AlunoController() {
        this.dao = new AlunoDAO();
    }

    public void menu(Scanner sc) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ALUNO ---");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Atualizar aluno");
            System.out.println("4 - Deletar aluno");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            int opt = sc.nextInt();
            sc.nextLine(); // limpar newline

            switch (opt) {
                case 1: criarAluno(sc); break;
                case 2: listarAlunos(); break;
                case 3: atualizarAluno(sc); break;
                case 4: deletarAluno(sc); break;
                case 0: running = false; break;
                default: System.out.println("Opção inválida"); break;
            }
        }
    }

    public void criarAluno(Scanner sc) {
        Aluno a = new Aluno();
        System.out.print("ID: "); a.setId(sc.nextLine());
        System.out.print("Nome: "); a.setNome(sc.nextLine());
        System.out.print("Email: "); a.setEmail(sc.nextLine());
        System.out.print("CPF: "); a.setCpf(sc.nextLine());
        System.out.print("Endereço: "); a.setEndereco(sc.nextLine());
        System.out.print("Telefone: "); a.setTelefone(sc.nextLine());

        dao.inserir(a);
        System.out.println("Aluno cadastrado (tentativa de inserir via DAO).");
    }

    public void listarAlunos() {
        try {
            List<Aluno> lista = dao.listar();
            System.out.println("\n=== ALUNOS ===");
            for (Aluno a : lista) {
                System.out.printf("ID = %s | Nome = %s - Email = %s\n", a.getId(), a.getNome(), a.getEmail());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
    }

    public void atualizarAluno(Scanner sc) {
        System.out.print("Informe ID do aluno a atualizar: ");
        String id = sc.nextLine();

        Aluno a = dao.buscarPorId(id);
        if (a == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Nome ["+a.getNome()+"]: "); String s = sc.nextLine(); if (!s.isEmpty()) a.setNome(s);
        System.out.print("Email ["+a.getEmail()+"]: "); s = sc.nextLine(); if (!s.isEmpty()) a.setEmail(s);
        System.out.print("Endereço ["+a.getEndereco()+"]: "); s = sc.nextLine(); if (!s.isEmpty()) a.setEndereco(s);
        System.out.print("Telefone ["+a.getTelefone()+"]: "); s = sc.nextLine(); if (!s.isEmpty()) a.setTelefone(s);

        dao.atualizar(a);
        System.out.println("Aluno atualizado (tentativa de atualizar via DAO).");
    }

    public void deletarAluno(Scanner sc) {
        System.out.print("Informe ID do aluno a deletar: ");
        String id = sc.nextLine();
        Aluno a = new Aluno();
        a.setId(id);
        dao.deletar(a);
        System.out.println("Solicitação de remoção enviada ao DAO.");
    }
}