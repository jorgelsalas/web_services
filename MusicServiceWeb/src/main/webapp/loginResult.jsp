<%-- 
    Document   : loginResult
    Created on : 28/06/2013, 12:26:36 AM
    Author     : csolisr
--%>

<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.musicservice.service.Usuario"%>
<%@page import="com.somee.musicservicebl.BLWebService"%>
<%@page import="com.somee.musicservicebl.BLWebServiceSoap"%>

<%
    LoginHelper helper = new LoginHelper();
    boolean error 
            = helper.login(
                request.getParameter("insertUsername"), 
                request.getParameter("insertPassword"), 
                response
            );
    response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <% if (!error) {%>
        <h1>¡Ingreso exitoso!</h1>
        <%} else {%>
        <h1>¡Error de ingreso!</h1>
        <%}%>
        <p>Volver a la <a href="index.jsp">página principal.</a>
    </body>
</html>
