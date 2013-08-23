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
    
    LoginHelper loginHelper = new LoginHelper();
    boolean userLoggedIn = loginHelper.isUserLoggedIn(request);
    if(!userLoggedIn){
        response.sendRedirect("index.jsp");
    }
    
    String profile = loginHelper.getProfile(request);
    
    String username = loginHelper.getUsername(request);
    
    String name = "";
    String surname1 = "";
    String surname2 = "";
    String email = "";
    boolean pass_vacio = true;
    
    String password = ""; //TODO: usar método seguro de envío    S
    try{
        BLWebService servicio = new BLWebService();
        BLWebServiceSoap port = servicio.getBLWebServiceSoap();
        
        Usuario usuario = port.getUsuarioByUsername(username);
        
        if (request.getParameter("insertName") != null &&
          !(request.getParameter("insertName").equals(""))){
            name = request.getParameter("insertName");
            usuario.setNombre(name);
        }
        if (request.getParameter("insertSurname1")!=null &&
          !(request.getParameter("insertSurname1").equals(""))){
            surname1=request.getParameter("insertSurname1");
            usuario.setApellido1(surname1);
        }
        if (request.getParameter("insertSurname2")!=null &&
          !(request.getParameter("insertSurname2").equals(""))){
            surname2=request.getParameter("insertSurname2");
            usuario.setApellido2(surname2);
        }
        if (request.getParameter("insertEmail") != null &&
          !(request.getParameter("insertEmail").equals(""))){
            email = request.getParameter("insertEmail");
            usuario.setEmail(email);
        }
        if (request.getParameter("insertPassword")!=null &&
          !(request.getParameter("insertPassword").equals(""))){
            password=request.getParameter("insertPassword");
            usuario.setPassword(password);
            pass_vacio = false;
        }
        else {
            pass_vacio = true;
        }
        
        if(pass_vacio){
            response.sendRedirect("perfil.jsp?error=true");
        }
        else{
            error = port.updateUsuario(usuario);
        }
        
        
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    if(error){
        response.sendRedirect("perfil.jsp?error=true");
    }
    else{
        response.sendRedirect("perfil.jsp?error=false");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Perfil</title>
    </head>
    <body>

    </body>
</html>
