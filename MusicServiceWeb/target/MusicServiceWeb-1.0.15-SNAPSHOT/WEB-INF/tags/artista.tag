<%-- 
    Document   : artista
    Created on : Jun 29, 2013, 9:18:44 PM
    Author     : Kaver
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Describe a un artista" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@ attribute name="nombre" required="true"%>
<%@ attribute name="url"    required="true"%>
<%@ attribute name="genero" required="true" %>
<%@ attribute name="img"    required="true" %>
<%@ attribute name="favoritoURL" required="true" %>
<%@attribute  name="isFavorite" required="true" %>

<ul class="media-list">
    <div class="media">
      <a class="pull-left" href="${url}">
        <img class="media-object" data-src="${img}" />
      </a>
      <div class="media-body">
        <h4 class="media-heading">
            <a href="${url}">${nombre}</a> <small> <b> (${genero}) </b> </small>
        </h4>
        
        <c:choose>
            <c:when test="${isFavorite == 'false'}">
                <a class="btn btn-success" href="${favoritoURL}"><i class="icon-heart"></i> Add Favorite </a>
            </c:when>
            <c:otherwise>
                <a class="btn btn-warning" href="${favoritoURL}"><i class="icon-heart"></i> Favorite! </a>
            </c:otherwise>
        </c:choose>
      </div>
    </div>
</ul>