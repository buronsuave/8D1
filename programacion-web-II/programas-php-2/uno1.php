<?php

$num1=$_POST['n1'];
$num2=$_POST['n2'];
$oper=$_POST['op'];
$resp=" ";

switch ($oper){
    case "1":
        echo "Programa Par e impar";
        echo "<br>";
        if (($num1%2)==0){
            $resp= "El numero ".$num1." es par<br>";
            $o="If, condicional de dos alternativas";
        }
        else{
            $resp= "El numero ".$num1." es impar<br>";
            $o="If, condicional de dos alternativas";
        }
    break;
    case "2":
        echo "Programa 1 al 20";
        echo "<br>";
        for ($i=1; $i<=$num1; $i++){
            $resp=$resp." ".$i;
        }
        $o="For, bucle con numero de iteraciones fijas";
    break;
    case "3":
        echo "<br>";
        echo "Programa dia de la semana";
        echo "<br>";

        switch ($num1){
            case 1: 
                $resp= "Lunes";
                break;
            case 2: 
                $resp= "Martes";
                break;
            case 3: 
                $resp= "Miércoles";
                break;
            case 4: 
                $resp= "Jueves";
                break;
            case 5: 
                $resp= "Viernes";
                break;
            case 6: 
                $resp= "Sábado";
                break;
            case 7: 
                $resp= "Domingo";
                break;
            default:
                $resp= "Día no existente";

        }
        $o="Switch, condicional de varias alternativas";
    break;
}
echo "<br>";
header("Location:formulario.php?r=".$resp."&opera=".$o);
echo "<br>";
?>