<!-- @author: David Lopez 17300155 -->
<!-- @date: febrero 21, 2021 -->

<html>
    <head>
        <title>Programa 1</title>
    </head>
    <body>
        Ingrese un entero para verifciar si es par o impar<br><br>
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
                
                // Verificar si es par o impar con mod 2
                if ($num % 2 == 0){
                    echo $num, " es par";
                } else {
                    echo $num, " es impar";
                }

            } else {
                echo "Sin datos ingresados";
            }
        ?>
    </body>
</html>