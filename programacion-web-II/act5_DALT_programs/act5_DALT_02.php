<!-- @author: David Alejandro Lopez Torres -->
<!-- @data: 17300155, 8D1 -->
<!-- @date: 11/03/2021 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>Expresiones 02</title>
</head>

<body>
<?php

	// Variables del programa
	$cadena1 = "1234567";
	$cadena2 = "abcdefg";
	$patron = "/^[[:digit:]]+$/";
	echo "EXPRESIONES REGULARES<br>";
	echo "FUNCION: 	preg_match()<br><br>";
	
	// Se utiliza preg_match() para verificar la coincidencia
	// [[:digit:]] es el conjunto de los digitos. Se acota toda la cadena con ^ y $
	if (preg_match($patron, $cadena1)) {
		print "<p>La cadena $cadena1 son sólo números.</p>\n";
	} else {
		print "<p>La cadena $cadena1 no son sólo números.</p>\n";
	}
	
	if (preg_match($patron, $cadena2)) {
		print "<p>La cadena $cadena2 son sólo números.</p>\n";
	} else {
		print "<p>La cadena $cadena2 no son sólo números.</p>\n";
	}
?>
</body>
</html>
