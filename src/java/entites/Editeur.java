
package entites;

/*
  Auteur: Djouela
  Date de céation: 19/01/2021
 */
public class Editeur {
    private int id;
    private String nom;

    public Editeur() {
    }

    public Editeur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Editeur{" + "id=" + id + ", nom=" + nom + '}';
    }
    
    
    
}
