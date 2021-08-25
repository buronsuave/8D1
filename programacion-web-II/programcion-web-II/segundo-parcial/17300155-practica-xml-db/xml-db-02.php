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
        <meta name="date" content="April 23, 2021"/>
        <meta name="topic" content="Programación Web II"/>

        <title>Lectura de XML</title>
    </head>

    <body>
        <h1>Estudiantes de la Escuela</h1>
        <!-- Obtener estudiantes desde el archivo xml -->
        <?php $estudiantes = simplexml_load_file("estudiantes.xml"); ?>
        Selecciona un Estudiante: 
        
        <select name="estudiantes">
            <!-- Iterar sobre cada uno de los estudiantes en el archivo -->
            <?php foreach ($estudiantes->estudiante as $estudiante) 
            { ?>
                <!-- Generar una opción con "nombre apellido" de valor y texto del estudiante en cuestión --> 
                <option value="<?php echo $estudiante->nombre, " ", $estudiante->apellido; ?>">
                    <?php echo $estudiante->nombre, " ", $estudiante->apellido;?>
                </option>
            <?php } ?>
        </select>
    </body>
</html>
