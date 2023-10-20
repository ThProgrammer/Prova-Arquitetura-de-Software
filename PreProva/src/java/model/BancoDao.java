package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/**
 *
 * @author Thomas
 */
public class BancoDao {
    private EntityManagerFactory factory;
    private EntityManager manager;
    
    
    private void conectar() {
        factory = Persistence.createEntityManagerFactory("PreProvaPU");
        manager = factory.createEntityManager();
    }
    
    public <T> int cadastrar(T obj){
        conectar();
        try{
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
            return 1;
        }   catch (RollbackException erro){
            return 2;
        }   catch(Exception erro){
            return 0;
        }
    }
    
    public <T>List listar(String queryNomeada, Class<T> classe){
        conectar();
        try{
            return manager.createNamedQuery(queryNomeada, classe).getResultList();
        } catch(NoResultException erro){
            return null;
        }
    }
}
