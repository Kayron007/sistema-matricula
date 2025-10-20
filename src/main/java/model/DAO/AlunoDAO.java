/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Aluno;
import main.java.model.Conexao;


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
            stmt.setString(3, a.getTelefone());
            stmt.setString(4, a.getId());
            stmt.executeUpdate();
            
            System.out.println("Dados atualizados com sucesso");
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o aluno: " + e.getMessage());
        }
    }

    public List<Aluno> listar() {
    List<Aluno> alunos = new ArrayList<>();
    String sql = "SELECT * FROM ALUNOS";
    try (Connection conn = Conexao.conectar();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            Aluno a = new Aluno();
            a.setId(String.valueOf(rs.getInt("ID")));
            a.setNome(rs.getString("NOME"));
            a.setEmail(rs.getString("EMAIL"));
            a.setCpf(rs.getString("CPF_NUM"));
            a.setEndereco(rs.getString("ENDERECO"));
            a.setTelefone(rs.getString("TELEFONE"));
            alunos.add(a);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao listar alunos: " + e.getMessage());
    }
    return alunos;
    }

    public Aluno buscarPorId(String id) {
        String sql = "SELECT * FROM ALUNOS WHERE ID=?";
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Aluno a = new Aluno();
                a.setId(id);
                a.setNome(rs.getString("NOME"));
                a.setEmail(rs.getString("EMAIL"));
                a.setCpf(rs.getString("CPF_NUM"));
                a.setEndereco(rs.getString("ENDERECO"));
                a.setTelefone(rs.getString("TELEFONE"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
        }
        return null;
    }
}
