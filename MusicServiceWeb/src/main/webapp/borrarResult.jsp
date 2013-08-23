<%-- 
    Document   : borrarResult
    Created on : Jun 30, 2013, 5:25:15 PM
    Author     : Jorge
--%>

<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%@page import="com.somee.musicservicebl.BLWebService"%>
<%@page import="com.somee.musicservicebl.BLWebServiceSoap"%>
<%@page import="com.musicservice.service.Artista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Este taglib nos permite acceder a los custom tags creados (utiles para evitar duplicacion)-->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
    //permite identificar si el usuario esta autenticado o no
    LoginHelper loginHelper = new LoginHelper();
    boolean userLoggedIn = loginHelper.isUserLoggedIn(request);
    String username = loginHelper.getUsername(request);
    String profile = loginHelper.getProfile(request);
    
    if (!profile.equals("1")){
        response.sendRedirect("index.jsp");
    }
    
    boolean error = true;
    int idArtista = -1;
    
    try{
        BLWebService servicio = new BLWebService();
        BLWebServiceSoap port = servicio.getBLWebServiceSoap();
        
        if (request.getParameter("idArtista") != null) {
            
            idArtista = Integer.parseInt(request.getParameter("idArtista"));
            
        }
        
        error = port.deleteArtistaById(idArtista);
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    
    
%>
<!DOCTYPE html>
<html lang="en">
    <t:musicservice_header/> <!-- Se agrega el header automaticamente con este tag -->

    <body>
        <div class="container">
            <!-- Se agrega el nav automaticamente con este tag -->
            <t:musicservice_nav isLoggedIn="<%= userLoggedIn ? "true" : "false" %>" username="<%=username%>" profile="<%=profile%>" />
            
            <!-- AGREGAR CONTENIDO DE LA PAGINA ACA! -->
            
            <%
                if (error){
            %>
            <h3>El artista no se pudo borrar</h3>
            
            <%
                } else {
            %>
            <h3>Artista borrado satisfactoriamente</h3>
            <%
                }
            %>
            
            <a href="administrar.jsp" > <button class="btn btn-primary"> Regresar </button> </a>

            <!-- Se agrega el footer automaticamente con este tag -->
            <t:musicservice_footer/>

        </div> <!-- /container -->

        <!-- Hace los imports basicos de js (bootstrap, jquery) -->
        <t:musicservice_base_js/>

    </body>
</html>
