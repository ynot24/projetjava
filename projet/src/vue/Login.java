/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modele.Utilisateur;
import modele.UtilisateurDAO;

/**
 * 
 * Classe qui définit une page de connexion qui vérifie 
 * si les identifiants renseignés se trouvent bien dans
 * la base de données et qui affiche la page dédié à l'utilisateur
 * en fonction de son droit d'accès
 * 
 * @author Tony
 * 
 */

public class Login {
    
    
    private static JPanel panel;
    private static JLabel id, mdp;
    private static JTextField textutil;
    private static JPasswordField textmdp;
    private static JButton button;
    private static JFrame frame;

    //Constructeur avec héritage de la classe mère Jframe
    public Login(){
        frame = new JFrame();
        frame.setTitle("Page de connexion à l'hyperplanning");
        frame.setSize(600,250);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        id = new JLabel("EMail : ");
        id.setBounds(150,50,100,25);
        panel.add(id);

        textutil = new JTextField(150);
        textutil.setBounds(250,50,180,25);
        panel.add(textutil);

        mdp = new JLabel("Mot de Passe : ");
        mdp.setBounds(150,90,100,25);
        panel.add(mdp);


        textmdp = new JPasswordField(150);
        textmdp.setBounds(250,90,180,25);
        panel.add(textmdp);


        button = new JButton("Se Connecter");
        button.setBounds(250, 150, 120, 25);
        button.addActionListener(new Login.buttonAction());

        panel.add(button);

        frame.setVisible(true);
          
    }
    
    //Methode de reconnaissance dans la base de données
    public int userMatch (String email_match, String password_match) {
        
        //Déclaration des variables
        String username = "root"; //Variable de type String qui stockera l'identifiant de la base de données
        String pass = ""; //Variable de type String qui stockera son mot de passe
        String url = "jdbc:mysql://localhost/timetable?autoReconnect=true&useSSL=false"; //Variable de type String qui stockera le lien vers la base de donnée
        String query = "select id from utilisateur where email='" + email_match + "' and password='" + password_match + "'"; //Variable de type String qui stockera la requête sql
        int matchUser = 0;
        try {
            //Création d'une connexion à la base de donnée
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbConnect = DriverManager.getConnection(url, username, pass);
            Statement dbStatement = dbConnect.createStatement();
            ResultSet dbResult = dbStatement.executeQuery(query);
            if (dbResult.next()){
                matchUser = dbResult.getInt("id");
                dbStatement.close();
                dbConnect.close();
            } 
            else {
                dbStatement.close();
                dbConnect.close();
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println("ECHEC CONNEXION A LA BDD");
        }
        return matchUser;
    }
    
    private class buttonAction implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {
            String recoverTextutil = textutil.getText();
            String recoverTextmdp = new String(textmdp.getPassword());
            
            if(userMatch(recoverTextutil, recoverTextmdp) != 0){
                UtilisateurDAO dao = new UtilisateurDAO();
                Utilisateur u = new Utilisateur();
                u = dao.find(userMatch(recoverTextutil, recoverTextmdp));
                
                switch(u.getDroit()){
                    case 1:
                        //Page Admin
                        Admin admin = new Admin();
                        break;
                        
                    case 2:
                        //Page Charge de cours
                        break;
                        
                    case 3:
                        //Page Enseignant
                        break;
                        
                    case 4:
                        //Page Etudiant
                        break;
                        
                    default:
                        break;
                }
                
                /*
                JFrame unePage = new JFrame();
                unePage.setTitle("EDT");
                unePage.setSize(600,250);
                unePage.setLocationRelativeTo(null);
                unePage.setResizable(false);
                unePage.setVisible(true);
                */
            }else{
                Login login = new Login();
            }
        }
    }    
}
