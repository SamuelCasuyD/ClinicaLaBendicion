/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import API.UsuarioAPI;
import Models.UsuarioDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SammyKazzu
 */
public class UsuarioController extends HttpServlet {

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
       
        RequestDispatcher res;
        UsuarioDTO user = new UsuarioDTO();
        UsuarioAPI Validar = new UsuarioAPI();

        if (request.getParameter("accion") != null) {

            String usuario = request.getParameter("txtuser");
            String password = request.getParameter("txtpass");

            user = Validar.validarUsurio(usuario, password);

            if (user.getUsuario() != null) {
                request.setAttribute("v", "1");
                request.setAttribute("usuario", user.getUsuario());
                request.setAttribute("nombre", user.getPrimerNombre());
                request.setAttribute("apellido", user.getPrimerApellido());
                request.setAttribute("idUsuario", user.getEntityID());
                request.setAttribute("rolUsuario", user.getIdRol());
                request.setAttribute("cantidadSolicitudes", user.getCantidadSolicitudes());
                
                
                
                 
            } else {
                request.setAttribute("v", "0");
            }

        }
        res = request.getRequestDispatcher("index.jsp");
        res.forward(request, response);
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
