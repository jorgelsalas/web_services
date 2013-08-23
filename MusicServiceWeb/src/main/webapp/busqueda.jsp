<%-- 
    Document   : busqueda
    Created on : 30/06/2013, 05:59:58 PM
    Author     : csolisr
--%>

<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%@page import="com.somee.musicservicebl.BLWebService"%>
<%@page import="com.somee.musicservicebl.BLWebServiceSoap"%>
//<%@page import="com.musicservice.service.Artista"%>
<%@page import="java.util.List"%>
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
    
    String query = request.getParameter("query");
    try {
        BLWebService servicio = new BLWebService();
        BLWebServiceSoap port = servicio.getBLWebServiceSoap();
        Artista artista = port.getArtistaByNombre(query);
        
        int idArtista = artista.getIdArtista();
        response.sendRedirect("albums.jsp?idArtista="+idArtista);
    } catch (Exception e){
        //e.printStackTrace();
        response.sendRedirect("albums.jsp");
    }
%>
<!DOCTYPE html>
<html lang="es">
    <t:musicservice_header/> <!-- Se agrega el header automaticamente con este tag -->

    <body>
        <div class="container">
            <!-- Se agrega el nav automaticamente con este tag -->
            <t:musicservice_nav isLoggedIn="<%= userLoggedIn ? "true" : "false" %>" username="<%=username%>" profile="<%=profile%>" />
            
            
            
            <!-- Se agrega el footer automaticamente con este tag -->
            <t:musicservice_footer/>

        </div> <!-- /container -->

        <!-- Hace los imports basicos de js (bootstrap, jquery) -->
        <t:musicservice_base_js/>

    </body>
</html>