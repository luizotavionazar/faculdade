#!/bin/bash

echo

echo ----------------------------
echo 	    MENU DE REDE
echo ----------------------------
echo    1 - Adicionar IP
echo    2 - Adicionar DNS
echo    3 - Opções da interface
echo ----------------------------
echo

echo aread a-p "O que deseja fazer? "

echo Com esse script você pode adicionar um novo IP ao host!
echo

read -p "Informe o endereço IP que deseja adicionar: " ip
echo

read -p "Informe a interface utilizada: " interface

sudo ip addr add $ip dev $interface

echo Agora vamos alterar o DNS...

read -p "Informe o DNS desejado: " dns1

echo $ip
echo $interface
echo


  sudo ifconfig enp4s0f0 192.168.21.12 netmask 255.255.255.192 up
