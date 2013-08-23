<%-- 
    Document   : base
    Created on : Jun 30, 2013, 2:39:07 AM
    Author     : Kaver
--%>

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
    
    if (profile == null || username == null || username.equals("") || !profile.equals("1")){
        response.sendRedirect("index.jsp");
    }
    
    ServiceHelper helper = new ServiceHelper();
    String numeroDePaginaStr = request.getParameter("num");
    int numeroDePagina = 1;
    try{
        numeroDePagina = Integer.parseInt(numeroDePaginaStr);
    }
    catch(Exception e){ 
        numeroDePagina = 1;
        e.printStackTrace(); 
    }
    List<Artista> artistas = helper.getArtistas(numeroDePagina);
    int totalPaginas = helper.getCantidadDePaginasDeArtistas();
%>
<!DOCTYPE html>
<html lang="en">
    <t:musicservice_header/> <!-- Se agrega el header automaticamente con este tag -->

    <body>
        <div class="container">
            <!-- Se agrega el nav automaticamente con este tag -->
            <t:musicservice_nav isLoggedIn="<%= userLoggedIn ? "true" : "false" %>" username="<%=username%>" profile="<%=profile%>" />
            
            <!-- AGREGAR CONTENIDO DE LA PAGINA ACA! -->
            <div class="page-header">
                <form action="agregarResult.jsp" class="form-horizontal" method="POST">
                    <div class="control-group">
                        <label class="control-label" for="nombreArtista">Nombre del Artista:&nbsp;&nbsp;</label>
                        <input type="text" id="nombreArtista" name="nombreArtista" placeholder="Nombre">
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="generoArtista">Género:&nbsp;&nbsp;</label>
                        <input type="text" id="generoArtista" name="generoArtista" placeholder="Género">
                    </div>
                    <div class="control-group controls">
                        <button type="submit" class="btn btn-primary">Agregar Artista</button>
                    </div>
                </form>
            </div>
            
            <div class="row">
                <div class="span6 offset1">
                    <%
                        if(artistas != null){
                            for(Artista artista : artistas){
                                if(artista != null){
                    %>
                                    <t:artista_admin nombre="<%= artista.getNombreArtista()%>" 
                                               genero="<%= artista.getGeneroArtista()%>"
                                               url="<%=request.getContextPath()+"/albums.jsp?idArtista="+artista.getIdArtista()%>"
                                               img="holder/holder.js/64x64" 
                                               isFavorite="false"
                                               idArtista="<%=Integer.toString(artista.getIdArtista())%>"
                                    />
                         <%
                                }
                            }
                        }
                        else{ %>
                        <p> Listado de artistas no disponible </p>
                        
                       <%} %>
                </div>
            </div>
             
            <div class="row">
                <div class="span6 offset1">
                    <jsp:include page="paginacion.jsp">
                        <jsp:param name="pagActual" value="<%=numeroDePagina+""%>"></jsp:param>
                        <jsp:param name="maxPags" value="<%=totalPaginas+""%>"></jsp:param>
                        <jsp:param name="pagsVecinas" value="<%=2+""%>"></jsp:param>
                        <jsp:param name="baseURL" value="<%=request.getContextPath()+"/administrar.jsp?num=" %>"></jsp:param>
                    </jsp:include>
                </div>
            </div>

            <!-- Se agrega el footer automaticamente con este tag -->
            <t:musicservice_footer/>

        </div> <!-- /container -->
        
        <script src="holder/holder.js"></script>
        <!-- Hace los imports basicos de js (bootstrap, jquery) -->
        <t:musicservice_base_js/>

    </body>
</html>
<%-- 
    Document   : administrar
    Created on : Jun 30, 2013, 3:20:10 PM
    Author     : Jorge
--%>
