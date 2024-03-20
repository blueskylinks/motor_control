/*
 tonepin : pin that trigger the motter relay
 ot_sensor : pin that detect the over head tank full
 ut_sensor : pin that detect the under ground tank empty
 */


const int tonepin = D8;
const int ot_sensor = D5;
const int ut_sensor = D6;
const int start_button = D9;
const int led1 = D4;
const int led2 = D3;
int ot_sensorstatus=1;
int ut_sensorstatus=1;
int timercount=30;
int ot_sensorcount=0;
int ut_sensorcount=0;
int count=0;
int analog_value=0;
int motor_status=0;
void setup()
{
  Serial.begin(115200);
  pinMode(tonepin, OUTPUT);
  pinMode(ot_sensor, INPUT_PULLUP);
  pinMode(ut_sensor, INPUT_PULLUP);
  pinMode(start_button, INPUT_PULLUP);
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  digitalWrite(tonepin, LOW);
  digitalWrite(led1, LOW);

  Serial.print("Analog Value");
  analog_value=analogRead(A0);
  Serial.println(analog_value);

  if(analog_value>=200 && analog_value<=300){
    timercount=15;
  }
  if(analog_value>=0 && analog_value<=200){
    timercount=30;
  }
  if(analog_value>=500 && analog_value<=600){
    timercount=45;
  }
  
}

void loop() {
  // put your main code here, to run repeatedly:
  Serial.print("Count:");
  Serial.println(count);
  Serial.print("Analog Value");
  Serial.println(analog_value);
  ot_sensorstatus=digitalRead(ot_sensor);
  ut_sensorstatus=digitalRead(ut_sensor);
  Serial.print("Motor Status:");
  Serial.println(digitalRead(tonepin));

  motor_status=digitalRead(start_button);
  if(motor_status==0){
    digitalWrite(tonepin,HIGH);
    digitalWrite(led1, HIGH);
  }

  if(digitalRead(tonepin)==1){
   count=count+1;
   if(count>=(timercount*60) || ot_sensorstatus==0){
    Serial.println(ot_sensorcount);
    Serial.println("Tank Full or Timed Out..!");
      if(ot_sensorcount>=4){
        digitalWrite(tonepin, LOW);
        digitalWrite(led1, LOW);
        count=0;
      }
    ot_sensorcount=ot_sensorcount+1;
   }
   else{
    ot_sensorcount=0;
   }   
  }


   if(ut_sensorstatus==0){
        Serial.println(ut_sensorcount);
        Serial.println("Tank Empty");
        digitalWrite(led2, HIGH);
        if(ut_sensorcount>=90){
          Serial.println("Water tank is still empty");
           digitalWrite(tonepin, HIGH);
           digitalWrite(led2, HIGH);
           digitalWrite(led1, HIGH);
        }
        ut_sensorcount=ut_sensorcount+1;
    }
    else{
       ut_sensorcount=0;
       digitalWrite(led2, LOW);
    } 
 
    delay(1000);
}
