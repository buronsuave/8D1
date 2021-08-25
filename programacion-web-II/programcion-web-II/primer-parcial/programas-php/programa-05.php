<!-- @author: David Lopez 17300155 -->
<!-- @date: febrero 21, 2021 -->

<html>
    <head>
        <title>Programa 5</title>
    </head>
    <body>
        Ingrese una distancia y su medida para convertir a pies o metros<br><br>
        <form action="" method="GET">
        Valor: <br>
        <input name="num" type="text">
        <select name="op">
            <option value="mt" selected="selected">Metros</option>
            <option value="ft">Pies</option>
        </select>
        <button type="submit">Ejecutar</button><br>
        </form>

        <?php
            // Revisar si hay entrada por GET
            if ($_GET['num'] && $_GET['op']){
                
                $factor = 3.28084;

                // Almacenar el valor (string)
                $num = $_GET['num'];
                $op = $_GET['op'];
                
                // Verificar si el valor (string) es numérico
                if (is_numeric($num) != 1){
                    echo $num, " no es un numero";
                    return;
                }

                // Obtener el valor en decimal
                $num = doubleval($num);
                
                // Hacer switch para realizar la operación
                switch($op){
                    case 'mt': 
                        echo $num, ' metros son ', $num*$factor, ' pies';
                        break;
                    case 'ft':
                        echo $num, ' pies son ', $num/$factor, ' metros';
                        break;
                    default:
                        echo "Algo salio mal";
                        break;
                }

            } else {
                echo "Ingrese todos los campos";
            }
        ?>
    </body>
</html>