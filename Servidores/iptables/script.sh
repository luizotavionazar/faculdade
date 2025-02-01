#!/bin/bash

install() {
	echo
	echo "Instalando o IP Tables..."
	echo
	sudo apt update
	sudo apt install -y iptables
	echo
	echo "IP Tables instalado!"
	echo
}

start() {
	echo
	echo "Definindo as regras..."
    echo "Bloqueio das portas 80 e 443"
	echo
	sudo iptables -A INPUT -m multiport -p tcp --dport 80,443 -j REJECT
    sudo iptables -A OUTPUT -m multiport -p tcp --dport 80,443 -j REJECT
}

stop() {
	echo
	echo "Removendo as regras definidas..."
	echo
	sudo iptables -D INPUT -m multiport -p tcp --dport 80,443 -j REJECT
    sudo iptables -D OUTPUT -m multiport -p tcp --dport 80,443 -j REJECT
}

restart() {
	echo
	echo "Reiniciando as regras..."
	echo
    stop
    start
}

list() {
    echo
    echo "Lista de regras definidas..."
    echo
    echo "---- Regras de Entrada \/"
    echo
    sudo iptables -L INPUT --line-numbers
    echo
    echo "---- Regras de Saída \/"
    echo
    sudo iptables -L OUTPUT --line-numbers
    echo
}

remove() {
	echo
	echo "Removendo o IP Tables..."
	echo
	sudo apt remove -y iptables
}

help() {
	echo
	echo "Comandos disponiveis:"
	echo "  install - Realiza a instalação do IP Tables;"
	echo "  start   - Define as regras pré-definidas"
	echo "  stop    - Limpa as regras pré-definidas;"
	echo "  restart - Reinicia as regras pré-definidas;"
	echo "  list    - Lista as regras pré-definidas;"
    echo "  remove  - Desinstala o IP Tables;"
	echo "  help    - Lista os comandos do Script."
	echo
}

case "$1" in
	install)
        install;;
	start) 
        start;;
	stop)
        stop;;
	restart)
        restart;;
	list)
        list;;
	remove)
        remove;;
	help)
	    help;;
	*)
        echo
	    echo "Comando inválido! Utilize: $0 {comando}"
	    echo "Dúvidas? Utilize o comando 'help'"
	    echo
	    exit 1;;
esac
