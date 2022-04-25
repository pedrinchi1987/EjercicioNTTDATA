#!/bin/bash

echo "------------------> INSTALAR IMAGEN DOCKER <------------------"

sudo docker pull pedrinchi1987/nttda:454
sudo docker run -p 5000:8080 pedrinchi1987/nttda:454

echo "------------------> FIN IMAGEN DOCKER <------------------"
