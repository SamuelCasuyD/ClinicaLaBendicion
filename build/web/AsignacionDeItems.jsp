<%-- 
    Document   : AsignacionDeItems
    Created on : May 22, 2021, 8:05:13 AM
    Author     : SammyKazzu
--%>

<%@include file="Header.jsp" %>
<div class="container">
    <div class="card">
            <h5 class="card-header">Vincular Items</h5>
            <div class="card-body">
                
                <div class="btn-group" role="group" aria-label="Basic example">
                    <a href="MuestrasController?menu=CrearMuestra" class="btn btn-outline-info" role="button" aria-pressed="true">Crear Muestra</a>
                    <a href="MuestrasController?menu=MuestraEliminada" class="btn btn-outline-info" role="button" aria-pressed="true">Muestras Eliminadas</a>                    
                </div>                
                <hr>
                
                <table id="example" class="table table-bordered table-striped small">
                    <thead>
                        <tr>
                            <th style="text-align: center">#</th>
                            <th>ID Muestra</th>
                            <th>Tipo de Muestra</th>
                            <th>Presentación</th>
                            <th style="text-align: center">Cantidad</th>
                            <th>Medida</th>
                            <th>Adjunto</th>
                            <th>Fecha Creación</th>
                            <th>Items Asociados</th>
                            <th style="text-align: center">Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        <c:forEach var="list" items="${listMuestras}">
                        <%! int contador = 1;%>
                        <tr> 
                            <td style="text-align: center">${contador}</td>
                            <td>${list.getNumMuestra()}</td>
                            <td>${list.getIdTipoMuestra()}</td>
                            <td>${list.getPresentacion()}</td>
                            <td>${list.getCantidadUnidades()}</td>
                            <td style="text-align: center">${list.getIdUnidadMedida()}</td>
                            <td>${list.getAdjunto()}</td>
                            <td>${list.getFechaCreacion()}</td>
                            <td>${list.getIdSolicitudes()}</td>
                            <td style="text-align: center">
                                <div class="btn-group" role="group" aria-label="Basic example">
                                    <a href="MuestrasController?menu=EliminarMuestra&id=${list.getIdMuestra()}" class="btn btn-outline-secondary btn-sm" role="button" aria-pressed="true" data-toggle="tooltip" title="Eliminar">
                                        <i class="fas fa-trash-alt"></i>
                                    </a>
                                    <a href="MuestrasController?menu=CardarDatos&id=${list.getIdMuestra()}" class="btn btn-outline-secondary btn-sm" role="button" aria-pressed="true" data-toggle="tooltip" title="Editar">
                                        <i class="far fa-edit"></i>
                                    </a>
                                </div>
                            </td>
                            <% contador++; %>
                        </tr>
                        
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>    
</div>

<%@include file="footer.jsp" %>