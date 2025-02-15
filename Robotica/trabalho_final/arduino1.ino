#include "Adafruit_LEDBackpack.h"
#include <IRremote.h>
#include <Servo.h>

int button = 0;
const int SENSOR_IR = 10;
const int luz1 = 7;
const int luz2 = 6;
const int luz3 = 5;
const int luz4 = 4;
Servo myServo;
int l1 = 0, l2 = 0, l3 = 0, l4 = 0;
int estadoPortao = 0;

// Mapa dos códigos retornados pelas teclas do controle
//    0   1   2
//    4   5   6
//    8   9  10
//   12  13  14
//   16  17  18
//   20  21  22
//   24  25  26
// Se o retorno não estiver no mapeamento, retorna -1

int mapCodeToButton(unsigned long code) {
    // No Tinkercad, o controle remoto envia códigos no formato 
    // 0xiivvBF00, onde 'vv' é o valor do botão em hexadecimal, 
    // 'ii' é o inverso de 'vv', e BF00 é uma parte fixa do código;
    // por exemplo, o botão Liga/Desliga envia 0xFF00BF00,
    // onde vv = 00 e ii = FF (inverso de 00).

    // Verifica o código recebido, isolando os bits significativas, 
    // capturando o valor de código recebido para o mapeamento
    if ((code & 0x0000FFFF) == 0x0000BF00) {
        code >>= 16;
        if (((code >> 8) ^ (code & 0x00FF)) == 0x00FF) {
            return code & 0xFF;
        }
    }
        return -1;
}

int readInfrared() {
    int result = -1;
    // Recepção do código
    if (IrReceiver.decode()) {
        // Captura o código e verifica o mapeamento respectivo
        unsigned long code = IrReceiver.decodedIRData.decodedRawData;
        result = mapCodeToButton(code);
        IrReceiver.resume();
    }
    return result;
}

void setup() {
    pinMode(luz1, OUTPUT);
    pinMode(luz2, OUTPUT);
    pinMode(luz3, OUTPUT);
    pinMode(luz4, OUTPUT);  
    Serial.begin(9600);
    myServo.attach(11);
    IrReceiver.begin(SENSOR_IR);
    moveServo(0000);
}

void ligaDesligaLuz(int *estado, int luz) {  
    if (*estado == 0) {
        digitalWrite(luz, HIGH);
        *estado = 1;
    } else {
        digitalWrite(luz, LOW);
        *estado = 0;
    }
}

void abreFechaPortao(int* estadoPortao) {
    if (*estadoPortao == 0) {
        moveServo(0070);
        *estadoPortao = 1;
    } else {
        moveServo(0000);
        *estadoPortao = 0;
    }
}

void moveServo(int angle) {
    myServo.write(angle);
    delay(500);
}

void loop() {  
    button = readInfrared();  
    if (button >= 0) {    
        Serial.print(button);
        if (button == 16) {      
            ligaDesligaLuz(&l1, luz1);      
        } else if (button == 17) {      
            ligaDesligaLuz(&l2, luz2);      
        } else if (button == 18) {      
            ligaDesligaLuz(&l3, luz3);      
        } else if (button == 20) {      
            ligaDesligaLuz(&l4, luz4);      
        } else if (button == 5) {      
            abreFechaPortao(&estadoPortao);      
        }
    }
    delay(10);
}