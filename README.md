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
![Image1](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/main/imagenes/ConsumoTokenRest.JPG)

Para la generación o procesos de Integracion continua se ha utilizado la herramienta de Azure DevOps Service (nube).
Los pipeline se encuentran en la carpeta: "PIPELINE" en sus respectivos formatos json y yml

![Image2](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/main/imagenes/PipelineIC.JPG)
![Image3](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/main/imagenes/PipelineEC.JPG)

Para el correcto funcionamiento de los procesos se han creado algunas cuentas de nube que deben ser configuras en Azure DevOps,
para su correcto funcionamiento:

* Cuenta de Amazon para los despligues: AWS¨
* Cuenta de Docker (Docker hub)
* Cuenta de GitHub (que es la que esta este codigo) 
	https://github.com/pedrinchi1987/EjercicioNTTDATA
* Cuenta de Sonarqube para los analisis de codigo (cuenta nube)

Para todas estas cuentas es necesario, declarar repositorios publicos y obtener sus respectivas claves
![Image4](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/main/imagenes/Conexiones.JPG)

El proceso de IC, utiliza el azure pipeline para poder desplegar, 

Para el pipeline de Release es muy importante tener en cuenta las claves de AWS, estas deben estar en las variables:
var_aws_access_key
var_aws_secret_key

Otro punto importante es configurar correctamente el grupo de seguridad, para poder ver el puerto que principio es 5000, pero es configurable.
Recordar que los scripts estan dados para una maquina de tipo aws-linux.

![Image10](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/main/imagenes/DefinicionPacker.JPG)

El despligue se realiza con las herramientas:

* Packer
* Docker Hub
* AWS

![Image5](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/main/imagenes/EjecucionPipelineEC.JPG)
![Image6](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/main/imagenes/DockerGenerado.JPG)
![Image7](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/main/imagenes/InstanciaCreada.JPG)

Se manejan las rutas configurables y reemplazables en el pipeline, por un tema de timeout, packer no termina exitoso.

De momento solo se establecieron, un pipeline para todas las ramas, en caso de dividir por rama y ambiente, se tenia pensado clonar los pipeline, 
y filtrarlos por ramas.

Aplicativo Funcionando
![Image8](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/main/imagenes/ConsumoDevOpsRest.JPG)
![Image9](https://github.com/pedrinchi1987/EjercicioNTTDATA/blob/main/imagenes/ErrorTipoEquivocadoConsumoDevOpsRest.JPG)

Para las parametrizaciones como clave, token, tenemos el archivo application.properties, del proyecto principal

El ejercicio no esta completamente terminado pero igual envio un avance, gracias por la experiencia.

