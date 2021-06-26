<%-- 
    Document   : CrearSolicitud
    Created on : 16/05/2021, 01:29:50 AM
    Author     : Alexander Elias
--%>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%@include file="Header.jsp" %>
<div class="container col-8 p-3">
    <div class=" row">
        <div class="col-12">
            <!--***********************************Formulario multiple******************************************-->
            <style>
                #regiration_form fieldset:not(:first-of-type) {
                    display: none;
                }
            </style>
            <%
                ses.setAttribute("nobmre", ses.getAttribute("nombreUsuario"));
                ses.setAttribute("apellido", ses.getAttribute("primerApellido"));
                ses.setAttribute("idUsuario", ses.getAttribute("EntityID"));


            %> 

            <div class="container col-sm-12 p-3">
                <div class="card col-sm-12">
                    <div class="card-body col-sm-12">

                        <div class="progress">
                            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>

                        <form id="regiration_form"  action="ExpedientesController"  method="POST">
                            <!--**********************************************************************************************************-->
                            <fieldset>
                                <h3>Paso 1: Crear solicitud médica</h3>
                                <div class="form-group">   
                                    <div class="row">                                                               
                                        <div class="col-sm-6">
                                            <label for="slcTpolicitante">Tipo de Solicitante</label>
                                            <select name="slcTpolicitante" class="form-control" >
                                                <c:forEach var="TS" items="${tipoSolicitante}">
                                                    <option value="${TS.getIdTipoSolicitnate()}">${TS.getNombreTipoSolicitante()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-sm-6">
                                            <label for="slcTpolicitud">Tipo solicitud</label>
                                            <select name="slcTpolicitud" class="form-control" >
                                                <c:forEach var="TSd" items="${TipoSolicitud}">
                                                    <option value="${TSd.getIdTipoSolicitud()}">${TSd.getNombreTipoSolicitud()}</option>
                                                </c:forEach>
                                            </select>   
                                        </div>
                                        <div class="col-6">
                                            <label for="Descripcion">Descripción</label>
                                            <textarea name="Descripcion" rows="4" cols="50" class="form-control" maxlength="2000" required="">            
                                            </textarea>
                                        </div>

                                        <div class="col-6">
                                            <label for="txtNoExpediente">Número de expediente</label>
                                            <div class="row">                                                               
                                                <div class="col-sm-8">
                                                    <input type="text" required="" class="form-control" name="txtNoExpediente" placeholder="0000-00-00-01-0000000" onkeyup="this.value = mascara(this.value)" maxlength="24" value="${expediente.getNoExpediente()}" autocomplete="off">

                                                    ${mensaje}                                                           
                                                </div>
                                                <div class="col-sm-4">                                                            
                                                    <input type="submit" name="menu" value="Buscar" class="btn btn-primary btn-b">
                                                </div>  
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="txtNit">NIT</label>
                                            <input type="text" class="form-control" name="txtNit" disabled="" value="${expediente.getNit()}" required="">
                                            <input type="hidden" class="form-control" name="Nit" value="${expediente.getNit()}">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="txtNombre">Nombre</label>                                                    
                                            <input type="text" class="form-control" name="txtNombre" disabled="" value="${nombre}" required="">
                                            <input type="hidden" class="form-control" name="Nombre" value="${nombre}">
                                        </div>
                                    </div>
                                </div>

                                <input type="button" name="password" class="next btn btn-success" value="Siguiente"/>
                                <a href="SolicitudesController?menu=mantenimiento" class="btn btn-danger">Cancelar</a> 
                            </fieldset>

                            <!--**********************************************************************************************************-->

                            <!--**********************************************************************************************************-->
                            <fieldset>

                                <h3>Paso 3: Soporte y contácto</h3>
                                <hr>
                                <h6>Tipo de soporte</h6>
                                <hr>


                                <div class="form-group">                                            
                                    <select name="Soporte" class="form-control" >
                                        <optgroup label="Interno">
                                            <c:forEach var="Tsoporte" items="${SoporteInt}">
                                                <option value="${Tsoporte.getIdSoprte()}">${Tsoporte.getNombreSoporte()}</option>
                                            </c:forEach>
                                        </optgroup>
                                        <optgroup label="Externo">
                                            <c:forEach var="TsoporteExt" items="${SoporteExt}">
                                                <option value="${TsoporteExt.getIdSoprte()}">${TsoporteExt.getNombreSoporte()}</option>
                                            </c:forEach>
                                        </optgroup>
                                    </select>                                            
                                </div>

                                <!**********************************************************************************************************>


                                <div class="form-group">
                                    <label for="txtSoporte">Número de soporte</label>
                                    <input type="text" class="form-control" name="txtSoporte" placeholder="Numero de soporte">
                                </div>

                                <div class="row">  
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="txtNoTel">Teléfono</label>
                                            <input type="text" class="form-control" name="txtNoTel" placeholder="Número de teléfono">
                                        </div>
                                    </div> 
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="txtGmail">Email</label>
                                            <input type="email" class="form-control" name="txtGmail" placeholder="example@gmail.com">
                                            <input type="hidden" name="txtEstado" value="1">
                                        </div>
                                    </div>                                            
                                </div>   

                                <br><input type="button" name="previous" class="previous btn btn-warning" value="Regresar" />
                                <input type="submit" name="menu" class="submit btn btn-success" value="Siguiente" />
                                <a href="SolicitudesController?menu=mantenimiento" class="btn btn-danger">Cancelar</a> 
                            </fieldset>
                            <!--**********************************************************************************************************-->
                        </form>

                    </div>
                </div>
            </div>
            <!--************************Fin formulario*******************************-->
        </div>
    </div>
</div>
<!--*************************************Fin Modal****************************************-->



<input type="hidden" id="activModal" value="${exp.getCodigoSolicitud()}">



<div class="modal fade" id="mostrarmodal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">         

                <div class="alert alert-success"><h3 align="center">Se creó con exito la solicitud médica</h3></div>
            </div>
            <div class="modal-body">
                <h2 align="center">Su número de solicitud es:</h2>  
                <h1 align="center"><b>${exp.getCodigoSolicitud()}</b></h1>
            </div>
            <div class="modal-footer">

                <a href="Controlador?menu=mantenimiento" data-dismiss="modal" class="btn btn-success">Aceptarr</a>
            </div>
        </div>
    </div>
</div>

<!--***********************************Finaliza Modal para ingreso de datos******************************************-->

<script>


    if ($('#activModal').val().length > 0) {

        $(document).ready(function ()
        {
            $("#mostrarmodal").modal("show");
        });

    }




    $(document).ready(function () {

        var current = 1, current_step, next_step, steps;
        steps = $("fieldset").length;
        $(".next").click(function () {
            current_step = $(this).parent();
            next_step = $(this).parent().next();
            next_step.show();
            current_step.hide();
            setProgressBar(++current);
        });

        $(".previous").click(function () {
            current_step = $(this).parent();
            next_step = $(this).parent().prev();
            next_step.show();
            current_step.hide();
            setProgressBar(--current);
        });

        setProgressBar(current);
        // Change progress bar action
        function setProgressBar(curStep) {
            var percent = parseFloat(100 / steps) * curStep;
            percent = percent.toFixed();
            $(".progress-bar")
                    .css("width", percent + "%")
                    .html(percent + "%");
        }
    });

    function mascara(valor) {

        if (valor.match(/^\d{4}$/) !== null) {

            return valor + '-';

        } else if (valor.match(/^\d{4}\-\d{2}$/) !== null) {

            return valor + '-';

        } else if (valor.match(/^\d{4}\-\d{2}\-\d{2}$/) !== null) {

            return valor + '-';

        } else if (valor.match(/^\d{4}\-\d{2}\-\d{2}\-\d{2}$/) !== null) {

            return valor + '-';

        }
        return cadena;
    }



</script>
<%@include file="footer.jsp" %>