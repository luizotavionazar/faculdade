#include <LiquidCrystal.h>
#include <Servo.h>

const int motor= 7;
LiquidCrystal lcd(13, 12, 11, 10, 9, 8);
Servo smotor;
bool control= false;

void setup() {
    lcd.begin(16, 2);
    smotor.attach(motor);
    Serial.begin(9600);
}

void loop() {
    if (!control) {
        smotor.write(93);
        lcd.setCursor(3,0);
        lcd.print("INICIANDO...");
        lcd.setCursor(2,1);
        lcd.print("TO NO MEIO!");
        delay(900);

        lcd.clear();
        smotor.write(48);
        lcd.setCursor(3,0);
        lcd.print("INICIANDO...");
        lcd.setCursor(3,1);
        lcd.print("DIREITA>");
        delay(750);

        lcd.clear();
        smotor.write(124);
        lcd.setCursor(3,0);
        lcd.print("INICIANDO...");
        lcd.setCursor(2,1);
        lcd.print("<ESQUERDA");
        delay(750);
        control=true;
    }

    lcd.clear();
    smotor.write(0);
    lcd.setCursor(1,0);
    lcd.print("SO PROGRESSO...");
    lcd.setCursor(0,1);
    lcd.print(">>>>>>>>>>>>>>>>");
    delay(1000);

    lcd.clear();
    lcd.setCursor(3,0);
    lcd.print("SUBINDO...");
    delay(10);
    for (int i=10; i<180; i++) {
        smotor.write(i);
        lcd.setCursor(6,1);
        lcd.print(i);
        lcd.setCursor(4,1);
        lcd.print(">");
        lcd.setCursor(10,1);
        lcd.print("<");
        delay(50);
    }

    lcd.clear();
    smotor.write(48);
    lcd.setCursor(3,0);
    lcd.print("REINICIANDO...");
    lcd.setCursor(3,1);
    lcd.print("DIREITA>");
    delay(750);

    lcd.clear();
    smotor.write(124);
    lcd.setCursor(3,0);
    lcd.print("REINICIANDO...");
    lcd.setCursor(2,1);
    lcd.print("<ESQUERDA");
    delay(500);

}