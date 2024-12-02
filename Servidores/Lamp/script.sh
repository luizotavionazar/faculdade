#!/bin/bash

menu_principal(){
echo
echo =========================
echo "       MENU LAMP"
echo =========================
echo   [1]. Instalar LAMP
echo   [2]. Aplicações
echo   [3]. Sair
echo
read -p    "O que deseja fazer? " opc
echo
}

menu_aplicacoes(){
echo
echo ========================
echo "    MENU APLICAÇÕES"
echo ========================
echo  [1]. Apache
echo  [2]. Maria DB
echo  [3]. Sair
echo
read -p    "O que deseja fazer? " opc
}

menu_mariadb(){
}

menu_apache(){
}

menu_principal

switch_menu_principal(){
case $opc in
	1)
	echo Instalando aplicações do LAMP...
	echo
	apt-get install apache2 mariadb-server php php-mysql libapache2-mod-php
	echo
	echo LAMP instalado!!
	echo;;
	2)
	menu_aplicacoes;;
	3)
	exit;;
	*)
	echo Opção inválida!!;;
esac
}

switch_menu_aplicacoes(){
case $opc in
	1)
	menu_mariadb;;
	2)
	menu_apache;;
	3)
	exit;;
	*)
	echo Opção inválida!!;;
esac
}
