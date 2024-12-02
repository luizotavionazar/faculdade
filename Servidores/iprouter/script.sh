#!/bin/bash

echo
echo Com esse script você pode adicionar um novo IP ao host!

echo
echo Instalando Ip Router...
echo
apt-get install iproute2

echo
echo Instalado!

echo
read -p "Informe o endereço IP que deseja adicionar: " ip
echo $ip

echo
read -p "Informe a interface utilizada: " interface
echo $interface

ip addr add $ip dev $interface

echo
echo IP $ip adicionado a Interface $interface !!

echo
echo Agora vamos alterar o DNS...

echo
read -p "Informe o 1º DNS desejado: " dns1
echo $dns1

echo
read -p "Agora, o 2º DNS desejado: " dns2
echo $dns2

echo "nameserver $dns1" > /etc/resolv.conf
echo "nameserver $dns2" >> /etc/resolv.conf

echo
echo DNSs alterados !!

echo
echo Acabou, tchau :D
