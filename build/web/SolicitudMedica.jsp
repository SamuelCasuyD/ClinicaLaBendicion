<%-- 
    Document   : SolicitudMedica
    Created on : 16/05/2021, 12:50:24 AM
    Author     : Alexander Elias
--%>
<%@include file="Header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid mt-4">
    <div class="card">

        <h4 class="card-header">Mantenimiento</h4>                 
        
            <div class="card-body">
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <a href="SolicitudesController?menu=crearSolicitud" class="btn btn-outline-info" role="button" aria-pressed="true">Crear Solicitud</a>   
                        <a href="SolicitudesController?menu=consultaSolicitudes" class="btn btn-outline-info" role="button" aria-pressed="true">Consultar Solicitud</a> 
                     
                        
                        <a href="ExpedientesController?menu=muestras" class="btn btn-outline-info" role="button" aria-pressed="true">Muestras</a> 
                      
                        
                    </div>            
               <hr> 
         
   
           </div>
</div>
</div>

<!--*****************************************Tabla de datos***************************************************************-->
<div class="container-fluid mt-4"  id="tabla" >
    <div class="card">
         <h4 class="card-header">Lista de Solicitudes</h4>        
        <div class="card-body">
            <table id="example" class="table table-bordered table-striped small">
                 <thead style="font-size: 12px">
                <th style="text-align: center">No</th>
                <th class="text-center">Código solicitud</th>
                <th class="text-center">No. expediente</th>
                <th class="text-center">NIT</th>
                <th class="text-center">No. soporte</th>
                <th class="text-center">Tipo solicitante</th>
                <th class="text-center">Tipo solicitud</th>
                <th class="text-center">Usuario asignación</th>
                <th class="text-center">Estado solicitud</th>
                <th class="text-center">Usuario creación</th>
                <th class="text-center">Fecha creación</th>
                <th class="text-center">Opciones</th>
                </thead>
                  <tbody style="font-size: 10px">

                    <c:forEach var="soli" items="${listSol}">
                    <input type="hidden" id="muestraTabla" value="${soli.getCodigoSolicitud()}">
                    <%! int contador = 1;%>
                    <tr>
                        <td style="text-align: center"><% out.println(contador); %></td>  
                        <td>${soli.getCodigoSolicitud()}</td>
                        <td>${soli.getNumExpediente()}</td>
                        <td>${soli.getNit()}</td>
                        <td>${soli.getNumSoporte()}</td>                      
                        <td>${soli.getNombreTipoSolicitante()}</td>
                        <td>${soli.getNombreTipoSolicitud()}</td>
                        <td>${soli.getUsuarioAsignacion()}</td>  
                        <td>${soli.getNombreEstadoSolicitud()}</td>
                        <td>${soli.getUsuarioCreacion()}</td>
                        <td>${soli.getFechaCreacion()}</td>
                        <td>
                            <div class="btn-group">
                                <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Opciones
                                </button>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <button class="dropdown-item" type="button">Asociar</button>
                                    <button class="dropdown-item" type="button">Desasociar</button>
                                     <a href="TrazabilidadController?menu=Enviar&codSolicitud='${soli.getCodigoSolicitud()}'" class="dropdown-item" role="button" aria-pressed="true">Enviar</a>
                                    <a href="TrazabilidadController?menu=trazabilidad" class="dropdown-item" role="button" aria-pressed="true">Trazabilidad</a>
                                    <button class="dropdown-item" type="button">Eliminar</button>
                                    <a href="ExpedientesController?menu=expedientes&numExpediente='${soli.getNumExpediente()}'" class="dropdown-item" role="button" aria-pressed="true">Expediente</a> 
                                    <a href="SolicitudesController?menu=informacionGeneral" class="dropdown-item" role="button" aria-pressed="true">Informacion General</a> 
                                </div>
                            </div>                      
                        </td>

                    </tr> 
                    <% contador++; %>   
                </c:forEach>    
                <% contador = 1; %>      
                </tbody>
            </table>  
        </div>  
    </div> 
</div>
              
<%@include file="footer.jsp" %>
