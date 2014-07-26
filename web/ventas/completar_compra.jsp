<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="d" uri="http://curso.develop.uaa.mx/5d" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Map"%>
<%@page import="mx.com.develop.store.model.Producto"%>
<%@page import="mx.com.develop.store.model.Producto"%>
<%@page import="mx.com.develop.store.model.Venta"%>

<c:if test="${cliente eq null}">
    <jsp:forward page="detalles_producto_error.jsp"/>
</c:if>

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
                    <h3><font color="white">Develop Store: Detalles de la compra.</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    <table>
                        <tr>
                            <td></td>
                            <td>
                                Usuario: ${cliente.nombre} <a href="logout.do">Salir</a>
                            </td>
                        </tr>
                    </table>
                </td> 
            </tr> 
        </table>
        <b>Usted está aquí:</b> <a href="../index.jsp">Inicio</a>/Detalles de la compra.
        <h2>La compra se realizó con éxito, aquí los detalles:</h2>
        <b>Compra realizada desde:</b> ${header["user-agent"]}</br>
        <b>Id de la compra:</b> ${cookie.JSESSIONID.value}</br>
        <b>Prueba del operador div:</b>${5 div 0}<br/>
        
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
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    Venta venta = (Venta) request.getAttribute("venta");
                    if (venta != null) {
                        Map<Producto, Integer> productosVenta = venta.getProductos();
                        Collection<Producto> productos = productosVenta.keySet();
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
                    <td><%= productosVenta.get(producto)%></td>                    
                </tr>
                <%
                        }
                    }
                %>
                <c:set var="subtotal" value="${total div 1.16}" scope="page"/>
                <c:set var="iva" value="${total - subtotal}" scope="page"/>
                <tr>
                    <td colspan="6"><b>IVA</b></td>
                    <td>$${iva}</td>
                </tr>
                <tr>
                    <td colspan="6"><b>Sub-total</b></td>
                    <td>$${subtotal}</td>
                </tr>
                <tr>
                    <td colspan="6"><b>Total</b></td>
                    <td>$${total}</td>
                </tr>
            </tbody>
        </table>
           
        <jsp:useBean id="factura" class="mx.com.develop.store.model.Factura" scope="request">
            <jsp:setProperty name="factura" property="cliente" value="${cliente}"/>
        </jsp:useBean>
        <jsp:setProperty name="factura" property="subtotal" value="${subtotal}"/>
        <jsp:setProperty name="factura" property="total" value="${total}"/>
        <jsp:setProperty name="factura" property="iva" value="${iva}"/>
                  
     
        <!--c:remove var="iva"/--> <%-- Remove the attribute named iva from all the scopes--%>
        <!--c:catch var="errorFactura"-->
            <!--c:set target="${factura}" property="cliente" value="${cliente}"/-->
            <!--c:set target="${factura}" property="subtotal" value="${subtotal}"/-->
            <!--c:set target="${factura}" property="total" value="${total}"/-->
            <!--c:set target="${factura}" property="iva" value="${iva}"/-->
        <!--/c:catch-->

        <h2>Detalles de la factura:</h2>
        <b>Nombre del cliente:</b>${factura["cliente"]["nombre"]}</br>
        <b>Direccion del cliente:</b>${factura["cliente"].direccion}</br>
        <b>SubTotal:</b>$<jsp:getProperty name="factura" property="subtotal"/></br>
        <b>Iva:</b>
        <c:choose>
            <c:when test="${empty errorFactura}"> 
                $${factura.iva}
            </c:when>
            <c:otherwise>
                Error al calcular IVA: ${errorFactura}
            </c:otherwise>
        </c:choose>
        </br>
       
        <b>Total:</b>$${factura.total}</br>
        
        <p>Los siguientes cupones tienen descuentos en tus próximas compras:</p>
        <c:forTokens items="${cupones}" delims=", " var="cupon" varStatus="status">
            ${status.index}. ${cupon}<br/>
        </c:forTokens>
        <p> <a href="../lista_productos.view">Seguir comprando</a></p>
    </body>
</html>
