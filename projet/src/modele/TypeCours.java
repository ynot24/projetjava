/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * 
 * Classe qui définit les attributs de la table type_cours
 * 
 * @author Tony
 * 
 */

public class TypeCours {
    
    //DDV
    protected int id;
    protected String nom;
    
    //Constructeur par défaut
    public TypeCours (){};
    
    //Constructeur à paramètres
    public TypeCours (int id_type, String nom_type){
        this.id = id_type;
        this.nom = nom_type;
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
