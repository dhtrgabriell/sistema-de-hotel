/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.DAO;

import java.util.List;

/**
 *
 * @author aluno
 */
public interface InterfaceDAO<T> {
   
    public abstract void Create(T objeto);
    
    public abstract T Retrieve(int id);
    public abstract List<T> Retrieve(String atributo, String valor);
    
    public abstract void Update(T objeto);
    public abstract void Delete(T objeto);
    
}
