package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Trazabilidad_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 int contador = 1;
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--*****************************************Tabla de datos***************************************************************-->\r\n");
      out.write("<div class=\"container-fluid mt-4\"  id=\"tabla\" >\r\n");
      out.write("    <div class=\"card\">\r\n");
      out.write("         <h4 class=\"card-header\">Trazabilidad</h4>        \r\n");
      out.write("        <div class=\"card-body\">\r\n");
      out.write("            <table id=\"example\" class=\"table table-bordered table-striped small\">\r\n");
      out.write("                <thead align=\"center\">\r\n");
      out.write("                     <th style=\"text-align: center\">#</th>\r\n");
      out.write("                    <th class=\"text-center\">Codigo Solicitud</th>\r\n");
      out.write("                    <th class=\"text-center\">Estado Solicitud</th>\r\n");
      out.write("                    <th class=\"text-center\">Enviado por</th>\r\n");
      out.write("                     <th class=\"text-center\">Asignado a</th>\r\n");
      out.write("                    <th class=\"text-center\">Fecha y hora de estado</th>\r\n");
      out.write("                    <th class=\"text-center\">Duración</th>  \r\n");
      out.write("                    <th class=\"text-center\">Acumulado</th> \r\n");
      out.write("                    <th class=\"text-center\">Observaciones</th>\r\n");
      out.write("                   \r\n");
      out.write("                   \r\n");
      out.write("                                   \r\n");
      out.write("                </thead>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <tbody align=\"center\">\r\n");
      out.write("                     ");
      out.write("\r\n");
      out.write("                    <c:forEach var=\"tbz\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${trazabilidad}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                     <tr>\r\n");
      out.write("                        <td style=\"text-align: center\">");
      out.print( contador);
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tbz.getCodigoSolicitud()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tbz.getNombreEstado()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tbz.getEnviadoPor()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tbz.getAsignadoA()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tbz.getFecha()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tbz.getDuracion()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tbz.getAcumulado()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tbz.getObservaciones()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                       \r\n");
      out.write("                    </tr>   \r\n");
      out.write("                    \r\n");
      out.write("                    ");
 contador++; 
      out.write("   \r\n");
      out.write("                </c:forEach>    \r\n");
      out.write("                ");
 contador = 1; 
      out.write("                    \r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>  \r\n");
      out.write("        </div>  \r\n");
      out.write("    </div> \r\n");
      out.write("</div>\r\n");
      out.write("              \r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
