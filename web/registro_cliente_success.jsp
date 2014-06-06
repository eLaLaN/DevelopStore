<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="mx.com.develop.store.model.Cliente"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'> 
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'> 
                <td>
                    <h3><font color='white'>Develop Store: Registro 
                        Satisfactorio</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    
                </td> 
            </tr> 
        </table>
        <b>Usted está aquí:</b> <a href="index.html">Inicio</a>/Registro Cliente       

        <p>Te has registrado de manera satisfactoria bajo la siguiente 
            información:</p>
        <b>Nombre:</b>${cliente.nombre}<br/>
        <b>Edad:</b>${cliente.edad}<br/>
        <b>Dirección:</b>${cliente.direccion}<br/>
        <b>Teléfono:</b>${cliente.telefono}<br/>
        <b>Usuario:</b>${cliente.usuario}<br/>
        <b>Contraseña:</b>${cliente.contrasenia}<br/>
    </body>
</html>
