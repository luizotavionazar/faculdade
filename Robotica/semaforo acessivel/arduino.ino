//Atividade Robotica - Semáforo com botão de acessibilidade
//Luiz Otávio Nazar

byte valores[11][7] = { 
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
 { 1,1,0,0,1,1,1 },  //Configuração do P
};

int verde= 13;
int amarelo= 12;
int vermelho= 11;
int piezoPin = 10; //Pino digital conectado ao piezo
int statusBotao = 0; //Variável para armazenar o estado do botão

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
    pinMode(9, INPUT); //Botão
    pinMode(piezoPin, OUTPUT); //Bipe
}

void ligarDisplay(byte digit){ //Aciona o display
    verifica_botao();
    byte pino = 2;
    verifica_botao();
    for (byte contadorSegmentos = 0; contadorSegmentos < 7; ++contadorSegmentos){ //Contador dos segmentos
        verifica_botao();
        digitalWrite(pino, valores[digit][contadorSegmentos]); //Avança o segmento
        verifica_botao();
        pino=pino+1; //Soma 1 ao contador
        verifica_botao();
    }
}

void semaforo() {
    digitalWrite(verde, HIGH);
    for (byte contador = 9; contador >= 1; contador--){ //Definição do tempo e ativação do VERDE
        verifica_botao();
        ligarDisplay(contador);
        verifica_botao();
        verifica_botao();
        if (contador <= 2) {
            digitalWrite(verde, LOW);
            verifica_botao();
            ligarDisplay(contador);
            delay(500);
            verifica_botao();
            digitalWrite(verde, HIGH);
            verifica_botao();
            delay(500);
   	        verifica_botao();
        } else {
            delay(1000);
        }
    }
    digitalWrite(verde, LOW);
  
    digitalWrite(amarelo, HIGH);
    for (byte contador = 5; contador >= 1; contador--){ //Definição do tempo e ativação do AMARELO
        verifica_botao();
        ligarDisplay(contador);
        verifica_botao();
        if (contador <= 3) {
            digitalWrite(amarelo, LOW);
            verifica_botao();
            ligarDisplay(contador);
            delay(500);
            verifica_botao();
            digitalWrite(amarelo, HIGH);
            verifica_botao();
            delay(500);
   	        verifica_botao();
        } else {
            delay(1000);
        }
    }
    digitalWrite(amarelo, LOW);
  
    for (byte contador = 9; contador > 0; contador--){ //Definição do tempo e ativação do VERMELHO
        verifica_botao();
        digitalWrite(vermelho, HIGH); 
        verifica_botao();
        ligarDisplay(contador);
        verifica_botao();
        delay(1000);
  	    verifica_botao();
  	}
    digitalWrite(vermelho, LOW); 
    verifica_botao();
}

bool control= false;

void verifica_botao() { //Verifica se o botão foi pressionado
    statusBotao = digitalRead(9);
    if (statusBotao == HIGH) {
        control= true; 
    }
}

void botao() { //Executa ação se o botão foi pressionado
    if (control) {
        digitalWrite(vermelho, HIGH);
        int temp=10;
        ligarDisplay(temp);
        for (int i=1; i<=9; i++) {
  	        tone(piezoPin, 1000); //Emite um som de 1000 Hz (1 kHz)
  	        delay(500);
  	        tone(piezoPin, 1000);
  	        delay(500);
        }
    noTone(piezoPin);
    digitalWrite(vermelho, LOW);
    delay(500);
    }
}

void loop() {
    semaforo();
    verifica_botao();
    botao();
}