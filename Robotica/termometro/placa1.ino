const int azul= 5;
const int verde= 4;
const int vermelho= 3;

void setup() {
    pinMode(A0, INPUT);
    pinMode(azul, OUTPUT);
    pinMode(verde, OUTPUT);
    pinMode(vermelho, OUTPUT);
    Serial.begin(9600);
}

void loop() {
    int numMedia= 5;  //Número de leituras para média
    long total= 0;
    
    for (int i = 0; i < numMedia; i++) { //Média para reduzir ruído
        total += analogRead(A0);
        delay(10);
    }
    
    int tmp= total / numMedia;  //Média das leituras
    float voltage= (tmp * 5.0) / 1024;  //Conversão para tensão (0 a 5V)
    float milliVolt= voltage * 1000;    //Conversão para milivolts
    float tmpCel= (milliVolt - 500) / 10; //Temperatura em Celsius
    
    if (tmpCel <= 18) { //LEDS de sinalização
        digitalWrite(verde, LOW);
        digitalWrite(vermelho, LOW);
        digitalWrite(azul, HIGH);
    } else if (tmpCel > 18 && tmpCel <= 50) {
        digitalWrite(azul, LOW);
        digitalWrite(vermelho, LOW);
        digitalWrite(verde, HIGH);
    } else if (tmpCel > 50) {
        digitalWrite(verde, LOW);
        digitalWrite(azul, LOW);
        digitalWrite(vermelho, HIGH);
    }
    
    Serial.println(tmpCel);
    delay(10);

}