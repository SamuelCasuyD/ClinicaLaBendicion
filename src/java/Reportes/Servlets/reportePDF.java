/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes.Servlets;

import API.Conection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;


/**
 *
 * @author Alexander Elias
 */
public class reportePDF extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JRException {
        
        Connection Conexion;
        
        Conection cn = new Conection();
      
        Map parameters = new HashMap();
        
        parameters.put("fechaInicio", new Date());
        
        ServletOutputStream out;
        //Creamos un objeto jasper con el fichero previamente compilado
        
       
        
        
        JasperReport jasperReportjasperReport;
        //jasperReportjasperReport = (JasperReport)JRLoader.loadObject("C:/Users/Alexander Elias/Documents/proyectoProgramacion/ClinicaLaBendicion/src/java/Reportes/Reports/rpSolicitudesMedicas.jasper");
        
        
        
       
        
        byte[] fichero = JasperRunManager.runReportToPdf("C:/Users/Alexander Elias/Documents/proyectoProgramacion/ClinicaLaBendicion/src/java/Reportes/Reports/rpSolicitudesMedicas.jasper", parameters, cn.getConnection());
        
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "inline; filename=consultas.pdf");
        response.setHeader("Cache-Control", "max-age=30");
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setContentLength(fichero.length);
        out = response.getOutputStream();
        
        out.write(fichero,0,fichero.length);
        out.flush();
        out.close();
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
        try {
            processRequest(request, response);
        } catch (JRException ex) {
            Logger.getLogger(reportePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (JRException ex) {
            Logger.getLogger(reportePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
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
