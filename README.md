# 02_SpringSecurityExample
# Implementation of basic authentication with springboot and spring security.

Pruebas

Es importante saber que este ejemplo va de una authenticacion básica por lo que 
la prueba se tiene que hacer de la siguiente manera:
```
curl -X GET \
http://localhost:8080/products \
-H 'Authorization: Basic bWFpa2k6MTIzNDU='
```
Ese curl hace una petición pasándole la cabecera Authorization: Basic b64(maiki:12345), si vemos lo que nos devuelve, 
veremos que es un array vacío, pero tan importante como eso es la cookie JSESSIONID, 
si nosotros usamos esta cookie para siguientes peticiones entonces ya no tendremos que pasarle
nuevamente la cabecera Authorization. Esto sucede porque en postman como en un navegador lo pilla al vuelo y vincula 
la cookie al dominio y para próximas peticiones lo envía, si quisieramos invalidarla, nos bastaría con invocar:
```
curl -X GET \
  http://localhost:8080/logout
```
Otro detalle es que el /logout funciona usando GET porque el csrf esta deshabilitado, de no ser así habría que 
usar obligatoriamente POST.
Las urls diponibles de prueba son el GET y POST para /products y /users.