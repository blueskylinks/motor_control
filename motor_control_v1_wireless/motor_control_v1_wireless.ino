#include <EEPROM.h>

int addr1 = 0;
int addr2 = 1;
int value1 = 1;
int value2 = 2;
byte memval1;
byte memval2;

const int buzzer = D8;
const int auto_status = D5;
const int input1 = D9;
int ot_sensorcount=0;
int ut_sensorcount=0;

int motor_status=0;
int motor_status_manual=0;
int motor_time=0;
int empty_start=0;
int value_count=0;
int motor_duration=3;
int motor_stoptime=0;
long duration;
float distanceCm;
float distanceInch;
int tank_size, len;
float cap;
int cap1;
int count=0;
int sound=0;
int stop_button=0;

void setup() {
  Serial.begin(115200); // Starts the serial communication
  EEPROM.begin(512);
  pinMode(input1, INPUT_PULLUP);  
  pinMode(buzzer, OUTPUT);
  pinMode(auto_status, INPUT_PULLUP);
  digitalWrite(buzzer, LOW);
  
  delay(1000);
  memval1=EEPROM.read(addr1);
  motor_duration=memval1;
  if(motor_duration<1 || motor_duration>12){
    motor_duration=3;
  }

  
  int temp_count=0;
  while(digitalRead(input1)==0){
    temp_count=temp_count+1;
    Serial.println(temp_count);
    if(temp_count>=3){
      Serial.println("Change...!");
      if(motor_duration<12){
        motor_duration=motor_duration+1;
      }else{
        motor_duration=1;
      }
      temp_count=0;
      Serial.print("Motor Duration:");
      Serial.println(motor_duration);
      
      EEPROM.write(addr1, motor_duration);
      if (EEPROM.commit()) {
      Serial.println("EEPROM successfully committed");
      } else {
      Serial.println("ERROR! EEPROM commit failed");
      }

      if(motor_duration<1 || motor_duration>12){
        motor_duration=3;
      }
      
      for(int i=0;i<motor_duration;i++){
        tank_blinkall();
      }
    }
    delay(1000);
  }

  if(motor_duration<1 || motor_duration>12){
        motor_duration=3;
  }
   
  digitalWrite(buzzer,LOW);
  //Set motor time duration*5 
  motor_time=(motor_duration*60)*5;
  empty_start=0;

  if(digitalRead(auto_status)==0){
    motor_status=1;
    digitalWrite(buzzer,HIGH);
  }

  for(int i=0;i<motor_duration;i++){
    tank_blinkall();
  }

}

void tank_blinkall(){
     digitalWrite(D4,HIGH);
     digitalWrite(D7,HIGH);
     delay(300);
     digitalWrite(D4,LOW);
     digitalWrite(D7,LOW);
     delay(300);
}


void loop() {
  Serial.println("=========================================");
  Serial.print("Motor Status:");
  Serial.println(motor_status);
  Serial.print("Motor Duration:");
  Serial.println(motor_duration);
  Serial.print("Motor Time:");
  Serial.println(motor_time); 
  Serial.print("HighWater Tank Status:");
  //Serial.println(ot_sensorstatus);
  Serial.print("LowWater Status:");
  //Serial.println(ut_sensorstatus);

  /*
  if(ot_sensorstatus==0){
    digitalWrite(ot_status,HIGH);
  }else{
    digitalWrite(ot_status,LOW);
  } */
  
  if(digitalRead(input1)==0){
    Serial.println("Button Clicked...!");
    if(motor_status_manual==0){
      digitalWrite(buzzer,HIGH);
      motor_status_manual=1;
      motor_status=1;
      delay(2000);
    }else{
      if(motor_status_manual==1){
        digitalWrite(buzzer,LOW);
        Serial.println("Motor is now stopped..!");
        motor_status_manual=0;
        motor_status=0;
        motor_time=(motor_duration*60)*10;
        delay(2000);
      }
    } 
  }

  if(digitalRead(buzzer)==1){
   motor_time=motor_time-1;
   Serial.println("Motor Running..!");
   if(motor_time<=0){
    Serial.print("Sensor Count:");
    Serial.println(ot_sensorcount);
    Serial.println("Tank Full or Timed Out..!");
    ot_sensorcount=ot_sensorcount+1;
      if(ot_sensorcount>=5){
        digitalWrite(buzzer, LOW);
        motor_status=0;
        ot_sensorcount=0;
        motor_time=(motor_duration*60)*10;
      }else{
      //ot_sensorcount=0;
      } 
   }else{
    ot_sensorcount=0;
   }
  }
  
   //motor_start();
    delay(1000);
    count=count+1;
 }
