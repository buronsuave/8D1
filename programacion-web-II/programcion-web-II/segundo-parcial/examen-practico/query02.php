<!-- 
    @author: David Alejandro López Torres
    @author-id: 17300155
    @date: May 7, 2021
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
		<title>02. Crear XML de Query 02.</title>
	</head>

	<body>
		<h1>02. Consulta de Clientes con Banco BBVA</h1>
		<?php 
			// Credenciales de conexión
			$host="127.0.0.1";
			$user="root";
			$pass="";
            $database="examen-practico-2";

            // Establecer conexion
            $mysqli = new mysqli($host, $user, $pass, $database);
			
            // Validar el estado de la conexion
			if (!$mysqli->connect_errno){

                echo "<br> La Conexion fue exitosa al Servidor. <br>";
            }
			else {
                echo "<br> Conexion Fallida. <br>";
            }

			$query="SELECT * FROM clientes WHERE BancoC = 'BBVA'";
            $result = $mysqli->query($query);

			// crear el Documento XML
			$clientes = new domdocument("1.0");
			$root = new domelement("clientes");
			$root = $clientes->appendChild($root);
			
			while($row = mysqli_fetch_array($result)) 
			{ 
                $idC = $row["idC"];
                $NombC = $row["NombC"];
                $TelC = $row["TelC"];
                $LimCredC = $row["LimCredC"];
                $BancoC = $row["BancoC"];
                $CorreoC = $row["CorreoC"];
                $CiudadC = $row["CiudadC"];

                $cliente = new domelement("cliente");
                $cliente = $root->appendChild($cliente);
                $cliente->setAttribute("id", $idC);

                $nombre = new domelement("nombre", $NombC);
                $nombre = $cliente->appendChild($nombre);

                $telefono = new domelement("telefono", $TelC);
                $telefono = $cliente->appendChild($telefono);

                $credito = new domelement("credito", $LimCredC);
                $credito = $cliente->appendChild($credito);

                $banco = new domelement("banco", $BancoC);
                $banco = $cliente->appendChild($banco);

                $correo = new domelement("correo", $CorreoC);
                $correo = $cliente->appendChild($correo);

                $ciudad = new domelement("ciudad", $CiudadC);
                $ciudad = $cliente->appendChild($ciudad);
			} 

            $clientes->preserveWhiteSpace = false;
            $clientes->formatOutput = true;
            $clientes->save("query02.xml");
			echo "<br>Se creo el archivo XML.";
		?>
	</body>
</html>