
/*
* CLASSE/ TRAITEMENT DES COMPTES CLIENTS
* auteur: djouela
* date de création: 13/01/2021
*/
package traitements;

import java.util.HashMap;
import outils.CustomedException;


public class GestionClient {

    
    // propriétes
    //construteurs
    
    public GestionClient() {
        
    }
    
    // methodes ou comportement
    
    public void creerNouveauClient(String nom, String prenom, 
            String email, String pwd, String pwd2) throws CustomedException{
     
        HashMap<String, String> erreurs = new HashMap<>();
        // verification des mots de passe
        // mot de passe d'au moins 8 caracteres
        
        if(!pwd.equals(pwd2)){
            erreurs.put("errPwd", "Les mots de passe ne sont pas identiques");
        } else if (pwd.equals(pwd2) && pwd.length() < 8){
            erreurs.put("errPwd", "Il faut au moins 8 caractères");
            
        }
        
        // à suivre...
        
        if(!erreurs.isEmpty()){
            CustomedException ex = new CustomedException(erreurs, "Echec de l'inscription");
            
            throw ex; // on fait remonter/propager l'exception
        }
    }
    
}
