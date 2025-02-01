// Arduino nº 1 - Teclado e Leds
// Luiz Otávio Nazar

#include <Keypad.h>

const byte LINHAS = 4; //Linhas do teclado
const byte COLUNAS = 4; //Colunas do teclado
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

int control = 0;
char senha[] = "12345";
char sentenca[5] = "";
bool digitandoSenha = false;
byte data= 0;

void setup() {
  pinMode(verde, OUTPUT);
  pinMode(vermelho, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  char leitura_teclas = teclado_personalizado.getKey();
  if (leitura_teclas) {
    if (control==0){ //Digitando a senha
      digitalWrite(verde, LOW);
      digitalWrite(vermelho, LOW);
      sentenca[control] = leitura_teclas;
      Serial.print("\nSenha: *");
      Serial.write(0);
      data= 1; //Não sei porque, mas se tirar, para de funcionar
      control++;
    } else {
      sentenca[control] = leitura_teclas;
      Serial.print("*");
      control++;
    }

    if (control == 5) { //Após digitar a senha
      sentenca[control] = '\0';
      if (strcmp(sentenca, senha) == 0) {
       	Serial.println("\nSenha correta!");
        Serial.write(1);
        digitalWrite(verde, HIGH);
        control= 0;
      } else {
        Serial.println("\nSenha incorreta!");
        Serial.write(2);
       	digitalWrite(vermelho, HIGH);
        control= 0;
      }
    }
  }
}