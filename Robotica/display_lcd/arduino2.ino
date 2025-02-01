// Arduino nº 2 - Display LCD
// Luiz Otávio Nazar

#include <LiquidCrystal.h>

LiquidCrystal lcd(13, 12, 11, 10, 9, 8);

void setup() {
  lcd.begin(16, 2);
  Serial.begin(9600);
}

void loop() {
    if (Serial.available()>0) {
        byte val = Serial.read();
        if (val==1) {
            lcd.clear();
            lcd.setCursor(3, 0);
            lcd.print("ACERTOUUUU");
            lcd.setCursor(1, 1);
            lcd.print("SENHA CORRETA!");
        } else if (val==2) {
            lcd.clear();
            lcd.setCursor(3, 0);
            lcd.print("ERROUUUUUU");
            lcd.setCursor(0, 1);
            lcd.print("SENHA INCORRETA!");
        } else if (val==0) {
            lcd.clear();
            lcd.setCursor(1,0);
            lcd.print("DIGITE A SENHA");
            lcd.setCursor(5,1);
            lcd.print("*****");
        }
    }
}