package Controllers;

import API.AsignarSolicitudesAPI;
import API.SolicitudesMedicasAPI;
import API.TrazabilidadAPI;
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

    SolicitudesMedicasAPI solicitudesAPI = new SolicitudesMedicasAPI();
    TrazabilidadDTO trazabilidad = new TrazabilidadDTO();

    TrazabilidadAPI trazaAPI = new TrazabilidadAPI();

    AsignarSolicitudesAPI asignaSolAPI = new AsignarSolicitudesAPI();

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String menu = request.getParameter("menu");
        


        if (menu.equalsIgnoreCase("principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if (menu.equalsIgnoreCase("trazabilidad")) {

            String codigoSolicitud = request.getParameter("codSolicitud");

            listaTzb = listaTzbAPI.listarTrazabildad(codigoSolicitud);
            request.setAttribute("trazabilidad", listaTzb);
            request.getRequestDispatcher("Trazabilidad.jsp").forward(request, response);

        } else if (menu.equalsIgnoreCase("Editar")) {

            int id = parseInt(request.getParameter("idSolicitud"));

            solMedicas = solicitudesAPI.listarSolicitudesId(id);
            request.setAttribute("solicitud", solMedicas);
            request.getRequestDispatcher("AsignarEstados.jsp").forward(request, response);

        } else if (menu.equalsIgnoreCase("Enviar")) {

            user = listaTzbAPI.retornarUsuarioConMenosSolicitudes();

            String idEstado = request.getParameter("estadoSolicitud");

            int idEstadoE = parseInt(idEstado);

            if (idEstadoE == 1) {

                int estado = idEstadoE + 1;

                //Obtenemos datos necesario del usuario que esta logueado
                int idUsuario = (int) request.getSession().getAttribute("idUsuario");
                String primerNombre = (String) request.getSession().getAttribute("nombreUsuario");
                String primerApellido = (String) request.getSession().getAttribute("primerApellido");
                String nobmreUsuario = primerNombre + " " + primerApellido;

                //obtenemos datos necesario del usuaio al que se va a asignar la solicitude
                int codigoUsuario = user.getEntityID();
                int cantidadSolicitudes = user.getCantidadSolicitudes();
                int catNueva = cantidadSolicitudes + 1;

                //datos proporcionaddo por la URL de la solicitud
                String codigoSolicitud = request.getParameter("codSolicitud");
                int codigoEstado = estado;

                //Actualiza datos de la solicitud
                solMedicas.setFechaModificaion(Fecha.FechaDB());
                solMedicas.setUsuraioModificacion(idUsuario);
                solMedicas.setUsuarioAsignacion(codigoUsuario);
                solMedicas.setCodigoSolicitud(codigoSolicitud);
                solMedicas.setEstadoSolicitud(codigoEstado);
                asignaSolAPI.ActualizaasignarSolicitud(solMedicas);

                //almacena la traza de la solicitud
                trazabilidad.setCodigoSolicitud(codigoSolicitud);
                trazabilidad.setEstadoSolicitud(codigoEstado);
                trazabilidad.setEnviadoPor(nobmreUsuario);
                trazabilidad.setAsignadoA(codigoUsuario);
                trazabilidad.setFecha(Fecha.FechaDB());
                trazaAPI.asignarTrazabilidad(trazabilidad);

                //actualiza la nueva cantidad de solicitudes del usuario
                user.setCantidadSolicitudes(catNueva);
                user.setEntityID(codigoUsuario);
                trazaAPI.asignarCantidadSolicitud(user);

                request.setAttribute("mensaje", "<div class='alert alert-success alert-dismissible fade show' role='alert'>"
                        + "La solicitud fue asignada con exito a " + user.getPrimerNombre() + " " + user.getPrimerApellido() + ""
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span> </button></div>");

            } else {

                request.setAttribute("mensaje", "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                        + "La solicitud solo puede ser enviada una vez"
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span> </button></div>");

            }

            request.getRequestDispatcher("SolicitudesController?menu=mantenimiento").forward(request, response);

        } else if (menu.equalsIgnoreCase("Asignar")) {

            user = listaTzbAPI.retornarUsuarioAnalistaConMenosSolicitudes();

            String idEstado = request.getParameter("estadoSolicitud");

            int idEstadoE = parseInt(idEstado);

            if (idEstadoE == 2) {

                int estado = idEstadoE + 1;

                //Datos del usuario que asigna
                int idUsuario = (int) request.getSession().getAttribute("idUsuario");
                String primerNombre = (String) request.getSession().getAttribute("nombreUsuario");
                String primerApellido = (String) request.getSession().getAttribute("primerApellido");
                int cantSolicitudes = (int) request.getSession().getAttribute("cantSolicitud");
                int nuevaCantidadAsignada = cantSolicitudes - 1;
                String nobmreUsuario = primerNombre + " " + primerApellido;

                //Datos del usuario a asignar
                int codigoUsuario = user.getEntityID();
                int cantidadSolicitudes = user.getCantidadSolicitudes();
                int catNueva = cantidadSolicitudes + 1;

                //Datos que trae la URL actual
                String codSoliciutd = request.getParameter("codSolicitud");
                int codigoEstado = estado;

                //Actualiza los datos de la solicitudes
                solMedicas.setFechaModificaion(Fecha.FechaDB());
                solMedicas.setUsuraioModificacion(idUsuario);
                solMedicas.setUsuarioAsignacion(codigoUsuario);
                solMedicas.setEstadoSolicitud(codigoEstado);
                solMedicas.setCodigoSolicitud(codSoliciutd);
                asignaSolAPI.ActualizaasignarSolicitud(solMedicas);

                //se guarda la traza de la solicitud
                trazabilidad.setCodigoSolicitud(codSoliciutd);
                trazabilidad.setEstadoSolicitud(codigoEstado);
                trazabilidad.setEnviadoPor(nobmreUsuario);
                trazabilidad.setAsignadoA(codigoUsuario);
                trazabilidad.setFecha(Fecha.FechaDB());
                trazaAPI.asignarTrazabilidad(trazabilidad);

                //Se le aumenta cantidad de solicitudes al usuario
                user.setCantidadSolicitudes(catNueva);
                user.setEntityID(codigoUsuario);
                trazaAPI.asignarCantidadSolicitud(user);

                // quita al usaurio actual una solicitud al asiganar
                user.setCantidadSolicitudes(nuevaCantidadAsignada);
                user.setEntityID(idUsuario);
                trazaAPI.quitarCantidadSolicitud(user);

                request.setAttribute("mensaje", "<div class='alert alert-success alert-dismissible fade show' role='alert'>"
                        + "La solicitud fue asignada con exito a " + user.getPrimerNombre() + " " + user.getPrimerApellido() + ""
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span> </button></div>");

            } else {

                request.setAttribute("mensaje", "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                        + "La solicitud solo puede ser enviada una vez"
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span> </button></div>");
            }

            request.getRequestDispatcher("TrazabilidadController?menu=listarSolicitudesAsignadas").forward(request, response);

        } else if (menu.equalsIgnoreCase("Rechazar")) {
            user = listaTzbAPI.retornarUsuarioAnalistaConMenosSolicitudes();

            String idEstado = request.getParameter("estadoSolicitud");

            int idEstadoE = parseInt(idEstado);

            if (idEstadoE == 2) {

                int Nuevoestado = idEstadoE + 7;

                //Datos del usuario que asigna
                int idUsuario = (int) request.getSession().getAttribute("idUsuario");
                String primerNombre = (String) request.getSession().getAttribute("nombreUsuario");
                String primerApellido = (String) request.getSession().getAttribute("primerApellido");
                int cantSolicitudes = (int) request.getSession().getAttribute("cantSolicitud");
                int nuevaCantidadAsignada = cantSolicitudes - 1;
                String nobmreUsuario = primerNombre + " " + primerApellido;

                //Datos del usuario a asignar
                int codigoUsuario = user.getEntityID();
                int cantidadSolicitudes = user.getCantidadSolicitudes();
                int catNueva = cantidadSolicitudes + 1;

                //Datos que trae la URL actual
                String codSoliciutd = request.getParameter("codSolicitud");
                String codusuaurioCreacion = request.getParameter("usuarioCreacion");
                int codUserCreo = parseInt(codusuaurioCreacion);

                // int codi
                //Actualiza los datos de la solicitudes
                solMedicas.setFechaModificaion(Fecha.FechaDB());
                solMedicas.setUsuraioModificacion(idUsuario);
                solMedicas.setUsuarioAsignacion(codUserCreo);
                solMedicas.setEstadoSolicitud(Nuevoestado);
                solMedicas.setCodigoSolicitud(codSoliciutd);
                asignaSolAPI.ActualizaasignarSolicitud(solMedicas);

                //se guarda la traza de la solicitud
                trazabilidad.setCodigoSolicitud(codSoliciutd);
                trazabilidad.setEstadoSolicitud(Nuevoestado);
                trazabilidad.setEnviadoPor(nobmreUsuario);
                trazabilidad.setAsignadoA(codigoUsuario);
                trazabilidad.setFecha(Fecha.FechaDB());
                trazaAPI.asignarTrazabilidad(trazabilidad);

                //Se le aumenta cantidad de solicitudes al usuario
                //user.setCantidadSolicitudes(catNueva);
                //user.setEntityID(codigoUsuario);
                //trazaAPI.asignarCantidadSolicitud(user);
                // quita al usaurio actual una solicitud al asiganar
                user.setCantidadSolicitudes(nuevaCantidadAsignada);
                user.setEntityID(idUsuario);
                trazaAPI.quitarCantidadSolicitud(user);

                request.setAttribute("mensaje", "<div class='alert alert-success alert-dismissible fade show' role='alert'>"
                        + "La solicitud fue asignada con exito"
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span> </button></div>");

            } else {

                request.setAttribute("mensaje", "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                        + "La solicitud solo puede ser enviada una vez"
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span> </button></div>");
            }

            request.getRequestDispatcher("TrazabilidadController?menu=listarSolicitudesAsignadas").forward(request, response);
        } else if (menu.equalsIgnoreCase("Analisis")) {

            String idEstado = request.getParameter("estadoSolicitud");
            int idEstadoE = parseInt(idEstado);
            int estadoNuevo = idEstadoE + 1;

            if (idEstadoE == 3) {

                //Datos del usuario que asigna
                int idUsuario = (int) request.getSession().getAttribute("idUsuario");
                String primerNombre = (String) request.getSession().getAttribute("nombreUsuario");
                String primerApellido = (String) request.getSession().getAttribute("primerApellido");
                int cantSolicitudes = (int) request.getSession().getAttribute("cantSolicitud");
                String nobmreUsuario = primerNombre + " " + primerApellido;

                //Datos que trae la URL actual
                String codSoliciutd = request.getParameter("codSolicitud");

                //Actualiza los datos de la solicitudes
                solMedicas.setFechaModificaion(Fecha.FechaDB());
                solMedicas.setUsuraioModificacion(idUsuario);
                solMedicas.setUsuarioAsignacion(idUsuario);
                solMedicas.setEstadoSolicitud(estadoNuevo);
                solMedicas.setCodigoSolicitud(codSoliciutd);
                asignaSolAPI.ActualizaasignarSolicitud(solMedicas);

                //se guarda la traza de la solicitud
                trazabilidad.setCodigoSolicitud(codSoliciutd);
                trazabilidad.setEstadoSolicitud(estadoNuevo);
                trazabilidad.setEnviadoPor(nobmreUsuario);
                trazabilidad.setAsignadoA(idUsuario);
                trazabilidad.setFecha(Fecha.FechaDB());
                trazaAPI.asignarTrazabilidad(trazabilidad);

                request.setAttribute("mensaje", "La actualizacion se realizo con exito");

            } else {
                request.setAttribute("mensaje", "La solicitude debe estar en estado Asignado 2");
            }
            request.getRequestDispatcher("TrazabilidadController?menu=listarSolicitudesAsignadasAnalista").forward(request, response);

        } else if (menu.equalsIgnoreCase("Espera")) {            

            String idEstado = request.getParameter("estadoSolicitud");
            int idEstadoE = parseInt(idEstado);
            int estadoNuevo = idEstadoE + 1;

            if (idEstadoE == 4) {

                //Datos del usuario que asigna
                int idUsuario = (int) request.getSession().getAttribute("idUsuario");
                String primerNombre = (String) request.getSession().getAttribute("nombreUsuario");
                String primerApellido = (String) request.getSession().getAttribute("primerApellido");
                int cantSolicitudes = (int) request.getSession().getAttribute("cantSolicitud");
                String nobmreUsuario = primerNombre + " " + primerApellido;

                //Datos que trae la URL actual
                String codSoliciutd = request.getParameter("codSolicitud");

                //Actualiza los datos de la solicitudes
                solMedicas.setFechaModificaion(Fecha.FechaDB());
                solMedicas.setUsuraioModificacion(idUsuario);
                solMedicas.setUsuarioAsignacion(idUsuario);
                solMedicas.setEstadoSolicitud(estadoNuevo);
                solMedicas.setCodigoSolicitud(codSoliciutd);
                asignaSolAPI.ActualizaasignarSolicitud(solMedicas);

                //se guarda la traza de la solicitud
                trazabilidad.setCodigoSolicitud(codSoliciutd);
                trazabilidad.setEstadoSolicitud(estadoNuevo);
                trazabilidad.setEnviadoPor(nobmreUsuario);
                trazabilidad.setAsignadoA(idUsuario);
                trazabilidad.setFecha(Fecha.FechaDB());
                trazaAPI.asignarTrazabilidad(trazabilidad);

                request.setAttribute("mensaje", "Se ha actualizado con exito");

            } else {
                request.setAttribute("mensaje", "La solicitud debe estar en estado Asignado");
            }
            request.getRequestDispatcher("TrazabilidadController?menu=listarSolicitudesAsignadasAnalista").forward(request, response);

        } else if (menu.equalsIgnoreCase("Revision")) {

            String idEstado = request.getParameter("estadoSolicitud");
            int idEstadoE = parseInt(idEstado);
            int estadoNuevo = idEstadoE + 2;

            if (idEstadoE == 4) {

                //Datos del usuario que asigna
                int idUsuario = (int) request.getSession().getAttribute("idUsuario");
                String primerNombre = (String) request.getSession().getAttribute("nombreUsuario");
                String primerApellido = (String) request.getSession().getAttribute("primerApellido");
                int cantSolicitudes = (int) request.getSession().getAttribute("cantSolicitud");
                String nobmreUsuario = primerNombre + " " + primerApellido;

                //Datos que trae la URL actual
                String codSoliciutd = request.getParameter("codSolicitud");

                //Actualiza los datos de la solicitudes
                solMedicas.setFechaModificaion(Fecha.FechaDB());
                solMedicas.setUsuraioModificacion(idUsuario);
                solMedicas.setUsuarioAsignacion(idUsuario);
                solMedicas.setEstadoSolicitud(estadoNuevo);
                solMedicas.setCodigoSolicitud(codSoliciutd);
                asignaSolAPI.ActualizaasignarSolicitud(solMedicas);

                //se guarda la traza de la solicitud
                trazabilidad.setCodigoSolicitud(codSoliciutd);
                trazabilidad.setEstadoSolicitud(estadoNuevo);
                trazabilidad.setEnviadoPor(nobmreUsuario);
                trazabilidad.setAsignadoA(idUsuario);
                trazabilidad.setFecha(Fecha.FechaDB());
                trazaAPI.asignarTrazabilidad(trazabilidad);

                request.setAttribute("mensaje", "Se ha actualizado con exito al estado revisión");
                request.getRequestDispatcher("TrazabilidadController?menu=listarSolicitudesAsignadasAnalista").forward(request, response);

            } else {
                request.setAttribute("mensaje", "La solicitud debe estar en estado Análisis");
                request.getRequestDispatcher("TrazabilidadController?menu=listarSolicitudesAsignadasAnalista").forward(request, response);
            }

        } else if (menu.equalsIgnoreCase("Rechazar2")) {
            user = listaTzbAPI.retornarUsuarioAnalistaConMenosSolicitudes();

            String idEstado = request.getParameter("estadoSolicitud");

            int idEstadoE = parseInt(idEstado);

            if (idEstadoE == 3) {

                int Nuevoestado = idEstadoE + 6;

                //Datos del usuario que asigna
                int idUsuario = (int) request.getSession().getAttribute("idUsuario");
                String primerNombre = (String) request.getSession().getAttribute("nombreUsuario");
                String primerApellido = (String) request.getSession().getAttribute("primerApellido");
                int cantSolicitudes = (int) request.getSession().getAttribute("cantSolicitud");
                int nuevaCantidadAsignada = cantSolicitudes - 1;
                String nobmreUsuario = primerNombre + " " + primerApellido;

                //Datos del usuario a asignar
                int codigoUsuario = user.getEntityID();
                int cantidadSolicitudes = user.getCantidadSolicitudes();
                int catNueva = cantidadSolicitudes + 1;

                //Datos que trae la URL actual
                String codSoliciutd = request.getParameter("codSolicitud");
                String codusuaurioCreacion = request.getParameter("usuarioCreacion");
                int codUserCreo = parseInt(codusuaurioCreacion);

                // int codi
                //Actualiza los datos de la solicitudes
                solMedicas.setFechaModificaion(Fecha.FechaDB());
                solMedicas.setUsuraioModificacion(idUsuario);
                solMedicas.setUsuarioAsignacion(codUserCreo);
                solMedicas.setEstadoSolicitud(Nuevoestado);
                solMedicas.setCodigoSolicitud(codSoliciutd);
                asignaSolAPI.ActualizaasignarSolicitud(solMedicas);

                //se guarda la traza de la solicitud
                trazabilidad.setCodigoSolicitud(codSoliciutd);
                trazabilidad.setEstadoSolicitud(Nuevoestado);
                trazabilidad.setEnviadoPor(nobmreUsuario);
                trazabilidad.setAsignadoA(codigoUsuario);
                trazabilidad.setFecha(Fecha.FechaDB());
                trazaAPI.asignarTrazabilidad(trazabilidad);

                //Se le aumenta cantidad de solicitudes al usuario
                //user.setCantidadSolicitudes(catNueva);
                //user.setEntityID(codigoUsuario);
                //trazaAPI.asignarCantidadSolicitud(user);
                // quita al usaurio actual una solicitud al asiganar
                user.setCantidadSolicitudes(nuevaCantidadAsignada);
                user.setEntityID(idUsuario);
                trazaAPI.quitarCantidadSolicitud(user);

                request.setAttribute("mensaje", "<div class='alert alert-success alert-dismissible fade show' role='alert'>"
                        + "La solicitud fue asignada con exito"
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span> </button></div>");

            } else {

                request.setAttribute("mensaje", "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                        + "La solicitud solo puede ser enviada una vez"
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span> </button></div>");
            }

            request.getRequestDispatcher("TrazabilidadController?menu=listarSolicitudesAsignadasAnalista").forward(request, response);
        } else if (menu.equalsIgnoreCase("Autorizar")) {
            user = listaTzbAPI.retornarUsuarioAnalistaConMenosSolicitudes();

            String idEstado = request.getParameter("estadoSolicitud");

            int idEstadoE = parseInt(idEstado);

            if (idEstadoE == 6) {

                int Nuevoestado = idEstadoE + 1;

                //Datos del usuario que asigna
                int idUsuario = (int) request.getSession().getAttribute("idUsuario");
                String primerNombre = (String) request.getSession().getAttribute("nombreUsuario");
                String primerApellido = (String) request.getSession().getAttribute("primerApellido");
                int cantSolicitudes = (int) request.getSession().getAttribute("cantSolicitud");
                int nuevaCantidadAsignada = cantSolicitudes - 1;
                String nobmreUsuario = primerNombre + " " + primerApellido;

                //Datos del usuario a asignar
                int codigoUsuario = user.getEntityID();
                int cantidadSolicitudes = user.getCantidadSolicitudes();
                int catNueva = cantidadSolicitudes + 1;

                //Datos que trae la URL actual
                String codSoliciutd = request.getParameter("codSolicitud");
                String codusuaurioCreacion = request.getParameter("usuarioCreacion");
                int codUserCreo = parseInt(codusuaurioCreacion);

                // int codi
                //Actualiza los datos de la solicitudes
                solMedicas.setFechaModificaion(Fecha.FechaDB());
                solMedicas.setUsuraioModificacion(idUsuario);
                solMedicas.setUsuarioAsignacion(codUserCreo);
                solMedicas.setEstadoSolicitud(Nuevoestado);
                solMedicas.setCodigoSolicitud(codSoliciutd);
                asignaSolAPI.ActualizaasignarSolicitud(solMedicas);

                //se guarda la traza de la solicitud
                trazabilidad.setCodigoSolicitud(codSoliciutd);
                trazabilidad.setEstadoSolicitud(Nuevoestado);
                trazabilidad.setEnviadoPor(nobmreUsuario);
                trazabilidad.setAsignadoA(codigoUsuario);
                trazabilidad.setFecha(Fecha.FechaDB());
                trazaAPI.asignarTrazabilidad(trazabilidad);

                //Se le aumenta cantidad de solicitudes al usuario
                //user.setCantidadSolicitudes(catNueva);
                //user.setEntityID(codigoUsuario);
                //trazaAPI.asignarCantidadSolicitud(user);
                // quita al usaurio actual una solicitud al asiganar
                user.setCantidadSolicitudes(nuevaCantidadAsignada);
                user.setEntityID(idUsuario);
                trazaAPI.quitarCantidadSolicitud(user);

                request.setAttribute("mensaje", "<div class='alert alert-success alert-dismissible fade show' role='alert'>"
                        + "La solicitud fue asignada con exito"
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span> </button></div>");

            } else {

                request.setAttribute("mensaje", "<div class='alert alert-danger alert-dismissible fade show' role='alert'>"
                        + "La solicitud solo puede ser enviada una vez"
                        + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                        + "<span aria-hidden='true'>&times;</span> </button></div>");
            }

            request.getRequestDispatcher("TrazabilidadController?menu=listarSolicitudesAsignadasAnalista").forward(request, response);
        } else if (menu.equalsIgnoreCase("Finalizar")) {

            String idEstado = request.getParameter("estadoSolicitud");
            int idEstadoE = parseInt(idEstado);
            int estadoNuevo = idEstadoE + 1;

            if (idEstadoE == 4) {

                //Datos del usuario que asigna
                int idUsuario = (int) request.getSession().getAttribute("idUsuario");
                String primerNombre = (String) request.getSession().getAttribute("nombreUsuario");
                String primerApellido = (String) request.getSession().getAttribute("primerApellido");
                int cantSolicitudes = (int) request.getSession().getAttribute("cantSolicitud");
                String nobmreUsuario = primerNombre + " " + primerApellido;

                //Datos que trae la URL actual
                String codSoliciutd = request.getParameter("codSolicitud");

                //Actualiza los datos de la solicitudes
                solMedicas.setFechaModificaion(Fecha.FechaDB());
                solMedicas.setUsuraioModificacion(idUsuario);
                solMedicas.setUsuarioAsignacion(idUsuario);
                solMedicas.setEstadoSolicitud(estadoNuevo);
                solMedicas.setCodigoSolicitud(codSoliciutd);
                asignaSolAPI.ActualizaasignarSolicitud(solMedicas);

                //se guarda la traza de la solicitud
                trazabilidad.setCodigoSolicitud(codSoliciutd);
                trazabilidad.setEstadoSolicitud(estadoNuevo);
                trazabilidad.setEnviadoPor(nobmreUsuario);
                trazabilidad.setAsignadoA(idUsuario);
                trazabilidad.setFecha(Fecha.FechaDB());
                trazaAPI.asignarTrazabilidad(trazabilidad);

                request.setAttribute("mensaje", "Se ha actualizado con exito");

            } else {
                request.setAttribute("mensaje", "La solicitud debe estar en estado Asignado");
            }
            request.getRequestDispatcher("TrazabilidadController?menu=listarSolicitudesAsignadasAnalista").forward(request, response);

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
