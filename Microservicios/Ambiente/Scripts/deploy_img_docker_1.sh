#!/bin/bash

echo "------------------> INSTALAR IMAGEN DOCKER <------------------"

sudo docker pull pedrinchi1987/nttda:475
sudo docker run -d -p 5000:8080 pedrinchi1987/nttda:475

echo "------------------> FIN IMAGEN DOCKER <------------------"
