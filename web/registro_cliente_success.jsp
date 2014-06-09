<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="mx.com.develop.store.model.Cliente"%> 

<!DOCTYPE html>
<html>
    <head>
        <title>Develop Store: Registro</title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'> 
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'> 
                <td>
                    <h3><font color="white">Develop Store: Registro Satisfactorio.</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    <b>Usted esta aqui:</b> <a href="index.html">Inicio</a> /Registro Cliente
                </td> 
            </tr> 
        </table>

        <p>Te has registrado de manera satisfactoria abjo la siguiente informacion</p>
        <b>Nombre:</b><%= ((Cliente) request.getAttribute("cliente")).getNombre() %><br/>
        <b>Edad:</b>${cliente.edad}<br/>
        <b>Direccion:</b>${cliente.direccion}<br/>
        <b>Telefono:</b>${cliente.telefono}<br/>
        <b>Usuario:</b>${cliente.usuario}<br/>
        <b>Contrasena:</b>${cliente.contrasena}<br/>
    </body>
</html>
