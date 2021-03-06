/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import API.EstadosSolicitudesAPI;
import API.SolicitudesMedicasAPI;
import API.TipoSolicitanteAPI;
import API.TipoSolicitudAPI;
import API.TipoSoporteAPI;
import Models.EstadosSolicitudesDTO;
import Models.SolicitudesMedicasDTO;
import Models.TipoSolicitanteDTO;
import Models.TipoSolicitudDTO;
import Models.TipoSoporteDTO;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SammyKazzu
 */
@WebServlet(name = "SolicitudesController", urlPatterns = {"/SolicitudesController"})
public class SolicitudesController extends HttpServlet {

    SolicitudesMedicasDTO findSolMedicById = new SolicitudesMedicasDTO();
    SolicitudesMedicasAPI findSolMedicByIdAPI = new SolicitudesMedicasAPI();
    List<SolicitudesMedicasDTO> listS = new ArrayList<>();

    TipoSolicitanteAPI TsolicitanteAPI = new TipoSolicitanteAPI();
    List<TipoSolicitanteDTO> TsolicitanteDTO = new ArrayList<>();

    TipoSoporteDTO sPExterno = new TipoSoporteDTO();
    TipoSoporteAPI spEDAO = new TipoSoporteAPI();
    List<TipoSoporteDTO> ListaSoporteInterno = new ArrayList<>();
    List<TipoSoporteDTO> ListaSoporteExterno = new ArrayList<>();

    TipoSolicitudAPI TSd_dao = new TipoSolicitudAPI();
    List<TipoSolicitudDTO> Tsolicitud = new ArrayList<>();

    EstadosSolicitudesAPI estSoliDAO = new EstadosSolicitudesAPI();
    List<EstadosSolicitudesDTO> ListarEstados = new ArrayList<>();

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
        String menu = request.getParameter("menu");

        Tsolicitud = TSd_dao.listarTsolicitud();
        request.setAttribute("TipoSolicitud", Tsolicitud);

        ListarEstados = estSoliDAO.listarEstadosSolicitudes();
        request.setAttribute("estados", ListarEstados);

        TsolicitanteDTO = TsolicitanteAPI.listar();

        request.setAttribute("tipoSolicitante", TsolicitanteDTO);

        ListaSoporteInterno = spEDAO.listarSoporteInterno();
        ListaSoporteExterno = spEDAO.listarSoporteExterno();
        request.setAttribute("SoporteInt", ListaSoporteInterno);
        request.setAttribute("SoporteExt", ListaSoporteExterno);

        if (menu.equalsIgnoreCase("principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } //--      
        else if (menu.equalsIgnoreCase("mantenimiento")) {

            listS = findSolMedicByIdAPI.listarSolicitudes();
            request.setAttribute("listSol", listS);

            request.getRequestDispatcher("SolicitudMedica.jsp").forward(request, response);

        } //--
        else if (menu.equalsIgnoreCase("crearSolicitud")) {

            request.getRequestDispatcher("CrearSolicitud.jsp").forward(request, response);

        } //--
        else if (menu.equalsIgnoreCase("consultaSolicitudes")) {

            request.getRequestDispatcher("ConsultaSolicitudes.jsp").forward(request, response);
        } //--
        else if (menu.equalsIgnoreCase("Buscar")) {

            String codigoSolicitud = request.getParameter("txtSolicitud");
            String numExpediente = request.getParameter("txtExpediente");
            String numSoporte = request.getParameter("txtNoSoporte");
            String tipoSolicitud = request.getParameter("slcTpolicitud");
            String nit = request.getParameter("txtNit");
            String estado = request.getParameter("slcEstado");
            String fechaInicio = request.getParameter("fechaInicio");
            String fechaFin = request.getParameter("fechaFin");

            if (codigoSolicitud.isEmpty()) {
                codigoSolicitud = null;
            }
            if (numExpediente.isEmpty()) {
                numExpediente = null;
            }
            if (numSoporte.isEmpty()) {
                numSoporte = null;
            }
            if (tipoSolicitud == null) {
                tipoSolicitud = null;
            }
            if (nit.isEmpty()) {
                nit = null;
            }
            if (estado == null) {
                estado = null;
            }
            if (fechaInicio.isEmpty()) {
                fechaInicio = null;
            }
            if (fechaFin.isEmpty()) {
                fechaFin = null;
            }
            if (codigoSolicitud == null && numExpediente == null
                    && numSoporte == null && tipoSolicitud == null && nit == null && estado == null
                    && (fechaInicio == null || fechaFin == null)) {

                request.setAttribute("error", "<div class='alert alert-danger' role='alert'>Seleccione un rango de fechas</div>");
                request.getRequestDispatcher("ConsultaSolicitudes.jsp").forward(request, response);

            } else {

                listS = findSolMedicByIdAPI.buscarSolicitudesMedicas(codigoSolicitud, numExpediente, numSoporte, tipoSolicitud, nit, estado, fechaInicio, fechaFin);

                if (listS.size() == 0) {
                    request.setAttribute("msj", "<div class='alert alert-warning alert-dismissible fade show' role='alert'>"
                            + "No hay datos asiciados al filtro de b??squeda, verifique que los datos ingresados sean correctos"
                            + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                            + "<span aria-hidden='true'>&times;</span> </button></div>");

                    request.getRequestDispatcher("ConsultaSolicitudes.jsp").forward(request, response);
                } else {
                    request.setAttribute("Solicitudes", listS);
                    request.getRequestDispatcher("ConsultaSolicitudes.jsp").forward(request, response);
                }
            }
        } //--
        else if (menu.equalsIgnoreCase("informacionGeneral")) {

            listS = findSolMedicByIdAPI.listarSolicitudes();
            request.setAttribute("listSol", listS);
            request.getRequestDispatcher("SolicitudesController?menu=mantenimiento").forward(request, response);
        } else if (menu.equalsIgnoreCase("Elininado")) {

            String idSolicitud = request.getParameter("idSolicitud");

            int idSol = parseInt(idSolicitud);
            int idEstado = 10;

            findSolMedicById.setIdSolicitud(idSol);
            findSolMedicById.setEstadoSolicitud(idEstado);
            
            findSolMedicByIdAPI.EliminarSolicitud(findSolMedicById);
            
           

            request.setAttribute("mensaje", "La solicitud fue eliminada con exito");
            request.getRequestDispatcher("SolicitudesController?menu=mantenimiento").forward(request, response);

        } else {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
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
