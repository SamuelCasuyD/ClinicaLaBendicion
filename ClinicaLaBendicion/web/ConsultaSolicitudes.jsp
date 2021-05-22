<%-- 
    Document   : ConsultaSolicitudes
    Created on : 16/05/2021, 01:45:00 AM
    Author     : Alexander Elias
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://momentjs.com/downloads/moment.js"></script>

<%@include file="Header.jsp" %>
<div class="container-fluid mt-4">
    <div class="card">
        <h5 class="card-header">Filtros de Búsqueda ${msj}</h5>
       
        <div class="card-body">
            <!--********************************************************************************************************-->
            <form action="SolicitudesController" method="POST">
            <div class="form-group" > 
                <div class="row">  
                    <!--********************************************************************************************************-->
                    <div class="col-2">                                    
                        <div class="form-group">
                            <label for="">Codigo Solicitud</label>
                            <input type="text" class="form-control" name="txtSolicitud" placeholder="AA-00000001-00002" autocomplete="off"> 
                           
                        </div>  
                    </div>
                    <!--********************************************************************************************************-->
                    <div class="col-3">  
                        <div class="form-group">
                            <label for="">Numero de Expediente</label>
                            <input type="text" class="form-control" name="txtExpediente" placeholder="">                                            
                        </div>  
                    </div>
                    <!--********************************************************************************************************-->
                    <!--********************************************************************************************************-->
                    <div class="col-2"> 

                        <div class="form-group">
                            <label for="">Numero de Soporte</label>
                            <input type="text" class="form-control" name="txtNoSoporte" placeholder="">                                       
                        </div>
                    </div>   
                    <!--********************************************************************************************************-->

                    <!--********************************************************************************************************-->
                    <div class="col-3"> 
                        <div class="form-group">
                            <label for="slcTpolicitud">Tipo solicitud</label>
                            <select name="slcTpolicitud" class="form-control" onchange="obtenersolicitud(this)">  
                                <option disabled selected>Seleccionar Tipo Solicitud</option>
                                <c:forEach var="TSd" items="${TipoSolicitud}">                                  
                                    <option value="${TSd.getIdTipoSolicitud()}">${TSd.getNombreTipoSolicitud()}</option>                                     
                                </c:forEach> 
                                    <input name="txtTiposolicitud" type="hidden" id="tSolicitud" >
                            </select> 
                            
                        </div>  
                    </div>   
                    <!--********************************************************************************************************-->
                    <!--********************************************************************************************************-->
                    <div class="col-2"> 

                        <div class="form-group">
                            <label for="">Nit</label>
                            <input type="text" class="form-control" name="txtNit" placeholder="">                                       
                        </div>
                    </div> 
                </div>
            </div>
            <!--**************************************************************************SEGUNDA FILA******************************-->
            <div class="form-group"> 
                <div class="row">
                    <div class="col-3"> 
                        <div class="form-group">
                            <label for="">Usuario Asignación</label>

                            <input type="text" disabled="" class="form-control" name="txtUsuario" placeholder="" value="<%out.println(ses.getAttribute("s1"));%>">                                            
                        </div>   
                    </div>
                    <div class="col-3"> 
                        <div class="form-group">
                            <label for="">Estado Solicitud</label>                                       
                            <select name="slcEstado" class="form-control" onchange="obteestado(this)"> 
                                 <option disabled selected>Seleccionar estado</option>
                                <c:forEach var="est" items="${estados}">
                                    <option value="${est.getIdEstado()}">${est.getNombreEstado()}</option>
                                </c:forEach>
                                    <input name="txtEstado" type="hidden" id="estados" >
                            </select>  
                            
                        </div>
                    </div>
                    <div class="col-3"> 
                        <div class="form-group">
                            <label for="">Fecha creacion (Desde)</label>
                            <input type="date" class="form-control" name="fecha1" placeholder=""  onchange="obtenerFecha1(this)"/> 
                            <input name="fechaInicio" type="hidden" id="fecha1" >
                             ${error}
                              
                        </div></div>
                    <div class="col-3"><div class="form-group">
                            <label for="">Fecha creacion (Hasta)</label>
                            <input type="date" class="form-control" name="fecha2" placeholder="" onchange="obtenerFecha2(this)"/>   
                            <input name="fechaFin" type="hidden" id="fecha2" >
                        </div>   
                    </div>

                </div>
            </div>
            <div class="btn-group" role="group" aria-label="Basic example">

               
                <input type="submit" name="menu" value="Buscar" class="btn btn-outline-info"> 
                <input type="reset" class="btn btn-outline-info" value="Limpiar"> 
            </div> 
            </form>
        </div> 
    </div> 
</div> 
<!--*****************************************Tabla de datos***************************************************************-->
<div class="container-fluid mt-4">
    <div class="card">
        <h5 class="card-header">Consulta Solicitudes Médicas</h5>
        <div class="card-body">
            <table id="example" class="table table-bordered table-striped small" style="font-size: 10px;">
                    <thead>
                    <th style="text-align: center">#</th>
                    <th class="text-center">Codigo Solicitud</th>                    
                    <th class="text-center">No. Expediente</th>
                    <th class="text-center">Nit</th>
                    <th class="text-center">No. Soporte</th>
                    <th class="text-center">Tipo Solicitud</th>
                    <th class="text-center">Usuario asignacion</th>
                    <th class="text-center">Estado</th>
                    <th class="text-center">Fecha Creacion</th>
                    <th class="text-center">Cantidad Muestras</th>
                    <th class="text-center">Cantidad Items</th>
                    <th class="text-center">Cantidad Doc</th>
                    <th class="text-center">Días vencimiento</th>
                    </thead>
                    <tbody>
                    <c:forEach var="sol" items="${Solicitudes}">
                         <%! int contador = 1;%>
                        <tr>
                            <td style="text-align: center"><% out.println(contador); %></td>
                            <td>${sol.getCodigoSolicitud()}</td>
                            <td>${sol.getNumExpediente()}</td>
                            <td>${sol.getNit()}</td>
                            <td>${sol.getNumSoporte()}</td>
                            <td>${sol.getNombreTipoSolicitud()}</td>
                            <td>${sol.getUsuarioAsignacion()}</td>
                            <td>${sol.getNombreEstadoSolicitud()}</td>
                            <td>${sol.getFechaCreacion()}</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                             
                        </tr> 
                        <% contador++;%>
                     </c:forEach> 
                        <% contador = 1;%>
                    </tbody>
                </table>
        </div>
    </div>    
</div>
   <script src="https://momentjs.com/downloads/moment.js"></script>
   <script>
       function obtenerFecha1(e)
        {
          var fecha = moment(e.value);
          
          var nuevafecha = fecha.format("DD-MM-YYYY");console.log(nuevafecha);
          document.getElementById("fecha1").value = nuevafecha;
          
        }
        
        function obtenerFecha2(e)
        {
          var fecha = moment(e.value);
          
          var nuevafecha = fecha.format("DD-MM-YYYY");    
          document.getElementById("fecha2").value = nuevafecha;
        }
        
        function obteestado(e)
        {
          
          var combo = (e.value);
          
          document.getElementById("estados").value=combo;
          
        }
        
        function obtenersolicitud(e)
        {
          
          var combo = (e.value);
          
          document.getElementById("tSolicitud").value=combo;
          
        }
        
        
        
          
   </script>
              
<%@include file="footer.jsp" %>
