<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="mx.com.develop.store.model.TipoProducto"%>
<%@page import="mx.com.develop.store.model.Talla"%>
<%@page import="mx.com.develop.store.model.Color"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Develop Store: Registro Productos</title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'>
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'>
                <td>
                    <h3><font color="white">Develop Store: Registro Productos</h3>
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
        <b>Usted está aquí:</b>&nbsp;<a href="../index.jsp">Inicio</a>/Admin/Registro Productos
        <p>Los campos marcados con <sup>*</sup> son obligatorios:</p>
        <form method="POST" action="registro_producto.do">
            <table border="0">
                <tr>
                    <td><sup>*</sup>Color:</td>
                    <td>
                        <select name="color">
                            <option>Selecciona...</option>
                            <%
                                Color colores[] = Color.values();
                                for (Color color : colores) {
                            %>
                            <option value="<%= color%>"><%= color.getTitulo()%></option>
                            <%}%>
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><sup>*</sup>Precio:</td>
                    <td><input type="text" name="precio"/></td>
                </tr>
                <tr>
                    <td><sup>*</sup>Talla:</td>
                    <td>
                        <select name="talla">
                            <option>Selecciona...</option>
                            <%
                                Talla tallas[] = Talla.values();
                                for (Talla talla : tallas) {
                            %>
                            <option value="<%= talla%>"><%= talla%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Descripción:</td>
                    <td>
                        <textarea name="descripcion" rows="6" cols="30"></textarea>
                    </td>
                </tr>
                <tr>
                    <td><sup>*</sup>Tipo:</td>
                    <td><select name="tipo">
                            <option>Selecciona...</option>
                            <%
                                TipoProducto tipos[] = TipoProducto.values();
                                for (TipoProducto tipo : tipos) {
                            %>
                            <option value="<%= tipo%>"><%= tipo.getTitulo()%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><sup>*</sup>Disponibles</td>
                    <td>
                    <td><input type="text" name="disponibles"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Registrar" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>

