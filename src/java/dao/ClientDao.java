/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entites.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * auteur: Djouela
 * Date de création: 14/01/2021
 * 
 * 
 * //classe qui va interagir avec la table client (requetes SQL)
    
 */
public class ClientDao {
    
    private MaConnexionBDD mcBDD;

    public ClientDao() {
        mcBDD = new MaConnexionBDD();
    }
// si on a jour besoin de modifier la connexion, on utilisera cet setteur
    public void setMcBDD(MaConnexionBDD mcBDD) {
        this.mcBDD = mcBDD;
    }
    
    // method pour exécuter(envoyer dans le sql) les requetes, elle soccupe uniquement 
    //de l'envoi
    //des donnees du client, et non de son traitemnt(fait lui par la classe GestionClient)
    
    public void insertClient (String nom, String prenom, String email, String mdp ) throws SQLException{
       try(Connection cnn = mcBDD.getConnection();){ // pas besoin de refermer la 
           //connexion car on a utilisé un try catch avec ressources
           //essayez toujours d'écrire les requetes SQL sur une ligne
           String sql = "INSERT INTO"
                    + " client(client_nom, client_prenom, client_email, client_mdp)"
                    + " VALUES(?,?,?, md5(?))";
           PreparedStatement pstm = cnn.prepareStatement(sql);
           pstm.setString(1, nom);
           pstm.setString(2,prenom);
           pstm.setString(3, email);
           pstm.setString(4, mdp);
           
           pstm.executeUpdate();
       }
        
    }
    
    public int verifierExistanceEmail(String email)throws SQLException{
        try(Connection cnn = mcBDD.getConnection();){ // pas besoin de refermer la 
           //connexion car on a utilisé un try catch avec ressources
           //essayez toujours d'écrire les requetes SQL sur une ligne
           String sql = "SELECT COUNT(*) FROM client WHERE client_email = ?";
           PreparedStatement pstm = cnn.prepareStatement(sql);
           pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            rs.next(); // on se met à la ligne, une seule colone(COUNT)
            int qte = rs.getInt(1);
            return qte;
          
           
           
       }
        
    }
    
    public Client selectClientByEmailAndPassword(String email, String password) throws SQLException{
        
        Client user = null;
       
         try(Connection cnn = mcBDD.getConnection();){ 
          
           String sql = "SELECT * FROM client "
                   + " WHERE client_email = ? AND client_mdp = md5(?)";
           PreparedStatement pstm = cnn.prepareStatement(sql);
           pstm.setString(1, email);
           pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
        if(rs.next()){ // s'il ya un match dans la BDD
            user = new Client();
            user.setId(rs.getInt("client_id")); //ne jamais faire un println ou affichage de la cle primaire dun client
            user.setNom(rs.getString("client_nom"));
            user.setPrenom(rs.getString("client_prenom"));
            
            user.setEmail(rs.getString("client_email"));
            
            
        }
           
          
           
           
       }
        
         return user;
    }
    
    
}
