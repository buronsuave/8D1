<!-- @author: David Alejandro Lopez Torres -->
<!-- @data: 17300155, 8D1 -->
<!-- @date: 11/03/2021 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Expresiones 01</title>
</head>

<body>

<?php
	
	// Variables del programa
	$cadena = "aaAA123";
	$patron1 = "/^[a-z]+$/";
	$patron2 = "/^[a-z]+$/i";
	echo "EXPRESIONES REGULARES<br>";
	echo "FUNCION: 	preg_match()<br><br>";
	
	// Utilizar preg_match() para buscar coincidencias
	// /i modifica para capitalizar o minimizar las letras
	if (preg_match($patron1, $cadena)) {
		print "<p>La cadena $cadena son sólo letras min�sculas.</p>\n";
	} else {
		print "<p>La cadena $cadena no son sólo letras min�sculas.</p>\n";
	}
	
	if (preg_match($patron2, $cadena)) {
		print "<p>La cadena $cadena son sólo letras minúsculas o mayúsculas.</p>\n";
	} else {
		print "<p>La cadena $cadena no son sólo letras minúsculas o mayúsculas.</p>\n";
	}
?>

</body>
</html>
