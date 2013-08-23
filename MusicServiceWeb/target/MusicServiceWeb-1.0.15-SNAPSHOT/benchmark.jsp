<%-- 
    Document   : benchmark
    Created on : Jun 28, 2013, 2:06:36 PM
    Author     : Jorge
--%>

<%@page import="com.serviciosweb.musicserviceweb.LoginHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.somee.musicservicebl.Correo"%>
<%@page import="com.somee.musicservicebl.BLWebService"%>
<%@page import="com.somee.musicservicebl.BLWebServiceSoap"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
    List<Correo> correos = null;
    try{
        BLWebService servicio = new BLWebService();
        BLWebServiceSoap port = servicio.getBLWebServiceSoap();
        correos = port.getCorreos().getCorreo();
    }
    catch(Exception e){
        correos = null;
    }
    
    LoginHelper loginHelper = new LoginHelper();
    boolean userLoggedIn = loginHelper.isUserLoggedIn(request);
    String username = loginHelper.getUsername(request);
    String profile = loginHelper.getProfile(request);
%>
<!DOCTYPE html>
<html lang="en">
    <t:musicservice_header> </t:musicservice_header>

    <body>
        <div class="container">
            <t:musicservice_nav isLoggedIn="<%= userLoggedIn ? "true" : "false" %>" username="<%=username%>" profile="<%=profile%>" />
            <div class="page-header">
                <h1> Correos <small>(Servicio externo)</small> </h1>
            </div>
            <ul class="unstyled">
                <%
                    if (correos == null) {
                %>
                
                <h2>Lo sentimos, el servicio no se encuentra disponible </h2>
                
                <%
                    }
                    else {
                        for(Correo a : correos){
                %>
                
                <li> <i class="icon-briefcase"></i> <%=a.getCorreo1() %> </li>
                
                <%
                        }
                    }
                    
                %>

            </ul>
   
            <t:musicservice_footer/>

        </div> <!-- /container -->

        <t:musicservice_base_js/>

    </body>
</html>
