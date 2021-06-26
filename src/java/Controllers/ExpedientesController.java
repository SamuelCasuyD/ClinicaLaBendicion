/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import API.ExpedientesAPI;
import API.SolicitudesMedicasAPI;
import API.TipoSolicitanteAPI;
import API.TipoSolicitudAPI;
import API.TipoSoporteAPI;
import Models.ExpedientesDTO;
import Models.SolicitudesMedicasDTO;
import Models.TipoSolicitanteDTO;
import Models.TipoSolicitudDTO;
import Models.TipoSoporteDTO;
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
public class ExpedientesController extends HttpServlet {
    
      ExpedientesAPI expAPI = new  ExpedientesAPI();    
    List<ExpedientesDTO> listaExpediente = new ArrayList<>();
    
    ExpedientesDTO exp = new ExpedientesDTO();
    ExpedientesAPI expdao = new ExpedientesAPI();
    
     TipoSolicitanteAPI TsolicitanteAPI=new TipoSolicitanteAPI();
    List<TipoSolicitanteDTO> TsolicitanteDTO = new ArrayList<>();
    
    TipoSoporteDTO sPExterno = new TipoSoporteDTO();
    TipoSoporteAPI spEDAO = new TipoSoporteAPI();
    List<TipoSoporteDTO> ListaSoporteInterno = new ArrayList<>();    
    List<TipoSoporteDTO> ListaSoporteExterno = new ArrayList<>();
    
    TipoSolicitudAPI TSd_dao = new TipoSolicitudAPI();
    List<TipoSolicitudDTO> Tsolicitud = new ArrayList<>();
    
    SolicitudesMedicasDTO SolMedic = new SolicitudesMedicasDTO();
    SolicitudesMedicasAPI SolMedicDao = new SolicitudesMedicasAPI();

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
        
        
         if (menu.equalsIgnoreCase("principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        
        else if (menu.equalsIgnoreCase("expedientes")){
        
            String numeroExpediente= request.getParameter("numExpediente");
             listaExpediente = expAPI.listarExpediente(numeroExpediente);
             request.setAttribute("expedientes", listaExpediente);

             
            
            request.getRequestDispatcher("Expedientes.jsp").forward(request, response);
        }else if (menu.equalsIgnoreCase("muestras")){
            
            request.getRequestDispatcher("MuestrasController?menu=analisis").forward(request, response);
            
        }else if (menu.equalsIgnoreCase("Buscar")){  
            String NumExpediente = request.getParameter("txtNoExpediente");
            exp = expdao.lisExpedientestById(NumExpediente);
           if (exp.getNoExpediente()!=null) {
               
               Tsolicitud = TSd_dao.listarTsolicitud();
             request.setAttribute("TipoSolicitud", Tsolicitud);
             TsolicitanteDTO = TsolicitanteAPI.listar();

             request.setAttribute("tipoSolicitante", TsolicitanteDTO);

             ListaSoporteInterno = spEDAO.listarSoporteInterno();
             ListaSoporteExterno = spEDAO.listarSoporteExterno();
             request.setAttribute("SoporteInt", ListaSoporteInterno);
             request.setAttribute("SoporteExt", ListaSoporteExterno);
               
                request.setAttribute("expediente", exp);
                request.setAttribute("nombre", exp.getPrimerNombre() + " " + exp.getPrimerApellido());
                
                request.getRequestDispatcher("CrearSolicitud.jsp").forward(request, response);
                
            }else{
               
                request.setAttribute("mensaje", "<label class='alert alert-danger' role='alert'>El número de expediente no existe</label>");
                request.getRequestDispatcher("CrearSolicitud.jsp").forward(request, response);
            }
           
           
        }else if(menu.equalsIgnoreCase("Siguiente")){
            
            int idUsuario = (int) request.getSession().getAttribute("idUsuario");
            String tipoSolicitante = request.getParameter("slcTpolicitante");
            String tipoSolicitud = request.getParameter("slcTpolicitud");
            String Descripcion = request.getParameter("Descripcion");
            
            String Descripcion2 = Descripcion.replaceAll("\\s","");
            
            String NumExpediente = request.getParameter("txtNoExpediente");
            String nit = request.getParameter("Nit");
            String nombre = request.getParameter("Nombre");
            String numTel = request.getParameter("txtNoTel");
            String email = request.getParameter("txtGmail");
            String fechaCreacion = Fecha.FechaDB();
            int usuarioCreacion = idUsuario;    
            String tipoSoporte = request.getParameter("Soporte");
            String numSoporte = request.getParameter("txtSoporte");
            int estado = 1;
            
            /*Datos para la trazabilidad*/
            
            
            
            
            SolMedic.setTipoSolicitante(parseInt(tipoSolicitante));
            SolMedic.setTipoSolicitud(parseInt(tipoSolicitud));
            SolMedic.setDescripcion(Descripcion2);
            SolMedic.setNumExpediente(NumExpediente);
            SolMedic.setNit(nit);
            SolMedic.setNombre(nombre);
            SolMedic.setTelefono(numTel);
            SolMedic.setEmail(email);
            SolMedic.setFechaCreacion(fechaCreacion);
            SolMedic.setUsuarioCreacion(usuarioCreacion);
            SolMedic.setTipoSoporte(parseInt(tipoSoporte));
            SolMedic.setNumSoporte(numSoporte);
            SolMedic.setEstadoSolicitud(estado);
        
            SolMedicDao.add(SolMedic);  
            
            SolMedic = SolMedicDao.listarExpediente(1);
             
            request.setAttribute("exp", SolMedic);
          
            
             request.getRequestDispatcher("CrearSolicitud.jsp").forward(request, response);
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
