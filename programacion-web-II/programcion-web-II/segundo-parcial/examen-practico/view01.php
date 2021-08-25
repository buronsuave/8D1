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

        <title>01. Lectura de XML</title>
    </head>

    <body>
        <h1>01. Consulta de Clientes con Crédito mayor a 10,000</h1>
        <!-- Obtener estudiantes desde el archivo xml -->
        <?php $clientes = simplexml_load_file("query01.xml"); ?>
        
        Selecciona un cliente: 
        
        <select name="clientes">
            <!-- Iterar sobre cada uno de los estudiantes en el archivo -->
            <?php foreach ($clientes->cliente as $cliente) 
            { ?>
                <!-- Generar una opción con "nombre" de valor del cliente en cuestión --> 
                <option value="<?php echo $cliente->nombre;?>">
                    <?php echo $cliente->nombre;?>
                </option>
            <?php } ?>
        </select>
    </body>
</html>
