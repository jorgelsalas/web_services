<%-- 
    Document   : albums
    Created on : Jun 29, 2013, 8:47:49 PM
    Author     : Kaver
--%>

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
    String username = loginHelper.getUsername(request);
    String profile = loginHelper.getProfile(request);
    
    ServiceHelper helper = new ServiceHelper();
    String idArtistaStr = request.getParameter("idArtista");
    int idArtista = -1;
    try{
        idArtista = Integer.parseInt(idArtistaStr);
    }
    catch(Exception e){ 
        idArtista = -1;
        e.printStackTrace(); 
    }
    Artista artista = helper.getArtistaById(idArtista);
    List<Album> albums = helper.getAlbumsDeArtista(idArtista);
    
%>
<!DOCTYPE html>
<html lang="en">
    <t:musicservice_header> </t:musicservice_header>

    <body>
        <div class="container">
            <t:musicservice_nav isLoggedIn="<%= userLoggedIn ? "true" : "false" %>" username="<%=username%>" profile="<%=profile%>" /> 
            <div class="page-header">
                  <%if(artista != null){ %>
                    <h1> 
                        <a href="#"><%= artista.getNombreArtista() %></a>
                        <small>(Albums)</small>
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
                        if(albums != null){
                            for(Album album : albums){
                                if(album != null){
                    %>
                                    <t:album  nombre="<%= album.getNombreAlbum()%>" 
                                               genero="<%= album.getGeneroAlbum()%>"
                                               url="<%= request.getContextPath()+"/canciones.jsp?idArtista="+artista.getIdArtista()
                                                       +"&idAlbum="+album.getIdAlbum()%>"
                                               fechaPublicacion="<%= album.getFechaPublicacion().getYear()+"" %>"
                                               img="holder/holder.js/64x64" />
                         <%
                                }
                            }
                        }
                        else if(artista == null){ %>
                        <p> Listado de albums no disponible </p>
                        
                       <%} 
                        else{ %>
                            Este artista no posee albums registrados
                        <%} %>
                </div>
            </div>
             
            <t:musicservice_footer/>
            <script src="holder/holder.js"></script>

        </div> <!-- /container -->

        <t:musicservice_base_js/>

    </body>
</html>