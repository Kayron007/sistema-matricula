/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import main.java.model.CursoMateria;
import main.java.model.Conexao;

/**
 *
 * @author gustavo
 */
public class CursoMateriaDAO implements InterfaceDAO<CursoMateria>{
    
    @Override
    public void inserir(CursoMateria a){
        String sql = "INSERT INTO CURSOMATERIA (ID_CURSOMATERIA, ID_CURSO, ID_MATERIA) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {    
        
            stmt.setString(1, a.getId());
            stmt.setString(2, a.getCursoId().getId());
            stmt.setString(3, a.getMateriaId().getId());
            stmt.executeUpdate();
            
            System.out.println("CursoMateria adicionado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao inserir o CursoMateria: " + e.getMessage());
        }
    }
    
    @Override
    public void deletar(CursoMateria a){
        String sql = "DELETE FROM CONSULTA WHERE NOME = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
           // stmt.setString(1, a.getNome());
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar o aluno: " + e.getMessage());
        }
    }
    
    @Override
    public void atualizar(CursoMateria a){
        String sql = "UPDATE CONSULTA SET NOME = ?, IDADE = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            //stmt.setString(1, a.getNome());
            //stmt.setInt(2, a.getIdade());
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o aluno: " + e.getMessage());
        }
    }
}
