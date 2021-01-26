
/*
* CLASSE/ TRAITEMENT DES COMPTES CLIENTS
* auteur: djouela
* date de création: 13/01/2021
*/
package traitements;

import dao.ClientDao;
import entites.Client;
import java.sql.SQLException;
import java.util.HashMap;
import outils.CustomedException;


public class GestionClient {

    
    // propriétes
    
    private ClientDao clientDao;
    //construteurs
    
    public GestionClient() {
        clientDao = new ClientDao();
    }
    
    // methodes ou comportement
    
    public void creerNouveauClient(String nom, String prenom, 
            String email, String pwd, String pwd2) throws CustomedException, SQLException{
     
        HashMap<String, String> erreurs = new HashMap<>();
        // verification des mots de passe
        // mot de passe d'au moins 8 caracteres
        
        if(!pwd.equals(pwd2)){
            erreurs.put("errPwd", "Les mots de passe ne sont pas identiques");
        } else if (pwd.equals(pwd2) && pwd.length() < 8){
            erreurs.put("errPwd", "Il faut au moins 8 caractères");
            
        }
        
        int qte = clientDao.verifierExistanceEmail(email);
        if(qte>0){
            erreurs.put("errMail", "Adresse mail déjà utilisée");
        }
        
        // à suivre...
        
        if(!erreurs.isEmpty()){
            CustomedException ex = new CustomedException(erreurs, "Echec de l'inscription");
            
            throw ex; // on fait remonter/propager l'exception
        } else{
            //si pas d'erreurs, on sauvegarde le client dans la base de données
        clientDao.insertClient(nom, prenom, email, pwd);
        //si problème on refait remonter le pb au servlet
        }
    }
    
    public Client seConnecter(String email, String password) throws CustomedException, SQLException{
        Client user = null;
        HashMap<String, String> erreurs = new HashMap<>();
        
        if(email == null || email.trim().isEmpty()){
            erreurs.put("ErrEmail", "email obligatoire");
        } else {
            email = email.trim();
        }
        
        if(password == null || password.isEmpty()){
            erreurs.put("errPassword", "mot de passe obligatoire");
        }
        if(!erreurs.isEmpty()){
            CustomedException ex = new CustomedException(erreurs, "échec de la connexion");
            throw ex;
        // on propage lexception par throw, et dans ce cas la suite du code n'est pas exécuté, on passe au bloque suivant
       // et donc pas de else
        }
        
        user = clientDao.selectClientByEmailAndPassword(email, password);
        if(user == null){
            CustomedException ex02 = new CustomedException(erreurs, "compte introuvable");
            throw ex02;
        }
        
        return user;
    }
    
}
