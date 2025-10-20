/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Conexao;
import model.Materia;

/**
 *
 * @author gustavo
 */
public class MateriaDAO implements InterfaceDAO<Materia>{
        @Override
    public void inserir(Materia a){
        String sql = "INSERT INTO MATERIA (ID_MATERIA, NOME_MATERIA, ID_CURSO) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {    
        
            stmt.setString(1, a.getId());
            stmt.setString(2, a.getNome());
            stmt.setString(3, a.getIdcurso().getId());
            stmt.executeUpdate();
            
            System.out.println("Materia adicionado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao inserir a materia: " + e.getMessage());
        }
    }
    
    @Override
    public void deletar(Materia a){
        String sql = "DELETE FROM MATERIA WHERE ID_MATERIA = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, a.getId());
            stmt.executeUpdate();
            
            System.out.println("Materia deletada com sucesso");            
        } catch (Exception e) {
            System.out.println("Erro ao deletar a materia: " + e.getMessage());
        }
    }
    
    @Override
    public void atualizar(Materia a){
        String sql = "UPDATE MATERIA SET NOME_MATERIA = ?, ID_CURSO = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getIdcurso().getId());
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a materia: " + e.getMessage());
        }
    }
}
