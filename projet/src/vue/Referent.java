/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * 
 * Classe qui définit une page dédiée au référent pédagogique 
 * où il ne peut que consulter les recapitulatifs des enseignants
 * et/ou des élèves
 * 
 * @author Tony
 * 
 */

public class Referent {
    
    private static JButton recapEnseignant, recapEtudiant;
    private static JFrame frame;
    private static JPanel panel;
    private static JTable table;
    private static JScrollPane sp;
    private static JLabel labelRecapEnseignant, labelRecapEtudiant;
    private static JTextField textfieldIDEnseignant, textfieldIDEtudiant;
    
    public Referent(){
        
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
         * Tableau des utilisateurs
         */
        
        String[][] user = new String [100][5];
        String colonnes[] = {"ID", "Email", "Nom", "Prénom", "Droit"};
        int i = 0;
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "select * from utilisateur where droit=3 or droit=4 ";
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);    
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult = dbStatement.executeQuery(query);
            while(dbResult.next()){
                user[i][0] = String.valueOf(dbResult.getInt("id"));
                user[i][1] = dbResult.getString("email");
                user[i][2] = dbResult.getString("nom");
                user[i][3] = dbResult.getString("prenom");
                user[i][4] = String.valueOf(dbResult.getInt("droit"));
                i++;
            }
            dbStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
        
        //Création du tableau
        table = new JTable (user,colonnes);
        sp = new JScrollPane(table);
        sp.setBounds(100,50,550,300);
        panel.add(sp);
        
        frame.setSize(1080,720);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creation des bouttons
        //Creation des titres
        
        labelRecapEnseignant = new JLabel("Consulter le récapitulatif des cours d'un enseignant");
        labelRecapEnseignant.setBounds(700,50,300,40);
        panel.add(labelRecapEnseignant);
        
        textfieldIDEnseignant = new JTextField("Veuillez rentrer l'id de l'enseignant", 150);
        textfieldIDEnseignant.setBounds(700,80,230,25);
        panel.add(textfieldIDEnseignant);
        
        recapEnseignant = new JButton("Visualiser");
        recapEnseignant.setBounds(700,110,100,25);
        recapEnseignant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recoverText = textfieldIDEnseignant.getText();
                if(recoverText!=""){
                    Professeur pr = new Professeur(Integer.parseInt(recoverText));
                }
                else {
                    JFrame reussi = new JFrame();
                    JLabel labelR = new JLabel("Recommencez la saisie !!!");
                    reussi.add(labelR);
                    reussi.setTitle("Erreur");
                    reussi.setSize(300,200);
                    reussi.setLocationRelativeTo(null);
                    reussi.setResizable(false);
                    reussi.setVisible(true);
                }
            }
        });
        panel.add(recapEnseignant);
        
        labelRecapEtudiant = new JLabel("Consulter le récapitulatif des cours d'un étudiant");
        labelRecapEtudiant.setBounds(700,200,300,40);
        panel.add(labelRecapEtudiant);
        
        textfieldIDEtudiant = new JTextField("Veuillez rentrer l'id de l'étudiant", 150);
        textfieldIDEtudiant.setBounds(700,230,230,25);
        panel.add(textfieldIDEtudiant);
        
        recapEtudiant = new JButton("Visualiser");
        recapEtudiant.setBounds(700,260,100,25);
        recapEtudiant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recoverText = textfieldIDEtudiant.getText();
                if(recoverText!=""){
                    Professeur pr = new Professeur(Integer.parseInt(recoverText));
                }
                else {
                    JFrame reussi = new JFrame();
                    JLabel labelR = new JLabel("Recommencez la saisie !!!");
                    reussi.add(labelR);
                    reussi.setTitle("Erreur");
                    reussi.setSize(300,200);
                    reussi.setLocationRelativeTo(null);
                    reussi.setResizable(false);
                    reussi.setVisible(true);
                }
            }
        });
        panel.add(recapEtudiant);
        
        frame.setVisible(true);
    }
    
}
