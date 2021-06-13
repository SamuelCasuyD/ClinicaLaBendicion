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
                        <input class="form-control col" type="text" name="NumSolicitud" id="NumSolicitud" aria-label="Recipient's username" aria-describedby="button-addon2" value="${BSoli.getCodigoSolicitud()}" placeholder="No. Solicitud Medica" required="" />
                        <%--   <div class="input-group-append">
                            <a class="btn btn-outline-primary" href="MuestrasController?menu=BuscarSolMe&NumSolicitud=${BSoli.getCodigoSolicitud()}"  id="button-addon2">
                                <i class="fa fa-search"></i> Buscar
                            </a>
                        </div> --%>
                    </div> 

                    <div class="input-group col" >
                        <input class="form-control col" type="text" name="txtMuestra" id="txtMuestra" aria-label="Recipient's username" aria-describedby="button-addon2" value="${Mtra.getNumMuestra()}" placeholder="No. Muestra Medica" required="" />
                        <div class="input-group-append">
                            <a class="btn btn-outline-primary"  href="MuestrasController?menu=AsignarItems&txtMuestra=${Mtra.getNumMuestra()}"  id="button-addon2">
                                <i class="fa fa-search"></i> Buscar
                            </a>
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
                                <%! int contador = 1;

                                %>
                                <c:forEach var="list" items="${itemsList}">
                                    <tr> 
                                        <td style="text-align: center"><%= contador%></td>
                                        <td>
                                            <div class="form-check"> 
                                                <input class="form-check-input" type="checkbox" value="${list.getIdItems()}" id="flexCheckDefault">
                                                <label class="form-check-label" for="flexCheckDefault">Check</label>
                                            </div>
                                        </td>
                                        <td>${list.getIdItems()}</td>
                                        <td>${list.getNombreItems()}</td>
                                    </tr>
                                    <% contador++; %>   
                                </c:forEach>
                                <% contador = 1;%>
                            </tbody>
                        </table>     
                    </div>
                </div>   
            </form>

        </div>
    </div>
</div>

<%@include file="footer.jsp" %>