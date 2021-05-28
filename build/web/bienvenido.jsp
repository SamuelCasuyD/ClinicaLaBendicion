<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession ses =request.getSession();  
            
            if (ses.getAttribute("s1")!=null) {
                    out.println("Bienvenido al Sistema " + "<h1>"+ses.getAttribute("nombreUsuario")+"</h1>");
                }
            else{
                response.sendRedirect("index.jsp");
            }
            out.println("<br><a href=bienvenido.jsp?c=1>Cerrar</a>");
            
            if (request.getParameter("c")!=null) 
            {
                ses.invalidate();
                response.sendRedirect("index.jsp"); 
            }
        %>
        <br>
        <a href="prueba.jsp">Prueba</a>
    </body>
</html>