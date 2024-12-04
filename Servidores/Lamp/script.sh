#!/bin/bash

menu_principal(){
clear
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
if [ $opc -eq 3 ]
then
	exit 0
else
	switch_menu_principal
fi
}

menu_aplicacoes(){
clear
echo
echo ========================
echo "    MENU APLICAÇÕES"
echo ========================
echo  [1]. Apache
echo  [2]. Maria DB
echo  [3]. Sair
echo
read -p    "O que deseja fazer? " opc
if [ $opc -eq 3 ]
then
	menu_principal
else
	switch_menu_aplicacoes
fi
}

menu_mariadb(){
clear
echo
echo ========================
echo "     MENU MARIA DB"
echo ========================
echo  [1]. Configuração inicial
echo  [2]. Verificar Status
echo  [3]. Iniciar Serviço
echo  [4]. Reiniciar Serviço
echo  [5]. Parar Serviço
echo  [6]. Acessar Query Tool
echo  [7]. Sair
echo
read -p    "O que deseja fazer? " opc
}

menu_apache(){
clear
echo
echo ========================
echo "      MENU APACHE"
echo ========================
echo  [1]. Verificar Status
echo  [2]. Iniciar Serviço
echo  [3]. Reiniciar Serviço
echo  [4]. Parar Serviço
echo  [5]. Criar PHP para teste
echo  [6]. Acessar HTML para teste
echo  [7]. Sair
echo
read -p    "O que deseja fazer? " opc
}

switch_menu_principal(){
case $opc in
	1)
	echo Instalando aplicações do LAMP...
	echo
	apt-get install apache2 mariadb-server php php-mysql libapache2-mod-php
	echo
	echo LAMP instalado!!
	echo
	echo Tecle Enter... 
	read -n 1
	menu_principal;;
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

menu_principal
