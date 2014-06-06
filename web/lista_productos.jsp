<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="mx.com.develop.store.model.Producto"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                            <td><%= request.getAttribute("usuario") %></td>
                        </tr>
                    </table>
                </td> 
            </tr> 
        </table>
        <b>Usted está aquí:</b> <a href="index.html">Inicio</a>/Listado de Productos        
        <h2>Lista de Productos:</h2>
        <table border="1" width="800" id="table">
            <thead>
                <tr bgcolor='#3882C7'>
                    <th>No.</th>
                    <th>Descripción</th>
                    <th>Tipo</th>
                    <th>Color</th>
                    <th>Talla</th>
                    <th>Precio</th>
                    <th>Disponibles</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Producto> productos = (List<Producto>) 
                            request.getAttribute("productos");
                    int i = 0;
                    for (Producto producto : productos) {
                        i++;
                %>
                <tr id="td">
                    <td><%= i%></td>
                    <td><%= producto.getDescripcion()%></td>
                    <td><%= producto.getTipo().getTitulo()%></td>
                    <td><%= producto.getColor().getTitulo()%></td>
                    <td><%= producto.getTalla()%></td>
                    <td>$<%= producto.getPrecio()%></td>
                    <td></td>
                    <td><img src="imagenes/carrito.png" width="50" 
                             height="50" alt="carrito"/>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>