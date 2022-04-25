# EjercicioNTTDATA
Prueba Ejercicio Practico NTTData

El ejercicio esta realizado para la empresa NTTDATA para la prueba de ingreso

Se ha utilizado las siguientes herramientas:

Netbeans
Spring Boot
Postman
Docker

Para poder obtener el token dinamico se debe ingresar al servicio Rest de nombre Token2. Ej:

http://[IP_DEL_DESPLIEGUE]:[PUERTO_DESPLIEGUE]/Token2

Para la generación o procesos de Ingrtegracion continua se ha utilizado la herramienta de Azure DevOps Service (nube).
Los pipeline se encuentran en la carpeta: "PIPELINE" en sus respectivos formatos json y yml

Para el correcto funcionamiento de los procesos se han creado algunas cuentas de nube que deben ser configuras en Azure DevOps,
para su correcto funcionamiento:

* Cuenta de Amazon para los despligues: AWS¨
* Cuenta de Docker (Docker hub)
* Cuenta de GitHub (que es la que esta este codigo) 
	https://github.com/pedrinchi1987/EjercicioNTTDATA
* Cuenta de Sonarqube para los analisis de codigo (cuenta nube)

Para todas estas cuentas es necesario, declarar repositorios publicos y obtener sus respectivas claves

El proceso de IC, utiliza el azure pipeline para poder desplegar, 

Para el pipeline de Release es muy importante tener en cuenta las claves de AWS, estas deben estar en las variables:
var_aws_access_key
var_aws_secret_key

El despligue se realiza con las herramientas:

* Packer
* Docker Hub
* AWS

De momento solo se establecieron, un pipeline para todas las ramas, en caso de dividir por rama y ambiente, se tenia pensado clonar los pipeline, 
y filtrarlos por ramas.

![Image1](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/finalin/imagenes/Conexiones.JPG)
![Image2](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/finalin/imagenes/ConsumoDevOpsRest.JPG)
![Image3](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/finalin/imagenes/ConsumoTokenRest.JPG)
![Image4](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/finalin/imagenes/DockerGenerado.JPG)
![Image5](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/finalin/imagenes/ErrorTipoEquivocadoConsumoDevOpsRest.JPG)
![Image6](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/finalin/imagenes/InstanciaCreada.JPG)
![Image7](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/finalin/imagenes/PipelineEC.JPG)
![Image8](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/finalin/imagenes/PipelineIC.JPG)


