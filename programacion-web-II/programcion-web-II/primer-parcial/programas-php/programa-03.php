<!-- @author: David Lopez 17300155 -->
<!-- @date: febrero 21, 2021 -->

<html>
    <head>
        <title>Programa 3</title>
    </head>
    <body>
        Ingrese un entero del 1 al 7 para verificar el día de la semana<br><br>
        <form action="" method="GET">
        Numero:<br>
        <input name="num" type="text"><br><br>
        <button type="submit">Ejecutar</button><br>
        </form>

        <?php
            // Revisar si hay entrada por GET
            if ($_GET['num']){

                // Almacenar el valor (string)
                $num = $_GET['num'];
                
                // Verificar si el valor (string) es numérico
                if (is_numeric($num) != 1){
                    echo $num, " no es un numero";
                    return;
                }

                // Truncar a entero y verificar que no haya decimales
                $aux = floatval($num);
                $num = intval($num);
                if (($aux-$num) != 0){
                    echo $aux, " no es un entero";
                    return;
                }
                
                // Hacer switch para verificar el día de la semana
                switch($num){
                    case 1:
                        echo "Lunes";
                        break;
                    case 2:
                        echo "Martes";
                        break;
                    case 3:
                        echo "Miercoles";
                        break;
                    case 4: 
                        echo "Jueves";
                        break;
                    case 5:
                        echo "Viernes";
                        break;
                    case 6:
                        echo "Sabado";
                        break;
                    case 7:
                        echo "Domingo";
                        break;
                    default: 
                        echo $num, " esta fuera de rango. El numero debe ser entre 1 y 7";
                        break;
                }

            } else {
                echo "Sin datos ingresados";
            }
        ?>
    </body>
</html>