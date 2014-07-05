<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List" %>
<%@page import="mx.com.develop.store.model.Producto" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Develop Store: Listado de Productos</title>
        <style type="text/css">
            #table {
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'>
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'>
                <td>
                    <h3><font color="white">Develop Store: Listado de Productos</h3>
                </td>
            </tr>
            <tr align='right'>
                <td>
                    <table>
                        <tr>

                            <td>Usuario: </td>
                            <%--<td><%= request.getAttribute("usuario") %></td>--%>
                            <!--td>${sessionScope.cliente.nombre}</td-->
                            <td>
                                <% Cookie cookies[] = request.getCookies();
                                    for (Cookie cookie : cookies) {
                                        if (cookie.getName().equalsIgnoreCase("nombreCliente")) {
                                            out.print(cookie.getValue());
                                            break;
                                        }
                                    }
                                %>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <b>Usted esta aqui:</b> <a href="index.html">Inicio</a>/Listado de Productos
        <h2>Lista de Productos:</h2>
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
                <%                    if (request.getAttribute("productos") != null) {
                        List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                        for (Producto producto : productos) {
                %>
                <tr>
                    <td><%=producto.getId()%></td>
                    <td><%=producto.getDescripcion()%></td>
                    <td><%=producto.getTipo().getTitulo()%></td>
                    <td><%=producto.getColor().getTitulo()%></td>
                    <td><%=producto.getTalla()%></td>
                    <td><%=producto.getPrecio()%></td>
                    <td><%=producto.getDisponibles()%></td>
                    <td>
                        <a href="<%= response.encodeRedirectURL("ventas/detalles_producto.view?id=" + producto.getId())%>">
                            <img src="imagenes/carrito.png" width="40" height="40"/>
                        </a>
                    </td>
                </tr>
                <%      }
                    }%>
            </tbody>
        </table>
    </body>
</html>