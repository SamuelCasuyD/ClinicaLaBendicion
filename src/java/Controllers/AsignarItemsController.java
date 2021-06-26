/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import API.AsignarItemsAPI;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander Elias
 */
public class AsignarItemsController extends HttpServlet {

    AsignarItemsAPI asignarItems = new AsignarItemsAPI();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String[] items = request.getParameterValues("items");        
        int idMuestra = parseInt(request.getParameter("idMuestra"));
        int[] idItmes = new int[items.length];

        for (int i = 0; i < idItmes.length; i++) {
            idItmes[i] = Integer.parseInt(items[i]);
            asignarItems.add(idItmes[i], idMuestra);
        }

        request.setAttribute("msj", "<div class='alert alert-success alert-dismissible fade show' role='alert'>"
                            + "Items asociados correctamente"
                            + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                            + "<span aria-hidden='true'>&times;</span> </button></div>");
        request.getRequestDispatcher("MuestrasController?menu=analisis").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
