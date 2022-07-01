#!/bin/bash

echo "------------------> INSTALAR IMAGEN DOCKER <------------------"

sudo docker pull pedrinchi1987/nttda:{BUILD_ID}
sudo docker run -d -p {PORT_MQ}:8080 pedrinchi1987/nttda:{BUILD_ID}

echo "------------------> FIN IMAGEN DOCKER <------------------"
