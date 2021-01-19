
package dao;

import entites.Livre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
Auteur: Djouela
Date de création: 19/01/2021
*/
public class LivreDao {
    private MaConnexionBDD mcBDD;

    public LivreDao() {
        mcBDD = new MaConnexionBDD();
    }

    public void setMcBDD(MaConnexionBDD mcBDD) {
        this.mcBDD = mcBDD;
    }
    
    // methodes pour exécuter les requetes SQL
    
    public List< Livre> selectAllLivres() throws SQLException{
        List <Livre> livres = new ArrayList<>();
        
        try(Connection cnn = mcBDD.getConnection();){
            String sql = "SELECT * FROM livre";
            PreparedStatement pstm = cnn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Livre lv = new Livre();
                
                String titre = rs.getString("livre_titre");// titre de la colonne
                lv.setTitre(titre);
                
                lv.setEan(rs.getString("livre_ean"));
                lv.setImage(rs.getString("livre_image"));
                lv.setPrixHT(rs.getFloat("livre_prixHT"));
                
                livres.add(lv);
                
            }
        }
        
        
        
        return livres;
    }
    
}
