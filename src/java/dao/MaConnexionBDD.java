
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djtew
 */
public class MaConnexionBDD {
    private String user;
    private String mdp;
    private String url;

    public MaConnexionBDD() {
        user = "root";
        mdp = "root";
        url = "jdbc:mysql://localhost:3306/librairie?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&useSSL=false";
    try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //chargement de la classe du driver
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MaConnexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MaConnexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MaConnexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MaConnexionBDD(String user, String mdp, String url) {
        this.user = user;
        this.mdp = mdp;
        this.url = url;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MaConnexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MaConnexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MaConnexionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Connection getConnection() throws SQLException{
        Connection cnn = DriverManager.getConnection(url, user, mdp);
        return cnn;
    }
   // ensuite on cree la classe clientDao qui va interagir avec la table client (requetes SQL
    
    
}
