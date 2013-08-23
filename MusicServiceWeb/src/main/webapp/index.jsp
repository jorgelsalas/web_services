<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.musicservice.service.Usuario"%>
<%@page import="com.somee.musicservicebl.BLWebService"%>
<%@page import="com.somee.musicservicebl.BLWebServiceSoap"%>
<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
    LoginHelper loginHelper = new LoginHelper();
    boolean userLoggedIn = loginHelper.isUserLoggedIn(request);
    String username = loginHelper.getUsername(request);
    String profile = loginHelper.getProfile(request);
    
%>
<!DOCTYPE html>
<html lang="en">
    <t:musicservice_header/>

    <body>
        <div class="container">
            <t:musicservice_nav isLoggedIn="<%= userLoggedIn ? "true" : "false" %>" username="<%=username%>" profile="<%=profile%>" />
            <!-- Main hero unit for a primary marketing message or call to action -->
            <div class="hero-unit">
                <h1>Music Service</h1>
                <p>Un servicio para mostrar lo más reciente de la música. Consulte artistas, álbumes y canciones.</p>
                <p><a href="registro.jsp" class="btn btn-primary btn-large">Registrarse &raquo;</a></p>
            </div>

            <t:musicservice_footer/>

        </div> <!-- /container -->

        <t:musicservice_base_js/>

    </body>
</html>
