<%-- 
    Document   : paginacion
    Created on : Jun 29, 2013, 10:03:44 PM
    Author     : Kaver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String numPagActualStr = request.getParameter("pagActual");
    String maxPagsStr = request.getParameter("maxPags");
    String maxPagsVecinasStr = request.getParameter("pagsVecinas");
    String baseURL = request.getParameter("baseURL");
    
    boolean valido = true;
    int numPagActual = 0;
    int maxPags = 0;
    int maxPagsVecinas = 0;
    int primerElemento = 0;
    int ultimoElemento = 0;
    try{
        numPagActual = Integer.parseInt(numPagActualStr);
        maxPags = Integer.parseInt(maxPagsStr);
        maxPagsVecinas = Integer.parseInt(maxPagsVecinasStr);
        
        int numeroDePaginaDentroDeLimites =
                Math.max(0, Math.min(numPagActual, maxPags));
        
        int paginasExtraALaIzquierda = 1;
        int paginasExtraALaDerecha   = 1;
        if(numeroDePaginaDentroDeLimites + maxPagsVecinas > maxPags){
            paginasExtraALaIzquierda = (numeroDePaginaDentroDeLimites+maxPagsVecinas - maxPags);
        }
        else if(numeroDePaginaDentroDeLimites - maxPagsVecinas < 1){
            paginasExtraALaDerecha = maxPagsVecinas - numeroDePaginaDentroDeLimites;
        }
        primerElemento = Math.max(1, numeroDePaginaDentroDeLimites - maxPagsVecinas - paginasExtraALaDerecha);
        ultimoElemento = Math.min(maxPags, numeroDePaginaDentroDeLimites + maxPagsVecinas + paginasExtraALaIzquierda);
    }
    catch(Exception e){
        valido = false;
    }
%>
    <%if(valido){ %>
            <div class="pagination">
             <ul>
               <% if(numPagActual > 1){  %>
                    <li><a href="<%=baseURL + (numPagActual-1) %>" >Prev</a></li>
               <% } 
                else{ %>
                    <li class="disabled"><a href="#" >Prev</a></li>
               <% } %>
               <%for(int i = primerElemento; i <= ultimoElemento; ++i){ %>
                    <%if(i == numPagActual){ %>
                        <li class="disabled"><a href="<%=baseURL + i%>" > <%= (i+"")%> </a></li>
                    <%}
                    else{ %>
                        <li><a href="<%=baseURL + i%>" > <%= (i+"")%> </a></li>
                    <%}%>
               <% } %> 
               <% if(numPagActual < maxPags){  %>
                    <li><a href="<%=baseURL + (numPagActual+1) %>" >Next</a></li>
               <% } 
               else{ %>
                    <li class="disabled"><a href="#" >Next</a></li>
               <% } %>
             </ul>
            </div>    
    <% } %>
