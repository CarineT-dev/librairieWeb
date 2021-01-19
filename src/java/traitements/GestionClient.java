
/*
* CLASSE/ TRAITEMENT DES COMPTES CLIENTS
* auteur: djouela
* date de création: 13/01/2021
*/
package traitements;

import dao.ClientDao;
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
    
}
