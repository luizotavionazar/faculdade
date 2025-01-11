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
echo  [3]. Voltar
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
echo  [7]. Voltar
echo
read -p    "O que deseja fazer? " opc
if [ $opc -eq 7 ]
then
	menu_aplicacoes
else
	switch_menu_mariadb
fi
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
echo  [7]. Voltar
echo
read -p    "O que deseja fazer? " opc
if [ $opc -eq 7 ]
then
	menu_aplicacoes
else
	switch_menu_apache
fi
}

switch_menu_principal(){
case $opc in
	1)
	sudo apt update -y
	echo
	echo "Instalando aplicações do LAMP..."
	echo
	sudo apt-get install apache2 mariadb-server php php-mysql libapache2-mod-php -y
	echo
	echo LAMP instalado!!
	echo
	read -p "Tecle Enter..." -n 1
	menu_principal;;
	2)
	menu_aplicacoes;;
	3)
	exit;;
	*)
	echo "Opção inválida!!";;
esac
}

switch_menu_aplicacoes(){
case $opc in
	1)
	menu_apache;;
	2)
	menu_mariadb;;
	3)
	exit;;
	*)
	echo "Opção inválida!!";;
esac
}

switch_menu_apache(){
case $opc in
	1)
	echo
	/etc/init.d/apache2 status
	echo
	read -p "Tecle Enter..." -n 1
	menu_apache;;
	2)
	echo
	/etc/init.d/apache2 start
	echo
	read -p "Tecle Enter..." -n 1
	menu_apache;;
	3)
	echo
	/etc/init.d/apache2 restart
	echo
	read -p "Tecle Enter..." -n 1
	menu_apache;;
	4)
	echo
	/etc/init.d/apache2 stop
	echo
	read -p "Tecle Enter..." -n 1
	menu_apache;;
	5)
	echo
	echo "<?php phpinfo(); ?>" | sudo tee /var/www/html/info.php
	firefox localhost/info.php
	echo
	echo "Arquivo PHP criado e Firefox foi aberto para teste do PHP!"
	echo
	read -p "Tecle Enter..." -n 1
	menu_apache;;
	6)
	echo
	firefox localhost/index.html
	echo "Firefox foi aberto para teste do HTML!"
	echo
	read -p "Tecle Enter..." -n 1
	menu_apache;;
	*)
	echo "Opção inválida!!";;
esac
}

switch_menu_mariadb(){
case $opc in
	1)
	echo
	sudo mysql_secure_installation
	echo
	read -p "Configuração realizada, Tecle Enter..." -n 1
	menu_mariadb;;
	2)
	echo
	sudo /etc/init.d/mariadb status
	echo
	read -p "Tecle Enter..." -n 1
	menu_mariadb;;
	3)
	echo
	/etc/init.d/mariadb start
	echo
	read -p "Tecle Enter..." -n 1
	menu_mariadb;;
	4)
	echo
	/etc/init.d/mariadb restart
	echo
	read -p "Tecle Enter..." -n 1
	menu_mariadb;;
	5)
	echo
	/etc/init.d/mariadb stop
	echo
	read -p "Tecle Enter..." -n 1
	menu_mariadb;;
	6)
	echo
	sudo mysql -u root -p
	echo
	read -p "Tecle Enter..." -n 1
	menu_mariadb;;
	*)
	echo "Opção inválida!!";;
esac
}

menu_principal