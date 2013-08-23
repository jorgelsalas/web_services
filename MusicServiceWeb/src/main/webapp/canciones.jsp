<%-- 
    Document   : canciones
    Created on : Jun 29, 2013, 8:47:49 PM
--%>

<%@page import="com.musicservice.service.Cancion"%>
<%@page import="com.musicservice.service.Album"%>
<%@page import="java.util.List"%>
<%@page import="com.musicservice.service.Artista"%>
<%@page import="com.serviciosweb.musicserviceweb.ServiceHelper"%>
<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
    LoginHelper loginHelper = new LoginHelper();
    boolean userLoggedIn = loginHelper.isUserLoggedIn(request);
    if(!userLoggedIn){
        response.sendRedirect("index.jsp");
    }
    String profile = loginHelper.getProfile(request);
    String username = loginHelper.getUsername(request);
    
    ServiceHelper helper = new ServiceHelper();
    String idArtistaStr = request.getParameter("idArtista");
    String idAlbumStr   = request.getParameter("idAlbum");
    int idArtista = -1;
    int idAlbum = -1;
    try{
        idArtista = Integer.parseInt(idArtistaStr);
        idAlbum = Integer.parseInt(idAlbumStr);
    }
    catch(Exception e){ 
        idArtista = -1;
        idAlbum = -1;
        e.printStackTrace(); 
    }
    System.out.println(idArtistaStr + " " + idAlbumStr);
    Artista artista = helper.getArtistaById(idArtista);
    Album album = helper.getAlbumById(idAlbum);
    List<Cancion> canciones = helper.getCancionesDeAlbum(idAlbum);
%>
<!DOCTYPE html>
<html lang="en">
    <t:musicservice_header> </t:musicservice_header>

    <body>
        <div class="container">
            <t:musicservice_nav isLoggedIn="<%= userLoggedIn ? "true" : "false" %>" username="<%=username%>" profile="<%=profile%>" />
            <div class="page-header">
                  <%if(artista != null && album != null){ %>
                    <h1> 
                        <a href="albums.jsp?idArtista=<%=artista.getIdArtista()+""%>"><%= artista.getNombreArtista() %></a> 
                        <small>[<a href="#"><%=album.getNombreAlbum()%></a>]</small>
                    </h1>
                  <%}
                  else{ %>		 
                    <h1>
                        Error 
                        <small> <a href="index.jsp"> (Volver a home) </a> </small>
                    </h1>
                   <%} %>
            </div>
            
            <div class="row">
                <div class="span6 offset1">
                    <%
                        if(canciones != null){
                            for(Cancion cancion : canciones){
                                if(cancion != null){
                    %>
                                    <t:cancion  nombre="<%= cancion.getNombreCancion()%>" 
                                                numTrack ="<%= cancion.getNumeroTrack()+""%>"
                                                url="#"
                                                img="holder/holder.js/64x64" />
                         <%
                                }
                            }
                        }
                        else if(artista == null || album == null){ %>
                        <p> Listado de canciones no disponible </p>
                        
                       <%} 
                        else{ %>
                            Este album no posee canciones registradas
                        <%} %>
                </div>
            </div>
             
            <t:musicservice_footer/>
            <script src="holder/holder.js"></script>

        </div> <!-- /container -->

        <t:musicservice_base_js/>

    </body>
</html>