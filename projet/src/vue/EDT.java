/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*; 
import java.awt.FlowLayout;
import javax.swing.JButton;
//import java.awt.FlowLayout; 
//import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
//import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * Classe qui affiche l'emploi du temps
 * (inachevée)
 * 
 * @author George
 */
public class EDT {
    
    //Classe EDT
    
    /*
    private JPanel panel, panel1;
    private JLabel msg;
    private JTextField textutil;
   // private static JButton button;
    private JFrame frame;
    //private FlowLayout menu;
    private JMenuBar menubar;
    private JMenu edt,modif;
    
    
    
    public EDT() {
        frame = new JFrame();
        frame.setTitle("Planning etudiant");
        frame.setSize(1600,840);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        // Mise en place de la barre de menu
        
        edt= new JMenu("Emploie du temps");
        modif= new JMenu("Liste de cours");
        menubar= new JMenuBar();
        menubar.add(edt);
        menubar.add(modif);
        
        
        panel = new JPanel();
       // panel.setLayout(null);
        panel.setBackground(Color.gray);
                
        panel1 = new JPanel();
        panel1.setBounds(0, 80, 1300, 600);
        panel1.setLayout(new BorderLayout());
        
        Vector<String> lig1 = new Vector<String>();
        lig1.addElement("8h30 - 10h");
        lig1.addElement("Math ");
        lig1.addElement("Physique");
        lig1.addElement("Alchimie");
        lig1.addElement("Math ");
        lig1.addElement("Physique");
        lig1.addElement("Alchimie");
        lig1.addElement("Math ");

    
        Vector<String> lig2 = new Vector<String>();
        lig2.addElement("10h30 - 12h ");
        lig2.addElement("Physique");
        lig2.addElement("Alchimie");
        lig2.addElement("Magie");
        lig2.addElement("Technologie");
        lig2.addElement("Ingenierie");
        
        
        Vector<String> lig3 = new Vector<String>();
        lig3.addElement("12h - 13h30h ");
        lig3.addElement("Physique");
        lig3.addElement("Alchimie");
        lig3.addElement("Magie");
        lig3.addElement("Technologie");
        lig3.addElement("Ingenierie");
        
        Vector<String> lig4 = new Vector<String>();
        lig4.addElement("13h45 - 15h15h ");
        lig4.addElement("Physique");
        lig4.addElement("Alchimie");
        lig4.addElement("Magie");
        lig4.addElement("Technologie");
        lig4.addElement("Ingenierie");
        
        Vector<String> lig5 = new Vector<String>();
        lig5.addElement("15h30 - 17h ");
        lig5.addElement("Physique");
        lig5.addElement("Alchimie");
        lig5.addElement("Magie");
        lig5.addElement("Technologie");
        lig5.addElement("Ingenierie");
        
        Vector<String> lig6 = new Vector<String>();
        lig6.addElement("17h15 - 18h45h ");
        lig6.addElement("Physique");
        lig6.addElement("Alchimie");
        lig6.addElement("Magie");
        lig6.addElement("Technologie");
        lig6.addElement("Ingenierie");
        
        Vector<String> lig7 = new Vector<String>();
        lig7.addElement("19h - 20h30 ");
        lig7.addElement("Physique");
        lig7.addElement("Alchimie");
        lig7.addElement("Magie");
        lig7.addElement("Technologie");
        lig7.addElement("Ingenierie");
    
        Vector<Vector> rowData = new Vector<Vector>();
        rowData.addElement(lig1);
        rowData.addElement(lig2);
        rowData.addElement(lig3);
        rowData.addElement(lig4);
        rowData.addElement(lig5);
        rowData.addElement(lig6);
        rowData.addElement(lig7);
        
    
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("horaires");
        columnNames.addElement("Lundi");
        columnNames.addElement("Mardi");
        columnNames.addElement("Mercredi");
        columnNames.addElement("Jeudi");
        columnNames.addElement("vendredi");
        columnNames.addElement("Samedi");
        
        JTable table = new JTable(rowData, columnNames);

        //table.setValueAt("Mathemaniques", 0, 0);
        JScrollPane scrollPane = new JScrollPane(table);
        panel1.add(scrollPane, BorderLayout.CENTER);
        
        //panel.add(new JScrollPane(table));
        
    
       // menu = new FlowLayout();
//        panel.setLayout(menu);
//        panel.add(new JButton("Ajouter un cours"));
//        panel.add(new JButton("supprimer un cours"));
//        panel.add(new JButton("ranger un cours"));
//        menubar.add(new JButton("manger un cours"));
//        menubar.add(new JButton("pedaler un cours"));
       

        frame.setJMenuBar(menubar);
        frame.add(panel1);
        frame.getContentPane().add(panel);
        
        //frame.pack();
        
//        msg = new JLabel("bienvenue sur votre edt");
//        
//        panel.add(msg);
        
        frame.setVisible(true);
              
    }
}

 
class buttonAction implements ActionListener{
    
       // private JPanel panel2 = new JPanel();
        //private JLabel msgerror = new JLabel();
       // private JFrame frame2 = new JFrame();
        
   public void actionPerformed(ActionEvent e) {
        
   }
   */
    //Partie connexion MySQL
    
