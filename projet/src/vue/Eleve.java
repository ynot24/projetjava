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
import modele.Etudiant;
import modele.EtudiantDAO;
import org.jfree.ui.RefineryUtilities;

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
        
        EtudiantDAO daoSt = new EtudiantDAO();
        Etudiant st;
        st = daoSt.find(id_eleve);
        int idGroupe = st.getId_groupe();
        
        //Déclaration des variables
        int i = 0;
        String[][] eleve = new String [100][7];
        int[] ids = new int[100];
        String colonnes[] = {"Nom du cours", "Salle", "Site", "Enseignant", "Date", "Heure de debut", "Etat"};
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult;
            String query1 = "SELECT * FROM seance_groupes WHERE id_groupe=" + idGroupe + "";
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
                    String query2 = "SELECT cours.nom, salle.nom, site.nom, utilisateur.nom, seance.date, seance.heure_debut, seance.etat "
                                + "FROM seance INNER JOIN cours ON seance.id_cours=cours.id "
                                + "INNER JOIN seance_salles ON seance_salles.id_seance=seance.id "
                                + "INNER JOIN salle ON seance_salles.id_salle=salle.id "
                                + "INNER JOIN site ON salle.id_site = site.id "
                                + "INNER JOIN seance_enseignants ON seance_enseignants.id_seance=seance.id "
                                + "INNER JOIN utilisateur ON seance_enseignants.id_enseignant=utilisateur.id "
                                + "WHERE seance.id=" + ids[j];
                    dbResultBis = dbStatement.executeQuery(query2);
                    dbResultBis.next();
                    eleve[j][0] = dbResultBis.getString("cours.nom");
                    eleve[j][1] = dbResultBis.getString("salle.nom");
                    eleve[j][2] = dbResultBis.getString("site.nom");
                    eleve[j][3] = dbResultBis.getString("utilisateur.nom");
                    eleve[j][4] = dbResultBis.getString("seance.date");
                    eleve[j][5] = dbResultBis.getString("seance.heure_debut");
                    eleve[j][6] = dbResultBis.getString("seance.etat");
                }
            }   
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
        //Création du tableau
        table = new JTable (eleve,colonnes);
        sp = new JScrollPane(table);
        sp.setBounds(100,50,700,300);
        panel.add(sp);
        
        frame.setSize(1080,720);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        
        Statistique demo = new Statistique(" ");  
        demo.setSize(560,367);    
        RefineryUtilities.centerFrameOnScreen(demo);    
        demo.setVisible(true);
    }
}
