<%-- 
    Document   : actualizar
    Created on : Jul 1, 2013, 2:11:01 PM
    Author     : Jorge
--%>

<%@page import="com.somee.musicservicebl.BLWebServiceSoap"%>
<%@page import="com.somee.musicservicebl.BLWebService"%>
<%@page import="com.musicservice.service.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.musicservice.service.Artista"%>
<%@page import="com.serviciosweb.musicserviceweb.ServiceHelper"%>
<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
    //permite identificar si el usuario esta autenticado o no
    LoginHelper loginHelper = new LoginHelper();
    boolean userLoggedIn = loginHelper.isUserLoggedIn(request);
    boolean shouldRedirect = false;
    if(!userLoggedIn){
        shouldRedirect = true;
    }
    String username = loginHelper.getUsername(request);
    String profile = loginHelper.getProfile(request);
    
    if (shouldRedirect || profile == null || username == null || !profile.equals("1")){
        response.sendRedirect("index.jsp");
    }
    
    
    int idArtista = -1;
    String nombre = "";
    String genero = "";
    
    try{
        BLWebService servicio = new BLWebService();
        BLWebServiceSoap port = servicio.getBLWebServiceSoap();
        
        if (request.getParameter("idArtista") != null) {
            
            idArtista = Integer.parseInt(request.getParameter("idArtista"));
            
        }
        
        Artista artista = port.getArtistaById(idArtista);
        
        nombre = artista.getNombreArtista();
        genero = artista.getGeneroArtista();
    
        
        
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
                if (idArtista == -1){
            %>
                    <h1>Hubo un problema recuperando los datos del artista</h1>
                    <h2>Por favor vuelva a intentarlo</h2>
            <% 
                } else {
            %>
                    <div class="page-header">
                        <form action="actualizarResult.jsp" class="form-horizontal" method="POST">
                            <div class="control-group">
                                <label class="control-label" for="nuevoNombreArtista">Nombre del Artista:&nbsp;&nbsp;</label>
                                <input type="text" id="nuevoNombreArtista" name="nuevoNombreArtista" value="<%= nombre %>" placeholder="<%= nombre %>">
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="nuevoGeneroArtista">Género:&nbsp;&nbsp;</label>
                                <input type="text" id="nuevoGeneroArtista" name="nuevoGeneroArtista" value="<%= genero %>" placeholder="<%= genero %>">
                            </div>
                            
                            <div class="control-group controls">
                                <button type="submit" class="btn btn-primary">Guardar cambios</button>
                            </div>
                            <div class="control-group">
                                
                                <input type="text" readonly="" class="hidden" id="idArtista" name="idArtista" value="<%= idArtista %>">
                            </div>
                        </form>
                    </div>
            <% 
                }
            %>
            
            

            <!-- Se agrega el footer automaticamente con este tag -->
            <t:musicservice_footer/>

        </div> <!-- /container -->

        <!-- Hace los imports basicos de js (bootstrap, jquery) -->
        <t:musicservice_base_js/>

    </body>
</html>
