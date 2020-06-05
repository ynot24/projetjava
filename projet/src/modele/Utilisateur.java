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
public class Utilisateur {
    
    //DDV
    protected int id;
    protected String email;
    protected String password;
    protected String nom;
    protected String prenom;
    protected int droit;
    
    //Constructeur par défaut
    public Utilisateur (){};
    
    //Constructeur à paramètres
    public Utilisateur (int id_user, 
            String email_user, 
            String password_user, 
            String nom_user, 
            String prenom_user, 
            int droit_user){
        this.id = id_user;
        this.email = email_user;
        this.password = password_user;
        this.nom = nom_user;
        this.prenom = prenom_user;
        this.droit = droit_user;
    }
   
    //Accesseurs et mutateurs
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getDroit() {
        return droit;
    }

    public void setDroit(int droit) {
        this.droit = droit;
    }
    
}
