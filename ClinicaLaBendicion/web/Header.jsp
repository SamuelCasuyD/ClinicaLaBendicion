<%-- 
    Document   : Header
    Created on : May 15, 2021, 12:28:26 PM
    Author     : SammyKazzu
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.24/datatables.min.css"/>
        <title>Clinica Medica</title>
    </head>
    <body>
        <%
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
        %>      
        
        <div class="container-fluid" style="padding-left: 0px; padding-right: 0px;">
            
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="dropdown">
                    <button style="border: none;" class="btn btn-outline-light dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <% out.println(ses.getAttribute("nombreUsuario"));
                        out.println(ses.getAttribute("primerApellido"));%>
                    </button>
                    <div class="dropdown-menu text-center">
                        <a class="dropdown-item" href="#">
                            <img src="img/user.jpg" alt="" width="60" height="60"/>
                        </a> 
                        <a class="dropdown-item" href="#"></a>
                        <a class="dropdown-item" href="#"><%out.println(ses.getAttribute("s1"));%></a>
                        <div class="dropdown-divider"></div>
                        <form action="Validar" method="POST">
                            <a name="accion" value="Salir" class="dropdown-item" href="#" Role="">
                                
                                <%out.println("<a href=bienvenido.jsp?c=1 style='text-decoration:none;' role='button'><i class='fas fa-sign-in-alt'> </i> Salir</a>");%>
                            </a>
                        </form>
                    </div>
                </div>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" role="button" href="MuestrasController?menu=principal">
                                <i class="fa fa-home" aria-hidden="true"> </i> INICIO</a>
                        </li>
                
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="MuestrasController?menu=analisis">Análisis de Muestra</a>
                        </li>
                
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=clasificacion">Clasificación</a>
                        </li>
                
                        <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="SolicitudesController?menu=mantenimiento">Mantenimiento de Solicictudes</a>
                        </li>
                    </ul>      
                </div>
            </nav>