/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Conexao;
import main.java.model.Curso;
import main.java.model.Turma;

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

    public List<Turma> listar() {
        List<Turma> turmas = new ArrayList<>();
        String sql = "SELECT * FROM TURMA";
        try (Connection conn = Conexao.conectar();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Turma t = new Turma();
                t.setId(String.valueOf(rs.getInt("ID_TURMA")));
                t.setAno(rs.getInt("ANO"));
                t.setSemestre(rs.getInt("SEMESTRE"));
                
                Curso c = new Curso();
                c.setId(String.valueOf(rs.getInt("ID_CURSO")));
                t.setIdcurso(c);
                turmas.add(t);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar turmas: " + e.getMessage());
        }
        return turmas;
    }

    public Turma buscarPorId(String id) {
        String sql = "SELECT * FROM TURMA WHERE ID_TURMA=?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Turma t = new Turma();
                t.setId(id);
                t.setAno(rs.getInt("ANO"));
                t.setSemestre(rs.getInt("SEMESTRE"));

                Curso c = new Curso();
                c.setId(String.valueOf(rs.getInt("ID_CURSO")));
                t.setIdcurso(c);
                return t;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar turma: " + e.getMessage());
        }
        return null;
    }
}
