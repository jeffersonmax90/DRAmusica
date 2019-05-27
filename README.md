# DRAmusica

El proyecto individual trata sobre la música.

para construir el proyecto:

docker-compose build
docker-compose up


1.Scrapping
Lenguaje utilizado es Python para obtener los datos de la web.
Para ejecutar el scrapping:

python leerDatos.py

2.Base de Datos:

Una base de datos PostgreSQL, usado una tabla llamada cancion con 4 campos.
	-Entero de la canción más escuchada
	-Titulo
	-Artista
	-Url imagen

3.API Rest:
Para la API se va a utilizar Sping Boot, con controlador.
Algunas Consultas son:
	-Add Canción
	-Borrar Canción
	-Get Cancion
	-Get Cancion by titulo
	-Get ALL Canciones 

*Las consultas se pueden ir ampliando a medida que se vaya realizando la web.