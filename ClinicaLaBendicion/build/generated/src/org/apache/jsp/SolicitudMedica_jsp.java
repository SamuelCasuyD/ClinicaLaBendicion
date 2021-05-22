package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SolicitudMedica_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container-fluid mt-4\">\n");
      out.write("    <div class=\"card\">\n");
      out.write("\n");
      out.write("        <h4 class=\"card-header\">Mantenimiento</h4>                 \n");
      out.write("        \n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                    <div class=\"btn-group\" role=\"group\" aria-label=\"Basic example\">\n");
      out.write("                        <a href=\"SolicitudesController?menu=crearSolicitud\" class=\"btn btn-outline-info\" role=\"button\" aria-pressed=\"true\">Crear Solicitud</a>   \n");
      out.write("                        <a href=\"SolicitudesController?menu=consultaSolicitudes\" class=\"btn btn-outline-info\" role=\"button\" aria-pressed=\"true\">Consultar Solicitud</a> \n");
      out.write("                        <a href=\"SolicitudesController?menu=informacionGeneral\" class=\"btn btn-outline-info\" role=\"button\" aria-pressed=\"true\">Informacion General</a> \n");
      out.write("                        <a href=\"ExpedientesController?menu=expedientes\" class=\"btn btn-outline-info\" role=\"button\" aria-pressed=\"true\">Expediente</a> \n");
      out.write("                        <a href=\"ExpedientesController?menu=muestras\" class=\"btn btn-outline-info\" role=\"button\" aria-pressed=\"true\">Muestras</a> \n");
      out.write("                        <a href=\"TrazabilidadController?menu=trazabilidad\" class=\"btn btn-outline-info\" role=\"button\" aria-pressed=\"true\">Trazabilidad</a>\n");
      out.write("                        \n");
      out.write("                    </div>            \n");
      out.write("               <hr>\n");
      out.write("         \n");
      out.write("   \n");
      out.write("           </div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--*******************************************************************-->\n");
      out.write("<div class=\"container-fluid mt-4\"  id=\"tabla\" >\n");
      out.write("    <div class=\"card\">\n");
      out.write("         <h4 class=\"card-header\">Información General</h4>   \n");
      out.write("        <div class=\"card-body\">\n");
      out.write("            <table id=\"example\" class=\"table table-bordered table-striped small\">\n");
      out.write("                <thead style=\"font-size: 8px\">\n");
      out.write("                <th class=\"text-center\">Código solicitud</th>\n");
      out.write("                <th class=\"text-center\">No. expediente</th>\n");
      out.write("                <th class=\"text-center\">NIT</th>\n");
      out.write("                <th class=\"text-center\">No. soporte</th>\n");
      out.write("                <th class=\"text-center\">Tipo soporte</th>\n");
      out.write("                <th class=\"text-center\">Tipo solicitante</th>\n");
      out.write("\n");
      out.write("                <th class=\"text-center\">Tipo solicitud</th>\n");
      out.write("                <th class=\"text-center\">Usuario asignación</th>\n");
      out.write("                <th class=\"text-center\">Estado solicitud</th>\n");
      out.write("                <th class=\"text-center\">Usuario creación</th>\n");
      out.write("                <th class=\"text-center\">Fecha creación</th>\n");
      out.write("                <!-- <th class=\"text-center\">Cantidad muestras</th>--> \n");
      out.write("\n");
      out.write("                <!-- <th class=\"text-center\">Cantidad ítems</th>--> \n");
      out.write("                <!-- <th class=\"text-center\">Cantidad documentos</th>--> \n");
      out.write("                <th class=\"text-center\">Descripción</th>\n");
      out.write("                <th class=\"text-center\">Solicitante</th>\n");
      out.write("                <th class=\"text-center\">Teléfonos</th>\n");
      out.write("                <th class=\"text-center\">Emails</th>\n");
      out.write("                </thead>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <tbody style=\"font-size: 8px\">\n");
      out.write("\n");
      out.write("                    <c:forEach var=\"soli\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listSol}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" id=\"muestraTabla\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getCodigoSolicitud()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getCodigoSolicitud()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getNumExpediente()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getNit()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getNumSoporte()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>    \n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getNombreSoporte()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getNombreTipoSolicitante()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getNombreTipoSolicitud()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getUsuarioAsignacion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>  \n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getNombreEstadoSolicitud()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getUsuarioCreacion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getFechaCreacion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <!--<td></td>--> \n");
      out.write("                        <!--<td></td>-->\n");
      out.write("                        <!--<td></td>-->\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getDescripcion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getTelefono()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getEmail()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\n");
      out.write("                    </tr>   \n");
      out.write("                </c:forEach>                        \n");
      out.write("                </tbody>\n");
      out.write("            </table>  \n");
      out.write("        </div>  \n");
      out.write("    </div> \n");
      out.write("</div>\n");
      out.write("<!--*******************************************************************-->\n");
      out.write("\n");
      out.write("            <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"https://cdn.datatables.net/v/bs4/dt-1.10.24/datatables.min.js\"></script>\n");
      out.write("            <script>\n");
      out.write("                $(function () {\n");
      out.write("                    $('[data-toggle=\"tooltip\"]').tooltip();\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("            <script>\n");
      out.write("                $(document).ready(function() {\n");
      out.write("                    $('#example').DataTable( {\n");
      out.write("                        \"lengthMenu\": [[10, 25, 50, 75, 100, -1], [10, 25, 50, 75, 100, \"Todas\"]],\n");
      out.write("                        \"language\":{\n");
      out.write("                            sLengthMenu: \"Mostrar _MENU_ registros\",\n");
      out.write("                            sInfo: \"Registros del _START_ al _END_ | Total: _TOTAL_\",\n");
      out.write("                            sInfoEmpty: \"Mostrando registros del 0 al 0 de un total de 0 registros\",\n");
      out.write("                            sInfoFiltered: \"(filtrado de un total de _MAX_ registros)\",\n");
      out.write("                            sSearch: \"Buscar:\",\n");
      out.write("                            sLoadingRecords: \"Cargando...\",\n");
      out.write("                            oPaginate: {\n");
      out.write("                                sFirst: \"Primero\",\n");
      out.write("                                sLast: \"Último\",\n");
      out.write("                                sNext: \"Siguiente\",\n");
      out.write("                                sPrevious: \"Anterior\"\n");
      out.write("                            }                 \n");
      out.write("                        }         \n");
      out.write("\n");
      out.write("                    } );\n");
      out.write("                } );\n");
      out.write("            </script>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
