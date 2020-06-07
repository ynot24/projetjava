/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * 
 * Classe qui définit les attributs de la table seance_groupes
 * 
 * @author Tony
 * 
 */

public class SeanceGroupes {
    
    //DDV
    protected int id_seance;
    protected int id_groupe;
    
    //Constructeur par défaut
    public SeanceGroupes (){};
    
    //Constructeur à paramètres
    public SeanceGroupes (int id_seance_c, int id_groupe_c){
        this.id_seance = id_seance_c;
        this.id_groupe = id_groupe_c;
    }
    
    //Accesseurs et mutateurs
    
    public int getId_seance() {
        return id_seance;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public int getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(int id_groupe) {
        this.id_groupe = id_groupe;
    }
    
}
