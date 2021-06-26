<%-- 
    Document   : AsignarEstados
    Created on : 22/06/2021, 06:46:55 PM
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

<div class="container-fluid mt-4 col-8"  id="tabla" >
    <div class="card">
        <h4 class="card-header">Cambiar estado</h4>  
        <hr>
        ${mensaje} 
        <div class="card-body ">
            <form class="form-sign" action="AsignarSolicitudesController" method="POST">                
                <div class="form-group" > 
                    <div class="row"> 
                        <!--********************************************************************************************************-->
                        <div class="col-4">                                    
                            <div class="form-group">
                                <label for="">Codigo Solicitud</label>
                                <input type="text" class="form-control" name="txtSolicitud" value="${solicitud.getCodigoSolicitud()}" autocomplete="off"> 

                            </div>  
                        </div>
                        <!--********************************************************************************************************-->
                        <div class="col-4"> 
                            <div class="form-group">
                                <label for="">Estado actual</label>
                                <input type="text" value="${solicitud.getNombreEstadoSolicitud()}" class="form-control" name="estadoActual" placeholder="">                                  
                            </div>
                        </div>  
                        <div class="col-4"> 
                            <div class="form-group">
                                <label for="">Nuevo estado</label>
                                <input type="text" value="${solicitud.getNombreEstadoSolicitud()}" class="form-control" name="nuevoEstado" placeholder="">                                  
                            </div>
                        </div>  
                    </div>  

                </div>  
                <!--********************************************************************************************************-->
                <!--********************************************************************************************************-->
                <div class="form-group" > 
                    <div class="row">  
                        <div class="col-6"> 

                            <div class="form-group">
                                <label for="Descripcion">Descripción</label>
                                <textarea name="Descripcion" rows="4"  cols="50" class="form-control" maxlength="2000" required=""> 
                                    ${solicitud.getDescripcion()}
                                </textarea>                                       
                            </div>
                        </div> 

                        <div class="col-6"> 

                            <div class="form-group">
                                <label for="Descripcion">Observaciones</label>
                                <textarea name="Observaciones" rows="4"  cols="50" class="form-control" maxlength="2000" required=""> 
                                         
                                </textarea>                                       
                            </div>
                        </div>                          

                    </div> 
                </div> 
                <div class="btn-group" role="group" aria-label="Basic example">
                     <input type="hidden" name="menu" value="${solicitud.getEstadoSolicitud()}">
                     <input type="hidden" name="estado" value="${solicitud.getEstadoSolicitud()}">
                     <input type="submit" name="accion" value="Siguiente" class="btn btn-outline-info"> 
                    <input type="reset" class="btn btn-outline-info" value="Cancelar"> 
                </div> 
            </form>
        </div>

    </div>  
</div> 



<%@include file="footer.jsp" %><div class="btn-group" role="group" aria-label="Basic example">



