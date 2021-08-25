<!-- 
    @author: David Alejandro López Torres
    @author-id: 17300155
    @date: April 23, 2021
    @topic: Programación Web II
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

        <meta name="author" content="David Alejandro López Torres"/>
        <meta name="author-id" content="17300155"/>
        <meta name="date" content="May 7, 2021"/>
        <meta name="topic" content="Programación Web II"/>

        <title>02. Lectura de XML</title>

        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>

    </head>

    <body>
    <h1>02. Consulta de Clientes con Banco BBVA</h1>
        <!-- Obtener estudiantes desde el archivo xml -->
        <?php $clientes = simplexml_load_file("query02.xml"); ?>
        
        <table>
        <tr>
            <th>Nombre</th>
            <th>Telefono</th>
        </tr>
        <!-- Iterar sobre cada uno de los estudiantes en el archivo -->
        <?php foreach ($clientes->cliente as $cliente) 
            { ?>
                <tr>
                    <td><?php echo $cliente->nombre;?></td>
                    <td><?php echo $cliente->telefono;?></td>
                </tr>
            <?php } ?>
        </table>
    </body>
</html>
