<%-- 
    Document   : registro
    Created on : 15/06/2013, 06:40:48 PM
    Author     : Carlos Solis
--%>

<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.somee.musicservicebl.BLWebService"%>
<%@page import="com.somee.musicservicebl.BLWebServiceSoap"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<%
    LoginHelper loginHelper = new LoginHelper();
    boolean userLoggedIn = loginHelper.isUserLoggedIn(request);
    String username = loginHelper.getUsername(request);
    
    
    if(userLoggedIn){
        //No permitir a usuarios loggeados a entrar la pagina de registro.
        response.sendRedirect("index.jsp");
    }
    
    String profile = loginHelper.getProfile(request);

    String errorStr = request.getParameter("error");
    boolean error = errorStr != null;
%>
<!DOCTYPE html>
<html lang="en">
    <t:musicservice_header />

    <body>
        <div class="container">

            <t:musicservice_nav isLoggedIn="<%= userLoggedIn ? "true" : "false" %>" username="<%=username%>" profile="<%=profile%>" />
            
            <%if(error){ %>
                <div class="alert alert-error">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>¡Error!</strong> No se pudo registrar el usuario. Intente de nuevo
                </div>
             <%}%>

            <!-- Example row of columns -->
            <div class="row">
                <div class="span6 offset3">
                    <form action="registroResult.jsp" class="form-horizontal" method="POST">
                        <div class="page-header">
                          <h1> Registro </h1>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="insertName">Nombre:&nbsp;&nbsp;</label>
                            <input type="text" id="insertName" name="insertName" placeholder="Nombre">
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="insertSurname1">Apellido:&nbsp;&nbsp;</label>
                            <input type="text" id="insertSurname1" name="insertSurname1" placeholder="Apellido">
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="insertSurname2">Segundo apellido:&nbsp;&nbsp;</label>
                            <input type="text" id="insertSurname2" name="insertSurname2" placeholder="Segundo apellido">
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="insertEmail">Correo electrónico:&nbsp;&nbsp;</label>
                            <input type="text" id="insertEmail" name="insertEmail" placeholder="Correo electrónico">
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="insertUsername">Nombre de usuario:&nbsp;&nbsp;</label>
                            <input type="text" id="insertUsername" name="insertUsername" placeholder="Nombre de usuario">
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="insertPassword">Contraseña:&nbsp;&nbsp;</label>
                            <input type="password" id="insertPassword" name="insertPassword" placeholder="Contraseña">
                        </div>
                        <div class="control-group controls">
                            <button type="submit" class="btn btn-primary">Enviar</button>
                        </div>
                    </form>
                </div>
            </div>

            <hr>

            <t:musicservice_footer />

        </div> <!-- /container -->

        <t:musicservice_base_js />

    </body>
</html>
