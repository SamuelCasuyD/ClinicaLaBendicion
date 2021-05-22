<%-- 
    Document   : Expedientes
    Created on : 19/05/2021, 08:22:39 PM
    Author     : Alexander Elias
--%>

<%-- 
    Document   : ConsultaSolicitudes
    Created on : 16/05/2021, 01:45:00 AM
    Author     : Alexander Elias
--%>


<%@include file="Header.jsp" %>     

<!--*****************************************Tabla de datos***************************************************************-->
<div class="container-fluid mt-4"  id="tabla" >
    <div class="card">
         <h4 class="card-header">Expedientes</h4>        
        <div class="card-body">
            <table id="example" class="table table-bordered table-striped small">
                <thead align="center">
                     <th style="text-align: center">No</th>
                    <th class="text-center">Numero de Expediente</th>
                    <th class="text-center">Origen</th>
                    <th class="text-center">Observaciones</th>
                </thead>
                <tbody align="center">
                     
                    <c:forEach var="exp" items="${expedientes}">
                    <%! int contador = 1;%>
                     <tr>
                       
                        <td style="text-align: center"><% out.println(contador); %></td>                         
                        <td>${exp.getNoExpediente()}</td>
                        <td>${exp.getObservaciones()}</td>
                        <td>${exp.getOrigen()}</td>
                       
                    </tr>
                    <% contador++;%>
                    </c:forEach>   
                    <% contador = 1;%>
                </tbody>
            </table>  
        </div>  
    </div> 
</div>
              
<%@include file="footer.jsp" %>

