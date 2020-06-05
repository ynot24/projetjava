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
public class UtilisateurDAO implements DAO<Utilisateur>{ 
    
    @Override
    public Utilisateur find(int idConnection) {
        
        //Déclaration des objets
        Utilisateur u = new Utilisateur();
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "select * from utilisateur where id=" + idConnection; //Variable de type String qui stockera la requête sql
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult = dbStatement.executeQuery(query);
            if(dbResult.next()){
                u.id = dbResult.getInt("id");
                u.email = dbResult.getString("email");
                u.password = dbResult.getString("password");
                u.nom = dbResult.getString("nom");
                u.prenom = dbResult.getString("prenom");
                u.droit = dbResult.getInt("droit");
            }
            else{
                System.out.println("Pas de résultat");
            }
            dbStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
        
        return u;
    }
    
    @Override
    public void create(Utilisateur userCreate) {
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "insert into utilisateur values (?,?,?,?,?,?)"; //Variable de type String qui stockera la requête sql
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            PreparedStatement dbPreparedStatement = dbConnect.prepareStatement(query);
            dbPreparedStatement.setString(2, userCreate.email);
            dbPreparedStatement.setString(3, userCreate.password);
            dbPreparedStatement.setString(4, userCreate.nom);
            dbPreparedStatement.setString(5, userCreate.prenom);
            dbPreparedStatement.setInt(6, userCreate.droit);
            dbPreparedStatement.executeUpdate();
            dbPreparedStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
    }

    @Override
    public void delete(Utilisateur userDelete) {
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "delete from utilisateur where id=" + userDelete.id; //Variable de type String qui stockera la requête sql
        
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
    public void update(Utilisateur userUpdate) {
        
        Utilisateur userOriginal;
        userOriginal = find(userUpdate.id);
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        
        if(userUpdate.email != userOriginal.email){
            String query = "update utilisateur set email=" + userUpdate.email + "where id=" + userUpdate.id;
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
        else if(userUpdate.password != userOriginal.password){
            String query = "update utilisateur set password=" + userUpdate.password + "where id=" + userUpdate.id;
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
        else if(userUpdate.nom != userOriginal.nom){
            String query = "update utilisateur set nom=" + userUpdate.nom + "where id=" + userUpdate.id;
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
        else if(userUpdate.prenom != userOriginal.prenom){
            String query = "update utilisateur set prenom=" + userUpdate.prenom + "where id=" + userUpdate.id;
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
        else if(userUpdate.droit != userOriginal.droit){
            String query = "update utilisateur set droit=" + userUpdate.droit + "where id=" + userUpdate.id;
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
