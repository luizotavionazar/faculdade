#include <LiquidCrystal.h> // Carrega a biblioteca LiquidCrystal nativa na IDE

// Define os pinos que serão utilizados para ligação ao display
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

const int pinFan = 13;    // Declara o pino digital 13 para acionar o cooler
const int pinSensor = 0;  // Declara o pino analógico A0 para ler o sensor
int incomingByte = 0;     // Para dados recebidos pela serial
int ligado = 1;

float temperature;

void setup() {
    lcd.begin(16, 2); // Define o display com 16 colunas e 2 linhas
    lcd.clear();      // Limpa a tela do display
    Serial.begin(9600);
    pinMode(pinFan, OUTPUT);
    pinMode(8, OUTPUT);
    pinMode(pinSensor, INPUT);
}

void loop() {
    if (Serial.available() > 0) {
        incomingByte = Serial.parseInt();
        if (incomingByte == 0) {
            if (ligado == 1) {
                ligado = 0;
                lcd.noDisplay();
                digitalWrite(pinFan, LOW);
                digitalWrite(pinSensor, LOW);
            } else {
                digitalWrite(pinFan, HIGH);
                digitalWrite(pinSensor, HIGH);
                lcd.display();
                ligado = 1;
            }
        }
    }

    if (ligado == 1) {
        digitalWrite(8, HIGH);
        /* Para evitar as grandes variações de leitura do componente
           LM35 são feitas 1000 leituras onde calculamos a média */
        for (int i = 0; i < 1000; i++) {
            temperature = temperature + float(analogRead(pinSensor)) * 500 / (1023);
        }
        temperature = temperature / 1000; // Calcula a média das leituras

        if (temperature > 30) { // Indica condição para acionamento do cooler
            // Define a coluna 0 e linha 1 do LCD onde será impressa a string
            lcd.setCursor(0, 1);
            lcd.write("Fan ligado !"); // Imprime no LCD
            digitalWrite(pinFan, HIGH); // Liga o cooler
        } else {
            lcd.setCursor(0, 1);
            lcd.write("Fan desligado !"); // Imprime no LCD
            digitalWrite(pinFan, LOW);    // Desliga o cooler
        }
        delay(1000); // Aguarda 1 segundo

        // Exibindo valor da leitura do sensor de temperatura no display LCD
        lcd.clear(); // Limpa o display do LCD
        lcd.print("Temp.: "); // Imprime a string no display do LCD
        lcd.print(temperature);
        lcd.write(B11011111); // Símbolo de graus Celsius
        lcd.print("C");
    }
}