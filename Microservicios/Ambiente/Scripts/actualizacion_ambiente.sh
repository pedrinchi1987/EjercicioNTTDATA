#!/bin/bash

echo "------------------> INICIO ACTUALIZAR AMBIENTE <------------------"

sudo amazon-linux-extras install -y docker
sudo service docker start

echo "------------------> FIN MONITORIZADOR Metricbeat <------------------"
