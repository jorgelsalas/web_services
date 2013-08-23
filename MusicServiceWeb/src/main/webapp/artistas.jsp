<%-- 
    Document   : artistas
    Created on : Jun 29, 2013, 8:47:49 PM
    Author     : Kaver
--%>

<%@page import="com.musicservice.service.Usuario"%>
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
    String numeroDePaginaStr = request.getParameter("num");
    int numeroDePagina = 1;
    try{
        numeroDePagina = Integer.parseInt(numeroDePaginaStr);
    }
    catch(Exception e){ 
        numeroDePagina = 1;
        e.printStackTrace(); 
    }
    int totalPaginas = helper.getCantidadDePaginasDeArtistas();    

    List<Artista> artistas = helper.getArtistas(numeroDePagina);
    Usuario usuario = helper.getUsuarioByUsername(username);
    List<Artista> favoritos = helper.favoritosDeUsuario(usuario);
%>
<!DOCTYPE html>
<html lang="en">
    <t:musicservice_header> </t:musicservice_header>

    <body>
        <div class="container">
            <t:musicservice_nav isLoggedIn="<%= userLoggedIn ? "true" : "false" %>" username="<%=username%>" profile="<%=profile%>" /> 
            <div class="page-header">
		  <h1>Artistas <small>Listado alfabético</small></h1>
            </div>
            
            <div class="row">
                <div class="span6 offset1">
                    <%
                        if(artistas != null){
                            for(Artista artista : artistas){
                                if(artista != null){
                                    boolean esFavorito = false;
                                               
                                    if(favoritos != null){
                                        for(Artista favorito : favoritos){
                                            if(artista.getIdArtista().equals(favorito.getIdArtista())){
                                                esFavorito = true;
                                                break;
                                            }
                                        }
                                    }
                                    
                    %>
                                    <t:artista nombre="<%= artista.getNombreArtista()%>" 
                                               genero="<%= artista.getGeneroArtista()%>"
                                               url="<%=request.getContextPath()+"/albums.jsp?idArtista="+artista.getIdArtista()%>"
                                               img="holder/holder.js/64x64" 
                                               favoritoURL="<%= "favoritos.jsp?idArtista="+artista.getIdArtista()
                                                                +"&numPag="+numeroDePagina+"&add="+ 
                                                                (esFavorito ? "false" : "true") %>"
                                               isFavorite="<%= esFavorito ? "true" : "false" %>"
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
                        <jsp:param name="baseURL" value="<%=request.getContextPath()+"/artistas.jsp?num=" %>"></jsp:param>
                    </jsp:include>
                </div>
            </div>
            <t:musicservice_footer/>
            <script src="holder/holder.js"></script>

        </div> <!-- /container -->

        <t:musicservice_base_js/>

    </body>
</html>