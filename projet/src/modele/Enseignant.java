/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * 
 * Classe qui définit les attributs de la table enseignant
 * 
 * @author Tony
 * 
 */

public class Enseignant {
    
    //DDV
    protected int id_user;
    protected int id_cours;
    
    //Constructeur par défaut
    public Enseignant (){};
    
    //Constructeur à paramètres
    public Enseignant (int id_user_c, int id_cours_c){
        this.id_user = id_user_c;
        this.id_cours = id_cours_c;
    }
    
    //Accesseurs et mutateurs

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_cours() {
        return id_cours;
    }

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }
    
}
