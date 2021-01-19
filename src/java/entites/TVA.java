
package entites;

/*
  Auteur: Djouela
  Date de céation: 19/01/2021
 */
public class TVA {
    private int id;
    private String label;
    private float taux; // en pourcentage

    public TVA() {
    }

    public TVA(int id, String label, float taux) {
        this.id = id;
        this.label = label;
        this.taux = taux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "TVA{" + "id=" + id + ", label=" + label + ", taux=" + taux + '}';
    }
    
    
}
