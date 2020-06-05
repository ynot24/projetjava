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
public class SiteDAO implements DAO<Site>{
    
    @Override
    public Site find(int idConnection) {
        
        //Déclaration des objets
        Site s = new Site();
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "select * from site where id=" + idConnection; //Variable de type String qui stockera la requête sql
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult = dbStatement.executeQuery(query);
            if(dbResult.next()){
                s.id = dbResult.getInt("id");
                s.nom = dbResult.getString("nom");
            }
            else{
                System.out.println("Pas de résultat");
            }
            dbStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
        
        return s;
    }

    @Override
    public void create(Site siteCreate) {
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "insert into site values (?," + siteCreate.nom + ")"; //Variable de type String qui stockera la requête sql
        
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
    public void delete(Site siteDelete) {
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "delete from site where id=" + siteDelete.id; //Variable de type String qui stockera la requête sql
        
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
    public void update(Site siteUpdate) {
        
        Site siteOriginal;
        siteOriginal = find(siteUpdate.id);
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        
        if(siteUpdate.nom != siteOriginal.nom){
            String query = "update site set email=" + siteUpdate.nom + "where id=" + siteUpdate.id;
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
