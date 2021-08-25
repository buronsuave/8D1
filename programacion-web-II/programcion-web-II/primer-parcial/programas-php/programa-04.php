<!-- @author: David Lopez 17300155 -->
<!-- @date: febrero 21, 2021 -->

<html>
    <head>
        <title>Programa 4</title>
    </head>
    <body>
        Ingrese dos numeros y una operacion<br><br>
        <form action="" method="GET">
        Numero 1:<br>
        <input name="num1" type="text"><br><br>
        Numero 2:<br>
        <input name="num2" type="text"><br><br>
        Operacion:<br>
        <select name="op">
            <option value="add" selected="selected">Suma</option>
            <option value="sub">Resta</option>
            <option value="mul">Multiplicacion</option>
            <option value="div">Division</option>
        </select>
        <button type="submit">Ejecutar</button><br>
        </form>

        <?php
            // Revisar si hay entrada por GET
            if ($_GET['num1'] && $_GET['num2'] && $_GET['op']){

                // Almacenar el valor (string)
                $num1 = $_GET['num1'];
                $num2 = $_GET['num2'];
                $op = $_GET['op'];
                
                // Verificar si el valor (string) es numérico
                if (is_numeric($num1) != 1){
                    echo $num1, " no es un numero";
                    return;
                }
                if (is_numeric($num2) != 1){
                    echo $num2, " no es un numero";
                    return;
                }

                // Obtener el valor en decimal
                $num1 = doubleval($num1);
                $num2 = doubleval($num2);
                
                // Hacer switch para realizar la operación
                switch($op){
                    case 'add': 
                        echo $num1, ' + ', $num2, ' = ', $num1+$num2;
                        break;
                    case 'sub': 
                        echo $num1, ' - ', $num2, ' = ', $num1-$num2;
                        break;
                    case 'mul': 
                        echo $num1, ' * ', $num2, ' = ', $num1*$num2;
                        break;
                    case 'div': 
                        echo $num1, ' / ', $num2, ' = ', $num1/$num2;
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