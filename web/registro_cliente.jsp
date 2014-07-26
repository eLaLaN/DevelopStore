<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mytags" uri="http://curso.develop.uaa.mx/5d" %>
<%--@taglib prefix="mytags" tagdir="/WEB-INF/tags"--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Develop Store: Registro</title>
    </head>
    <body>
        <mytags:header titulo="Registro Cliente"/>

        <p>Los campos marcados con * son obligatorios:</p>
        <form action="registro_cliente.do" method="POST">
            <table border="0">
                <tr>
                    <td><sup>*</sup>Nombre: </td>
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
                    <td><sup>*</sup>Usuario: </td>
                    <td><input type="text" name="usuario" value="" size="20" /></td>
                </tr>
                <tr>
                    <td><sup>*</sup>Contrasena: </td>
                    <td><input type="password" name="contrasena" value="" size="20" /></td>
                </tr>
                <tr>
                    <td>
                        <img src="captcha.jpg" width="137" height="56" alt="1"/>
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

