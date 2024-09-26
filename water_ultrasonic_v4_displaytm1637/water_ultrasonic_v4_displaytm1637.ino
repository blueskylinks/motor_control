#include <EEPROM.h>
#include <Arduino.h>
#include <TM1637Display.h>

// Module connection pins (Digital Pins)
#define CLK D3
#define DIO D4

int addr1 = 0;
int addr2 = 1;
int value1 = 1;
int value2 = 2;
byte memval1;
byte memval2;

const int trigPin = D1;
const int echoPin = D2;
const int buzzer = D8;
const int input1 = D9;

//define sound velocity in cm/uS
#define SOUND_VELOCITY 0.034
#define CM_TO_INCH 0.393701

int motor_status=0;
int motor_status_manual=0;
int motor_time=0;
int empty_start=0;
int analog_value=10;
int value_count=0;
int motor_duration=30;
int motor_stoptime=0;
long duration;
int distanceCm;
int distanceInch;
int tank_size, len;
float cap;
int cap1;
int count=0;
int sound=0;
int stop_button=0;

TM1637Display display(CLK, DIO);

  uint8_t data[] = { 0xff, 0xff, 0xff, 0xff };
  uint8_t blank[] = { 0x00, 0x00, 0x00, 0x00 };

const uint8_t SEG_ON[] = {
  SEG_A | SEG_B | SEG_C | SEG_D | SEG_E | SEG_F,   // O
  SEG_C | SEG_E | SEG_G,                           // n
  
  };

void setup() {
  Serial.begin(115200); // Starts the serial communication
  EEPROM.begin(512);
  tank_size=40;
  len=tank_size/10;
  pinMode(input1, INPUT_PULLUP);  
  pinMode(buzzer, OUTPUT);
  digitalWrite(buzzer, LOW);
  pinMode(trigPin, OUTPUT); // Sets the trigPin as an Output
  pinMode(echoPin, INPUT); // Sets the echoPin as an Input
  delay(1000);
  display.setBrightness(0x0f);
  display.setSegments(blank);
  delay(2000);
  memval1=EEPROM.read(addr1);
  motor_duration=memval1;
  if(motor_duration<1 || motor_duration>90){
    motor_duration=30;
  }
  int temp_count=100;
  if(digitalRead(input1)==0){
    while(temp_count>=1){
      if(digitalRead(input1)==0){
        if(motor_duration<=90){
          motor_duration=motor_duration+5;
          temp_count=temp_count+1;
        }else{
          motor_duration=0;
        } 
      }
      temp_count=temp_count-1;
      delay(200);
      Serial.print("Temp Count:");
      Serial.println(temp_count);
      Serial.print("Motor Duration:");
      Serial.println(motor_duration);

      EEPROM.write(addr1, motor_duration);
      if (EEPROM.commit()) {
      Serial.println("EEPROM successfully committed");
      display.showNumberDec(motor_duration,false);
      } else {
      Serial.println("ERROR! EEPROM commit failed");
      }      
    }
  }  

  /*
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
      display.showNumberDec(motor_duration,false);
      } else {
      Serial.println("ERROR! EEPROM commit failed");
      }

      if(motor_duration<1 || motor_duration>12){
        motor_duration=3;
      }
      
      for(int i=0;i<motor_duration;i++){
      }
    }
    delay(2000);
  }*/

  display.showNumberDec(motor_duration,false);  
  digitalWrite(buzzer,LOW);
  empty_start=0;

}

