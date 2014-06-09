<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Develop Store: Registro</title>
    </head>
    <body>
        <table border='0' cellpadding='5' cellspacing='0' width='800'> 
            <tr bgcolor='#3882C7' align='center' valign='center' height='20'> 
                <td>
                    <h3><font color="white">Develop Store: Registro de clientes.</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    <b>Usted esta aqui:</b> <a href="index.html">Inicio</a>/Registro Cliente
                </td> 
            </tr> 
        </table>

        <form action="registro_cliente.do" method="POST">
            <table border="0">
                <tr>
                    <td>Nombre: </td>
                    <td><input type="text" name="nombre" value="" size="20" /></td>
                </tr>
                <tr>
                    <td>Edad: </td>
                    <td><input type="text" name="edad" value="" size="3" /></td>
                </tr>
                <tr>
                    <td>Direccion: </td>
                    <td><input type="text" name="direccion" value="" size="40" /></td>
                </tr>
                <tr>
                    <td>Telefono: </td>
                    <td><input type="text" name="telefono" value="" size="15" /></td>
                </tr>
                <tr>
                    <td>Usuario: </td>
                    <td><input type="text" name="usuario" value="" size="20" /></td>
                </tr>
                <tr>
                    <td>Contrasena: </td>
                    <td><input type="password" name="contrasena" value="" size="20" /></td>
                </tr>
                <%
                int aleatorio = ((int) (Math.random() * (3 - 1 + 1) + 1));
                %>
                <tr>
                    <td>
                        <img src="imagenes/<%=aleatorio%>.png" width="137" height="56" alt="1"/>
                    </td>
                    <td>
                        Escribe el texto de la imagen.<br/>
                        <input type='text' name='captcha' value='' size='20' />
                    </td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Registrarse" />
        </form>
    </body>
</html>

