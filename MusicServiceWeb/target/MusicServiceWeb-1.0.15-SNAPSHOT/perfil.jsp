<%-- 
    Document   : perfil
    Created on : 30/06/2013, 03:08:02 PM
    Author     : csolisr
--%>

<%@page import="com.somee.musicservicebl.BLWebService"%>
<%@page import="com.somee.musicservicebl.BLWebServiceSoap"%>
<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%@page import="com.musicservice.service.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Este taglib nos permite acceder a los custom tags creados (utiles para evitar duplicacion)-->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
    LoginHelper loginHelper = new LoginHelper();
    boolean userLoggedIn = loginHelper.isUserLoggedIn(request);
    if(!userLoggedIn){
        response.sendRedirect("index.jsp");
    }
    String profile = loginHelper.getProfile(request);
    String username = loginHelper.getUsername(request);
    
    boolean error = false;
    
    Usuario usuario = null;
    
    String name = "";
    String surname1 = "";
    String surname2 = "";
    String email = "";
    
    try {
        BLWebService servicio = new BLWebService();
        BLWebServiceSoap port = servicio.getBLWebServiceSoap();
        usuario = port.getUsuarioByUsername(username);
        
        name = usuario.getNombre();
        surname1 = usuario.getApellido1();
        surname2 = usuario.getApellido2();
        email = usuario.getEmail();
    } catch (Exception e) {
        error = true;
    }
    
    String errorStr = request.getParameter("error");
    
    if(errorStr != null){
       error = errorStr.equals("true");
    }
    boolean mostrarBanner = errorStr != null;
%>
<!DOCTYPE html>
<html lang="en">
    <t:musicservice_header/> <!-- Se agrega el header automaticamente con este tag -->
    

    <body>
        <t:musicservice_base_js/>
        <script type="text/javascript" src="./bootstrap/js/jquery.validate.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){

              $(".form-horizontal").validate(
                  {
                      rules: {
                          insertPassword: "required"
                      },
                      messages: {
                          insertPassword: "Este campo no puede ir vacío"
                      }
                  }
              );
            });
        </script>
        
    <%if(error){ %>
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong>¡Error!</strong> No se pudo modificar el perfil del usuario. Intente de nuevo
        </div>
    <%}else if (mostrarBanner){%>
        <div class="alert">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            Cambios guardados.
        </div>
    <%}%>
        <div class="container">
            <!-- Se agrega el nav automaticamente con este tag -->
            <t:musicservice_nav isLoggedIn="<%= userLoggedIn ? "true" : "false" %>" username="<%=username%>" profile="<%=profile%>" />
            
            <!-- AGREGAR CONTENIDO DE LA PAGINA ACA! -->
            
            <div class="row">
                <div class="span6 offset3">
                    <form action="perfilResult.jsp" class="form-horizontal" method="POST">
                        <div class="page-header">
                          <h1> Modificar Perfil 
                               <small>[<a href="#"><%=username%></a>]</small>
                          </h1>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="insertName">Nombre:&nbsp;&nbsp;</label>
                            <input type="text" id="insertName" name="insertName" placeholder="Nombre" value="<%=name%>">
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="insertSurname1">Apellido:&nbsp;&nbsp;</label>
                            <input type="text" id="insertSurname1" name="insertSurname1" placeholder="Apellido" value="<%=surname1%>">
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="insertSurname2">Segundo apellido:&nbsp;&nbsp;</label>
                            <input type="text" id="insertSurname2" name="insertSurname2" placeholder="Segundo apellido" value="<%=surname2%>">
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="insertEmail">Correo electrónico:&nbsp;&nbsp;</label>
                            <input type="text" id="insertEmail" name="insertEmail" placeholder="Correo electrónico" value="<%=email%>">
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="insertPassword">Contraseña:&nbsp;&nbsp;</label>
                            <input type="password" id="insertPassword" name="insertPassword" placeholder="Contraseña">
                            <span class="help-inline"></span>
                        </div>
                        <div class="control-group controls">
                            <button type="submit" class="btn btn-primary">Modificar</button>
                        </div>
                    </form>
                </div>
            </div>

            <!-- Se agrega el footer automaticamente con este tag -->
            <t:musicservice_footer/>

        </div> <!-- /container -->

        <!-- Hace los imports basicos de js (bootstrap, jquery) -->
        
        

    </body>
</html>
