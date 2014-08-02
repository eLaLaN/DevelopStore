<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Develop Store: Inicio</title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'>
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'>
                <td>
                    <h3><font color="white">Develop Store: Inicio</h3>
                </td>
            </tr>
            <tr align='right'>
                <td>
                    <table>
                        <tr>
                            <td><a href="login.html">Login</a></td>
                            <td>/</td>
                            <td><a href="registro_cliente.jsp">Registrate</a>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <h2>Bienvenido a DEVELOP Store.</h2>
        <h3>Clientes</h3>
        <ul>
            <li>
                <a href="lista_productos.view">Ver listado de Productos.</a>
            </li>
            <c:if test="${cliente.usuario eq 'admin'}">
                <li>
                    <a href="admin/registro_producto.jsp">Registro Producto</a>
                </li>
            </c:if>
        </ul>
        <%!
            private static int numeroVisitas = 0;

            private int getVisitanteNumero() {
                return ++numeroVisitas;
            }
        %>
        Visitante numero: <%= this.getVisitanteNumero()%>

        <jsp:include page="fecha.jsp">
            <jsp:param name="label" value="Hoy es:"/>
        </jsp:include>

    </body>
</html>
