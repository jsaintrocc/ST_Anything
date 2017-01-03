//******************************************************************************************
//  File: ST_Anything_DSC_Alarm.ino
//  Author: James Saint-Rossy
//  Based on: ST_Anything_Doors_Windows by Dan G Ogorchock & Daniel J Ogorchock (Father and Son)
//
//  Summary:  This Arduino Sketch, along with the ST_Anything library and the revised SmartThings 
//            library, connects a wired DSC Alarm panel to a SmartThings controller.  While specifically
//            Written for a DSC power series pannel (PC1555) it should work with any system that uses
//            Wired contact switches.
//
//            ST_Anything_DSC_Alarm implements the following:
//              - 14 x Contact Sensor devices (door/window/PIR contact switches)
//    
//  Change History: See Github logs for this project
//
//******************************************************************************************

//******************************************************************************************
// SmartThings Library for Arduino Shield
//******************************************************************************************
#include <SoftwareSerial.h> //Arduino UNO/Leonardo uses SoftwareSerial for the SmartThings Library
#include <SmartThings.h>    //Library to provide API to the SmartThings Shield
#include <avr/pgmspace.h>

//******************************************************************************************
// ST_Anything Library 
//******************************************************************************************
#include <Constants.h>       //Constants.h is designed to be modified by the end user to adjust behavior of the ST_Anything library
#include <Device.h>          //Generic Device Class, inherited by Sensor and Executor classes
#include <Sensor.h>          //Generic Sensor Class, typically provides data to ST Cloud (e.g. Temperature, Motion, etc...)
#include <InterruptSensor.h> //Generic Interrupt "Sensor" Class, waits for change of state on digital input 
#include <Everything.h>      //Master Brain of ST_Anything library that ties everything together and performs ST Shield communications

#include <IS_Contact.h>      //Implements an Interrupt Sensor (IS) to monitor the status of a digital input pin

//******************************************************************************************
//Define which Arduino Pins will be used for each device
//  Notes: -Serial Communications Pins are defined in Constants.h (avoid pins 0,1,2,3
//          for inputs and output devices below as they may be used for communications)
//         -Always avoid Pin 6 as it is reserved by the SmartThings Shield
//
//******************************************************************************************
//"RESERVED" pins for SmartThings ThingShield - best to avoid
#define PIN_O_RESERVED               0  //reserved by ThingShield for Serial communications OR USB Serial Monitor
#define PIN_1_RESERVED               1  //reserved by ThingShield for Serial communications OR USB Serial Monitor
#define PIN_2_RESERVED               2  //reserved by ThingShield for Serial communications
#define PIN_3_RESERVED               3  //reserved by ThingShield for Serial communications
#define PIN_6_RESERVED               6  //reserved by ThingShield (possible future use?)

//Contact Pins
#define PIN_CONTACT_ZONE1  4
#define PIN_CONTACT_ZONE2  5
#define PIN_CONTACT_ZONE3  7
#define PIN_CONTACT_ZONE4   8
#define PIN_CONTACT_ZONE5   9
#define PIN_CONTACT_ZONE6   10
#define PIN_CONTACT_ZONE7   11
#define PIN_CONTACT_ZONE8    12
#define PIN_CONTACT_ZONE9    13
#define PIN_CONTACT_ZONE10   A1
#define PIN_CONTACT_ZONE11   A2
#define PIN_CONTACT_ZONE12   A3
#define PIN_CONTACT_ZONE13   A4
#define PIN_CONTACT_ZONE14   A5

//******************************************************************************************
//Arduino Setup() routine
//******************************************************************************************
void setup()
{
  //******************************************************************************************
  //Declare each Device that is attached to the Arduino
  //  Notes: - For each device, there is typically a corresponding "tile" defined in your 
  //           SmartThings DeviceType Groovy code
  //         - For details on each device's constructor arguments below, please refer to the 
  //           corresponding header (.h) and program (.cpp) files.
  //         - The name assigned to each device (1st argument below) must match the Groovy
  //           DeviceType Tile name.  
  //******************************************************************************************
 
  static st::IS_Contact sensor1(F("zone1"), PIN_CONTACT_ZONE1, LOW, true, 500);
  static st::IS_Contact sensor2(F("zone2"), PIN_CONTACT_ZONE2, LOW, true, 500);
  static st::IS_Contact sensor3(F("zone3"), PIN_CONTACT_ZONE3, LOW, true, 500);
  static st::IS_Contact sensor4(F("zone4"), PIN_CONTACT_ZONE4, LOW, true, 500);
  static st::IS_Contact sensor5(F("zone5"), PIN_CONTACT_ZONE5, LOW, true, 500);
  static st::IS_Contact sensor6(F("zone6"), PIN_CONTACT_ZONE6, LOW, true, 500);
  static st::IS_Contact sensor7(F("zone7"), PIN_CONTACT_ZONE7, LOW, true, 500);
  static st::IS_Contact sensor8(F("zone8"), PIN_CONTACT_ZONE8, LOW, true, 500);
  static st::IS_Contact sensor9(F("zone9"), PIN_CONTACT_ZONE9, LOW, true, 500);
  static st::IS_Contact sensor10(F("zone10"), PIN_CONTACT_ZONE10, LOW, true, 500);
  static st::IS_Contact sensor11(F("zone11"), PIN_CONTACT_ZONE11, LOW, true, 500);
  static st::IS_Contact sensor12(F("zone12"), PIN_CONTACT_ZONE12, LOW, true, 500);
  static st::IS_Contact sensor13(F("zone13"), PIN_CONTACT_ZONE13, LOW, true, 500);
  static st::IS_Contact sensor14(F("zone14"), PIN_CONTACT_ZONE14, LOW, true, 500);
  
  //*****************************************************************************
  //  Configure debug print output from each main class 
  //  -Note: Set these to "false" if using Hardware Serial on pins 0 & 1
  //         to prevent communication conflicts with the ST Shield communications
  //*****************************************************************************
  st::Everything::debug=true;
  st::Device::debug=true;
  st::InterruptSensor::debug=true;
  
  //*****************************************************************************
  //Initialize the "Everything" Class
  //*****************************************************************************
  st::Everything::init();
  
  //*****************************************************************************
  //Add each sensor to the "Everything" Class
  //*****************************************************************************
  st::Everything::addSensor(&sensor1);
  st::Everything::addSensor(&sensor2);
  st::Everything::addSensor(&sensor3);
  st::Everything::addSensor(&sensor4); 
  st::Everything::addSensor(&sensor5); 
  st::Everything::addSensor(&sensor6);
  st::Everything::addSensor(&sensor7); 
  st::Everything::addSensor(&sensor8);
  st::Everything::addSensor(&sensor9);
  st::Everything::addSensor(&sensor10); 
  st::Everything::addSensor(&sensor11); 
  st::Everything::addSensor(&sensor12);
  st::Everything::addSensor(&sensor13); 
  st::Everything::addSensor(&sensor14);
  
  //*****************************************************************************
  //Initialize each of the devices which were added to the Everything Class
  //*****************************************************************************
  st::Everything::initDevices();

}

//******************************************************************************************
//Arduino Loop() routine
//******************************************************************************************
void loop()
{
  //*****************************************************************************
  //Execute the Everything run method which takes care of "Everything"
  //*****************************************************************************
  st::Everything::run();
}
