<%-- 
    Document   : SolicitudesAsignadas
    Created on : 19/06/2021, 01:44:47 PM
    Author     : Alexander Elias
--%>
<%@include file="HeaderAnalista.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ses.setAttribute("nobmre", ses.getAttribute("nombreUsuario"));
    ses.setAttribute("apellido", ses.getAttribute("primerApellido"));
    ses.setAttribute("idUsuario", ses.getAttribute("EntityID"));
    ses.setAttribute("cantSolicitud", ses.getAttribute("solicitudes"));
%>

<div class="container-fluid mt-4"  id="tabla" >
    <div class="card">
        <h4 class="card-header">Mis solicitudes </h4>  
        <hr>
        ${mensaje} 
        <div class="card-body">
            <table id="example" class="table table-bordered table-striped small">
                <thead align="center">
                <th style="text-align: center">#</th>
                <th class="text-center">Codigo Solicitud</th>
                <th class="text-center">Estado Solicitud</th>
                <th class="text-center">Enviado por</th>
                <th class="text-center">Fecha y hora de estado</th>
                <th class="text-center">Opciones</th>


                </thead>


                <tbody align="center">
                    <%! int contador = 1;%>
                    <c:forEach var="tbz" items="${trazabilidad}">
                        <tr>
                            <td style="text-align: center"><%= contador%></td>
                            <td>${tbz.getCodigoSolicitud()}</td>
                            <td>${tbz.getNombreEstadoSolicitud()}</td>                             
                            <td>${tbz.getUsuraioModificacion()}</td>
                            <td>${tbz.getFechaModificaion()}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Opciones
                                    </button>

                                    <div class="dropdown-menu dropdown-menu-right"> 

                                        <a href="AsignarSolicitudesController?menu=Editar&idSolicitud=${tbz.getIdSolicitud()}" class="dropdown-item" role="button" aria-pressed="true">ASD</a>                              
                                        <a href="AsignarSolicitudesController?menu=Analisis&codSolicitud=${tbz.getCodigoSolicitud()}&estadoSolicitud=${tbz.getEstadoSolicitud()}" class="dropdown-item" role="button" aria-pressed="true">Análisis</a>                              
                                        <a href="AsignarSolicitudesController?menu=Espera&codSolicitud=${tbz.getCodigoSolicitud()}&estadoSolicitud=${tbz.getEstadoSolicitud()}" class="dropdown-item" role="button" aria-pressed="true">Espera</a>                              
                                        <a href="AsignarSolicitudesController?menu=Revision&codSolicitud=${tbz.getCodigoSolicitud()}&estadoSolicitud=${tbz.getEstadoSolicitud()}" class="dropdown-item" role="button" aria-pressed="true">Revisión</a>                              
                                        <a href="AsignarSolicitudesController?menu=Rechazar2&codSolicitud=${tbz.getCodigoSolicitud()}&estadoSolicitud=${tbz.getEstadoSolicitud()}&usuarioCreacion=${tbz.getUsuarioCreacion()}" class="dropdown-item" role="button" aria-pressed="true">Rechazar</a>                              
                                        <a href="AsignarSolicitudesController?menu=Autorizar&codSolicitud=${tbz.getCodigoSolicitud()}&estadoSolicitud=${tbz.getEstadoSolicitud()}&usuarioCreacion=${tbz.getUsuarioCreacion()}" class="dropdown-item" role="button" aria-pressed="true">Autorizar</a>   

                                    </div>
                                </div> 
                            </td>
                        </tr>   

                        <% contador++; %>   
                    </c:forEach>    
                    <% contador = 1;%> 
                    
                </tbody>
            </table>  
        </div>  
    </div> 
</div>


              
            
<%@include file="footer.jsp" %>