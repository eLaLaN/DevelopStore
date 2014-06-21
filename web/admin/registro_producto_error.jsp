<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Develop Store: Registro Producto</title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'>
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'>
                <td>
                    <h3><font color="white">Develop Store: Registro Producto</h3>
                </td>
            </tr>
            <tr align='right'>
                <td>
                    <table>
                        <tr>
                            <td>Usuario: </td>
                            <%--<td><%= request.getAttribute("usuario") %></td>--%>
                            <td>${usuario}</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <b>Usted está aquí:</b>&nbsp;<a href="../index.html">Inicio</a>/Admin/Registro Producto
        <h3>Corrige los siguientes errores:</h3>
        <% List<String> listaErrores = (List<String>) request.getAttribute("listaErrores");%>
        <font color="red">
        <ul>
            <%
                for (String error : listaErrores) {
            %>
            <li>
                <%=error%>
            </li>
            <%}%>
        </ul>
        </font>
        <a href="registro_producto.jsp">Regresar</a>
    </body>
</html>
