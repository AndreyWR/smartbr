
package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


/**
 *
 * @author andrey
 */
public class DAO {
    
    public void inserirContato(Contato contato){

        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction tx = null; 
        
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(contato);
            tx.commit();
        }catch(Exception e){            
            System.err.println(e);
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            
        }finally{
            em.close();
        }
    }
    
    /** CRUD READ **/
    public ArrayList<Contato> listarContatos(){
        //Criando um objeto para acessar a classe Contato (JavaBean)

        EntityManager em = new ConnectionFactory().getConnection();
        
        List<Contato> contato = null;
        ArrayList<Contato> contatos = null;
        
        try{
            contato = em.createQuery("from Contato c").getResultList();
            contatos = new ArrayList<Contato>(contato);
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return contatos;
        
    }
    
    /** CRUD UPDATE **/
    //Selecionar o contato
    public void selecionarContato(Contato contato){
        
        EntityManager em = new ConnectionFactory().getConnection();
        Contato cont = null;
        
        try{
            cont = em.find(Contato.class, contato.getIdcon());
            contato.setIdcon(cont.getIdcon());
            contato.setNome(cont.getNome());
            contato.setEmail(cont.getEmail());
            contato.setFone(cont.getFone());
            contato.setMensagem(cont.getMensagem());
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
    }
    
    // editar o contato
    public void alterarContato(Contato contato){
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        try{
            em.getTransaction().begin();
            em.merge(contato);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            System.err.println(e);
        }finally{
            em.close();
        }
    }
    
    /** CRUD DELETE **/
    public void deletarContato(Contato contato){
        
        EntityManager em = new ConnectionFactory().getConnection();
        Contato cont = null;
        
        try{
            cont = em.find(Contato.class, contato.getIdcon());
            
            em.getTransaction().begin();
            em.remove(cont);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            System.err.println(e);
        }finally{
            em.close();
        }
    }
    
}
