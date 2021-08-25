<!-- @author: David Alejandro Lopez Torres -->
<!-- @data: 17300155, 8D1 -->
<!-- @date: 11/03/2021 -->

<?php
// String con espacios
$string = 'El mundo            deja       de         tener       el sentido   de antes'; 

// Mediante preg_replace() se cambian las coincidencias de muchos espacios por una sola
$string = preg_replace('/\s\s+/', ' ', $string); 
 
// Se imprime la nueva versión de la cadema
echo $string; 
?>