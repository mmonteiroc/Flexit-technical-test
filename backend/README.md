# Backend


Este directorio contiene el backend para la prueba tecnica de flexIT.

#### Como ejectuar este proyecto:


##### Docker
   
   Encontraras un archivo Dockerfile dentro de este proyecto. 
   Este dockerfile solo representa la imagen de springboot. Sin 
   base de datos ni front end, si quiere ejecutar el back con el 
   front y la base de datos, dirigete al 
   [README.md](https://github.com/mmonteiroc/Flexit-technical-test/blob/master/README.md)
   que encontraras en la raiz del repositorio de github o del zip. 
   
   **_Para usar un contenedor docker con la imagen 
   de este proyecto podemos ejecutar los siguientes comandos:_**
   
   ``docker pull mmonteiroc/test-flexit-back``
   
   ``docker run -d -p 8080:8080 --name container-test-back-flexit mmonteiroc/test-flexit-back``
   
   Esta imagen tendra el archivo application.properties tal y como lo encontraras en el repositorio, 
   es decir por defecto.
   
  **_O tambien se podria generar una imagen nueva de la siguiente manera:_**
   
   Para generar solo la imagen de backend asegurate de tener las propiedades del `application.properties` configuradas correctamente, como puede ser el nombre de la BBDD. puerto, direccion.... (si usaras esta imagen en el compose, no toques la base de datos [url] del properties)
   
   Una vez esta configurado, ejecutamos los siguientes comandos los cuales nos prepararan la imagen de docker y instalarán las dependencias de maven:
   
    
   - Instalar dependencias de maven y preparar el archivo .war: ``mvn package`` 
   - Preparar la imagen docker: `` docker build -t test-back-flexit .``
   - Arrancar la imagen docker: ``docker run -d -p 8080:8080 --name container-test-back-flexit test-back-flexit``
   - Una vez arrancado, tendremos la API REST disponible en la direccion http://localhost:8080 


