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
                    <th class="text-center">Opciones</th>
                </thead>
                <tbody align="center">
                     
                    <c:forEach var="exp" items="${expedientes}">
                    <%! int contador = 1;%>
                     <tr>
                       
                        <td style="text-align: center"><% out.println(contador); %></td>                         
                        <td>${exp.getNoExpediente()}</td>
                        <td>${exp.getObservaciones()}</td>
                        <td>${exp.getOrigen()}</td>
                        <td>
                            <div class="btn-group">
                                <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    opciones
                                </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#">Informacion General</a>
                                    <a class="dropdown-item" href="#">Expediente</a>
                                    <a class="dropdown-item" href="#">Trazabilidad</a>
                                </div>                                
                            </div>                            
                        </td>
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

