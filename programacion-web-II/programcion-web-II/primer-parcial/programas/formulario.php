<!DOCTYPE html>
<html lang="es">
<head>
<title>Estructuras basicas en PGP</title>

<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    

<meta name="description" content="comparacion, bucle, estructura de control, modulo">
<link rel="stylesheet" href="estilos.css" />
<link rel="shortcut icon" href="/favicon.ico" />
</head>
 
<body>
    <header>
       <h1>Mi sitio web</h1>
       <p>Mi sitio web creado en html5</p>
       
    </header>
    <nav>
       <ul class="navbar">
            <li><a class="active" href="formulario.php">Datos</a></li>
            <li><a href="formulario.php?uno=PROGRAMA QUE VERIFICA SI UN NUMERO ES PAR O IMPAR">Uno</a></li>
            <li><a href="formulario.php?uno=PROGRAMA QUE VERIFICA MUESTRA LOS NUMEROS DEL 1 AL 20">Dos</a></li>
            <li><a href="formulario.php?uno=PROGRAMA QUE DIA DE LA SEMANA CORRESPONDE AL NUMERO TECLEADO">Tres</a></li>
    </ul>
    </nav>
    
    <section>
       <article>
           <?php
                if (isset($_GET['uno'])){
                    echo "<br>";
                    echo $_GET['uno'];
                }
                else{
                    ?>   
           <h2>Formulario</h2>
           <p> 
                <form name="datos" id="datos" action="uno1.php" method="post">
                    <input type="number" name="n1" id="n1" placeholder="Numero 1" required>
                    <input type="number" name="n2" id="n2" placeholder="Numero 2">
                    <select name="op" id="op">
                        <option value="1">Par/Impar</option>
                        <option value="2">1 al 20</option>
                        <option value="3">Dia de la semana</option>
                    </select>
                    
                    <input type="submit" value="Enviar">
                </form>
           </p>
        <?php
                }
        ?>
       </article>
    </section>
    <aside class="dcha">
       <h3>Estructuras de control</h3>
        <h4>Resultado</h4>
           <p><?php 
               if (isset($_GET['r'])){
                    echo $_GET['opera'];
                    echo "<br>";
                    echo "<br>";
                    echo $_GET['r'];
               }
               ?></p>
    </aside>
    <footer>
        <address>Creado por mi</address>
    </footer>

</body>
</html>