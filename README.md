# ARSW-Lab3-Spring-

# Integrantes:
Willson Melo Merchan  
Jeymar Vega

## GRAMMAR CHECKER
### Parte 1
# 
En esta sección se nos pide hacer uso de las anotaciones de Spring para garantizar la injección de dependencias.
Lo cual se hizo de la siguiente manera.
#
![alt text1](https://github.com/Stilink/ARSW-Lab3-Spring-/blob/master/GRAMMAR-CHECKER/img/Grammar-part-1.PNG)
![alt text1](https://github.com/Stilink/ARSW-Lab3-Spring-/blob/master/GRAMMAR-CHECKER/img/Grammar-part-1-spell.PNG)
#
## BLUEPRINTS
### Parte 1
#
En esta sección del mismo modo que en la primera de la sección pasada, se nos solicita hacer uso de las anotaciones Spring.
#
Lo cual se hizo así:
#
![alt text1](https://github.com/Stilink/ARSW-Lab3-Spring-/blob/master/BLUEPRINTS-PART1/img/Blueprint-part-1.PNG)
#
Aunque no se muestre, también se uso la anotación de componente sobre la clase "InMemoryBlueprintPersistence".
#
Por otro lado, se nos solicitaba la implementación de los metodos getBluePrint() y getBlueprintsByAuthor(), lo cual se hizo así:
#
![alt text1](https://github.com/Stilink/ARSW-Lab3-Spring-/blob/master/BLUEPRINTS-PART1/img/Blueprint-part-1-methods.PNG)
#
A esto también cabe añadirle que se tuvo que modificar un constructor del objeto Blueprint, pues no estaba guardando correctamente el nombre.
### Parte 3
#
Para esta sección se nos solicitaba hacer un "filtro" de las consultas. Nuestro primer acercamiento no nos termino de convencer, 
pues intentamos crear "más implementaciones del InMemory" modificando cosas para que se filtrará,
sin embargo al avanzar notamos que dicho sistema podría resultar enredado tanto de manejar como de probar, 
así que decidimos descartarlo. De este modo obtamos por una versión mas simple y menos acoplada que resultaba en un "Sistema de filtros"
que aplica directamente desde el BlueprintService. Se implemento de la siguiente manera:
#
![alt text1](https://github.com/Stilink/ARSW-Lab3-Spring-/blob/master/BLUEPRINTS-PART1/img/Blueprint-part-3-first.PNG)
#
Junto a los servicios pusimos la sección de filtros.
#
![alt text1](https://github.com/Stilink/ARSW-Lab3-Spring-/blob/master/BLUEPRINTS-PART1/img/Blueprint-part-3-second.PNG)
#
Donde dentro pusimos una interfaz "BlueprintsFilter".
#
![alt text1](https://github.com/Stilink/ARSW-Lab3-Spring-/blob/master/BLUEPRINTS-PART1/img/Blueprint-part-3-interface.PNG)
#
Esta interfaz cuenta con sus implementaciones, que en este caso resultan ser los dos filtros solicitados.
#
![alt text1](https://github.com/Stilink/ARSW-Lab3-Spring-/blob/master/BLUEPRINTS-PART1/img/Blueprint-part-3-impl.PNG)
#
Que dentro de la clase services queda así:
#
![alt text1](https://github.com/Stilink/ARSW-Lab3-Spring-/blob/master/BLUEPRINTS-PART1/img/Blueprint-part-3-services.PNG)
#
![alt text1](https://github.com/Stilink/ARSW-Lab3-Spring-/blob/master/BLUEPRINTS-PART1/img/Blueprint-part-3-services-methods.PNG)
#
Los cuales son dos metodos nuevos que hacen las funciones de consultar y de filtrar dicha consulta.
