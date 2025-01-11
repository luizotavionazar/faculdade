#!/bin/bash

menu_principal(){
clear
echo
echo =========================
echo "       MENU SAMBA"
echo =========================
echo   [1]. Instalar e Configurar
echo   [2]. Gerenciar Samba
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

menu_gerenciar_samba(){
clear
echo
echo ========================
echo "    GERENCIAR SAMBA"
echo ========================
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
	switch_menu_gerenciar_samba
fi
}

switch_menu_principal(){
case $opc in
	1)
	instalar_configurar_samba
	menu_principal;;
	2)
	menu_gerenciar_samba;;
	3)
	exit;;
	*)
	echo "Opção inválida!!";;
esac
}

switch_menu_gerenciar_samba(){
case $opc in
	1)
	echo
	/etc/init.d/smbd restart
	echo
	read -p "Tecle Enter..." -n 1
	menu_gerenciar_samba;;
	2)
	echo
	/etc/init.d/smbd status
	echo
	read -p "Tecle Enter..." -n 1
	menu_gerenciar_samba;;
	3)
	echo
	/etc/init.d/smbd start
	echo
	read -p "Tecle Enter..." -n 1
	menu_gerenciar_samba;;
	4)
	echo
	/etc/init.d/smbd stop
	echo
	read -p "Tecle Enter..." -n 1
	menu_gerenciar_samba;;
	*)
	echo "Opção inválida!!";;
esac
}

instalar_configurar_samba(){
	echo
	echo "Atualizando os repositórios..."
	sudo apt update -y
	echo
	echo "Instalando o Samba..."
	sudo apt-get install samba -y
	echo
	echo "Configurando o Samba..."
sudo CONF_FILE="/etc/samba/smb.conf"
cat <<EOL > $CONF_FILE
[global]
   workgroup = WORKGROUP
   server string = Servidor Samba
   security = user
   map to guest = Bad User
   dns proxy = no

# Compartilhamento público
[Publico]
   path = /samba/publico
   browseable = yes
   writable = yes
   guest ok = yes
   create mask = 0777
   directory mask = 0777
EOL
	mkdir -p /samba/publico
	chmod 777 /samba/publico
	echo "Instalação e configuração do Samba concluídas!!"
	echo "- Criou o compartilhamento público sem senha;"
	echo "- Criou o diretório com permissão de leitura e escrita."
	echo
	read -p "Tecle Enter..." -n 1
	/etc/init.d/smbd restart
}

menu_principal