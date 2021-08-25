<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>02</title>
	</head>

	<body>
		<h1>Ejercicio 02</h1>
		<?php 
			$host="127.0.0.1";
			$user="root";
			$pass="";
            $database="examen";
            $mysqli = new mysqli($host, $user, $pass, $database);
			if (!$mysqli->connect_errno) 
                echo "<br>Se conectó correctamente<br>";
			else
                echo "<br>No se conectó<br>";
			$query="SELECT * FROM clientes WHERE CiudadC = 'TNL'";
            $result = $mysqli->query($query);
			$clientes = new domdocument("1.0");
            $xslt = $clientes->createProcessingInstruction('xml-stylesheet', 'type="text/xsl" href="ejercicio3.xsl"');
            $clientes->appendChild($xslt);
			$root = new domelement("Clientes");
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
                $cliente = new domelement("Cliente");
                $cliente = $root->appendChild($cliente);
                $cliente->setAttribute("idC", $idC);
                $nombre = new domelement("NombC", $NombC);
                $nombre = $cliente->appendChild($nombre);
                $telefono = new domelement("TelC", $TelC);
                $telefono = $cliente->appendChild($telefono);
                $credito = new domelement("LimCredC", $LimCredC);
                $credito = $cliente->appendChild($credito);
                $banco = new domelement("BancoC", $BancoC);
                $banco = $cliente->appendChild($banco);
                $correo = new domelement("CorreoC", $CorreoC);
                $correo = $cliente->appendChild($correo);
                $ciudad = new domelement("CiudadC", $CiudadC);
                $ciudad = $cliente->appendChild($ciudad);
			} 
            $clientes->preserveWhiteSpace = false;
            $clientes->formatOutput = true;
            $clientes->save("ejercicio3.xml");
			echo "<br>XML generado<br>";
		?>
	</body>
</html>