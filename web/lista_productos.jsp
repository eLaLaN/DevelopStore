<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" uri="http://curso.develop.uaa.mx/5d" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@page import="java.util.List" %>
<%@page import="mx.com.develop.store.model.Producto" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Develop Store: Listado de Productos</title>
    </head>
    <body>
        <c:import url="includes/header.jsp">
            <c:param name="moduloTitulo" value="Lista Productos"/>
        </c:import>

        <b>Usted esta aqui:</b>&nbsp;<a href="index.jsp">Inicio</a>/Listado de Productos
        <h2>Lista de Productos:</h2>
        Productos disponibles: ${fn:length(productos)}
        <table border="1" width="800" id="table">
            <thead>
                <tr bgcolor='#3882C7'>
                    <th>No.</th>
                    <th>Descripcion</th>
                    <th>Tipo</th>
                    <th>Color</th>
                    <th>Talla</th>
                    <th>Precio</th>
                    <th>Disponibles</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>${requestScope.productos[0]["descripcion"]}</td>
                    <td>${requestScope["productos"][0]["tipo"].titulo}</td>
                    <td>${requestScope["productos"][0]["color"]["titulo"]}</td>
                    <td>${applicationScope["productos"][0].talla}</td>
                    <td>$${applicationScope.productos[0].precio}</td>
                    <td>${applicationScope.productos[0].disponiblesPorAca}</td>
                    <td>
                        <c:url var="detallesProducto" value="ventas/detalles_producto.view">
                            <c:param name="id" value="${productos[0].id}"/>
                        </c:url>
                        <a href="${detallesProducto}">
                            <img src="imagenes/carrito.png" width="40" height="40"/>
                        </a>
                    </td>
                </tr>
                <%/* if (request.getAttribute("productos") != null) {
                     List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                     for (Producto producto : productos) {
                     pageContext.setAttribute("producto", producto);
                     */
                %>
                <mytag:forEach items="${productos}" begin="1" varStatus="status">
                    <jsp:attribute name="var">producto</jsp:attribute>
                    <jsp:body>
                        <tr>
                            <td>${status + 1}</td>
                            <td>${producto.descripcion}</td>
                            <td>${producto.tipo.titulo}</td>
                            <td>${producto.color.titulo}</td>
                            <td>${producto.talla}</td>
                            <td><mytag:formatCurrency moneda="${producto.precio}"/></td>
                            <td>${producto.disponibles}</td>
                            <td>
                                <a href="ventas/detalles_producto.view?id=${producto.id}">
                                    <img src="imagenes/carrito.png" width="40" height="40"/>
                                </a>
                            </td>
                        </tr>
                    </jsp:body>
                </mytag:forEach>
                <% /* } } */%>
            </tbody>
        </table>
    </body>
</html>