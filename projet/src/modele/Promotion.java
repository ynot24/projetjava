/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * 
 * Classe qui définit les attributs de la table promotion
 * 
 * @author Tony
 * 
 */

public class Promotion {
    
    //DDV
    protected int id;
    protected String nom;
    
    //Constructeur par défaut
    public Promotion (){};
    
    //Constructeur à paramètres
    public Promotion (int id_promo, String nom_promo){
        this.id = id_promo;
        this.nom = nom_promo;
    }
    
    //Accesseurs et mutateurs

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
