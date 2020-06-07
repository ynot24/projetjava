/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 
 * Classe qui définit une page ou l'élève 
 * peut regarder le récapitulatif des cours.
 * 
 * @author Tony
 * 
 */

public class Eleve {
    
    private static JFrame frame;
    private static JPanel panel;
    private static JTable table;
    private static JScrollPane sp;
    
    public Eleve (int id_eleve){
        
        /**
         * Création d'une fenêtre
         */
        
        frame = new JFrame();
        frame.setTitle("Hyperplanning");
                    
        /**
         * Création d'un panel
         */
        
        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        
        /**
         * Tableau des cours de l'élève
         */
        
        String[][] eleve = new String [100][7];
        String colonnes[] = {"Nom du cours", "Salle", "Site", "Enseignant", "Date", "Heure de debut", "Etat"};
        int i = 0;
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        
         try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);    
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult, dbResultBis;
            
            String query1 = "SELECT etudiant.id_groupe FROM etudiant INNER JOIN groupe ON etudiant.id_groupe=groupe.id WHERE etudiant.id_user=" + id_eleve;
            dbResult = dbStatement.executeQuery(query1);
            int id_groupe = dbResult.getInt("etudiant.id_groupe");
            
            String query2 = "SELECT * FROM seance_groupes INNER JOIN seance ON seance_groupes.id_seance=seance.id WHERE seance_groupes.id_groupe=" + id_groupe;
            dbResult = dbStatement.executeQuery(query1);
            while(dbResult.next()){
                //eleve[i][]
            }
         } catch (Exception e) {
            
         }
        
        
        
        String query3 = "select * from utilisateur";
        String query4 = "select * from utilisateur";
        String query5 = "select * from utilisateur";
        String query6 = "select * from utilisateur";
        String query7 = "select * from utilisateur";
        String query8 = "select * from utilisateur";
        
        
        
    }
}
