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
import modele.Enseignant;
import modele.EnseignantDAO;
import org.jfree.ui.RefineryUtilities;

/**
 * 
 * Classe qui définit une page dédiée à l'enseignant 
 * où il peut suivre le récapitulatif des cours
 * 
 * @author Tony
 * 
 */

public class Professeur {
    
    private static JFrame frame;
    private static JPanel panel;
    private static JTable table;
    private static JScrollPane sp;
    
    public Professeur (int id_prof){
        
        
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
        
        EnseignantDAO daoTe = new EnseignantDAO();
        Enseignant te;
        te = daoTe.find(id_prof);
        int idTeacher = te.getId_user();
        
        //Déclaration des variables
        int i = 0;
        String[][] prof = new String [100][6];
        int[] ids = new int[100];
        String colonnes[] = {"Nom du cours", "Salle", "Site", "Date", "Heure de debut", "Etat"};
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult;
            String query1 = "SELECT * FROM seance_enseignants WHERE id_enseignant=" + idTeacher + "";
            dbResult = dbStatement.executeQuery(query1);
            while (dbResult.next()){
                ids[i] = dbResult.getInt("id_seance");
                i++;
            }
            dbStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResultBis;
            for (int j = 0; j < ids.length; j++) {
                if(ids[j]!=0){
                    String query2 = "SELECT cours.nom, salle.nom, site.nom, seance.date, seance.heure_debut, seance.etat "
                            + "FROM seance_enseignants "
                            + "INNER JOIN seance ON seance.id=seance_enseignants.id_seance "
                            + "INNER JOIN cours ON cours.id=seance.id_cours "
                            + "INNER JOIN seance_salles ON seance_salles.id_seance=seance.id "
                            + "INNER JOIN salle ON seance_salles.id_salle=salle.id "
                            + "INNER JOIN site ON salle.id_site = site.id "
                            + "WHERE seance_enseignants.id_seance =" + ids[j];
                    dbResultBis = dbStatement.executeQuery(query2);
                    dbResultBis.next();
                    prof[j][0] = dbResultBis.getString("cours.nom");
                    prof[j][1] = dbResultBis.getString("salle.nom");
                    prof[j][2] = dbResultBis.getString("site.nom");
                    prof[j][3] = dbResultBis.getString("seance.date");
                    prof[j][4] = dbResultBis.getString("seance.heure_debut");
                    prof[j][5] = dbResultBis.getString("seance.etat");
                }
            }   
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
        //Création du tableau
        table = new JTable (prof,colonnes);
        sp = new JScrollPane(table);
        sp.setBounds(100,50,700,300);
        panel.add(sp);
        
        frame.setSize(1080,720);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        
        Statistique demo = new Statistique("");  
        demo.setSize(560,367);    
        RefineryUtilities.centerFrameOnScreen(demo);    
        demo.setVisible(true);
    }
}
