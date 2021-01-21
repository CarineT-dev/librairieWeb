/*
Auteur: Djouela
Date de création: 19/01/2021
*/
package servlets;

import entites.Livre;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import traitements.GestionLivre;


@WebServlet(name = "CatalogueServlet", urlPatterns = {"/vers-catalogue"})
public class CatalogueServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       request.setCharacterEncoding("UTF-8");
         HttpSession session = request.getSession();
       
       String urlJSP = "/WEB-INF/catalogue.jsp";
       
       //TODO algo pour récupérer les livres
       // MALADROIT: on extancie pas les objets plusieurs fois, faut trouver le moyen de le faire une fois et le reutiliser après
       // BON
       if(getServletContext().getAttribute("gestionLivre") == null){ //get Attribute recupere lobjet
                
                getServletContext().setAttribute("gestionLivre", new GestionLivre()); //set Attribute met lobjet
            }
       
       GestionLivre gestionLivre = (GestionLivre) getServletContext().getAttribute("gestionLivre");
        try{
        List<Livre> catalogues = gestionLivre.selectAllLivres();
        
        // request connecte le servlet au JSP
        request.setAttribute("catalogue", catalogues); // clé et valeur comme dans une HashMap; 
        //les deux classes ci-dessus peuvent etre fusionner en une seule ainsi qu'il suit:
        //request.setAttribute("catalogue", gestionLivre.selectAllLivres();
        } catch(SQLException ex){
            // to do
            System.out.println("erreur catalogue : " +ex.getMessage());
            ex.printStackTrace();
        }
       
       getServletContext().getRequestDispatcher(urlJSP).include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
