//Atividade Robotica - Semáforo com display de 7 segmentos
//Luiz Otávio Nazar

byte valores[10][7] = { 
    { 1,1,1,1,1,1,0 },  //Configuração do dígito 0
    { 0,1,1,0,0,0,0 },  //Configuração do dígito 1
    { 1,1,0,1,1,0,1 },  //Configuração do dígito 2
    { 1,1,1,1,0,0,1 },  //Configuração do dígito 3
    { 0,1,1,0,0,1,1 },  //Configuração do dígito 4
    { 1,0,1,1,0,1,1 },  //Configuração do dígito 5
    { 1,0,1,1,1,1,1 },  //Configuração do dígito 6
    { 1,1,1,0,0,0,0 },  //Configuração do dígito 7
    { 1,1,1,1,1,1,1 },  //Configuração do dígito 8
    { 1,1,1,0,0,1,1 },  //Configuração do dígito 9
};

int verde= 13;
int amarelo= 12;
int vermelho= 11;

void setup(){
    pinMode(2, OUTPUT); //Segmento A
    pinMode(3, OUTPUT); //Segmento B
    pinMode(4, OUTPUT); //Segmento C
    pinMode(5, OUTPUT); //Segmento D
    pinMode(6, OUTPUT); //Segmento E
    pinMode(7, OUTPUT); //Segmento F
    pinMode(8, OUTPUT); //Segmento G
    pinMode(verde, OUTPUT);
    pinMode(amarelo, OUTPUT);
    pinMode(vermelho, OUTPUT);
}

void ligarDisplay(byte digit){ //Aciona o display
    byte pino = 2;

    for (byte contadorSegmentos = 0; contadorSegmentos < 7; ++contadorSegmentos){ //Contador dos segmentos
        digitalWrite(pino, valores[digit][contadorSegmentos]); //Avança o segmento
        pino=pino+1; //Soma 1 ao contador
    }
}

void semaforo() {
    digitalWrite(verde, HIGH); //Definição do tempo e ativação do VERDE
    for (byte contador = 9; contador >= 1; contador--){ 
        ligarDisplay(contador);
        if (contador <= 2) {
            digitalWrite(verde, LOW);
            ligarDisplay(contador);
            delay(500);
            digitalWrite(verde, HIGH);
            delay(500);
        } else {
            delay(1000);
        }
    }
    digitalWrite(verde, LOW);
  
    digitalWrite(amarelo, HIGH); //Definição do tempo e ativação do AMARELO 
    for (byte contador = 5; contador >= 1; contador--){ 
        ligarDisplay(contador);
        if (contador <= 3) {
            digitalWrite(amarelo, LOW);
            ligarDisplay(contador);
            delay(500);
            digitalWrite(amarelo, HIGH);
            delay(500);
        } else {
            delay(1000);
        }
    }
    digitalWrite(amarelo, LOW);
    for (byte contador = 9; contador > 0; contador--){ //Definição do tempo e ativação do VERMELHO
        digitalWrite(vermelho, HIGH);
        ligarDisplay(contador);
        delay(1000);
  	}
    digitalWrite(vermelho, LOW);
}

void loop() {
    semaforo();
}