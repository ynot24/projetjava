/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * 
 * Classe qui définit les attributs de la table seance_salles
 * 
 * @author Tony
 * 
 */

public class SeanceSalles {
    
    //DDV
    protected int id_seance;
    protected int id_salle;
    
    //Constructeur par défaut
    public SeanceSalles (){};
    
    //Constructeur à paramètres
    public SeanceSalles (int id_seance_c, int id_salle_c){
        this.id_seance = id_seance_c;
        this.id_salle = id_salle_c;
    }
    
    //Accesseurs et mutateurs

    public int getId_seance() {
        return id_seance;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }
    
}
