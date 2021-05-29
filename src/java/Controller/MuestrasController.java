/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import API.TipoMuestraAPI;
import API.UploadFileAPI;
import Models.SolicitudesMedicasDTO;
import Models.TipoMuestraDTO;
import Models.UploadFileDTO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static java.lang.Integer.parseInt;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author SammyKazzu
 */
@MultipartConfig
@WebServlet(name = "MuestrasController", urlPatterns = {"/MuestrasController"})
public class MuestrasController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private UploadFileAPI upFiles = new UploadFileAPI();
    private String pathFiles = "C:\\Users\\SammyKazzu\\Documents\\GitHub\\ClinicaLaBendicion\\web\\Files\\"; 
    private File uploads = new File(pathFiles);
    private String[] extens ={".pdf",".jpg",".png",".docx",".xlsx"};
    
    TipoMuestraAPI ListMuestra = new TipoMuestraAPI();
    List<TipoMuestraDTO> Muestra = new ArrayList<>();
    TipoMuestraDTO Create = new TipoMuestraDTO();
    TipoMuestraDTO Edit = new TipoMuestraDTO();
    
    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String menu = request.getParameter("menu");
        
        if (menu.equalsIgnoreCase("principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        //--MUESTA UNA TABLA CON LAS MUESTRAS MEDICAS CREADAS--\\
        else if (menu.equalsIgnoreCase("analisis")){
        
            Muestra = ListMuestra.ListarMuestras();
            request.setAttribute("listMuestras", Muestra);            
            request.getRequestDispatcher("AnalisisMuestras.jsp").forward(request, response);
        }
        //--SOLICITUD DE DATOS PARA CREAR MUESTAS MEDICAS--\\
        else if (menu.equalsIgnoreCase("CrearMuestra")){
            
            Muestra= ListMuestra.listarTipoMuestra();
            request.setAttribute("muestra", Muestra);
            
            Muestra = ListMuestra.listUniMedida();
            request.setAttribute("medida", Muestra);
            
            Muestra = ListMuestra.ListarSolicitudes();
            request.setAttribute("solicitud", Muestra);
            
            request.getRequestDispatcher("CrearMuestra.jsp").forward(request, response);
        }
        //--CREAR MUESTAS MEDICAS--\\
        else if(menu.equalsIgnoreCase("NewMuestras")){            
            
            String IdTipoMuestra = request.getParameter("slcMuestra");
            String Presentacion = request.getParameter("TxtPresentacion");    
            String Cantidad = request.getParameter("cantidad");
            String UniMedida = request.getParameter("unidadmedida");   
            String idsolicitud = request.getParameter("idsolicitud");
            
            boolean estado = false;
                        
            Create.setIdTipoMuestra(parseInt(IdTipoMuestra));
            Create.setPresentacion(Presentacion);
            Create.setCantidadUnidades(parseInt(Cantidad));
            Create.setIdUnidadMedida(parseInt(UniMedida));            
            Create.setFechaCreacion(sqlDate);
            Create.setEliminado(estado);
            Create.setIdMuestra(parseInt(idsolicitud));
            ListMuestra.CrearMuestra(Create);
            
            saveCustomer(request, response);
            
            request.getRequestDispatcher("MuestrasController?menu=analisis").forward(request, response);
        }
        //--CARGAR DATOS PARA EDITAR LAS MUESTRAS--\\
        else if (menu.equalsIgnoreCase("CardarDatos")){
            Muestra = ListMuestra.listarTipoMuestra();
            request.setAttribute("muestra", Muestra);
            
            Muestra = ListMuestra.listUniMedida();
            request.setAttribute("medida", Muestra);
            
            int IdMuestra = Integer.parseInt(request.getParameter("id"));            
            TipoMuestraDTO puntoID = ListMuestra.ModificarX_ID(IdMuestra);
            
            request.setAttribute("datoMu", puntoID);
            request.getRequestDispatcher("ActualizarMuestra.jsp").forward(request, response);            
        }        
        //--ELIMINAR LAS MUESTRAS--\\
        else if(menu.equalsIgnoreCase("EliminarMuestra")){
            
            int IdMuestra;
            IdMuestra = Integer.parseInt(request.getParameter("id"));
            ListMuestra.EliminarMuestra(IdMuestra);
            request.getRequestDispatcher("MuestrasController?menu=analisis").forward(request, response);
        }
        //--MOSTRA LAS MUESTRAS ELIMINADAS--\\
        else if (menu.equalsIgnoreCase("MuestraEliminada")){
            
            Muestra = ListMuestra.MuestrasEliminadas();
            request.setAttribute("eliminada", Muestra);
            
            request.getRequestDispatcher("MuestraEliminada.jsp").forward(request, response);
        }
        //--RESTAURAR MUESTRA ELIMINADA--\\
        else if(menu.equalsIgnoreCase("RestaurarMuestra")){
            int IdMuestra;
            IdMuestra = Integer.parseInt(request.getParameter("id"));
            ListMuestra.Restaurar(IdMuestra);
            request.getRequestDispatcher("MuestrasController?menu=MuestraEliminada").forward(request, response);
        }
        //--EDITAR LOS LAS MUESTAS--\\
        else if(menu.equalsIgnoreCase("EditarMuestra")){
            
            String IdMuestra = request.getParameter("idmuestra");
            String IdTipoMuestra = request.getParameter("slcMuestra");
            String Presentacion = request.getParameter("TxtPresentacion");    
            String Cantidad = request.getParameter("cantidad");
            String UniMedida = request.getParameter("unidadmedida");            
            //boolean estado = false;            
            
            Edit.setIdTipoMuestra(parseInt(IdTipoMuestra));
            Edit.setPresentacion(Presentacion);
            Edit.setCantidadUnidades(parseInt(Cantidad));
            Edit.setIdUnidadMedida(parseInt(UniMedida));
            Edit.setIdMuestra(parseInt(IdMuestra));
            Edit.setFechaCreacion(sqlDate);
            //sMue.setEliminado(estado);
            ListMuestra.actualizar(Edit);
            
            request.getRequestDispatcher("MuestrasController?menu=analisis").forward(request, response);
        }
        //--BUSCAR SOLICITUD MEDICA--\\
        else if(menu.equalsIgnoreCase("BuscarS")){
            int IdMuestra;
            IdMuestra = Integer.parseInt(request.getParameter("id"));
            //ListMuestra.BuscarSolicitud(IdMuestra);            
            
            //SolicitudesMedicasDTO usuarioID = ListMuestra.BuscarSolicitud(IdMuestra);
            //request.setAttribute("solicitudS", usuarioID);
            
            request.getRequestDispatcher("MuestrasController?menu=CrearMuestra").forward(request, response);
        }
        //--VINCULAR SOLICITUD MEDICA--\\
        else if(menu.equalsIgnoreCase("AsignarItems")){
            
            
            String IdMuestra = request.getParameter("id");
            if(IdMuestra != null ){
                TipoMuestraDTO puntoID = ListMuestra.BuscarItem(IdMuestra);
                request.setAttribute("itemsList", puntoID);
            }   
            
            String IdSolicitud = request.getParameter("solicitudM");
            if(IdSolicitud != null)
            {
                Muestra = ListMuestra.ListarItems();
                request.setAttribute("itemsList", Muestra);
                

                SolicitudesMedicasDTO usuarioID = ListMuestra.Buscasoli(IdSolicitud);
                request.setAttribute("soli", usuarioID);
            }
            
            request.getRequestDispatcher("AsignacionDeItems.jsp").forward(request, response);
        }
        
    }    
    
    private void saveCustomer(HttpServletRequest req, HttpServletResponse resp){
        
        try{
            String name = req.getParameter("name");
            String file = req.getParameter("file");          
            
            int idadjunt = 0;
            String num = "";
            String num1 ="";
            boolean tres = false;
            
            Part part = req.getPart("file");
            
            if(part == null){
                System.out.println("Aun no tiene archivos seleccionados");
                return;
            }
            
            if(isExtension(part.getSubmittedFileName(), extens)){
                String Photo = saveFile(part,uploads);
                UploadFileDTO docs = new UploadFileDTO(idadjunt, num, file, sqlDate, sqlDate, tres);
                upFiles.addUploadFile(docs);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    private String saveFile(Part part, File pathUploads){
        
        String pathAbsolute = "";
        
        try{            
            Path path = Paths.get(part.getSubmittedFileName());
            String fileName = path.getFileName().toString();
            InputStream input = part.getInputStream();   
            
            if(input != null){
                File file = new File(pathUploads, fileName);
                pathAbsolute = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }
        }catch (Exception e){            
            e.printStackTrace();        
        }
        return pathAbsolute;
    }
    
    private boolean isExtension(String fileName, String[] extensions){
        for(String et : extensions){
            if(fileName.toLowerCase().endsWith(et)){
                return true;
            }
        }
        return false;
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
