<%@include file="Header.jsp" %>
<div class="container">
    <div class ="container mt-6 col-md-8 col-xl-6 p-0" style="padding-top: 20px">
        <div class="form-group">
            <h3 align="center" class="col-12">Crear Muestra</h3>
        </div>
            <div class="card col-lg-12">
                <div class="card-body">

                    <form class="col-12" action="MuestrasController" method="POST">

                        <div class="form-group">
                            <div class="row">
                                <label for="slcMuestra">Tipo muestra</label>
                                <select id="slcMuestra" name="slcMuestra" class="form-control" >
                                        <option>--Seleccionar--</option>
                                        <c:forEach var="mu" items="${muestra}">
                                            <option value="${mu.getIdTipoMuestra()}">${mu.getTipoMuestra()}</option>
                                        </c:forEach>
                                </select>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-12">
                                    <label >Presentaci�n</label>
                                    <textarea name="TxtPresentacion" class="form-control" placeholder="Ingrese informacion"  required="" rows="3"></textarea>
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="row">
                                <div class="col-12 col-md-12">
                                    <label for="">Cantidad unidades</label>
                                    <input type="text" name="cantidad" class="form-control" placeholder="0001" autocomplete="off" maxlength="4">
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="row">
                                <div class="col-12 col-md-12">
                                    <label for="">Unidad de Medida</label>
                                    <select name="unidadmedida" class="form-control" required="" >
                                        <c:forEach var="me" items="${medida}">
                                            <option value="${me.getIdUnidadMedida()}">${me.getUnidadMedida()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" placeholder="Solicitud medica" aria-label="Recipient's username" aria-describedby="button-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="button" id="button-addon2" data-toggle="modal" data-target="#exampleModal">
                                    <i class="fa fa-search"></i> Buscar
                                </button>
                            </div>
                        </div>
                        
                        <div class="btn-group" role="group" aria-label="Basic example" style="text-align: center">
                            <button type="submit" name="menu" value="NewMuestras" class="btn btn-outline-secondary btn-md" >
                                <i class="fas fa-save fa-lg"> </i> Guardar
                            </button>                           
                            <a class="btn btn-outline-secondary btn-md" href="Controlador?menu=CrearUsuario&accion=Cancelar" target='myIframe'>
                                <i class="fas fa-window-close fa-lg"> </i> 
                                Cancelar
                            </a>
                        </div>
                    </form>
                </div>
            </div>
    </div>    
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Lista de Solicitudes</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table id="example" class="table table-bordered table-striped small">
                    <thead>
                        <tr>
                            <th style="text-align: center">#</th>
                            <th>ID Muestra</th>
                            <th>Tipo de Muestra</th>
                            <th>Presentaci�n</th>
                            <th>Cantidad</th>
                            <th>Medida</th>
                            <th>Adjunto</th>
                            <th>Fecha Creaci�n</th>
                            <th>Fecha Modificacion</th>
                            <th style="text-align: center">Acci�n</th>
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
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>


<%@include file="footer.jsp" %>