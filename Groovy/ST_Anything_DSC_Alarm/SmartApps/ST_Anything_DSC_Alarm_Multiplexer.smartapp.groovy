/**
 *  ST_Anything Doors & Windows Multiplexer - ST_Anything_Doors_Windows_Multiplexer.smartapp.groovy
 *
 *  Copyright 2015 Daniel Ogorchock
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  Change History:
 *
 *    Date        Who            What
 *    ----        ---            ----
 *    2015-10-31  Dan Ogorchock  Original Creation
 *
 */
 
definition(
    name: "ST_Anything DSC Alarm Multiplexer",
    namespace: "dscalarm",
    author: "James Saint-Rossy",
    description: "Connects single Arduino with multiple ContactSensor devices to their virtual device counterparts.",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")

preferences {

	section("Select the Contact Sensor Zones (Virtual Contact Sensor devices)") {
		input "zone1", title: "Virtual Contact Sensor for Zone 1", "capability.contactSensor"
		input "zone2", title: "Virtual Contact Sensor for Zone 2", "capability.contactSensor"
		input "zone3", title: "Virtual Contact Sensor for Zone 3", "capability.contactSensor"
		input "zone4", title: "Virtual Contact Sensor for Zone 4", "capability.contactSensor"
		input "zone5", title: "Virtual Contact Sensor for Zone 5", "capability.contactSensor"
		input "zone6", title: "Virtual Contact Sensor for Zone 6", "capability.contactSensor"
	}

	section("Select the Motion Sensor Zones (Virtual PIR Sensor devices)") {
		input "pirzone1", title: "Virtual Motion Sensor for Zone 1", "capability.motionSensor"
		input "pirzone2", title: "Virtual Motion Sensor for Zone 2", "capability.motionSensor"
		input "pirzone3", title: "Virtual Motion Sensor for Zone 3", "capability.motionSensor"
		input "pirzone4", title: "Virtual Motion Sensor for Zone 4", "capability.motionSensor"
		input "pirzone5", title: "Virtual Motion Sensor for Zone 5", "capability.motionSensor"
		input "pirzone6", title: "Virtual Motion Sensor for Zone 6", "capability.motionSensor"
	}
    

	section("Select the Arduino ST_Anything_Doors_Windows device") {
		input "arduino", "capability.contactSensor"
    }    
    

}

def installed() {
	log.debug "Installed with settings: ${settings}"
	subscribe()
}

def updated() {
	log.debug "Updated with settings: ${settings}"
	unsubscribe()
	subscribe()
}

def subscribe() {

   
    subscribe(arduino, "zone1.open", zone1Open)
    subscribe(arduino, "zone1.closed", zone1Closed)
    
    subscribe(arduino, "zone2.open", zone2Open)
    subscribe(arduino, "zone2.closed", zone2Closed)
    
    subscribe(arduino, "zone3.open", zone3Open)
    subscribe(arduino, "zone3.closed", zone3Closed)
    
    subscribe(arduino, "zone4.open", zone4Open)
    subscribe(arduino, "zone4.closed", zone4Closed)
    
    subscribe(arduino, "zone5.open", zone5Open)
    subscribe(arduino, "zone5.closed", zone5Closed)
    
    subscribe(arduino, "zone6.open", zone6Open)
    subscribe(arduino, "zone6.closed", zone6Closed)
    
    subscribe(arduino, "pirzone1.open", pirzone1Open)
    subscribe(arduino, "pirzone1.closed", pirzone1Closed)
    
    subscribe(arduino, "pirzone2.open", pirzone2Open)
    subscribe(arduino, "pirzone2.closed", pirzone2Closed)
    
    subscribe(arduino, "pirzone3.open", pirzone3Open)
    subscribe(arduino, "pirzone3.closed", pirzone3Closed)
    
    subscribe(arduino, "pirzone4.open", pirzone4Open)
    subscribe(arduino, "pirzone4.closed", pirzone4Closed)
    
    subscribe(arduino, "pirzone5.open", pirzone5Open)
    subscribe(arduino, "pirzone5.closed", pirzone5Closed)
    
    subscribe(arduino, "pirzone6.open", pirzone6Open)
    subscribe(arduino, "pirzone6.closed", pirzone6Closed)
}

// --- Zone 1 --- 
def zone1Open(evt)
{
    if (zone1.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone1.openme()
    }
}

def zone1Closed(evt)
{
    if (zone1.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone1.closeme()
    }
}

// --- Zone 2 --- 
def zone2Open(evt)
{
    if (zone2.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone2.openme()
    }
}

def zone2Closed(evt)
{
    if (zone2.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone2.closeme()
    }
}

// --- Zone 3 --- 
def zone3Open(evt)
{
    if (zone3.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone3.openme()
    }
}

def zone3Closed(evt)
{
    if (zone3.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone3.closeme()
    }
}

// --- Zone 4 --- 
def zone4Open(evt)
{
    if (zone4.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone4.openme()
    }
}

def zone4Closed(evt)
{
    if (zone4.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone4.closeme()
    }
}

// --- Zone 5 --- 
def zone5Open(evt)
{
    if (zone5.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone5.openme()
    }
}

def zone5Closed(evt)
{
    if (zone5.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone5.closeme()
    }
}

// --- Zone 6 --- 
def zone6Open(evt)
{
    if (zone6.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone6.openme()
    }
}

def zone6Closed(evt)
{
    if (zone6.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	zone6.closeme()
    }
}
// --- PIR Zone 1 --- 
def pirzone1Open(evt)
{
    if (pirzone1.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone1.openme()
    }
}

def pirzone1Closed(evt)
{
    if (pirzone1.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone1.closeme()
    }
}

// --- PIR Zone 2 --- 
def pirzone2Open(evt)
{
    if (pirzone2.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone2.openme()
    }
}

def pirzone2Closed(evt)
{
    if (pirzone2.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone2.closeme()
    }
}

// --- PIR Zone 3 --- 
def pirzone3Open(evt)
{
    if (pirzone3.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone3.openme()
    }
}

def pirzone3Closed(evt)
{
    if (pirzone3.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone3.closeme()
    }
}

// --- PIR Zone 4 --- 
def pirzone4Open(evt)
{
    if (pirzone4.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone4.openme()
    }
}

def pirzone4Closed(evt)
{
    if (pirzone4.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone4.closeme()
    }
}

// --- PIR Zone 5 --- 
def pirzone5Open(evt)
{
    if (pirzone5.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone5.openme()
    }
}

def pirzone5Closed(evt)
{
    if (pirzone5.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone5.closeme()
    }
}

// --- PIR Zone 6 --- 
def pirzone6Open(evt)
{
    if (pirzone6.currentValue("contact") != "open") {
    	log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone6.openme()
    }
}

def pirzone6Closed(evt)
{
    if (pirzone6.currentValue("contact") != "closed") {
		log.debug "arduinoevent($evt.name: $evt.value: $evt.deviceId)"
    	pirzone6.closeme()
    }
}


def initialize() {
	// TODO: subscribe to attributes, devices, locations, etc.
}
