<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="mx.com.develop.store.model.Producto"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Develop Store: Correcto</title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'>
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'>
                <td>
                    <h3><font color="white">Develop Store: Detalles del Producto</h3>
                </td>
            </tr>
            <tr align='right'>
                <td>
                    <table>
                        <tr>
                            <td></td>
                            <td>
                                Usuario: ${cliente.nombre} <a href="../logout.do">Salir</a>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <b>Usted está aquí:</b> <a href="../index.jsp">Inicio</a>/<a href="../lista_productos.view">Listado de Productos</a>/Detalles del Producto<br/>
        <b>Color:</b> ${producto["color"]["titulo"]}</br>
        <%-- Set a "precio" attribute in one scope, so it can be accessible through EL, ${precio}  --%>
        <% pageContext.setAttribute("precio", "precio"); %>
        <b>Precio:</b> ${producto[precio]}</br
        <%-- Set a "productoTalla" attribute in one scope, so it can be accessible through EL, ${productoTalla}  --%>
        <% //pageContext.setAttribute("productoTalla", "talla"); %>
        <c:set var="productoTalla" value="talla"/>
        <b>Talla:</b> ${producto[productoTalla]}</br>
        <b>Descripcion:</b> ${producto.descripcion}</br>
        <b>Tipo:</b> ${producto["tipo"].titulo}</br>

        <form action="<c:url value="agregar_carrito.do"><c:param name="id" value="${param.id}"/></c:url>" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Cantidad:</td>
                        <td>
                            <select name="cantidad">
                                <%
                                    Producto producto = (Producto) request.getAttribute("producto");
                                    int disponibles = producto.getDisponibles();
                                    for (int i = 1; i <= disponibles; i++) {
                                %>
                                <option><%=i%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Agregar a carrito" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
