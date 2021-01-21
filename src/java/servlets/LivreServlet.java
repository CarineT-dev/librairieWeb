
/*
Auteur: Djouela
Date de création: 20/01/2021
*/
package servlets;

import entites.Livre;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import traitements.GestionLivre;


@WebServlet(name = "LivreServlet", urlPatterns = {"/vers-livre"})
public class LivreServlet extends HttpServlet {

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
      
      String urlJSP = "/WEB-INF/detail-livre.jsp";
      String eanParametre = request.getParameter("ean");
      
      
      //  - BON CODE
      
       if(getServletContext().getAttribute("gestionLivre") == null){ //get Attribute recupere lobjet
                
                getServletContext().setAttribute("gestionLivre", new GestionLivre()); //set Attribute met lobjet
            }
       
       GestionLivre gestionLivre = (GestionLivre) getServletContext().getAttribute("gestionLivre");
        try {
            Livre livre = gestionLivre.selectLivreByEan(eanParametre);
            request.setAttribute("livre", livre);
        } catch (SQLException ex) {
            Logger.getLogger(LivreServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LivreServlet.class.getName()).log(Level.SEVERE, null, ex);
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
