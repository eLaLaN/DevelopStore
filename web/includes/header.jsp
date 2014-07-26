<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" uri="http://curso.develop.uaa.mx/5d" %>

<style type="text/css">
    #table {
        border-collapse: collapse;
    }
</style>

<table border='0' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#3882C7' align='center' valign='center' height='20'>
        <td>
            <h3><font color="white">Develop Store: ${param.moduloTitulo}</h3>
        </td>
    </tr>
    <tr align='right'>
        <td>
            <table style="text-align: right;">
                <tr>
                    <td>
                        <mytag:if test="${sessionScope.cliente ne null}">
                            <mytag:then>
                                <a href="ventas/lista_carrito.jsp">Ver carrito de compras</a>
                            </mytag:then>
                            <mytag:else>
                                <a href="login.html">Login</a> / <a href="registro_cliente.jsp">Registrate</a>
                            </mytag:else>
                        </mytag:if>
                    </td>
                </tr>
                <tr>
                    <td>
                        <b>Usuario:</b>&nbsp;
                        <%--=request.getAttribute("usuario")--%>
                        <!--td>${sessionScope.cliente.nombre}</td-->
                        <% /* Cookie cookies[] = request.getCookies();
                             for (Cookie cookie : cookies) {
                             if (cookie.getName().equalsIgnoreCase("nombreCliente")) {
                             out.print(cookie.getValue());
                             break;}} */%>
                        <c:out value="${cookie.nombreCliente.value}" escapeXml="false">
                            <b>Invitado</b><!-- Default value cuando c:out es empty o null -->
                        </c:out>
                    </td>
                </tr>
                <tr>
                    <td><b>Escaped EL:</b>&nbsp;\${sessionScope.cliente.nombre}</td>
                </tr>
            </table>
        </td>
    </tr>
</table>