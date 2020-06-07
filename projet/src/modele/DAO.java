/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Interface qui respecte le pattern DAO
 * 
 * @author Tony
 * @param <T>
 */
public interface DAO<T> {
    
    /**
    * Méthode de recherche des informations
    * @param id
    * @return T
    */
    public T find(int id);
    
    /**
    * Méthode de création
    * @param t
    */
    public void create(T t);

    /**
    * Méthode pour effacer
    * @param t
    */
    public void delete(T t);

    /**
    * Méthode de mise à jour
    * @param t
    */
    public void update(T t);
    
}
