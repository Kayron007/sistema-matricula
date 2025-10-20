/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Conexao;
import model.Curso;

/**
 *
 * @author gustavo
 */
public class CursoDAO implements InterfaceDAO<Curso>{
    
    @Override
    public void inserir(Curso c){
        String sql = "INSERT INTO CURSO (ID_CURSO, NOME_CURSO, CARGA_HORARIA) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {    
        
            stmt.setString(1, c.getId());
            stmt.setString(2, c.getNome());
            stmt.setInt(3, c.getCargaHoraria());
            stmt.executeUpdate();
            
            System.out.println("Curso adicionado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao inserir o aluno: " + e.getMessage());
        }
    }
    
    @Override
    public void deletar(Curso c){
        String sql = "DELETE FROM CURSO WHERE ID_CURSO = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, c.getId());
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar o Curso: " + e.getMessage());
        }
    }
    
    @Override
    public void atualizar(Curso c){
        String sql = "UPDATE CURSO SET NOME_CURSO = ?, CARGA_HORARIA = ? WHERE ID_CURSO = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getCargaHoraria());
            stmt.setString(3, c.getId());
            stmt.executeUpdate();
            
            System.out.println("Curso atualizado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o aluno: " + e.getMessage());
        }
    }
}
