
package entites;

import java.util.Date;
import java.util.List;

/*
  Auteur: Djouela
  Date de céation: 19/01/2021
 */
public class Livre {
    private String ean; //identifiant de 13 caracteres
    private String titre;
    private float poids; // en Kg
    private int nbPages;
    private Date parution;  //java.util.date ppté de java
    private int stock;
    private String image; // nom de la photo de couverture
    private String resume;
    private float prixHT;
    
    // pptés correspondant aux associations
    
    private TVA tva;
    private Editeur editeur;
    private List<Auteur> auteurs;

    public Livre() {
    }

    public Livre(String ean, String titre, float poids, int nbPages, Date parution, int stock, String image, String resume, float prixHT) {
        this.ean = ean;
        this.titre = titre;
        this.poids = poids;
        this.nbPages = nbPages;
        this.parution = parution;
        this.stock = stock;
        this.image = image;
        this.resume = resume;
        this.prixHT = prixHT;
    }

    public Livre(String ean, String titre, float poids, int nbPages, Date parution, int stock, String image, String resume, float prixHT, TVA tva, Editeur editeur, List<Auteur> auteurs) {
        this.ean = ean;
        this.titre = titre;
        this.poids = poids;
        this.nbPages = nbPages;
        this.parution = parution;
        this.stock = stock;
        this.image = image;
        this.resume = resume;
        this.prixHT = prixHT;
        this.tva = tva;
        this.editeur = editeur;
        this.auteurs = auteurs;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public Date getParution() {
        return parution;
    }

    public void setParution(Date parution) {
        this.parution = parution;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }

    public TVA getTva() {
        return tva;
    }

    public void setTva(TVA tva) {
        this.tva = tva;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(List<Auteur> auteurs) {
        this.auteurs = auteurs;
    }

    @Override
    public String toString() {
        return "Livre{" + "ean=" + ean + ", titre=" + titre + ", prixHT=" + prixHT + '}';
    }
    
    
    
}
