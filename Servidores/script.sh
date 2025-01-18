#!/bin/bash

instalar() {
	echo
	echo "Instalando o Serviço..."
	echo
	sudo apt update
	sudo apt install isc-dhcp-server
	echo
	echo "Serviço instalado, realize a configuração!"
	echo
}

configurar() {
	echo "configurar"
}

iniciar() {
	echo
	echo "Iniciando o Serviço..."
	echo
	sudo /etc/init.d/isc-dhcp-server start
}

parar() {
	echo
	echo "Parando o Serviço..."
	echo
	sudo /etc/init.d/isc-dhcp-server stop
}

reiniciar() {
	echo
	echo "Reiniciando o Serviço..."
	echo
	sudo /etc/init.d/isc-dhcp-server restart
}

status() {
	echo
	echo "Status do Serviço..."
	echo
	sudo /etc/init.d/isc-dhcp-server status
}

remover() {
	echo
	echo "Removendo o pacote ISC DHCP..."
	echo
	sudo apt remove isc-dhcp-server
}

ajuda() {
	echo
	echo "Comandos disponiveis:"
	echo "  instalar   - Realiza a instalação do serviço ISC DHCP;"
	echo "  configurar - Realiza a configuração para utilização do serviço ISC DHPC;"
	echo "  iniciar    - Inicia o serviço ISC DHCP;"
	echo "  parar      - Interrompe o serviço ISC DHCP;"
	echo "  reiniciar  - Reincia o serviço ISC DHCP;"
	echo "  status     - Verifica o status de execução do serviço ISC DHCP;"
	echo "  remover    - Desinstala o serviço ISC DHCP da máquina."
	echo
}

case "$1" in
	instalar)
	  instalar;;
	configurar)
	  configurar;;
	iniciar)
	  iniciar;;
	parar)
	  parar;;
	reiniciar)
          reiniciar;;
	status)
	  status;;
	remover)
	  remover;;
	ajuda)
	  ajuda;;
	*)
    	  echo
	  echo "Comando inválido! Utilize: $0 {comando}"
	  echo "Dúvidas? Utilize o comando 'ajuda'"
	  echo
	  exit 1;;
esac
