<?php
$path="alumnos2.json";
$file=fopen($path,"w");

//Escribir en el arreglo:
$alumnos=array(
	array("nombre"=>"David","calif"=>"95"),
	array("nombre"=>"Alejandro","calif"=>"60")
);

//Codificarlo:
$json=json_encode($alumnos);
//Y Guardarlo:
fwrite($file, $json);
fclose($file);

//*con archivo externo
$path="alumnos2.json";
$json=file_get_contents($path);
$json=json_decode($json,true);

echo "<table border='1'>";
for($i=0;$i<count($json);$i++){
	$n=$json[$i]['nombre'];
    $v=$json[$i]['calif'];
    echo "<tr><td>".$n."</td><td>".$v."</td></tr>";
}
echo "</table>";

?>