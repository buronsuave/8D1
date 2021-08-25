<!-- @author: David Alejandro Lopez Torres -->
<!-- @data: 17300155, 8D1 -->
<!-- @date: 11/03/2021 -->

<?php

$string = 'El feliz murciélago hindú comía feliz cardillo y kiwi'; 

// Original string
echo "Original: ";
echo $string."<br><br>";

// Definiciones de patrones a buscar
$patterns = array(); 
$patterns[0] = '/feliz/' ; 
$patterns[1] = '/cardillo/' ; 
$patterns[2] = '/kiwi/'; 

// Definiciones de cadenas de reemplazo
$subs = array(); 
$subs[2] = 'solitario' ; 
$subs[1] = 'pan'; 
$subs[0] = 'palomitas'; 

/*
Los patrones serán reemplazados en el orden inverso de las sustituiciones
$patterns[0] -> $subs[2]  
$patterns[1] -> $subs[1]  
$patterns[2] -> $subs[0] 
*/ 

// New  string
echo "Susitucion: ";
echo preg_replace($patterns, $subs, $string)."<br><br>"; 
?>