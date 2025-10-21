/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM CURSO";
        try (Connection conn = Conexao.conectar();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                Curso c = new Curso();
                c.setId(String.valueOf(rs.getInt("ID_CURSO")));
                c.setNome(rs.getString("NOME_CURSO"));
                c.setCargaHoraria(rs.getInt("CARGA_HORARIA"));
                cursos.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar cursos: " + e.getMessage());
        }
        return cursos;
    }

    public Curso buscarPorId(String id) {
        String sql = "SELECT * FROM CURSO WHERE ID_CURSO=?";
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Curso c = new Curso();
                c.setId(id);
                c.setNome(rs.getString("NOME_CURSO"));
                c.setCargaHoraria(rs.getInt("CARGA_HORARIA"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar curso: " + e.getMessage());
        }
        return null;
    }
}
