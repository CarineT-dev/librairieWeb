/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import outils.CustomedException;
import traitements.GestionClient;

/**
 *
 * @author djtew
 */
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription"})
public class InscriptionServlet extends HttpServlet {

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
        
        String urlJSP = "/WEB-INF/home.jsp";
        
         // algo ici
        
        String nom = request.getParameter("nom"); // en orange c'est le parametre enregistre dans inscription-form
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String pwd2 = request.getParameter("pwd2");
        
        // maladroit !!!!
        GestionClient gtClient = new GestionClient();
        try{
          gtClient.creerNouveauClient(nom, prenom, email, pwd, pwd2);   
        }catch(CustomedException ex){
            String message = ex.getMessage();
            System.out.println(message);
            request.setAttribute("msg", message);
            urlJSP = "/WEB-INF/inscription-form.jsp";
        }
       
        
        System.out.println(">>>>>>>>>>>>> urlJSP : " +urlJSP);
        getServletContext().getRequestDispatcher(urlJSP).include(request, response);    }

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
