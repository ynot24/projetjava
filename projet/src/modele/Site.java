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
public class Site {
    
    //DDV
    protected int id;
    protected String nom;
    
    //Constructeur par défaut
    public Site (){};
    
    //Constructeur à paramètres
    public Site (int id_site, String nom_site){
        this.id = id_site;
        this.nom = nom_site;
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
