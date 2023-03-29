# File-line-validator
Este proyecto conecta dos microservicios por medio de rest api para evaluar datos especificos dentro de archivos (csv,xlsx)

El servicio de procesamiento recibe una peticion post desde el servidor, lee el archivo y se comunica con el microservicio de validación 

El microservicio de validacion devuelve una respuesta al servicio de procesamiento

El microservicio de procesamiento devuelve la respuesta al servidor (lineas invalidas, validas y la posicion de estas)


![ejemplo](https://user-images.githubusercontent.com/90018701/226496966-1078db79-4cee-4888-ad19-d3eb74385166.png)

