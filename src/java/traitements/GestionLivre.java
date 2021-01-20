package traitements;

import dao.LivreDao;
import entites.Livre;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/*
 Auteur: Djouela
 Date de création: 19/01/2021
 */
public class GestionLivre {

    private LivreDao livreDao;

    public GestionLivre() {
        livreDao = new LivreDao();

    }

    // methodes
    public List<Livre> selectAllLivres() throws SQLException {

        return livreDao.selectAllLivres();
    }

    public Livre selectLivreByEan(String ean) throws SQLException, ParseException {

        if (ean == null || ean.trim().isEmpty()) {
            return null;   // aucun livre trouvé
        } else {
            ean = ean.trim();

            return livreDao.selectLivreByEan(ean);
        }
    }

}
