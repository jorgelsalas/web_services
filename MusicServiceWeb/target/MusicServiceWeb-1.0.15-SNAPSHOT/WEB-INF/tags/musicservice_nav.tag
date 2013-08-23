<%-- 
    Document   : nav
    Created on : Jun 29, 2013, 1:36:53 PM
    Author     : Kaver
--%>

<%@tag description="Adds the nav to the page" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 
Requires:
    1. bootstrap 
-->

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@ attribute name="isLoggedIn" required="true"%>
<%@ attribute name="username" required="true" %>
<%@ attribute name="profile" required="true" %>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
      <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
          </button>
          <a class="brand" href="index.jsp">Music Service</a>
          <div class="nav-collapse collapse">
              <ul class="nav">
                  <li class="dropdown">
                  <c:choose>
                    <c:when test="${isLoggedIn == 'true'}">
                        <li><a href="artistas.jsp">Explorar</a></li>
                    </c:when>
                    <c:otherwise> 
                        <li><a href="registro.jsp">Registro</a></li>
                    </c:otherwise>
                  </c:choose>
                  <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Otros <b class="caret"></b></a>
                      <ul class="dropdown-menu">
                          <li class="divider"></li>
                          <li class="nav-header">Servicios externos</li>
                          <li><a href="benchmark.jsp">Servicio Benchmark</a></li>      
                      </ul>
                  </li>
              </ul>
              <c:choose>
                <c:when test="${isLoggedIn == 'true'}">
                    <form action="busqueda.jsp" class="navbar-search">
                       <input type="text" class="search-query" id="query" name="query" placeholder="Búsqueda">
                    </form>          
                </c:when>
              </c:choose>
              <c:choose>
                <c:when test="${isLoggedIn == 'false'}">
                  <form id="login_form" action="loginResult.jsp" class="navbar-form form-inline pull-right" method="POST">
                      <input id="insertUsername" class="navbar-form input-small" name="insertUsername" type="text" placeholder="N. usuario">
                      <input id="insertPassword" class="navbar-form input-small" name="insertPassword" type="password" placeholder="Contraseña">
                      <button type="submit" class="navbar-form btn">Login</button>
                  </form>
                </c:when>
                <c:otherwise>
                      <ul class="nav pull-right">
                          <li class="dropdown"> 
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                  ${username}
                                  <b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                                  <li><a href="perfil.jsp"> Perfil </a> </li>
                                  <c:choose>
                                    <c:when test="${profile == '1'}">
                                          <li><a href="administrar.jsp">Administrar Artistas</a> </li>
                                    </c:when>
                                  </c:choose>
                                  <li><a href="logoutResult.jsp"> Logout </a> </li>
                              </ul>
                          </li>
                      </ul>
                </c:otherwise>
              </c:choose>
          </div><!--/.nav-collapse -->
      </div>
  </div>
</div>