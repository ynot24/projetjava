/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tony
 */
public class EnseignantDAO implements DAO<Enseignant>{
    
    @Override
    public Enseignant find(int idConnection) {
        
        //Déclaration des objets
        Enseignant st = new Enseignant();
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "select * from enseignant where id_user=" + idConnection; //Variable de type String qui stockera la requête sql
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult = dbStatement.executeQuery(query);
            if(dbResult.next()){
                st.setId_user(dbResult.getInt("id_user"));
                st.setId_cours(dbResult.getInt("id_groupe"));
            }
            else{
                System.out.println("Pas de résultat");
            }
            dbStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
        
        return st;
    }

    @Override
    public void create(Enseignant tCreate) {
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "insert into enseignant values (?," + tCreate.getId_cours() + ")"; //Variable de type String qui stockera la requête sql
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            dbStatement.executeUpdate(query);
            dbStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
    }

    @Override
    public void delete(Enseignant tDelete) {
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "delete from enseignant where id_user=" + tDelete.getId_user(); //Variable de type String qui stockera la requête sql
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            dbStatement.executeUpdate(query);
            dbStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
    }

    @Override
    public void update(Enseignant tUpdate) {
        
        Enseignant tOriginal;
        tOriginal = find(tUpdate.getId_user());
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        
        if(tUpdate.id_cours != tOriginal.id_cours){
            String query = "update enseignant set id_cours=" + tUpdate.getId_cours() + " where id_user=" + tUpdate.getId_user();
            try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            dbStatement.executeUpdate(query);
            dbStatement.close();
            dbConnect.close();
            } catch (Exception e) {
                System.out.println("ECHEC CONNEXION A LA BDD");
            }
        }
        else{
            System.out.println("Il n'y a pas de mise à jour");
        }
    }
    
}
