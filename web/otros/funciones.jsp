<?php
	
	function subir_imagen($tipo, $imagen,$nombre)
	{
		if(strstr($tipo, "image"))
		{
			//saber tipo de extension
			//strstr sirve para evaluar si en la primer cadena de texto existe la segunda cadena de texto
			//si dentro del tipo de archivo se encuentra la palabra image significa que el archivo es una iamgen
			if(strstr($tipo, "jpeg"))
				$extension = ".jpg";
			else if(strstr($tipo, "gif"))
				$extension = ".gif";
			else if(strstr($tipo, "png"))
				$extension = ".png";
			
		
				$destino ="../img/Aretes/".$nombre;

				move_uploaded_file($imagen, $destino)or die ("no se pudo subir");

				
				
				//Asigno el nombre de la foto que se guarda en la D como cadena
				$imagen = $nombre.$extension;	
				return $imagen;

		}
		else
		{
			return false;
		}
	}	
?>
