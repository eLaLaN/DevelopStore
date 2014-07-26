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
            <table>
                <tr>
                    <td>
                        <c:if test="${sessionScope.cliente ne null}">
                            <a href="ventas/lista_carrito.jsp">Ver carrito de compras</a> / 
                        </c:if>
                    </td>
                    <td>Usuario: </td>
                    <%--<td><%= request.getAttribute("usuario") %></td>--%>
                    <!--td>${sessionScope.cliente.nombre}</td-->
                    <td>
                        <% /* Cookie cookies[] = request.getCookies();
                            for (Cookie cookie : cookies) {
                                if (cookie.getName().equalsIgnoreCase("nombreCliente")) {
                                    out.print(cookie.getValue());
                                    break;
                                }
                            }
                        */ %>
                        <core:out value="${cookie.nombreCliente.value}" escapeXml="false">
                            <b>Invitado</b>
                        </core:out>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>EL:</td>
                    <td>\${sessionScope.cliente.nombre}</td>
                </tr>
            </table>
        </td>
    </tr>
</table>