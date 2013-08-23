<%-- 
    Document   : logoutResult
    Created on : 28/06/2013, 05:51:31 PM
    Author     : csolisr
--%>

<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.musicservice.service.Usuario"%>
<%@page import="com.somee.musicservicebl.BLWebService"%>
<%@page import="com.somee.musicservicebl.BLWebServiceSoap"%>

<%
LoginHelper loginHelper = new LoginHelper();
boolean error = loginHelper.logout(request, response);
response.sendRedirect("index.jsp");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <% if (!error) {%>
        <h1>¡Logout exitoso!</h1>
        <%} else {%>
        <h1>¡Error al hacer el logout, intente de nuevo!</h1>
        <%}%>
        <p>Volver a la <a href="index.jsp">Página principal.</a>
    </body>
</html>
