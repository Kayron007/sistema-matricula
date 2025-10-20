/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.model.DAO;


public interface InterfaceDAO <T> {
    public void inserir(T obj);
    
    public void deletar(T obj);
    
    public void atualizar(T obj);
}
