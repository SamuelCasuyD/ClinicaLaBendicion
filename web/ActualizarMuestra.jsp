<%-- 
    Document   : ActualizarMuestra
    Created on : May 19, 2021, 11:33:15 PM
    Author     : SammyKazzu
--%>

<%@include file="Header.jsp" %>
    <div class ="container mt-6 col-md-8 col-xl-6 p-0" style="padding-top: 20px">
        <div class="form-group">
            <h3 align="center" class="col-12">Modificar Muestra</h3>
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
                                    <option value="${datoMu.getIdTipoMuestra()}">${mu.getTipoMuestra()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                        
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-12">
                                    <label >Presentación</label>
                                    <input type="text" name="TxtPresentacion" class="form-control" placeholder="Ingrese informacion"  rows="3" value="${datoMu.getPresentacion()}" />
                                    <input type="text" name="idmuestra" class="form-control" value="${datoMu.getIdMuestra()}" hidden="" />
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="row">
                                <div class="col-12 col-md-12">
                                    <label for="">Cantidad unidades</label>
                                    <input type="text" name="cantidad" class="form-control" placeholder="0001" autocomplete="off" maxlength="4" value="${datoMu.getCantidadUnidades()}">
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="row">
                                <div class="col-12 col-md-12">
                                    <label for="">Unidad de Medida</label>
                                    <select name="unidadmedida" class="form-control" required="" >
                                        <c:forEach var="me" items="${medida}">
                                            <option value="${datoMu.getIdUnidadMedida()}">${me.getUnidadMedida()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="btn-group" role="group" aria-label="Basic example" style="text-align: center">
                            <button type="submit" name="menu" value="EditarMuestra" class="btn btn-outline-secondary btn-md" >
                                <i class="fas fa-save fa-lg"> </i> Guardar
                            </button>        
                            
                            <a class="btn btn-outline-secondary btn-md" href="MuestrasController?menu=analisis">
                                <i class="fas fa-window-close fa-lg"> </i> 
                                Cancelar
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
                                    
<%@include file="footer.jsp" %>