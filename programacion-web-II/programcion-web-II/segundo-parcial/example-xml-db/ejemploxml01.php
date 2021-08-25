<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Crear XML desde una Consulta a MySQL.</title>
	</head>

	<body>
		<h1>Consulta de Platillos</h1>
		<?php 
			$local="127.0.0.1";
			$usuario="root";
			$contra="";
			$conectar=mysql_connect($local, $usuario, $contra);
			
			//valida que la conexion sea correcta
			if ($conectar>=1)
				echo "<br> La Conexion fue exitosa al Servidor. <br>";
			else 
				echo "<br> Conexion Fallida. <br>";
			mysql_select_db("bd_practica",$conectar);
			
			$consulta="select * from platillos ";
				
			$resultado=mysql_query($consulta, $conectar);
			
			//mostrar en la pagina los resultados.
			
			echo "Id Platillo 	  Platillo       Precio<br>";
			//Crear el Documento XML
			$platillos = new domdocument("1.0");
			$raiz = new domelement("platillos");
			$raiz = $platillos->appendChild($raiz);
			
			while($row = mysql_fetch_array($resultado)) 
			{ 
				 		 $idp=$row['idplatillo'];
						 $nom=$row['platillo'];
						 $prec=$row['precio'];
						 echo $idp,"  ",$nom,"  ",$prec,"<br>  ";
						 
						 $platillo = new domelement("platillo");
						 $platillo = $raiz->appendChild($platillo);
						 $platillo->setAttribute("id",$idp);
						 
						 $nombre = new domelement("nombre",$nom);
						 $nombre = $platillo->appendChild($nombre);
						
						 $precio = new domelement("precio",$prec);
						 $precio = $platillo->appendChild($precio);

			} 
			$platillos->save("platillos.xml");
			echo "<br>Se creo el archivo XML.";
		?>
	</body>
</html>
