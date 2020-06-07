/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Tony
 */
public class Cours {
    
    //DDV
    protected int id;
    protected String nom;
    
    //Constructeur par défaut
    public Cours (){};
    
    //Constructeur à paramètres
    public Cours (int id_cours, String nom_cours){
        this.id = id_cours;
        this.nom = nom_cours;
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
