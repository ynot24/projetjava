/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * 
 * Classe qui définit les attributs de la table groupe
 * 
 * @author Tony
 * 
 */

public class Groupe {
    
    //DDV
    protected int id;
    protected String nom;
    protected int id_promo;
    
    //Constructeur par défaut
    public Groupe (){};
    
    //Constructeur à paramètres
    public Groupe (int id_cours, String nom_cours, int id_promo_c){
        this.id = id_cours;
        this.nom = nom_cours;
        this.id_promo = id_promo_c;
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

    public int getId_promo() {
        return id_promo;
    }

    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }
}
