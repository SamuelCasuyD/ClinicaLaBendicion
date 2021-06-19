package Controllers;

import API.AsignarSolicitudesAPI;
import API.TrazabilidadAPI;
import API.UsuarioAPI;
import Models.SolicitudesMedicasDTO;
import Models.TrazabilidadDTO;
import Models.UsuarioDTO;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander Elias
 */
public class AsignarSolicitudesController extends HttpServlet {

    TrazabilidadAPI listaTzbAPI = new TrazabilidadAPI();
    List<TrazabilidadDTO> listaTzb = new ArrayList<>();

    UsuarioDTO user = new UsuarioDTO();

    SolicitudesMedicasDTO solMedicas = new SolicitudesMedicasDTO();
    TrazabilidadDTO trazabilidad = new TrazabilidadDTO();

    TrazabilidadAPI trazaAPI = new TrazabilidadAPI();

    AsignarSolicitudesAPI asignaSolAPI = new AsignarSolicitudesAPI();

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

        if (menu.equalsIgnoreCase("principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if (menu.equalsIgnoreCase("trazabilidad")) {

            String codigoSolicitud = request.getParameter("codSolicitud");

            listaTzb = listaTzbAPI.listarTrazabildad();
            request.setAttribute("trazabilidad", listaTzb);
            request.getRequestDispatcher("Trazabilidad.jsp").forward(request, response);

        } else if (menu.equalsIgnoreCase("Asignar")) {

            user = listaTzbAPI.retornarUsuarioConMenosSolicitudes();

            String idEstado = request.getParameter("estadoSolicitud");

            int idEstadoE = parseInt(idEstado);

            if (idEstadoE == 1) {

                int estado = idEstadoE + 1;

                int idUsuario = (int) request.getSession().getAttribute("idUsuario");
                String primerNombre = (String) request.getSession().getAttribute("nombreUsuario");
                String primerApellido = (String) request.getSession().getAttribute("primerApellido");

                String nobmreUsuario = primerNombre + " " + primerApellido;

                int codigoUsuario = user.getEntityID();
                String codigoSolicitud = request.getParameter("codSolicitud");
                int codigoEstado = estado;

                solMedicas.setUsuarioAsignacion(codigoUsuario);
                solMedicas.setCodigoSolicitud(codigoSolicitud);
                solMedicas.setEstadoSolicitud(codigoEstado);
                asignaSolAPI.asignarSolicitud(solMedicas);

                trazabilidad.setCodigoSolicitud(codigoSolicitud);
                trazabilidad.setEstadoSolicitud(codigoEstado);
                trazabilidad.setEnviadoPor(nobmreUsuario);
                trazabilidad.setAsignadoA(codigoUsuario);
                trazabilidad.setFecha(Fecha.FechaDB());

                trazaAPI.asignarTrazabilidad(trazabilidad);

                request.setAttribute("mensaje", "<div class='alert alert-success alert-dismissible fade show' role='alert'>"
                        + "La solicitud fue asignada con exito a "+user.getPrimerNombre()+" "+user.getPrimerApellido()+""
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span> </button></div>");

            } else {

                request.setAttribute("mensaje", "<div class=\"alert alert-danger\" role=\"alert\">No puede enviar la solicitud mas de una vez</div>");

            }

            request.getRequestDispatcher("SolicitudesController?menu=mantenimiento").forward(request, response);

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
