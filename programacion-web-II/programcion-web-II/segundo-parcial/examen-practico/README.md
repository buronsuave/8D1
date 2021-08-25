# Examen Práctico PWII P2
## Parte 1: Base de Datos 
Generar una base de datos de mysql con base al archivo [clientes.sql](clientes.sql) (asegurarse de conocer las credenciales de usuario y contraseña que se usan en el fichero php, por defecto es:
> mysql -u root -p

## Parte 2: Consultas y generación de archivos
1. Generar el archivo [query01.php](query01.php) para mostrar el resultado de la siguiente consulta: 

    ``` SELECT * FROM clientes WHERE LimCredC > 10000```

    con base al resultado, generar el fihero [query01.xml](query01.xml) para vaciar los resultados. Generar un 2do fichero php [view01.php](view01.php) para mostrar los resultados en un cuadro de selección
<br></br>

1. Generar el archivo [query02.php](query02.php) para mostrar el resultado de la siguiente consulta: 

    ``` SELECT * FROM clientes WHERE BancoC = 'BBVA' ```

    con base al resultado, generar el fihero [query02.xml](query02.xml) para vaciar los resultados. Generar un 2do fichero php [view02.php](view02.php) para mostrar los resultados en una tabla
<br></br>

1. Generar el archivo [query03.php](query03.php) para mostrar el resultado de la siguiente consulta: 

    ``` SELECT * FROM clientes WHERE CiudadC = 'TNL' ```

    con base al resultado, generar el fihero [query03.xml](query03.xml) para vaciar los resultados. Generar un el fichero [view03.xsl](view03.xsl) para modificar el estilo del fichero xml generado (abrir el xml para observar que se hace referencia al archivo xsl y en navegador se aplica este estilo)
    <br></br>

1. Generar el archivo [query02.json](query02.json) a partir del archivo [query02.xml](query02.xml) (utilice un convertidor en línea para ello)