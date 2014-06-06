<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                    <h3><font color="white">Develop Store: Listado de Productos</h3>
                </td> 
            </tr> 
            <tr align='right'> 
                <td>
                    <table>
                        <tr>

                            <td>Usuario: </td>
                            <td><%= request.getParameter("usuario") %></td>
                        </tr>
                    </table>
                </td> 
            </tr> 
        </table>
        <b>Usted está aquí:</b> <a href="index.html">Inicio</a>/Listado de Productos        
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
                    <th>Disponibles</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Playera con estampado de Disney.</td>
                    <td>Playera</td>
                    <td>Rojo</td>
                    <td>CHICA</td>
                    <td>$167.5</td>
                    <td></td>
                    <td><img src="imagenes/carrito.png" width="40" height="40" alt="carrito"/>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Pantalón de mezclilla.</td>
                    <td>Pantalon</td>
                    <td>Azul</td>
                    <td>GRANDE</td>
                    <td>$199.99</td>
                    <td></td>
                    <td><img src="imagenes/carrito.png" width="40" height="40" alt="carrito"/>
                    </td>
                </tr>
                <tr >
                    <td>3</td>
                    <td>Blusa morada con cuello V.</td>
                    <td>Blusa</td>
                    <td>Morado</td>
                    <td>MEDIANA</td>
                    <td>$257.99</td>
                    <td></td>
                    <td><img src="imagenes/carrito.png" width="40" height="40" alt="carrito"/>
                    </td>
                </tr>
                <tr >
                    <td>4</td>
                    <td>Camisa con boton premium.</td>
                    <td>Pantalón</td>
                    <td>Café</td>
                    <td>GRANDE</td>
                    <td>$174.5</td>
                    <td></td>
                    <td><img src="imagenes/carrito.png" width="40" height="40" alt="carrito"/>
                    </td>
                </tr>
                <tr >
                    <td>5</td>
                    <td>Playera para caballero con estampado de Dinosaurio.</td>
                    <td>Playera</td>
                    <td>Negro</td>
                    <td>EXTRA_GRANDE</td>
                    <td>$480.99</td>
                    <td></td>
                    <td><img src="imagenes/carrito.png" width="40" height="40" alt="carrito"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>