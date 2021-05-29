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
                <div class="row">
                    <div class="col-12">                    
                        <div class="input-group" >
                            <input class="form-control" type="text" name="solicitudM" aria-label="Recipient's username" aria-describedby="button-addon2" placeholder="No. Solicitud Medica" />
                            <div class="input-group-append">
                                <button class="btn btn-outline-primary" type="submit" name="menu" value="AsignarItems" id="button-addon2">
                                    <i class="fa fa-search"></i> Buscar
                                </button>
                            </div>
                        </div>                    
                    </div>
                </div>
            </form>
            
            <hr>
            
            <div >
                <div class="col-12">
                  <table id="example" class="table table-bordered table-striped small">
                    <thead>
                        <tr>
                            <th style="text-align: center">#</th>
                            <th>ID </th>
                            <th>No. Solicitud</th>
                            <th>No. Expediente</th>
                            <th >Cliente</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%! int contador = 1;%>
                        <tr> 
                            <td style="text-align: center"><%= contador%></td>
                            <td>${soli.getIdSolicitud()}</td>
                            <td>${soli.getCodigoSolicitud()}</td>
                            <td>${soli.getNumExpediente()}</td>
                            <td>${soli.getNombre()}</td>
                        </tr>
                        <% contador++; %>                       
                        <% contador = 1; %>
                    </tbody>
                </table>     
                </div>
            </div>            
        </div>
    </div>   
 
</div>

<%@include file="footer.jsp" %>