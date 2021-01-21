
package traitements;

import dao.LivreDao;
import entites.LigneCommande;
import entites.Livre;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;

/*
  Auteur: Djouela
  Date de céation: 21/01/2021
 */
public class GestionPanier {
    
    // Panier propre à un utilisateur
    
    private HashMap<String, LigneCommande> panier;
    
    private LivreDao livreDao;

    public GestionPanier() {
        panier = new HashMap<>();
        this.livreDao = new LivreDao();
    }
    
    public void addLivre(String ean) throws SQLException, ParseException{
        if(ean==null || ean.trim().isEmpty()){
            return; // on quitte cad on abandonne et ne fait rien
        }
        ean = ean.trim();
        if(panier.containsKey(ean)){
            LigneCommande lc = panier.get(ean);
            int newQte = lc.getQte() + 1;
            lc.setQte(newQte);
        } else {
            // aller chercher le livre dans la BDD 
            // et insérer une nouvelle ligne de commande dans le panier
            
            Livre lv = this.livreDao.selectLivreByEan(ean);
            
            if(lv !=null){
                LigneCommande lc = new LigneCommande(lv);
                panier.put(ean, lc);
            }
            
        }
        
    }
    
    public void viderPanier(){
        this.panier.clear();
    }
    
    public Collection<LigneCommande> getAllLignesPanier(){
        return this.panier.values();
    }
    
    public int CompterArticles(){
        int somme = 0;
        Collection<LigneCommande> lignes = this.getAllLignesPanier();
        
        for(LigneCommande lc : lignes){
            somme += lc.getQte();
        }
        
        
        
        return somme;
    }
    
    // etc d'autres mthds en fonction des besoins
}
