<%-- 
    Document   : AnalisisSolicitudes
    Created on : 25/05/2021, 09:52:44 PM
    Author     : Alexander Elias
--%>

<%@include file="Header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--*******************************************************************-->
<div class="container-fluid mt-4"  id="tabla" >
    <div class="card">
         <h4 class="card-header">Solicitudes Medicas</h4>   
        <div class="card-body">
            <table id="example" class="table table-bordered table-striped small">
                <thead style="font-size: 13px">
                <th class="text-center">Código solicitud</th>
                <th class="text-center">No. expediente</th>
               
               
               
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
                <th class="text-center">Opciones</th>
               
                </thead>


                <tbody style="font-size: 13px">

                    <c:forEach var="soli" items="${listSol}">
                    <input type="hidden" id="muestraTabla" value="${soli.getCodigoSolicitud()}">
                    <tr>
                        <td>${soli.getCodigoSolicitud()}</td>
                        <td>${soli.getNumExpediente()}</td>
                      
                        
                      
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
                        

                    </tr>   
                </c:forEach>                        
                </tbody>
            </table>  
        </div>  
    </div> 
</div>
<!--*******************************************************************-->
<%@include file="footer.jsp" %>
