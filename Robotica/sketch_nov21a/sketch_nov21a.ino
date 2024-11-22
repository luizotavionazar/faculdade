// Atividade Robotica - 14/11

int verde= 13;
int amarelo= 12;
int vermelho= 11;

void setup() {
  pinMode(verde, OUTPUT);
  pinMode(amarelo, OUTPUT);
  pinMode(vermelho, OUTPUT); }

void loop() {
  semaforo(); }

void semaforo() {
  digitalWrite(verde, HIGH);
  delay(5000);
  digitalWrite(verde, LOW);
  
  digitalWrite(amarelo, HIGH);
  delay(4000);
  digitalWrite(amarelo, LOW);
  delay(300);
  
  for(int i=0; i<=3; i++){
  digitalWrite(amarelo, HIGH);
  delay(300);
  digitalWrite(amarelo, LOW);
  delay(300);}
  
  digitalWrite(vermelho, HIGH);
  delay(5000);
  digitalWrite(vermelho, LOW); }