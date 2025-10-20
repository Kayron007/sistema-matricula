/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Materia;
import main.java.model.Conexao;
import main.java.model.Curso;
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
        String sql = "UPDATE MATERIA SET NOME_MATERIA = ?, ID_CURSO = ? WHERE ID_MATERIA = ?";
        
        try (Connection con = Conexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getIdcurso().getId());
            stmt.setString(3, a.getId());
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a materia: " + e.getMessage());
        }
    }

    public List<Materia> listar() {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM MATERIA";
        try (Connection conn = Conexao.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Materia m = new Materia();
                m.setId(String.valueOf(rs.getInt("ID_MATERIA")));
                m.setNome(rs.getString("NOME_MATERIA"));

                Curso c = new Curso();
                c.setId(String.valueOf(rs.getInt("ID_CURSO")));
                m.setIdcurso(c);
                materias.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar matérias: " + e.getMessage());
        }
        return materias;
    }

    public Materia buscarPorId(String id) {
        String sql = "SELECT * FROM MATERIA WHERE ID_MATERIA=?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Materia m = new Materia();
                m.setId(id);
                m.setNome(rs.getString("NOME_MATERIA"));

                Curso c = new Curso();
                c.setId(String.valueOf(rs.getInt("ID_CURSO")));
                m.setIdcurso(c);

                return m;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar matéria: " + e.getMessage());
        }
        return null;
    }
}
