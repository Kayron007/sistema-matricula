/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
   
    private static final String url = "jdbc:mysql://localhost:3306/SISTEMA_MATRICULA";
    private static final String user = "root";
    private static final String senha = "26841379"; 
    
    public static Connection conectar(){
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, senha); 
            System.out.println("Conexao bem sucedida");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do BD n localizado");
        } catch (SQLException e) {
            System.out.println("ocorreu um erro ao acessar o banco: " + e.getMessage());
        }
        return conexao;
    }

}
