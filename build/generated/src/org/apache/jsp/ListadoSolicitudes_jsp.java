package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ListadoSolicitudes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/v/bs4/dt-1.10.24/datatables.min.css\"/>\r\n");
      out.write("        <title>Clinica Medica</title>\r\n");
      out.write("        <style>\r\n");
      out.write("\r\n");
      out.write("#myBtn {\r\n");
      out.write("  display: none;\r\n");
      out.write("  position: fixed;\r\n");
      out.write("  bottom: 20px;\r\n");
      out.write("  right: 30px;\r\n");
      out.write("  z-index: 99;\r\n");
      out.write("  font-size: 18px;\r\n");
      out.write("\r\n");
      out.write("  outline: none;\r\n");
      out.write("\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  padding: 15px;\r\n");
      out.write("  border-radius: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#myBtn:hover {\r\n");
      out.write("  background-color: #555;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
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
        
      out.write("      \r\n");
      out.write("        \r\n");
      out.write("        <div class=\"container-fluid\" style=\"padding-left: 0px; padding-right: 0px;\">\r\n");
      out.write("        \r\n");
      out.write("  \r\n");
      out.write("            \r\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n");
      out.write("                <div class=\"dropdown\">\r\n");
      out.write("                    <button style=\"border: none;\" class=\"btn btn-outline-light dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                        ");
 out.println(ses.getAttribute("nombreUsuario"));
                        out.println(ses.getAttribute("primerApellido"));
      out.write("\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <div class=\"dropdown-menu text-center\">\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">\r\n");
      out.write("                            <img src=\"img/user.jpg\" alt=\"\" width=\"60\" height=\"60\"/>\r\n");
      out.write("                        </a> \r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\"></a>\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">");
out.println(ses.getAttribute("s1"));
      out.write("</a>\r\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\r\n");
      out.write("                        <form action=\"Validar\" method=\"POST\">\r\n");
      out.write("                            <a name=\"accion\" value=\"Salir\" class=\"dropdown-item\" href=\"#\" Role=\"\">\r\n");
      out.write("                                \r\n");
      out.write("                                ");
out.println("<a href=bienvenido.jsp?c=1 style='text-decoration:none;' role='button'><i class='fas fa-sign-in-alt'> </i> Salir</a>");
      out.write("\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("                    <ul class=\"navbar-nav\">\r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" role=\"button\" href=\"MuestrasController?menu=principal\">\r\n");
      out.write("                                <i class=\"fa fa-home\" aria-hidden=\"true\"> </i> INICIO</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                \r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"MuestrasController?menu=analisis\">Análisis de Muestra</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                \r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"Controlador?menu=clasificacion\" target=\"myFrame\">Clasificación</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                \r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"SolicitudesController?menu=mantenimiento\">Mantenimiento de Solicictudes</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a style=\"margin-left: 10px; border: none\" class=\"btn btn-outline-light\" href=\"AnalisisSolicitudesController?menu=AnalisisSolicitudes\">Analisis de solicitudes</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>      \r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("      </div> ");
      out.write("\n");
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
      out.write("               \n");
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
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("                        \n");
      out.write("                </tbody>\n");
      out.write("            </table>  \n");
      out.write("        </div>  \n");
      out.write("    </div> \n");
      out.write("</div>\n");
      out.write("<!--*******************************************************************-->\n");
      out.write("\r\n");
      out.write("            <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("            <script type=\"text/javascript\" src=\"https://cdn.datatables.net/v/bs4/dt-1.10.24/datatables.min.js\"></script>\r\n");
      out.write("            <script>\r\n");
      out.write("                $(function () {\r\n");
      out.write("                    $('[data-toggle=\"tooltip\"]').tooltip();\r\n");
      out.write("                });\r\n");
      out.write("            </script>\r\n");
      out.write("            <script>\r\n");
      out.write("                $(document).ready(function() {\r\n");
      out.write("                    $('#example').DataTable( {\r\n");
      out.write("                        \"lengthMenu\": [[10, 25, 50, 75, 100, -1], [10, 25, 50, 75, 100, \"Todas\"]],\r\n");
      out.write("                        \"language\":{\r\n");
      out.write("                            sLengthMenu: \"Mostrar _MENU_ registros\",\r\n");
      out.write("                            sInfo: \"Registros del _START_ al _END_ | Total: _TOTAL_\",\r\n");
      out.write("                            sInfoEmpty: \"Mostrando registros del 0 al 0 de un total de 0 registros\",\r\n");
      out.write("                            sInfoFiltered: \"(filtrado de un total de _MAX_ registros)\",\r\n");
      out.write("                            sSearch: \"Buscar:\",\r\n");
      out.write("                            sLoadingRecords: \"Cargando...\",\r\n");
      out.write("                            oPaginate: {\r\n");
      out.write("                                sFirst: \"Primero\",\r\n");
      out.write("                                sLast: \"Último\",\r\n");
      out.write("                                sNext: \"Siguiente\",\r\n");
      out.write("                                sPrevious: \"Anterior\"\r\n");
      out.write("                            }                 \r\n");
      out.write("                        }         \r\n");
      out.write("\r\n");
      out.write("                    } );\r\n");
      out.write("                } );\r\n");
      out.write("            </script>\r\n");
      out.write("            <script>\r\n");
      out.write("    $(document).ready(function() {\r\n");
      out.write("        function bs_input_file() {\r\n");
      out.write("            $(\".input-file\").before(\r\n");
      out.write("                function() {\r\n");
      out.write("                    if ( ! $(this).prev().hasClass('input-ghost') ) {\r\n");
      out.write("                        var element = $(\"<input type='file' class='input-ghost' style='visibility:hidden; height:0'>\");\r\n");
      out.write("                        element.attr(\"name\",$(this).attr(\"name\"));\r\n");
      out.write("                        element.change(function(){\r\n");
      out.write("                            element.next(element).find('input').val((element.val()).split('\\\\').pop());\r\n");
      out.write("                        });\r\n");
      out.write("                        $(this).find(\"button.btn-choose\").click(function(){\r\n");
      out.write("                            element.click();\r\n");
      out.write("                        });\r\n");
      out.write("                        $(this).find(\"button.btn-reset\").click(function(){\r\n");
      out.write("                            element.val(null);\r\n");
      out.write("                            $(this).parents(\".input-file\").find('input').val('');\r\n");
      out.write("                        });\r\n");
      out.write("                        $(this).find('input').css(\"cursor\",\"pointer\");\r\n");
      out.write("                        $(this).find('input').mousedown(function() {\r\n");
      out.write("                            $(this).parents('.input-file').prev().click();\r\n");
      out.write("                            return false;\r\n");
      out.write("                        });\r\n");
      out.write("                        return element;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            );\r\n");
      out.write("        }\r\n");
      out.write("         \r\n");
      out.write("        bs_input_file();\r\n");
      out.write("         \r\n");
      out.write("        $(\"#uploadBtn\").on(\"click\", function() {\r\n");
      out.write("            var url = \"demo\";\r\n");
      out.write("            var form = $(\"#sampleUploadFrm\")[0];\r\n");
      out.write("            var data = new FormData(form);\r\n");
      out.write("            /* var data = {};\r\n");
      out.write("            data['key1'] = 'value1';\r\n");
      out.write("            data['key2'] = 'value2'; */\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                type : \"POST\",\r\n");
      out.write("                encType : \"multipart/form-data\",\r\n");
      out.write("                url : url,\r\n");
      out.write("                cache : false,\r\n");
      out.write("                processData : false,\r\n");
      out.write("                contentType : false,\r\n");
      out.write("                data : data,\r\n");
      out.write("                success : function(msg) {\r\n");
      out.write("                    var response = JSON.parse(msg);\r\n");
      out.write("                    var status = response.status;\r\n");
      out.write("                    if (status == 1) {\r\n");
      out.write("                        alert(\"File has been uploaded successfully\");\r\n");
      out.write("                    } else {\r\n");
      out.write("                        alert(\"Couldn't upload file\");\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                error : function(msg) {\r\n");
      out.write("                    alert(\"Couldn't upload file\");\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("//Get the button\r\n");
      out.write("var mybutton = document.getElementById(\"myBtn\");\r\n");
      out.write("\r\n");
      out.write("// When the user scrolls down 20px from the top of the document, show the button\r\n");
      out.write("window.onscroll = function() {scrollFunction()};\r\n");
      out.write("\r\n");
      out.write("function scrollFunction() {\r\n");
      out.write("  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {\r\n");
      out.write("    mybutton.style.display = \"block\";\r\n");
      out.write("  } else {\r\n");
      out.write("    mybutton.style.display = \"none\";\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// When the user clicks on the button, scroll to the top of the document\r\n");
      out.write("function topFunction() {\r\n");
      out.write("  document.body.scrollTop = 0;\r\n");
      out.write("  document.documentElement.scrollTop = 0;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("soli");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listSol}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
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
          out.write("                 \n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${soli.getFechaCreacion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <!--<td></td>--> \n");
          out.write("                        <!--<td></td>-->\n");
          out.write("                        <!--<td></td>-->\n");
          out.write("                        \n");
          out.write("\n");
          out.write("                    </tr>   \n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
