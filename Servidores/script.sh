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
	echo
	echo "Configuração... Informe os dados necessários:"
	echo
	dhcp_config="/etc/dhcp/dhcpd.conf"
	read -p "Digite o IP da sub-rede (ex: 192.168.21.0): " subnet_ip
	read -p "Digite a máscara de rede (ex: 255.255.255.192): " subnet_mask
	subnet_config="
	subnet $subnet_ip netmask $subnet_mask {
		range ${subnet_ip%.*}.10 ${subnet_ip%.*}.50;
		option routers ${subnet_ip%.*}.1;
	}"
	if ! grep -q "subnet $subnet_ip" "$dhcp_config"; then
		echo "Adicionando configuração de sub-rede no $dhcp_config"
		echo "$subnet_config" | sudo tee -a "$dhcp_config" > /dev/null
	else
		echo "Configuração de sub-rede já existe no $dhcp_config"
	fi
	default_config="/etc/default/isc-dhcp-server"
	read -p "Digite o nome da interface de rede (ex: enp4s0f0): " interface_name
	interface_config="INTERFACESv4=\"$interface_name\""
	if ! grep -q "INTERFACESv4" "$default_config"; then
		echo "Adicionando configuração de interface no $default_config"
		echo "$interface_config" | sudo tee -a "$default_config" > /dev/null
	else
		sudo sed -i "s/^INTERFACESv4=.*/INTERFACESv4=\"$interface_name\"/" "$default_config"
		echo "Configuração de interface no $default_config foi atualizada."
	fi
	if grep -q "INTERFACESv6" "$default_config"; then
		echo "Comentando a linha INTERFACESv6 no $default_config"
		sudo sed -i 's/^INTERFACESv6=.*/#&/' "$default_config"
	else
	echo "A linha INTERFACESv6 não foi encontrada em $default_config"
	fi
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
