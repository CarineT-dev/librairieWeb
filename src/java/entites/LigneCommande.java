
package entites;

/*
 
Auteur : Djouela
Date de création: 21/01/2021
 */
public class LigneCommande {
    
    private int id;
    private float prixHT;
    private int qte; // pardefaut qte= 1, donc pas besoin de lui dans le constructeur
    private float tva; // en pourcentage lors de la commande
    
    private Livre livre;

    public LigneCommande() {
    }

    public LigneCommande(Livre livre) {
        this.livre = livre;
        this.qte = 1;
        this.prixHT = livre.getPrixHT();
        this.tva = livre.getTva().getTaux();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
    
    
    
}
