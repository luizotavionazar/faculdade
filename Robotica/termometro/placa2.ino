#include <LiquidCrystal.h>

char degree = 176; // Código ASCII para o símbolo de grau
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
float temp= 0.0;

void setup() {
    lcd.begin(16, 2);
    Serial.begin(9600);
}

void loop() {
    if (Serial.available()>0) {
        temp= Serial.parseFloat();
        Serial.println(temp);

        lcd.clear();
        lcd.setCursor(4, 0);
        lcd.print(temp);
        lcd.print(" C");

        if (temp < -10) {
            lcd.setCursor(0, 1);
            lcd.print("FRIIII DEMAIS!!!");
        } else if (temp > -10 && temp <= 0) {
            lcd.setCursor(0, 1);
            lcd.print("TREM GELOU BAO!!");
        } else if (temp > 0 && temp <= 18) {
            lcd.setCursor(0, 1);
            lcd.print("TREM ESFRIO NE?!");
        } else if (temp > 18 && temp <= 50) {
            lcd.setCursor(0, 1);
            lcd.print("PASSANDO DE BAO!");
        } else if (temp > 50 && temp <= 60) {
            lcd.setCursor(0, 1);
            lcd.print("TREM ESQUENTOU!!");
        } else if (temp > 60 && temp <= 80) {
            lcd.setCursor(0, 1);
            lcd.print("VAI SE HIDRATAR!");
        } else if (temp > 80 && temp <= 110) {
            lcd.setCursor(0, 1);
            lcd.print("CORRE PRA SOMBRA");
        } else if (temp > 110) {
            lcd.setCursor(0, 1);
            lcd.print("CALOR DO DJABO!!");
        }
        
    }
}