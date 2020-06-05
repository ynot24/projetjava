/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tony
 */
public class SeanceSallesDAO implements DAO<SeanceSalles>{
    
    @Override
    public SeanceSalles find(int idConnection) {
        
        //Déclaration des objets
        SeanceSalles ss = new SeanceSalles();
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "select * from seance_salles where id_seance=" + idConnection; //Variable de type String qui stockera la requête sql
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult = dbStatement.executeQuery(query);
            if(dbResult.next()){
                ss.id_seance = dbResult.getInt("id_seance");
                ss.id_salle = dbResult.getInt("id_salle");
            }
            else{
                System.out.println("Pas de résultat");
            }
            dbStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
        
        return ss;
    }

    @Override
    public void create(SeanceSalles ssCreate) {
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "insert into seance_salles values (?,?)"; //Variable de type String qui stockera la requête sql
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            PreparedStatement dbPreparedStatement = dbConnect.prepareStatement(query);
            dbPreparedStatement.setInt(1, ssCreate.id_seance);
            dbPreparedStatement.setInt(2, ssCreate.id_salle);
            dbPreparedStatement.executeUpdate();
            dbPreparedStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
    }

    @Override
    public void delete(SeanceSalles ssDelete) {
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "delete from seance_salles where id_seance=" + ssDelete.id_seance; //Variable de type String qui stockera la requête sql
        
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
    public void update(SeanceSalles ssUpdate) {
        
        SeanceSalles ssOriginal;
        ssOriginal = find(ssUpdate.id_seance);
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        
        if(ssUpdate.id_salle != ssOriginal.id_salle){
            String query = "update seance_salles set id_salle=" + ssUpdate.id_salle + "where id_seance=" + ssUpdate.id_seance;
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
