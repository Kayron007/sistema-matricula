/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sistemamatricula;

import java.util.Scanner;
import model.DAO.AlunoDAO;
import model.*;

public class SistemaMatricula {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bool = true;
        while (bool) {
            System.out.println("=====PORTAL DO ALUNO=====");
            System.out.println("Escolha uma opção:");
            System.out.println("1- Já é aluno, entrar.\n2-Quero me tornar aluno.\n3-Sair.");
            
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Escreva seu RA\nFUNCAO QUE VERIFICA O RA");
                    break;

                case 2:
                    System.out.println("Registrando novo aluno\nFUNCAO QUE REGISTRA NOVO ALUNO");
                    break;

                case 3:
                    System.out.println("SAIR");
                    bool = false;
                default:
                    System.out.println("opção inválida");
                    ;
            }
        }
        sc.close();
    }
}
