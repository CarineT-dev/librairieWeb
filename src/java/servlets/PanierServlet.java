/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
import traitements.GestionPanier;

/**
 *
 * @author djtew
 */
@WebServlet(name = "PanierServlet", urlPatterns = {"/vers-panier"})
public class PanierServlet extends HttpServlet {

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
        
        String urlJSP = "/WEB-INF/home.jsp";
        
        // on recupere les parametres derriere l'url
        String operation = request.getParameter("operation");
        String ean = request.getParameter("ean");
        
        //algo
       // request.setAttribute("msgSucces", "Panier mis à jour");
        
        if(session.getAttribute("gestionPanier")==null){
            session.setAttribute("gestionPanier", new GestionPanier());
        }
        GestionPanier gestionPanier = (GestionPanier) session.getAttribute("gestionPanier"); //(GestionPanier)= cast
        
        if("ajouter".equals(operation)){ // exception: sourround statement with try catch
            try {
                gestionPanier.addLivre(ean);
            } catch (SQLException ex) {
                Logger.getLogger(PanierServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(PanierServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // if(enlever.equals(operation)....
        
        
        
        
        //on tue la qequete coté serveur et on la redirige vers catalogue, donc plus de getServletContext().getRequestDispatcher(urlJSP).include(request, response);
    
    response.sendRedirect("vers-catalogue"); // plus d'url avec ajout au panier http://localhost:8080/librairieWeb/vers-catalogue (operation= ajouter a été tué par le sendRedirect)
    // donc le refresh najoute plus rien
        
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
