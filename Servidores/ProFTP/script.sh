#!/bin/bash

menu_principal(){
clear
echo
echo =========================
echo "       MENU FTP"
echo =========================
echo   [1]. Instalar e Configurar
echo   [2]. Gerenciar FTP
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

menu_gerenciar_ftp(){
clear
echo
echo ==========================
echo "     GERENCIAR FTP"
echo ==========================
echo  [1]. Reiniciar Serviço
echo  [2]. Verificar Status
echo  [3]. Iniciar Serviço
echo  [4]. Parar Serviço
echo  [5]. Voltar
echo
read -p    "O que deseja fazer? " opc
if [ $opc -eq 5 ]
then
	menu_principal
else
	switch_menu_gerenciar_ftp
fi
}

switch_menu_principal(){
case $opc in
	1)
	instalar_configurar_ftp
	menu_principal;;
	2)
	menu_gerenciar_ftp;;
	3)
	exit;;
	*)
	echo "Opção inválida!!";;
esac
}

switch_menu_gerenciar_ftp(){
case $opc in
	1)
	/etc/init.d/proftpd restart
	echo
	read -p "Tecle Enter..." -n 1
	menu_gerenciar_ftp;;
	2)
	/etc/init.d/proftpd status
	echo
	read -p "Tecle Enter..." -n 1
	menu_gerenciar_ftp;;
	3)
	/etc/init.d/proftpd start
	echo
	read -p "Tecle Enter..." -n 1
	menu_gerenciar_ftp;;
	4)
	/etc/init.d/proftpd stop
	echo
	read -p "Tecle Enter..." -n 1
	menu_gerenciar_ftp;;
	*)
	echo "Opção inválida!!";;
esac
}

instalar_configurar_ftp(){
	sudo apt update -y
	echo
	echo "Instalando o ProFTPD..."
	sudo apt-get install proftpd -y
	echo
	echo "ProFTPD Instalado!!"
	echo
	echo "Instalando o FileZilla..."
	sudo apt-get install filezilla -y
	echo
	echo "FileZilla Instalado!!"
	echo
	echo "Configurando o ProFTPD..."
sudo arquivo_conf="/etc/proftpd/proftpd.conf"
cat <<EOL > $arquivo_conf
	ServerName                      "Servidor FTP"
	ServerType                      standalone
	DefaultServer                   on

	<Anonymous ~ftp>
	  User                          ftp
	  Group                         nogroup
	  UserAlias                     anonymous ftp
	  RequireValidShell             off
	  MaxClients                    10
	</Anonymous>

	<Global>
	  DefaultRoot                   ~
	  RequireValidShell             off
	</Global>

	Port                            21
	Umask                           022
	MaxInstances                    30
EOL
	echo
	echo "Configuração realizada!!"
	echo "- Definiu o servidor como padrão;"
	echo "- Criou usuário e grupo com limite de 10 conexões;"
	echo "- Restrigiu o acesso do usuário no seu diretório;"
	echo "- Definiu a porta 21 como padrão, liberou as permissões e limitou em 30 conexões."
	/etc/init.d/proftpd restart
	echo
	read -p "Tecle Enter..." -n 1
}

menu_principal