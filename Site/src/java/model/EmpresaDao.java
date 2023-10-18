/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Thomas
 */
public class EmpresaDao {
    private EntityManagerFactory factory;
    private EntityManager manager;
    
    private void conectar() {
        factory = Persistence.createEntityManagerFactory("SitePU");
        manager = factory.createEntityManager();
    }
    
    public Usuario validarLogin(String u, String s) { //O método é publico pois vou ter que chamá-lo lá na classe Controller
        try {
            conectar(); //Antes de tudo temos que conectar com o banco, se não como vamos mandar para o banco de dados depos???
            TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.findByEmailSenha", Usuario.class); //Perguntar essa linha pro matulis 
            /**Parametros da createNamedQuery (Name da Named query, classe onde ela esta)**/
            query.setParameter("emailFun", u);
            query.setParameter("senhaFun", s);
            return query.getSingleResult();
        } catch(NoResultException x) {
            return null;
        }
    }
}
