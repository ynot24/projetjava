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
public class SeanceEnseignants {
    
    //DDV
    protected int id_seance;
    protected int id_enseignant;
    
    //Constructeur par défaut
    public SeanceEnseignants (){};
    
    //Constructeur à paramètres
    public SeanceEnseignants (int id_seance_c, int id_enseignant_c){
        this.id_seance = id_seance_c;
        this.id_enseignant = id_enseignant_c;
    }
    
    //Accesseurs et mutateurs

    public int getId_seance() {
        return id_seance;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }
    
}
