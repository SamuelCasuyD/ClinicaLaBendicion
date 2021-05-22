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
                        <a href="SolicitudesController?menu=informacionGeneral" class="btn btn-outline-info" role="button" aria-pressed="true">Informacion General</a> 
                        <a href="ExpedientesController?menu=expedientes" class="btn btn-outline-info" role="button" aria-pressed="true">Expediente</a> 
                        <a href="ExpedientesController?menu=muestras" class="btn btn-outline-info" role="button" aria-pressed="true">Muestras</a> 
                        <a href="TrazabilidadController?menu=trazabilidad" class="btn btn-outline-info" role="button" aria-pressed="true">Trazabilidad</a>
                        
                    </div>            
               <hr>
         
   
           </div>
</div>
</div>

<!--*******************************************************************-->
<div class="container-fluid mt-4"  id="tabla" >
    <div class="card">
         <h4 class="card-header">Información General</h4>   
        <div class="card-body">
            <table id="example" class="table table-bordered table-striped small">
                <thead style="font-size: 8px">
                <th class="text-center">Código solicitud</th>
                <th class="text-center">No. expediente</th>
                <th class="text-center">NIT</th>
                <th class="text-center">No. soporte</th>
                <th class="text-center">Tipo soporte</th>
                <th class="text-center">Tipo solicitante</th>

                <th class="text-center">Tipo solicitud</th>
                <th class="text-center">Usuario asignación</th>
                <th class="text-center">Estado solicitud</th>
                <th class="text-center">Usuario creación</th>
                <th class="text-center">Fecha creación</th>
                <!-- <th class="text-center">Cantidad muestras</th>--> 

                <!-- <th class="text-center">Cantidad ítems</th>--> 
                <!-- <th class="text-center">Cantidad documentos</th>--> 
                <th class="text-center">Descripción</th>
                <th class="text-center">Solicitante</th>
                <th class="text-center">Teléfonos</th>
                <th class="text-center">Emails</th>
                </thead>


                <tbody style="font-size: 8px">

                    <c:forEach var="soli" items="${listSol}">
                    <input type="hidden" id="muestraTabla" value="${soli.getCodigoSolicitud()}">
                    <tr>
                        <td>${soli.getCodigoSolicitud()}</td>
                        <td>${soli.getNumExpediente()}</td>
                        <td>${soli.getNit()}</td>
                        <td>${soli.getNumSoporte()}</td>    
                        <td>${soli.getNombreSoporte()}</td>
                        <td>${soli.getNombreTipoSolicitante()}</td>
                        <td>${soli.getNombreTipoSolicitud()}</td>
                        <td>${soli.getUsuarioAsignacion()}</td>  
                        <td>${soli.getNombreEstadoSolicitud()}</td>
                        <td>${soli.getUsuarioCreacion()}</td>
                        <td>${soli.getFechaCreacion()}</td>
                        <!--<td></td>--> 
                        <!--<td></td>-->
                        <!--<td></td>-->
                        <td>${soli.getDescripcion()}</td>
                        <td>${soli.getNombre()}</td>
                        <td>${soli.getTelefono()}</td>
                        <td>${soli.getEmail()}</td>

                    </tr>   
                </c:forEach>                        
                </tbody>
            </table>  
        </div>  
    </div> 
</div>
<!--*******************************************************************-->
<%@include file="footer.jsp" %>
