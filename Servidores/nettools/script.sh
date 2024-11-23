echo
ifconfig -a
echo
route -v
echo
cat /etc/resolv.conf

echo

read -p "Informe o endereço IP: " ip
read -p "Informe a Interface de Rede: " interface
read -p "Informe a Máscara de Rede: " mascara
read -p "Informe o Gateway padrão: " getway

echo

ifconfig $interface down

ifconfig $interface $ip netmask $mascara up

route add default gw $getway $interface

echo "nameserver 8.8.8.8" > /etc/resolv.conf
echo "nameserver 8.8.4.4" >> /etc/resolv.conf
