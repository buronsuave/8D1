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

		<title>Crear XML desde una Consulta a MySQL</title>
	</head>

	<body>
		<h1>Consulta de Estudiantes</h1>
		<?php 
            // Credenciales de conexión
			$host="127.0.0.1";
			$user="root";
			$pass="";
            $database="School";

            // Establecer conexion
            $mysqli = new mysqli($host, $user, $pass, $database);
			
			// Validar el estado de la conexion
			if (!$mysqli->connect_errno){

                echo "<br> La Conexion fue exitosa al Servidor. <br>";
            }
			else {
                echo "<br> Conexion Fallida. <br>";
            }

            // Generar una nueva consulta para obtener a todos los estudiantes 
            // de la base de datos "School" en la tabla "Student"
			$query="SELECT * FROM Student";				
			$result = $mysqli->query($query);
			
            // Mostrar cabecera de los resultados
			echo "Id = Nombre Apellido; Edad<br><br>";
            
			// Crear el Documento XML
			$students = new domdocument("1.0");
			$root = new domelement("estudiantes");
			$root = $students->appendChild($root);
			
			while($row = mysqli_fetch_array($result)) 
			{ 
                // Obtener valores del estudiante
                $id=$row['Id'];
                $fName=$row['FirstName'];
                $lName=$row['LastName'];
                $age=$row['Age'];
                
                // Mostrar valores en la página
                echo $id," = ",$fName," ",$lName, " ; ", $age,"<br>";
                
                // Crear la tag del estudiante con id de atributo
                $student = new domelement("estudiante");
                $student = $root->appendChild($student);
                $student->setAttribute("id",$id);
                
                // Dentro de estudiante poner el nombre
                $firstName = new domelement("nombre",$fName);
                $firstName = $student->appendChild($firstName);
                
                // Dentro del estudiante poner el apellido
                $lastName = new domelement("apellido",$lName);
                $lastName = $student->appendChild($lastName);

                // Dentro del estudiante poner la edad
                $sAge = new domelement("edad",$age);
                $sAge = $student->appendChild($sAge);

			} 

            // Formatear el archivo y guardar
            $students->preserveWhiteSpace = false;
            $students->formatOutput = true;
			$students->save("estudiantes.xml");

            // Indicar que todo salió correctamente
			echo "<br>Se creo el archivo XML.";
		?>
	</body>
</html>
