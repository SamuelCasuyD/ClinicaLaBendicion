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

            <form action="AsignarItems" method="POST">




                <hr>
                ${msj}
                <div class="row" >
                    <div class="col-12">
                        <table  class="table table-bordered table-striped small">
                            <thead>
                                <tr>
                                    <th style="text-align: center">#</th>
                                    <th>Id Items</th>
                                    <th>Check Items</th>   
                                </tr>
                            </thead>
                            <tbody>
                                
                            <input type="hidden" name="idMuestra" value="${Muestra}">

                                <%! int contador = 1;

                                %>
                                <c:forEach var="list" items="${itemsList}">
                                    <tr> 
                                        <td style="text-align: center"><%= contador%></td>
                                        <td>${list.getIdItems()}</td>
                                        <td>
                                            <div class="form-check"> 
                                                <input class="form-check-input" name="items" type="checkbox" value="${list.getIdItems()}" id="flexCheckDefault">
                                                <label class="form-check-label" for="flexCheckDefault">${list.getNombreItems()}</label>
                                            </div>
                                        </td>
                                    </tr>
                                    <% contador++; %>   
                                </c:forEach>
                                <% contador = 1;%>

                            </tbody>
                        </table>     
                    </div>
                </div>   
                <div class="btn-group" role="group" aria-label="Basic example">
                    <input type="submit" name="menu" value="Buscar" class="btn btn-outline-info"> 
                    <input type="reset" class="btn btn-outline-info" value="Limpiar"> 
                </div> 
        </div>
        </form>

    </div>
</div>
</div>

<%@include file="footer.jsp" %>