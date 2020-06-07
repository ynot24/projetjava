/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.HeadlessException;
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
import modele.Utilisateur;
import modele.UtilisateurDAO;

/**
 *
 * @author Tony
 */
public class Admin {
    
    private static JButton ajoutButton, supprButton, majButton;
    private static JTextField textidAM, 
                textemailAM,
                textpassAM,
                textnomAM,
                textprenomAM,
                textdroitAM,
                textidS;
    private static JLabel labelAM, 
                labelS,
                labelidAM, 
                labelemailAM,
                labelpassAM,
                labelnomAM,
                labelprenomAM,
                labeldroitAM,
                labelidS;
    private static JFrame frame;
    private static JPanel panel;
    private static JTable table;
    private static JScrollPane sp;
    
    public Admin (){
        
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
        
        String[][] user = new String [100][6];
        String colonnes[] = {"ID", "Email", "Mot de Passe", "Nom", "Prénom", "Droit"};
        int i = 0;
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "select * from utilisateur";
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);    
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult = dbStatement.executeQuery(query);
            while(dbResult.next()){
                user[i][0] = String.valueOf(dbResult.getInt("id"));
                user[i][1] = dbResult.getString("email");
                user[i][2] = dbResult.getString("password");
                user[i][3] = dbResult.getString("nom");
                user[i][4] = dbResult.getString("prenom");
                user[i][5] = String.valueOf(dbResult.getInt("droit"));
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
        sp.setBounds(100,50,500,300);
        panel.add(sp);
        
        frame.setSize(1080,720);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        /**
        * PARTIE AJOUT OU MISE A JOUR D'UN UTILISATEUR
        */
        
        labelAM = new JLabel("- AJOUTER / METTRE A JOUR UN UTILISATEUR -");
        labelAM.setBounds(700,50,300,40);
        panel.add(labelAM);
        
        labelidAM = new JLabel("ID : ");
        labelidAM.setBounds(700,80,100,25);
        panel.add(labelidAM);
        
        textidAM = new JTextField(150);
        textidAM.setBounds(800,80,180,25);
        panel.add(textidAM);
        
        labelemailAM = new JLabel("EMail : ");
        labelemailAM.setBounds(700,110,100,25);
        panel.add(labelemailAM);
        
        textemailAM = new JTextField(150);
        textemailAM.setBounds(800,110,180,25);
        panel.add(textemailAM);
        
        labelpassAM = new JLabel("Mot de Passe : ");
        labelpassAM.setBounds(700,140,100,25);
        panel.add(labelpassAM);
        
        textpassAM = new JTextField(150);
        textpassAM.setBounds(800,140,180,25);
        panel.add(textpassAM);
        
        labelnomAM = new JLabel("Nom : ");
        labelnomAM.setBounds(700,170,100,25);
        panel.add(labelnomAM);
        
        textnomAM = new JTextField(150);
        textnomAM.setBounds(800,170,180,25);
        panel.add(textnomAM);
        
        labelprenomAM = new JLabel("Prenom : ");
        labelprenomAM.setBounds(700,200,100,25);
        panel.add(labelprenomAM);
        
        textprenomAM = new JTextField(150);
        textprenomAM.setBounds(800,200,180,25);
        panel.add(textprenomAM);
        
        labeldroitAM = new JLabel("Droit : ");
        labeldroitAM.setBounds(700,230,100,25);
        panel.add(labeldroitAM);
        
        textdroitAM = new JTextField(150);
        textdroitAM.setBounds(800,230,180,25);
        panel.add(textdroitAM);
        
        ajoutButton = new JButton("Ajouter");
        ajoutButton.setBounds(700,270,100,25);
        ajoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textidAM.getText());
                    String email = textemailAM.getText();
                    String pass = textpassAM.getText();
                    String nom = textnomAM.getText();
                    String prenom = textprenomAM.getText();
                    int droit = Integer.parseInt(textdroitAM.getText());
                    UtilisateurDAO dao = new UtilisateurDAO();
                    Utilisateur u = new Utilisateur(id, email, pass, nom, prenom, droit);
                    dao.create(u);
                    JFrame reussi = new JFrame();
                    JLabel labelR = new JLabel("Utilisateur ajouté !");
                    reussi.add(labelR);
                    reussi.setTitle("Utilisateur ajouté !");
                    reussi.setSize(300,200);
                    reussi.setLocationRelativeTo(null);
                    reussi.setResizable(false);
                    reussi.setVisible(true);
                } catch (NumberFormatException ex) {
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
        panel.add(ajoutButton);
        
        majButton = new JButton("Mettre à jour");
        majButton.setBounds(820,270,150,25);
        majButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textidAM.getText());
                    String email = textemailAM.getText();
                    String pass = textpassAM.getText();
                    String nom = textnomAM.getText();
                    String prenom = textprenomAM.getText();
                    int droit = Integer.parseInt(textdroitAM.getText());
                    UtilisateurDAO dao = new UtilisateurDAO();
                    Utilisateur u = new Utilisateur(id, email, pass, nom, prenom, droit);
                    dao.update(u);
                    JFrame reussi = new JFrame();
                    JLabel labelR = new JLabel("Utilisateur mis à jour !");
                    reussi.add(labelR);
                    reussi.setTitle("Utilisateur mis à jour !");
                    reussi.setSize(300,200);
                    reussi.setLocationRelativeTo(null);
                    reussi.setResizable(false);
                    reussi.setVisible(true);
                } catch (NumberFormatException ex) {
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
        panel.add(majButton);
        
        /**
        * PARTIE SUPPRESSION D'UN UTILISATEUR
        */
        
        labelS = new JLabel("- SUPPRIMER UN UTILISATEUR -");
        labelS.setBounds(700,350,300,40);
        panel.add(labelS);
        
        labelidS = new JLabel("ID : ");
        labelidS.setBounds(700,380,100,25);
        panel.add(labelidS);
        
        textidS = new JTextField(150);
        textidS.setBounds(800,380,180,25);
        panel.add(textidS);
        
        supprButton = new JButton("Supprimer");
        supprButton.setBounds(700,420,120,25);
        supprButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textidS.getText());
                    UtilisateurDAO dao = new UtilisateurDAO();
                    Utilisateur u = new Utilisateur();
                    u = dao.find(id);
                    dao.delete(u);
                    JFrame reussi = new JFrame();
                    JLabel labelR = new JLabel("Utilisateur supprimé !");
                    reussi.add(labelR);
                    reussi.setTitle("Utilisateur ajouté !");
                    reussi.setSize(300,200);
                    reussi.setLocationRelativeTo(null);
                    reussi.setResizable(false);
                    reussi.setVisible(true);
                } catch (NumberFormatException ex) {
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
        panel.add(supprButton);
        
        frame.setVisible(true);
    }
}
