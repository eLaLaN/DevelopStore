<%@tag pageEncoding="UTF-8" body-content="empty" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" uri="http://curso.develop.uaa.mx/5d" %>

<%@attribute name="titulo" %>

<table border='0' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#3882C7' align='center' valign='center' height='20'>
        <td>
            <h3><font color="white">${titulo}</h3>
        </td>
    </tr>
    <tr align='right'>
        <td>
            <table style="text-align: right">
                <tr>
                    <td>
                        <mytag:if test="${sessionScope.cliente ne null}">
                            <mytag:then>
                                <b>Ir a:</b>&nbsp;<a href="ventas/lista_carrito.jsp">Ver carrito de compras</a>
                            </mytag:then>
                            <mytag:else>
                                <b>Usted esta aqui:</b>&nbsp;<a href="index.jsp">Inicio</a> / Registro Cliente
                            </mytag:else>
                        </mytag:if>
                    </td>
                </tr>
                <tr>
                    <td>
                        Usuario:
                        <c:out value="${sessionScope.cliente.nombre}" escapeXml="false">
                            <b>Invitado</b>
                        </c:out>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
