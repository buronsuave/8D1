<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Lectura de XML.</title>
</head>

<body>
	<h1>Platillos del Menu.</h1>
	<?php $platillos = simplexml_load_file("platillos.xml"); ?>
	Selecciona un Platillo: <select name="platillos">
	<?php foreach ($platillos->platillo as $plato) 
	{ ?>
	   <option value="<?php echo $plato->nombre; ?>"><?php echo $plato->nombre; ?></option>
	  	
	<?php } ?>
    </select>
</body>
</html>
