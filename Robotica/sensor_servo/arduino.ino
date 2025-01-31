#include <IRremote.hpp>
#include <Servo.h>

const int sensor= 6;
const int servo= 7;
const int R= 5;
const int B= 4;
const int G= 3;

Servo servoMotor;

void setup() {
    Serial.begin(9600);
    IrReceiver.begin(sensor, ENABLE_LED_FEEDBACK);
    servoMotor.attach(servo);
    pinMode(R, OUTPUT);
    pinMode(G, OUTPUT);
    pinMode(B, OUTPUT);
}

void loop() {
    if (IrReceiver.decode()) { //Verifica o sensor
        switch (IrReceiver.decodedIRData.command) {
            case 0x10: //Apertou '1'
                servoMotor.write(0);
                digitalWrite(R, HIGH);
                digitalWrite(G, LOW);
                digitalWrite(B, LOW);
                break;

            case 0x11: //Apertou '2'
                servoMotor.write(90);
                digitalWrite(R, LOW);
                digitalWrite(G, HIGH);
                digitalWrite(B, LOW);
                break;

            case 0x12: //Apertou '3'
                servoMotor.write(180);
                digitalWrite(R, LOW);
                digitalWrite(G, LOW);
                digitalWrite(B, HIGH);
                break;

            default:
                break;
        }
        IrReceiver.resume();
    }
}