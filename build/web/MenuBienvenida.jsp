<%-- 
    Document   : MenuBienvenida
    Created on : 19/06/2021, 12:36:44 AM
    Author     : Alexander Elias
--%>
<%
    HttpSession ses = request.getSession();
    
    int idRol = (int) ses.getAttribute("rol");

    if (idRol == 1) {
        out.println("Administrador");
        response.sendRedirect("Principal.jsp");
    }
    if (idRol == 2) {
        out.println("Centralizador");
        response.sendRedirect("menuCentralizador.jsp");
    }
    if (idRol == 3) {
        out.println("Centralizador");
        response.sendRedirect("menuAnalista.jsp");
    }
%>      



