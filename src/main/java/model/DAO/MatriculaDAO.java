/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.Aluno;
import model.Conexao;
import model.Matricula;
import model.Turma;

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
            stmt.setString(3, a.getIdTurma().getId());
            stmt.setBoolean(4, a.isStatus());
            stmt.setDate(5,java.sql.Date.valueOf(a.getDataMatricula()));
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
            stmt.setString(2, a.getIdTurma().getId());
            stmt.setBoolean(3 , a.isStatus());
            stmt.setString(4, a.getId());
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o aluno: " + e.getMessage());
        }
    }

    public List<Matricula> listar() {
    List<Matricula> matriculas = new ArrayList<>();
    String sql = "SELECT * FROM MATRICULA";
    try (Connection conn = Conexao.conectar(); 
        Statement st = conn.createStatement(); 
        ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            Matricula m = new Matricula();
            m.setId(String.valueOf(rs.getInt("ID")));
            m.setStatus(rs.getBoolean("STATUS"));
            m.setDataMatricula(rs.getDate("DATA_MATRICULA").toLocalDate());

            Aluno a = new Aluno();
            a.setId(String.valueOf(rs.getInt("ID_ALUNO")));
            m.setIdAluno(a);

            Turma t = new Turma();
            t.setId(String.valueOf(rs.getInt("ID_TURMA")));
            m.setIdTurma(t);

            matriculas.add(m);
        }

        } catch (SQLException e) {
            System.out.println("Erro ao listar matrículas: " + e.getMessage());
        }
        return matriculas;
    }

    public Matricula buscarPorId(String id) {
        String sql = "SELECT * FROM MATRICULA WHERE ID=?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Matricula m = new Matricula();
                m.setId(id);
                m.setStatus(rs.getBoolean("STATUS"));
                m.setDataMatricula(rs.getDate("DATA_MATRICULA").toLocalDate());

                Aluno a = new Aluno();
                a.setId(String.valueOf(rs.getInt("ID_ALUNO")));
                m.setIdAluno(a);

                Turma t = new Turma();
                t.setId(String.valueOf(rs.getInt("ID_TURMA")));
                m.setIdTurma(t);

                return m;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar matrícula: " + e.getMessage());
        }
        return null;
    }
}
