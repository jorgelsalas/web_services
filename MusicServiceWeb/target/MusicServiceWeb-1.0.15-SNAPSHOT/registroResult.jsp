<%-- 
    Document   : registroResult
    Created on : 20/06/2013, 08:21:09 PM
    Author     : Carlos Solis
--%>


<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.musicservice.service.Usuario"%>
<%@page import="com.somee.musicservicebl.BLWebService"%>
<%@page import="com.somee.musicservicebl.BLWebServiceSoap"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%
    boolean error = true;
    String name = "";
    String surname1 = "";
    String surname2 = "";
    String email = "";
    String username = "";
    String password = ""; //TODO: usar método seguro de envío    S
    try{
        BLWebService servicio = new BLWebService();
        BLWebServiceSoap port = servicio.getBLWebServiceSoap();
        
        if (request.getParameter("insertName") != null &&
            request.getParameter("insertSurname1")!=null &&
            request.getParameter("insertSurname2")!=null &&
            request.getParameter("insertEmail") != null &&
            request.getParameter("insertUsername")!=null &&
            request.getParameter("insertPassword")!=null){
            name = request.getParameter("insertName");
            surname1=request.getParameter("insertSurname1");
            surname2=request.getParameter("insertSurname2");
            email = request.getParameter("insertEmail");
            username=request.getParameter("insertUsername");
            password=request.getParameter("insertPassword");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(name);
        usuario.setApellido1(surname1);
        usuario.setApellido2(surname2);
        usuario.setEmail(email);
        usuario.setUsername(username);
        usuario.setPassword(password);
    
        error = port.addUsuario(usuario);
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    if(error){
        response.sendRedirect("registro.jsp?error=true");
    }
    else {
        LoginHelper helper = new LoginHelper();
        helper.login(username, password, response);
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>

    </body>
</html>
