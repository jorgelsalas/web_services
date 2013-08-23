<%-- 
    Document   : album
    Created on : Jun 30, 2013, 1:05:24 AM
    Author     : Kaver
--%>

<%@tag description="Describe a un album" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@ attribute name="nombre"   required="true"%>
<%@ attribute name="url"    required="true"%>
<%@ attribute name="genero" required="true" %>
<%@ attribute name="fechaPublicacion" required="true" %>
<%@ attribute name="img"    required="true" %>

<ul class="media-list">
    <div class="media">
      <a class="pull-left" href="${url}">
        <img class="media-object" data-src="${img}" />
      </a>
      <div class="media-body">
        <h4 class="media-heading">
            <a href="${url}">${nombre}</a>
            <small> <b> (${fechaPublicacion}) </b>
        </h4>
        <p> ${genero} </p>
      </div>
    </div>
</ul>