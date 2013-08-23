<%-- 
    Document   : favoritos
    Created on : Jun 30, 2013, 5:32:34 PM
    Author     : Kaver
--%>

<%@page import="com.musicservice.service.Artista"%>
<%@page import="com.serviciosweb.musicserviceweb.ServiceHelper"%>
<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%
    LoginHelper loginHelper = new LoginHelper();
    boolean userLoggedIn = loginHelper.isUserLoggedIn(request);
    if(!userLoggedIn){
        response.sendRedirect("index.jsp");
    }
    String profile = loginHelper.getProfile(request);
    String username = loginHelper.getUsername(request);
    String idArtistaStr = request.getParameter("idArtista");
    String numPaginaStr = request.getParameter("numPag");
    if(numPaginaStr == null){
        numPaginaStr = "1";
    }
    
    String shouldAddStr = request.getParameter("add");
    boolean shouldAdd = (shouldAddStr == null) || shouldAddStr.equals("true");
    
    int idArtista = -1;
    try{
        idArtista = Integer.parseInt(idArtistaStr);
    }
    catch(Exception e){
       e.printStackTrace();
       idArtista = -1;
    }   
    
    ServiceHelper helper = new ServiceHelper();
    if(shouldAdd){
        System.out.println("Adding fav " + idArtista + " to " + username);
        helper.addFavorito(username, idArtista);
    }
    else{
        System.out.println("Deleting fav " + idArtista + " to " + username);
        helper.deleteFavorito(username, idArtista);
    }
    
    response.sendRedirect("artistas.jsp?num="+numPaginaStr);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
