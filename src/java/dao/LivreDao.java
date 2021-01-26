
package dao;

import entites.Editeur;
import entites.Livre;
import entites.TVA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            String sql = "SELECT * FROM livre"; // faire une jointure pou tva pour afficher TTC
           
            
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
    
     public Livre selectLivreByEan(String ean) throws SQLException, ParseException{
       
       Livre lv = null;
       
        try(Connection cnn = mcBDD.getConnection();){
            String sql = "SELECT * FROM livre l "
                    + "JOIN tva t ON t.tva_id = l.tva_id "
                    + "JOIN editeur e ON e.editeur_id = l.editeur_id "
                    + "WHERE l.livre_ean = ?";
            
            PreparedStatement pstm = cnn.prepareStatement(sql);
            pstm.setString(1, ean);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                lv = new Livre();
                
                String titre = rs.getString("livre_titre");// titre de la colonne
                lv.setTitre(titre);
                
                lv.setEan(rs.getString("livre_ean"));
                lv.setImage(rs.getString("livre_image"));
                lv.setPrixHT(rs.getFloat("livre_prixHT"));
                
                lv.setResume(rs.getString("livre_resume"));
                lv.setPoids(rs.getFloat("livre_poids"));
                lv.setNbPages(rs.getInt("livre_nb_pages"));
                
                String dateStr = rs.getString("libre_parution");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date dateParution = sdf.parse(dateStr);
                
              
                lv.setParution(dateParution);
                
                
                // tva
                int idTva = rs.getInt("tva_id");
                String labelTva = rs.getString("tva_label");
                float tauxTva = rs.getFloat("tva_taux");
                
                TVA tva = new TVA(idTva, labelTva, tauxTva);
                lv.setTva(tva);
                
                //editeur
                int idEditeur = rs.getInt("editeur_id");
                String nomEditeur = rs.getString("editeur_nom");
                Editeur ed = new Editeur(idEditeur, nomEditeur);
                lv.setEditeur(ed);
               
                
            }
        }
        
        
        
        return lv;
    }
    
    
}

/*

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


public class MessageDao {
    
    private MaConnexionBDD mcBDD;

    public MessageDao() {
        mcBDD = new MaConnexionBDD();
    }

    public MessageDao(MaConnexionBDD mcBDD) {
        this.mcBDD = mcBDD;
    }

    public void setMcBDD(MaConnexionBDD mcBDD) {
        this.mcBDD = mcBDD;
    }
    
    public void insererMessage(String contenu, Date dateMessage ) throws SQLException{
        
        try( Connection cnn = mcBDD.getConnection();){
            String sql = "INSERT INTO "
                    + "message(message_contenu, message_date, membre_id) "
                    + "VALUES(?,?,1)";
            PreparedStatement pstm = cnn.prepareStatement(sql);
            pstm.setString(1, contenu);
            pstm.setDate(2, java.sql.Date(dateMessage.getTime()) );
            
        }
    }
    
    
}

package entites;

import java.util.Date;


public class message {
    private int id;
    private String contenu;
    private Date dateMessage;
    private Membre membre;

    public message() {
    }

    public message(int id, String contenu, Date dateMessage) {
        this.id = id;
        this.contenu = contenu;
        this.dateMessage = dateMessage;
    }

    public message(int id, String contenu, Date dateMessage, Membre membre) {
        this.id = id;
        this.contenu = contenu;
        this.dateMessage = dateMessage;
        this.membre = membre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    
    
    
    
}








*/