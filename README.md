# Flexit-technical-test
Repo for the technical test of the Flexit interview

### Explicacion
He generado este unico repositorio con  2 subcarpetas (fron y back) por mera comodidad para la entrega, en vez de haber generado dos repos.
Al final he usado una bbdd y esta todo preparado para que simplemente clonando el proyecto y dentro del proyecto ejecutando el comando 
`docker-compose up -d` o `docker-compose up` si queremos ver los logs.
Por defecto he puesto el backend en el puerto 8080(tipico de tomcat) y el frontend en el puerto 8888 por si acaso teneis el 80 con un apache ocupado.
http://localhost:8888

El docker compose utiliza imagenes docker las cuales estarán subidas a mi repositorio de [dockerhub](https://hub.docker.com/u/mmonteiroc). Simplemente lo hago así para daros felicidad a la hora de ejcutar el proyecto. 

Aun asi si quereis montar vosotros mismos las imagenes de docker, seria tan simple como ir a cada subdirectorio y leer sus readme.md para ver como generarlas

- [front](https://github.com/mmonteiroc/Flexit-technical-test/tree/master/frontend#frontend)
- [back](https://github.com/mmonteiroc/Flexit-technical-test/tree/master/backend#backend)
