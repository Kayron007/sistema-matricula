/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.*;
import model.Aluno;
import model.Conexao;


public class AlunoDAO implements InterfaceDAO<Aluno> {
    
    @Override
    public void inserir(Aluno a){
        String sql = "INSERT INTO ALUNOS (ID, NOME, EMAIL, CPF_NUM, ENDERECO, TELEFONE) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {    
        
            stmt.setString(1, a.getId());
            stmt.setString(2, a.getNome());
            stmt.setString(3, a.getEmail());
            stmt.setString(4, a.getCpf());
            stmt.setString(5, a.getEndereco());
            stmt.setString(6, a.getTelefone());
            stmt.executeUpdate();
            
            System.out.println("Aluno adicionado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao inserir o aluno: " + e.getMessage());
        }
    }
    
    @Override
    public void deletar(Aluno a){
        String sql = "DELETE FROM ALUNOS WHERE ID = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, a.getId());
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar o aluno: " + e.getMessage());
        }
    }
    
    @Override
    public void atualizar(Aluno a){
        String sql = "UPDATE ALUNOS SET EMAIL = ?, ENDERECO = ?, TELEFONE = ? WHERE ID = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, a.getEmail());
            stmt.setString(2, a.getEndereco());
            stmt.setString(2, a.getTelefone());
            stmt.setString(2, a.getId());
            stmt.executeUpdate();
            
            System.out.println("Dados atualizados com sucesso");
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o aluno: " + e.getMessage());
        }
    }
}