void loop() {
  Serial.print("=========================================");
  // Clears the trigPin
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  // Sets the trigPin on HIGH state for 10 micro seconds
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  // Reads the echoPin, returns the sound wave travel time in microseconds
  duration = pulseIn(echoPin, HIGH);
  // Calculate the distance
  distanceCm = duration * SOUND_VELOCITY/2;
  // Convert to inches
  distanceInch = distanceCm * CM_TO_INCH;
  //=====================================================================================
  /*
  // Prints the distance on the Serial Monitor
  Serial.print("Distance (cm):\n ");
  Serial.println(distanceCm);
  Serial.print("Distance (inch): ");
  Serial.println(distanceInch);
  cap=distanceInch/(len*1.6);
  Serial.print("Capacity:");
  cap1=(((int)cap)+0);
  Serial.println(cap1);

  */

  
  /*if(distanceInch<2.00){
    cap1=10;
  }*/
  if(distanceInch>2.00 && distanceInch<=10.00){
    cap1=1;
  }
  if(distanceInch>10.00 && distanceInch<=15.00){
    cap1=2;
  }
  if(distanceInch>15.00 && distanceInch<=20.00){
    cap1=3;
  }
  if(distanceInch>20.00 && distanceInch<=25.00){
    cap1=4;
  }
  if(distanceInch>25.00 && distanceInch<=30.00){
    cap1=5;
  }
  if(distanceInch>30.00 && distanceInch<=35.00){
    cap1=6;
  }
  if(distanceInch>35.00 && distanceInch<=40.00){
    cap1=7;
  }
  if(distanceInch>40.00){
    cap1=8;
  }
  if(distanceInch>=200.00){
    cap1=9;
  }
  
  
  Serial.print("Distance (inch): ");
  Serial.println(distanceInch);
  display.showNumberDec(distanceInch,false);
  Serial.print("Capacity:");
  Serial.println(cap1);
  Serial.print("Analog Value:");
  Serial.println(analog_value);

  if(digitalRead(input1)==0){
    Serial.println("Button Clicked...!");
    if(motor_status_manual==0){
      digitalWrite(buzzer,HIGH);
      motor_status_manual=1;
      motor_status=1;
      motor_time=motor_duration*60;
      value_count=15;
    }else{
      if(motor_status_manual==1){
        digitalWrite(buzzer,LOW);
        Serial.println("Motor is now stopped..!");
        motor_status_manual=0;
        motor_status=0;
        value_count=0;
      }
    } 
  }

  
  switch(cap1){

    case 1:
      Serial.println("Level 1 Full");
      motor_status=0;
      break;
    case 2:
      Serial.println("Level 2");
      break;
    case 3: 
      Serial.println("Level 3");
    break;
    case 4:
      Serial.println("Level 4");
    break;
    case 5:
      Serial.println("Level 5");
      break;
    case 6:
      Serial.println("Level 6");
      break;
    case 7:
      delay(1000);
      Serial.println("Level 5");
      motor_time=motor_duration*60;
      motor_status=1;
      break;
    case 9:
      if(distanceInch>=200){
        delay(1000);
        Serial.println("Level 0 Full");      
    }
    default:
 
      Serial.println("Level Default");                                
   }

   tank_start();
      Serial.print("motor status:");
      Serial.println(digitalRead(buzzer));
      Serial.println(motor_status);
      delay(500);
    count=count+1;
    Serial.print("Count:");
    Serial.println(count);
    /*
    if(count>=120){
      Serial.println("Sleep Mode Start....");
      ESP.deepSleep(60e6);
    }
    */
 }

 void tank_start(){
  if(motor_time>0 && motor_status==1){
    digitalWrite(buzzer,HIGH);
    Serial.print("Motor Time:");
    Serial.println(motor_time);
    //display.setSegments(blank);
    display.showNumberDec(1, false, 1, 0);
    display.showNumberDec((motor_time/60)+1,false);  
  }
  else{
    if(value_count<=0){
    digitalWrite(buzzer,LOW);
    Serial.println("Motor is now stopped...!");
    motor_status=0;
    //display.setSegments(blank);
    //display.showNumberDec(0, false, 1, 0); 
    }
  }
  if(motor_time>=0){
    motor_time=motor_time-1;
  }
  if(value_count>=0){
    value_count=value_count-1;
  }
    Serial.print("Motor Time:");
    Serial.println(motor_time);
    Serial.print("Value Count:");
    Serial.println(value_count);
 }
