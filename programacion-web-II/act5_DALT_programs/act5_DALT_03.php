<!-- @author: David Alejandro Lopez Torres -->
<!-- @data: 17300155, 8D1 -->
<!-- @date: 11/03/2021 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Expresiones 03</title>
</head>

<body>

<?php

	// Variables del programa
	$cadena = "Esto es una cadena de prueba";
	$patron = "/de/";

	// Encuentra todas las coincidencias del patrón y se guardan en el arrgelo $coincidencias
	$encontrado = preg_match_all($patron, $cadena, $coincidencias, PREG_OFFSET_CAPTURE);
	echo "EXPRESIONES REGULARES<br>";
	echo "FUNCION: 	preg_match_all()<br><br>";
	
	if ($encontrado) {
		print "<pre>"; print_r($coincidencias); print "</pre>\n";
		print "<p>Se han encontrado $encontrado coincidencias.</p>\n";

		// Se itera a través de todas las coincidencias
		foreach ($coincidencias[0] as $coincide) {
			print "<p>Cadena: '$coincide[0]' - Posición: $coincide[1]</p>\n";
		}
	} else {
		print "<p>No se han encontrado coincidencias.</p>\n";
	}
?>
</body>
</html>
