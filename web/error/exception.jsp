<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'>
            <tr bgcolor="#FF0000" align='center' valign='center' height='20'>
                <td>
                    <h3>
                        <font color='white'>Error interno.
                    </h3>
                </td>
            </tr>
            <tr align='right'>
                <td>

                </td>
            </tr>
        </table>
        <img src="<c:url value="/error/error_interno.png"/>" width="579" height="309" alt="error_interno"/>
        <p>
            Detalles del error: <% exception.printStackTrace(new java.io.PrintWriter(out));%>
        </p>
    </body>
</html>
