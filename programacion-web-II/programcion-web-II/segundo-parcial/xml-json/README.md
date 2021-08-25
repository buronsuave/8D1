# Programación Web II
## Actividad de XML y JSON
### Parte 1
* Copiar archivo [ejercicio.json](ejercicio.json)
* Generar archivo [ejercicio.min.json](ejercicio.min.json) ([captura](img/ejercicio.min.json.png))
* Traducir el archivo a [ejercicio.xml](ejercicio.xml) ([captura](img/ejercicio.xml.png))
* Traducir el archivo a [ejercicio.min.xml](ejercicio.min.xml) ([captura](img/ejercicio.min.xml.png))
### Parte 2
* Cuadro comparativo entre JSON y XML

| Característica    | XML                                                                                    | JSON                                                                                                          |
|-------------------|----------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| Sencillez         | Resulta sencillo entender las dependencias entre los diferentes niveles de información | En un principio puede parecer más confuso que XML, pero termina siendo simple cuando uno comprende las reglas |
| Extensibilidad    | Tiene un tamaño que es generalmente mucho más grande que el JSON (incluso minificado)  | Posee una forma compacta de representar mucha información                                                     |
| Interoperabilidad | Es fácil leer datos desde php                                                          | Es fácil leer datos desde javascript                                                                          |
| Interpretabilidad | Tiene una lectura fluida y simple, al igual que el enmarcado HTML                      | Puede generar algunas dudas a medida que las anidaciones crecen                                               |
| Confiabilidad     | Está diseñado bajo los estándares de los navegadores                                   | Está diseñado para el manejo de datos con javascript, por lo que es ligeramente más inseguro que XML          |


### Parte 3
* Realizar la minificación de los arcivos de colores json
    * A partir del [colores1.json](colores1.json) generar el [colores1.min.json](colores1.min.json) ([captura](img/colores1.min.json.png))
    * A partir del [colores2.json](colores2.json) generar el [colores2.min.json](colores2.min.json) ([captura](img/colores2.min.json.png))
    * A partir del [colores3.json](colores3.json) generar el [colores3.min.json](colores3.min.json) ([captura](img/colores3.min.json.png))
* Traducir los archivos de colores json a xml
    * A partir del [colores1.json](colores1.json) generar el [colores1.xml](colores1.xml) ([captura](img/colores1.xml.png))
    * A partir del [colores2.json](colores2.json) generar el [colores2.xml](colores2.xml) ([captura](img/colores2.xml.png))
    * A partir del [colores3.json](colores3.json) generar el [colores3.xml](colores3.xml) ([captura](img/colores3.xml.png))
    
### Parte 4
* Generar un código HTML para la representación de una tabla a partir de un objeto JSON. El resultado se encuentra en [json_tabla.html](json_tabla.html)
### Parte 5
* Modificar el archivo [leerYescribir_json.php](leerYescribir_json.php) con primer y segundo nombre del alumno, y poner una calificación para aprobar y una para reprobar. Al ejecutar debe generar al archivo [alumnos2.json](alumnos2.json)