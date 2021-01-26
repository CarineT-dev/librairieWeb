
package servlets;
/*
Auteur: Djouela
Date de création: 26/01/2021
 */
import entites.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import outils.CustomedException;
import traitements.GestionClient;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        
        
        String urlJSp = "/WEB-INF/home.jsp";
        
        String email = request.getParameter("email"); // en orange = para entré par le user
        String password = request.getParameter("password");
        
        //On invoque ensuite le modele
        if(getServletContext().getAttribute("gestionClient") == null){ // setAttribute pour poser les objets dans la session
            getServletContext().setAttribute("gestionClient", new GestionClient());
        }
        
       
        GestionClient gtClient = (GestionClient)getServletContext().getAttribute("gestionClient");
        
        try { //surround statement with try catch ie, on ne le fait que sur notre instruction(statement) et pas le block entier
            Client user = gtClient.seConnecter(email, password);
            session.setAttribute("user", user); //user en orange c'est la clé'
            
            request.setAttribute("msgSucces", "Vous etes identifié en tant que  " +user.getNom());
        //on set une seule fois
        } catch (CustomedException ex) {
            request.setAttribute("errLogIn", ex.getMessage());
            HashMap<String, String> erreurs = ex.getErreurs();
            // affichage des erreurs
            request.setAttribute("errEmail", erreurs.get("errEmail"));
            request.setAttribute("errPassword", erreurs.get("errPassword"));
           
            //reaffichage de l'email
            request.setAttribute("emailFouni", email);
            
            urlJSp = "/WEB-INF/login-form.jsp";
            
        } catch (SQLException ex) {
            System.out.println("erreur O2 sql: " + ex.getMessage());
           
        }
        
        getServletContext().getRequestDispatcher(urlJSp).include(request, response);
      
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
