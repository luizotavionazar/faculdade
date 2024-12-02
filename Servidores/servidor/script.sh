#!/bin/bash

menu() {
    echo
    echo ----------------------------
    echo :::::::::::MENU:::::::::::::
    echo ----------------------------
    echo    1 - Instalar LAMP
    echo    2 - Opções do Apache
    echo    3 - Opções do MariaDB
    echo ----------------------------
    echo
    read -p "O que deseja fazer? " opc1
}

menu_apache() {
    echo
    echo ----------------------------
    echo :::::::::::MENU:::::::::::::
    echo ----------------------------
    echo    1 - Verificar Status
    echo    2 - Parar serviço
    echo    3 - Iniciar serviço
    echo    4 - Reiniciar serviço
    echo ----------------------------
    echo 
    read -p "O que deseja fazer? " opc2
}

menu
if ["$opc1" == "2"]; then
    menu_apache
fi