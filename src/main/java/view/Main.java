package view;

import java.util.Scanner;

import control.AlunoController;
import control.CursoController;
import control.MateriaController;
import control.TurmaController;
import control.MatriculaController;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AlunoController alunoCtrl = new AlunoController();
        CursoController cursoCtrl = new CursoController();
        MateriaController materiaCtrl = new MateriaController();
        TurmaController turmaCtrl = new TurmaController();
        MatriculaController matriculaCtrl = new MatriculaController();

        boolean running = true;

        while (running) {
            System.out.println("\n===============================");
            System.out.println("     SISTEMA DE MATRÍCULA");
            System.out.println("===============================");
            System.out.println("1 - Gerenciar Alunos");
            System.out.println("2 - Gerenciar Cursos");
            System.out.println("3 - Gerenciar Matérias");
            System.out.println("4 - Gerenciar Turmas");
            System.out.println("5 - Gerenciar Matrículas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    alunoCtrl.menu(sc);
                    break;
                case "2":
                    cursoCtrl.menu(sc);
                    break;
                case "3":
                    materiaCtrl.menu(sc);
                    break;
                case "4":
                    turmaCtrl.menu(sc);
                    break;
                case "5":
                    matriculaCtrl.menu(sc);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("\nSistema encerrado com sucesso!");
        sc.close();
    }
}