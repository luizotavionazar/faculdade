#include <Keypad.h>
#define PIEZO_PIN 3

// Notas musicais com suas frequências em Hz
#define NOTE_B3  247
#define NOTE_C4  262
#define NOTE_D4  294
#define NOTE_E4  330
#define NOTE_F4  349
#define NOTE_G4  392
#define NOTE_A4  440
#define NOTE_B4  494

const byte LINHAS = 4; // Linhas do teclado
const byte COLUNAS = 4; // Colunas do teclado
const int verde= 4;
const int vermelho= 5;

char TECLAS_MATRIZ[LINHAS][COLUNAS] = { // Matriz de caracteres (mapeamento do teclado)
  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};

byte PINOS_LINHAS[LINHAS] = {13, 12, 11, 10}; // Pinos de conexao com as linhas do teclado
byte PINOS_COLUNAS[COLUNAS] = {9, 8, 7, 6}; // Pinos de conexao com as colunas do teclado

Keypad teclado_personalizado = Keypad(makeKeymap(TECLAS_MATRIZ), PINOS_LINHAS, PINOS_COLUNAS, LINHAS, COLUNAS); // Inicia teclado

// Melodia da música "Jingle Bells"
int melody[] = {
    NOTE_E4, NOTE_E4, NOTE_E4, // "Jingle bells"
    NOTE_E4, NOTE_E4, NOTE_E4, // "Jingle bells"
    NOTE_E4, NOTE_G4, NOTE_C4, NOTE_D4, NOTE_E4, // "Jingle all the way"
    NOTE_F4, NOTE_F4, NOTE_F4, NOTE_F4, NOTE_F4, NOTE_E4, NOTE_E4, NOTE_E4, NOTE_E4, // "Oh, what fun it is to ride"
    NOTE_E4, NOTE_D4, NOTE_D4, NOTE_E4, NOTE_D4, NOTE_G4 // "In a one-horse open sleigh"
};

// Duração de cada nota (em milissegundos)
int noteDurations[] = {
    250, 250, 500,
    250, 250, 500,
    250, 250, 250, 250, 500,
    250, 250, 250, 250, 250, 250, 250, 250,
    250, 250, 250, 250, 500
};

int control = 0;
char senha[] = "1596";
char sentenca[5] = "";
char cod_musica[]= "0000";
bool digitandoSenha = false;

void setup() {
    Serial.begin(9600); //Inicia porta serial
    pinMode(PIEZO_PIN, OUTPUT);
}

void tocarMusica() {
    for (int i = 0; i < sizeof(melody) / sizeof(melody[0]); i++) {
        int noteDuration = noteDurations[i];
        tone(PIEZO_PIN, melody[i], noteDuration);
        delay(noteDuration * 1.3); //Tempo entre as notas
    }
    delay(2000); //Tempo antes de repetir a música
}

void loop() {
    digitalWrite(verde, LOW);
  	digitalWrite(vermelho, LOW);
    char leitura_teclas = teclado_personalizado.getKey(); //Captura a tecla digitada
    if (leitura_teclas) {
        if (!digitandoSenha && leitura_teclas == '#') { // Se pressionou '#' e ainda não está digitando a senha
            tone(PIEZO_PIN, NOTE_B3, 50);
          	Serial.print("\nSenha: ");
            digitandoSenha = true; // Ativa o modo de digitação da senha
            control = 0; // Reseta o índice da senha
        } else if (digitandoSenha && control < 4) { // Se está no modo de digitação e ainda há espaço para mais caracteres
            tone(PIEZO_PIN, NOTE_A4, 50);
            sentenca[control] = leitura_teclas; // Armazena o caractere digitado
            control++;
            Serial.print("*"); // Exibe um asterisco para cada caractere digitado
        }

        if (digitandoSenha && control == 4) { //Após finalizada a digitação
            sentenca[control] = '\0';
            digitandoSenha = false; //Encerra o modo de digitação

            if (strcmp(sentenca, senha) == 0) {
              	Serial.println("\nSenha correta!");
                digitalWrite(verde, HIGH);
                tone(PIEZO_PIN, NOTE_G4, 100);
                delay(5000);
            }
            else if (strcmp(sentenca, cod_musica) == 0) {
                Serial.println("\nLa vai o jingle bell...");
                tocarMusica();
            }
            else {
                Serial.println("\nSenha incorreta!");
              	digitalWrite(vermelho, HIGH);
                delay(250);
                tone(PIEZO_PIN, NOTE_D4, 100);
                delay(250);
                tone(PIEZO_PIN, NOTE_D4, 100);
                delay(250);
                tone(PIEZO_PIN, NOTE_D4, 100);
                delay(250);
                tone(PIEZO_PIN, NOTE_D4, 100);
                delay(250);
                tone(PIEZO_PIN, NOTE_D4, 100);
              	delay(2850);
            }
        }
    }
}