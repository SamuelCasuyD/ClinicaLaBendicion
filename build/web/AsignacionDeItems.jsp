<%--
    Document   : AsignacionDeItems
    Created on : May 22, 2021, 8:05:13 AM
    Author     : SammyKazzu
--%>

<%@include file="Header.jsp" %>
<div class="container mt-4">    
    <div class="card">
        <h6 class="card-header">Vincular Items</h6>
        <div class="card-body">
            
            <form action="MuestrasController" method="POST">
                <div class="form-row">

                    <div class="input-group col">
                        <input class="form-control col"  type="text" name="solicitudM" aria-label="Recipient's username" aria-describedby="button-addon2" value="${soli.getCodigoSolicitud()}" placeholder="No. Solicitud Medica" />
                        <div class="input-group-append">
                            <button class="btn btn-outline-primary" type="submit" name="menu" value="AsignarItems" id="button-addon2">
                                <i class="fa fa-search"></i> Buscar
                            </button>
                        </div>
                    </div> 

                    <div class="input-group col" >
                        <input class="form-control col" type="text" name="muestraM" aria-label="Recipient's username" aria-describedby="button-addon2" value="${asItem.getNumMuestra()}" placeholder="No. Muestra Medica" />
                        <div class="input-group-append">
                            <button class="btn btn-outline-primary" type="submit" name="menu" value="AsignarItems" id="button-addon2">
                                <i class="fa fa-search"></i> Buscar
                            </button>
                        </div>
                    </div>  
                </div>
                        
                <div class="col-12" style="padding-top: 10px; text-align: right">
                    <div class="btn-group" role="group" aria-label="Basic example" style="text-align: center">
                        <button type="submit" name="menu" value="NewMuestras" class="btn btn-outline-secondary btn-md" >
                            <i class="fas fa-save fa-lg"> </i> Guardar
                        </button>                           
                        <a class="btn btn-outline-secondary btn-md" href="MuestrasController?menu=analisis">
                            <i class="fas fa-window-close fa-lg"> </i> Cancelar
                        </a>
                    </div>
                </div>
            
                <hr>
            
                <div class="row" >
                    <div class="col-12">
                        <table id="example" class="table table-bordered table-striped small">
                            <thead>
                                <tr>
                                    <th style="text-align: center">#</th>
                                    <th>Check </th>
                                    <th>Id Items</th>
                                    <th>Nombre Items</th>                            
                                </tr>
                            </thead>
                            <tbody>
                            <%! int contador = 1;%>
                            <c:forEach var="list" items="${itemsList}">
                                <tr> 
                                    <td style="text-align: center"><%= contador%></td>
                                    <td>
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="tableDefaultCheck2">
                                            <label class="custom-control-label" for="tableDefaultCheck2">Check</label>
                                        </div>
                                    </td>
                                    <td>${list.getIdItems()}</td>
                                    <td>${list.getNombreItems()}</td>
                                </tr>
                                <% contador++; %>   
                            </c:forEach>
                            <% contador = 1; %>
                            </tbody>
                        </table>     
                    </div>
                </div>   
            </form>
                            
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>