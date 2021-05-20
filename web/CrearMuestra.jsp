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
                                    <label >Presentación</label>
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
<%@include file="footer.jsp" %>