package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Principal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Header.jsp");
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/v/bs4/dt-1.10.24/datatables.min.css\"/>\n");
      out.write("        <title>Clinica Medica</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            HttpSession ses =request.getSession();            
            if (ses.getAttribute("s1")!=null) {
                    //out.println("Bienvenido al Sistema " + "<h1>"+ses.getAttribute("nombreUsuario")+"</h1>");
                }
            else{
                response.sendRedirect("index.jsp");
            }
            //out.println("<br><a href=bienvenido.jsp?c=1>Cerrar</a>");
            
            if (request.getParameter("c")!=null) 
            {
                ses.invalidate();
                response.sendRedirect("index.jsp");
            }
        
      out.write("      \n");
      out.write("        \n");
      out.write("        <div class=\"container-fluid\" style=\"padding-left: 0px; padding-right: 0px;\">\n");
      out.write("            \n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("                <div class=\"dropdown\">\n");
      out.write("                    <button style=\"border: none;\" class=\"btn btn-outline-light dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                        ");
 out.println(ses.getAttribute("nombreUsuario"));
                        out.println(ses.getAttribute("primerApellido"));
      out.write("\n");
      out.write("                    </button>\n");
      out.write("                    <div class=\"dropdown-menu text-center\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">\n");
      out.write("                            <img src=\"img/user.jpg\" alt=\"\" width=\"60\" height=\"60\"/>\n");
      out.write("                        </a> \n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\"></a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">");
out.println(ses.getAttribute("s1"));
      out.write("</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <form action=\"Validar\" method=\"POST\">\n");
      out.write("                            <a name=\"accion\" value=\"Salir\" class=\"dropdown-item\" href=\"#\" Role=\"\">\n");
      out.write("                                \n");
      out.write("                                ");
out.println("<a href=bienvenido.jsp?c=1 style='text-decoration:none;' role='button'><i class='fas fa-sign-in-alt'> </i> Salir</a>");
      out.write("\n");
      out.write("                            </a>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" role=\"button\" href=\"MuestrasController?menu=principal\">\n");
      out.write("                                <i class=\"fa fa-home\" aria-hidden=\"true\"> </i> INICIO</a>\n");
      out.write("                        </li>\n");
      out.write("                \n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"MuestrasController?menu=analisis\">Análisis de Muestra</a>\n");
      out.write("                        </li>\n");
      out.write("                \n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"Controlador?menu=clasificacion\" target=\"myFrame\">Clasificación</a>\n");
      out.write("                        </li>\n");
      out.write("                \n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"Controlador?menu=mantenimiento\" target=\"myFrame\">Mantenimiento de Solicictudes</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>      \n");
      out.write("                </div>\n");
      out.write("            </nav>");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    \n");
      out.write("    <div id=\"carouselExampleControls\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("        <div class=\"carousel-inner\">\n");
      out.write("            <div class=\"carousel-item active\">               \n");
      out.write("                <img src=\"img/Slider/home-slider-1.png\" class=\"d-block w-100\" alt=\"\"/>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"carousel-item\">      \n");
      out.write("                <img src=\"img/Slider/home-slider-2.png\" class=\"d-block w-100\" alt=\"\"/>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"carousel-item\">      \n");
      out.write("                <img src=\"img/Slider/slider-principal.jpg\" class=\"d-block w-100\" alt=\"\"/>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <a class=\"carousel-control-prev\" href=\"#carouselExampleControls\" role=\"button\" data-slide=\"prev\">\n");
      out.write("            <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("            <span class=\"sr-only\">Previous</span>\n");
      out.write("        </a>\n");
      out.write("        <a class=\"carousel-control-next\" href=\"#carouselExampleControls\" role=\"button\" data-slide=\"next\">\n");
      out.write("            <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("            <span class=\"sr-only\">Next</span>\n");
      out.write("        </a>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("</div>\n");
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
