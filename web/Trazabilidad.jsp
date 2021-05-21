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
                    <th class="text-center">Codigo Solicitud</th>
                    <th class="text-center">Estado Solicitud</th>
                    <th class="text-center">Enviado por</th>
                    <th class="text-center">Fecha y hora de estado</th>
                    <th class="text-center">Duración</th>                    
                    <th class="text-center">Asignado a</th>
                                   
                </thead>


                <tbody align="center">

                    <c:forEach var="exp" items="${expedientes}">
                     <tr>
                        <td>${exp.getNoExpediente()}</td>
                        <td>${exp.getObservaciones()}</td>
                        <td>${exp.getOrigen()}</td>
                        <td>${exp.getOrigen()}</td>
                       
                    </tr>   
                </c:forEach>                        
                </tbody>
            </table>  
        </div>  
    </div> 
</div>
              
<%@include file="footer.jsp" %>


