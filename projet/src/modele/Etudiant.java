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
public class Etudiant {
    
    //DDV
    protected int id_user;
    protected int numero;
    protected int id_groupe;
    
    //Constructeur par défaut
    public Etudiant (){};
    
    //Constructeur à paramètres
    public Etudiant (int id_user_c, int numero_c, int id_groupe_c){
        this.id_user = id_user_c;
        this.numero = numero_c;
        this.id_groupe = id_groupe_c;
    }
    
    //Accesseurs et mutateurs

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(int id_groupe) {
        this.id_groupe = id_groupe;
    }
    
}
