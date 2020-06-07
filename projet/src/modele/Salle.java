/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * 
 * Classe qui définit les attributs de la table salle
 * 
 * @author Tony
 * 
 */

public class Salle {
    
    //DDV
    protected int id;
    protected String nom;
    protected int capacite;
    protected int id_site;
    
    //Constructeur par défaut
    public Salle (){};
    
    //Constructeur à paramètres
    public Salle (int id_c, String nom_c, int capacite_c, int id_site_c){
        this.id = id_c;
        this.nom = nom_c;
        this.capacite = capacite_c;
        this.id_site = id_site_c;
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

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getId_site() {
        return id_site;
    }

    public void setId_site(int id_site) {
        this.id_site = id_site;
    }
    
}
