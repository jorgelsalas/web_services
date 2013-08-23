<%@page import="java.util.Collection"%>
<%@page import="com.musicservice.entities.Usuario"%>
<%@page import="com.musicservice.entities.Cancion"%>
<%@page import="com.musicservice.entities.Album"%>
<%@page import="com.musicservice.entities.Artista"%>
<%@page import="com.musicservice.dao.CancionDAO"%>
<%@page import="com.musicservice.dao.AlbumDAO"%>
<%@page import="com.musicservice.dao.ArtistaDAO"%>
<%@page import="com.musicservice.dao.UsuarioDAO"%>
<%
  UsuarioDAO usuarioDAO = new UsuarioDAO();
  ArtistaDAO artistaDAO = new ArtistaDAO();
  AlbumDAO albumDAO = new AlbumDAO();
  CancionDAO cancionDAO = new CancionDAO();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Music service</title>
    </head>
    <body>
        <h3> Artistas </h3>
        <%
        for(Artista artista : artistaDAO.findAll()){            
        %>
        
        <li> <i class="icon-briefcase"></i>Nombre = <%=artista.getNombreArtista()%> - Genero = <%=artista.getGeneroArtista()%> </l1>
        
        <%}%>
        
        <h3> Albums </h3>
        
        <%
        for(Album album : albumDAO.findAll()){            
        %>
        
        <li> Nombre = <%=album.getNombreAlbum()%> - Genero = <%=album.getGeneroAlbum()%> - Artista = <%= album.getIdArtista().getNombreArtista() %> </l1>
        
        <%}%>
        
        <h3> Canciones </h3>
        
        <%
        for(Cancion cancion : cancionDAO.findAll()){            
        %>
        
        <li> Nombre = <%=cancion.getNombreCancion()%> - Num. pista = <%= cancion.getNumeroTrack() %> - Album = <%= cancion.getIdAlbum().getNombreAlbum() %> - Artista = <%=cancion.getIdAlbum().getIdArtista().getNombreArtista() %> </l1>
        
        <%}%>
        
        <h3> Usuarios </h3>
        
        <%
        for(Usuario usuario : usuarioDAO.findAll()){                   
        %>
        
        <li> Nombre = <%=usuario.getNombre() + " " + usuario.getApellido1() %> - Username = <%= usuario.getUsername() %> - Email = <%= usuario.getEmail() %>  </li>
        
        <%}%>
</body>
</html>
