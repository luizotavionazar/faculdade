#!/bin/bash
echo

cd /var/backups

echo *Criando diretório /var/backups/image*
if [ ! -d "/var/backups/image" ]; then
mkdir image;
echo ~Criação finalizada~;
else
echo ~Diretório já existe~;
fi
sleep 1

echo

cd /var/log
echo *Criando diretório /var/log/image*
if [ ! -d "/var/log/image" ]; then
mkdir image;
echo ~Criação finalizada~;
else
echo ~Diretório já existe~;
fi
sleep 1

echo

echo *Iniciando backup da imagem*
echo *Copiando imagem para o Backup*
cd /home/luizotavio
cp /home/luizotavio/image.jpg /var/backups/image
echo ~Imagem copiada para o diretorio /var/backups/image~
echo *Renomeando imagem para o backup*
cd /var/backups/image
data="$(date +%d_%m_%Y_%H%M)"
mv image.jpg image_$data.jpg
echo ~Imagem renomeada para o backup~
echo ~Backup da imagem finalizado~

echo

echo *Iniciando gravação dos Logs*
cd /var/log/image
echo "Backup realizado com sucesso "$data >> logimage.log
echo ~Logs gravados~

echo

exit