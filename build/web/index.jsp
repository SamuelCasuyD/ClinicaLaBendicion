<%-- 
    Document   : index
    Created on : 15/05/2021, 09:35:34 AM
    Author     : SammyKazzu
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">              
        <title>Login</title>
    </head>
    <body>        
        <div class="container mt-4 col-lg-4">  
            <div class="card col-lg-10">
                <div class="card-body">
                    <form class="form-sign" action="UsuarioController" method="POST">
                        <div class="form-group text-center">
                            <h3>Login</h3>
                            <img src="img/user.jpg" width="150px" alt=""/><br>
                            <label>Bienvenidos al Sistema</label>
                        </div>  
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" name="txtuser" class="form-control" placeholder="Ingrese usuario">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="txtpass" class="form-control" placeholder="Ingrese contraseña">
                        </div>
                        <input type="submit" name="accion" class="btn btn-primary btn-b">
                    </form>
                    
                    <%          
                         
                        if (request.getAttribute("v") != null){
                           
                            if (request.getAttribute("v") == "1") {
                                
                                
                                HttpSession ses = request.getSession();
                                ses.setMaxInactiveInterval(60 * 60);
                                ses.setAttribute("s1", request.getAttribute("usuario"));
                                ses.setAttribute("nombreUsuario", request.getAttribute("nombre"));
                                ses.setAttribute("primerApellido", request.getAttribute("apellido"));
                                ses.setAttribute("EntityID", request.getAttribute("idUsuario"));
                                
                                response.sendRedirect("Principal.jsp");
                            } else {
                                out.println("<br>Credenciales incorrectas");
                            }
                         }
                    %>
                </div>                
            </div>
        </div>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
