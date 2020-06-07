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
 * Classe qui implémente l'interface DAO de type Salle
 * 
 * @author Tony
 * 
 */

public class SalleDAO implements DAO<Salle>{
    
    @Override
    public Salle find(int idConnection) {
        
        //Déclaration des objets
        Salle cr = new Salle();
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "select * from salle where id=" + idConnection; //Variable de type String qui stockera la requête sql
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult = dbStatement.executeQuery(query);
            if(dbResult.next()){
                cr.setId(dbResult.getInt("id"));
                cr.setNom(dbResult.getString("nom"));
                cr.setCapacite(dbResult.getInt("capacite"));
                cr.setId_site(dbResult.getInt("id_site"));
            }
            else{
                System.out.println("Pas de résultat");
            }
            dbStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
        
        return cr;
    }
    
    @Override
    public void create(Salle crCreate) {
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "insert into salle values (?,?,?,?)"; //Variable de type String qui stockera la requête sql
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            PreparedStatement dbPreparedStatement = dbConnect.prepareStatement(query);
            dbPreparedStatement.setInt(1, crCreate.getId());
            dbPreparedStatement.setString(2, crCreate.getNom());
            dbPreparedStatement.setInt(3, crCreate.getCapacite());
            dbPreparedStatement.setInt(4, crCreate.getId_site());
            dbPreparedStatement.executeUpdate();
            dbPreparedStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
    }

    @Override
    public void delete(Salle crDelete) {
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "delete from salle where id=" + crDelete.getId(); //Variable de type String qui stockera la requête sql
        
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
    public void update(Salle crUpdate) {
        
        Salle crOriginal;
        crOriginal = find(crUpdate.getId());
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        
        if(crUpdate.getNom() != crOriginal.getNom()){
            String query = "update salle set nom='" + crUpdate.getNom() + "' where id=" + crUpdate.getId();
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
        if(crUpdate.getCapacite() != crOriginal.getCapacite()){
            String query = "update salle set capacite=" + crUpdate.getCapacite() + " where id=" + crUpdate.getId();
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
        if(crUpdate.getId_site() != crOriginal.getId_site()){
            String query = "update salle set id_site=" + crUpdate.getId_site() + " where id=" + crUpdate.getId();
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