    /*
    public void afficherEtudiantEDT(int id){
        
        //Déclaration des variables
        int tableSeance[] = null;
        int i = 0;
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "select id_seance from seance_etudiants where id_etudiant=" + id;
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult = dbStatement.executeQuery(query);
            while (dbResult.next()){
                tableSeance[i] = dbResult.getInt("id_seance");
                i++;
            }
            
            if (tableSeance.length==0){
                //creation fenetre edt vide
                
            }
            else {
                //creation de la fenetre edt
                for (int j = 0; j < tableSeance.length; j++) {
                    query = "select * from seance where id=" + tableSeance[j];
                    dbResult = dbStatement.executeQuery(query);
                    dbResult.next();
                    int id_s = dbResult.getInt("id");
                    int semaine_s = dbResult.getInt("semaine");
                    String date_s = dbResult.getString("date");
                    String heure_debut_s = dbResult.getString("heure_debut");
                    String heure_fin_s = dbResult.getString("heure_fin");
                    String etat_s = dbResult.getString("etat");
                    int id_cours_s = dbResult.getInt("id_cours");
                    int id_type_s = dbResult.getInt("id_type");
                    //ajout bloc de seance
                }
            }
            dbStatement.close();
            dbConnect.close();
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
        
    }
    
    public void afficherEnseignantEDT(int id){
        
        //Déclaration des variables
        int tableSeance[] = {};
        int i = 0;
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "select id_seance from seance_enseignants where id_enseignant=" + id;
        
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult = dbStatement.executeQuery(query);
            while (dbResult.next()){
                tableSeance[i] = dbResult.getInt("id_seance");
                i++;
            }
            
            if (tableSeance.length==0){
                //creation fenetre edt vide
                
            }
            else {
                //creation de la fenetre edt
                for (int j = 0; j < tableSeance.length; j++) {
                    query = "select * from seance where id=" + tableSeance[j];
                    dbResult = dbStatement.executeQuery(query);
                    dbResult.next();
                    int id_s = dbResult.getInt("id");
                    int semaine_s = dbResult.getInt("semaine");
                    String date_s = dbResult.getString("date");
                    String heure_debut_s = dbResult.getString("heure_debut");
                    String heure_fin_s = dbResult.getString("heure_fin");
                    String etat_s = dbResult.getString("etat");
                    int id_cours_s = dbResult.getInt("id_cours");
                    int id_type_s = dbResult.getInt("id_type");
                    //ajout bloc de seance
                }
            }
            dbStatement.close();
            dbConnect.close();
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
    }*/
   

}