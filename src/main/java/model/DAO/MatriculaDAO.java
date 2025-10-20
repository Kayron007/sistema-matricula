/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Conexao;
import model.Matricula;

/**
 *
 * @author gustavo
 */
public class MatriculaDAO implements InterfaceDAO<Matricula>{
    
    @Override
    public void inserir(Matricula a){
        String sql = "INSERT INTO MATRICULA (ID, ID_ALUNO, ID_TURMA, STATUS, DATA_MATRICULA) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {    
        
            stmt.setString(1, a.getId());
            stmt.setString(2, a.getIdAluno().getId());
            stmt.setString(3, a.getIdturma().getId());
            stmt.setBoolean(4, a.isStatus());
            stmt.setDate(5,java.sql.Date.valueOf(a.getData()));
            stmt.executeUpdate();
            
            System.out.println("Matricula adicionada com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao inserir o aluno: " + e.getMessage());
        }
    }
    
    @Override
    public void deletar(Matricula a){
        String sql = "DELETE FROM MATRICULA WHERE ID = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, a.getId());
            stmt.executeUpdate();
            
            System.out.println("Matricula excluida com sucesso");
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar o MATRICULA: " + e.getMessage());
        }
    }
    
    @Override
    public void atualizar(Matricula a){
        String sql = "UPDATE MATRICULA SET ID_ALUNO = ?, ID_TURMA = ?, STATUS = ? WHERE ID = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, a.getIdAluno().getId());
            stmt.setString(2, a.getIdturma().getId());
            stmt.setBoolean(3 , a.isStatus());
            stmt.setString(4, a.getId());
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o aluno: " + e.getMessage());
        }
    }
}
