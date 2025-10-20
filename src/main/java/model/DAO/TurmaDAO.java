/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Conexao;
import model.Turma;

/**
 *
 * @author gustavo
 */
public class TurmaDAO implements InterfaceDAO<Turma>{
    
    @Override
    public void inserir(Turma a){
        String sql = "INSERT INTO TURMA (ID_TURMA, ANO, SEMESTRE, ID_CURSO) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {    
        
            stmt.setString(1, a.getId());
            stmt.setInt(2, a.getAno());
            stmt.setInt(3, a.getSemestre());
            stmt.setString(4, a.getIdcurso().getId());
            stmt.executeUpdate();
            
            System.out.println("Turma adicionado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao inserir o aluno: " + e.getMessage());
        }
    }
    
    @Override
    public void deletar(Turma a){
        String sql = "DELETE FROM TURMA WHERE ID_TURMA = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, a.getId());
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar o turma: " + e.getMessage());
        }
    }
    
    @Override
    public void atualizar(Turma a){
        String sql = "UPDATE TURMA SET ANO = ?, SEMESTRE = ?, ID_CURSO = ? WHERE ID_TURMA = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setInt(1, a.getAno());
            stmt.setInt(2, a.getSemestre());
            stmt.setString(3, a.getIdcurso().getId());
            stmt.setString(4, a.getId());
            
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o turma: " + e.getMessage());
        }
    }
}
