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
public class Seance {
    
    //DDV
    protected int id;
    protected int semaine;
    protected String date;
    protected String heure_debut;
    protected String heure_fin;
    protected String etat;
    protected int id_cours;
    protected int id_type;
    
    //Constructeur par défaut
    public Seance (){};
    
    //Constructeur à paramètres
    public Seance (int id_seance,
            int semaine_seance,
            String date_seance, 
            String heure_debut_seance, 
            String heure_fin_seance, 
            String etat_seance,
            int id_cours_seance,
            int id_type_seance){
        this.id = id_seance;
        this.semaine = semaine_seance;
        this.date = date_seance;
        this.heure_debut = heure_debut_seance;
        this.heure_fin = heure_fin_seance;
        this.etat = etat_seance;
        this.id_cours = id_cours_seance;
        this.id_type = id_type_seance;
    }
   
    //Accesseurs et mutateurs

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemaine() {
        return semaine;
    }

    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(String heure_debut) {
        this.heure_debut = heure_debut;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getId_cours() {
        return id_cours;
    }

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }
}
