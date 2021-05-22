<%-- 
    Document   : Trazabilidad
    Created on : 19/05/2021, 10:21:49 PM
    Author     : Alexander Elias
--%>

<%@include file="Header.jsp" %>
<!--*****************************************Tabla de datos***************************************************************-->
<div class="container-fluid mt-4"  id="tabla" >
    <div class="card">
         <h4 class="card-header">Trazabilidad</h4>        
        <div class="card-body">
            <table id="example" class="table table-bordered table-striped small">
                <thead align="center">
                     <th style="text-align: center">#</th>
                    <th class="text-center">Codigo Solicitud</th>
                    <th class="text-center">Estado Solicitud</th>
                    <th class="text-center">Enviado por</th>
                     <th class="text-center">Asignado a</th>
                    <th class="text-center">Fecha y hora de estado</th>
                    <th class="text-center">Duración</th>  
                    <th class="text-center">Acumulado</th> 
                    <th class="text-center">Observaciones</th>
                   
                   
                                   
                </thead>


                <tbody align="center">
                     <%! int contador = 1;%>
                    <c:forEach var="tbz" items="${trazabilidad}">
                     <tr>
                        <td style="text-align: center"><%= contador%></td>
                        <td>${tbz.getCodigoSolicitud()}</td>
                        <td>${tbz.getNombreEstado()}</td>
                        <td>${tbz.getEnviadoPor()}</td>
                        <td>${tbz.getAsignadoA()}</td>
                        <td>${tbz.getFecha()}</td>
                        <td>${tbz.getDuracion()}</td>
                        <td>${tbz.getAcumulado()}</td>
                        <td>${tbz.getObservaciones()}</td>
                       
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


