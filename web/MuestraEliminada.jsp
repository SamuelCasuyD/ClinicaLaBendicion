<%-- 
    Document   : MuestraEliminada
    Created on : May 15, 2021, 10:46:03 PM
    Author     : SammyKazzu
--%>
<%@include file="Header.jsp" %>
<div class="container ">
    <div class="card">
        <h5 class="card-header">Muestras Eliminadas</h5>
        <div class="card-body">
                
                <div class="btn-group" role="group" aria-label="Basic example">
                    <a href="MuestrasController?menu=CrearMuestra" class="btn btn-outline-info" role="button" aria-pressed="true">Crear Muestra</a>
                    <a href="MuestrasController?menu=analisis" class="btn btn-outline-info" role="button" aria-pressed="true">Listar Muestras</a>
                </div>                
                <hr>
                
                <table id="example" class="table table-bordered table-striped small">
                    <thead>
                        <tr>
                            <th style="text-align: center">#</th>
                            <th>ID Muestra</th>
                            <th>Tipo de Muestra</th>
                            <th>Presentación</th>
                            <th>Cantidad</th>
                            <th>Medida</th>
                            <th>Adjunto</th>
                            <th>Fecha Creación</th>
                            <th>Fecha Modificacion</th>
                            <th style="text-align: center">Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%! int contador = 1;%>
                        <c:forEach var="list" items="${eliminada}">
                            
                        <tr>
                            <td style="text-align: center"><%= contador%></td>
                            <td>${list.getNumMuestra()}</td>
                            <td>${list.getIdTipoMuestra()}</td>
                            <td>${list.getPresentacion()}</td>
                            <td>${list.getCantidadUnidades()}</td>
                            <td>${list.getIdUnidadMedida()}</td>
                            <td>${list.getAdjunto()}</td>
                            <td>${list.getFechaCreacion()}</td>
                            <td>${list.getFechaModificacion()}</td>
                            <td style="text-align: center">
                                <div class="btn-group" role="group" aria-label="Basic example">
                                    <a href="MuestrasController?menu=RestaurarMuestra&id=${list.getIdMuestra()}" class="btn btn-outline-secondary btn-sm" role="button" aria-pressed="true" data-toggle="tooltip" title="Restaurar">
                                        <i class="fas fa-undo-alt"></i>
                                    </a>
                                    <a href="Consultas?accion=EliminarMuestra&id=${list.getIdMuestra()}" class="btn btn-outline-secondary btn-sm" role="button" aria-pressed="true" data-toggle="tooltip" title="Editar">
                                        <i class="far fa-edit"></i>
                                    </a>
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