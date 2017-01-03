/**
 *  ST_Anything_DSC_Alarm Device Type - ST_Anything_DSC_Alarm.device.groovy
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
 *  Change History: See Github Logs
 *
 */

metadata {
	definition (name: "ST_Anything_DSC_Alarm", namespace: "dscalarm", author: "James Saint-Rossy") {
		capability "Contact Sensor"
		capability "Motion Sensor"
		capability "Sensor"

		attribute "zone1", "string"
		attribute "zone2", "string"
		attribute "zone3", "string"
		attribute "zone4", "string"
 		attribute "zone5", "string"
		attribute "zone6", "string"       
		attribute "pirzone1", "string"       
		attribute "pirzone2", "string"       
		attribute "pirzone3", "string"       
		attribute "pirzone4", "string"       
		attribute "pirzone5", "string"       
		attribute "pirzone6", "string"       
	}

    simulator {
        status "on":  "catchall: 0104 0000 01 01 0040 00 0A21 00 00 0000 0A 00 0A6F6E"
        status "off": "catchall: 0104 0000 01 01 0040 00 0A21 00 00 0000 0A 00 0A6F6666"

        // reply messages
        reply "raw 0x0 { 00 00 0a 0a 6f 6e }": "catchall: 0104 0000 01 01 0040 00 0A21 00 00 0000 0A 00 0A6F6E"
        reply "raw 0x0 { 00 00 0a 0a 6f 66 66 }": "catchall: 0104 0000 01 01 0040 00 0A21 00 00 0000 0A 00 0A6F6666"
    }
	
    // Preferences

	// tile definitions
	tiles {
        standardTile("zone1", "device.zone1", width: 1, height: 1, canChangeIcon: true, canChangeBackground: true) {
			state("open", label:'${name}', icon:"st.contact.contact.open", backgroundColor:"#ffa81e")
			state("closed", label:'${name}', icon:"st.contact.contact.closed", backgroundColor:"#79b821")
 		}
        standardTile("zone2", "device.zone2", width: 1, height: 1, canChangeIcon: true, canChangeBackground: true) {
			state("open", label:'${name}', icon:"st.contact.contact.open", backgroundColor:"#ffa81e")
			state("closed", label:'${name}', icon:"st.contact.contact.closed", backgroundColor:"#79b821")
 		}
        standardTile("zone3", "device.zone3", width: 1, height: 1, canChangeIcon: true, canChangeBackground: true) {
			state("open", label:'${name}', icon:"st.contact.contact.open", backgroundColor:"#ffa81e")
			state("closed", label:'${name}', icon:"st.contact.contact.closed", backgroundColor:"#79b821")
 		}
        standardTile("zone4", "device.zone4", width: 1, height: 1, canChangeIcon: true, canChangeBackground: true) {
			state("open", label:'${name}', icon:"st.contact.contact.open", backgroundColor:"#ffa81e")
			state("closed", label:'${name}', icon:"st.contact.contact.closed", backgroundColor:"#79b821")
 		}
        standardTile("zone5", "device.zone5", width: 1, height: 1, canChangeIcon: true, canChangeBackground: true) {
			state("open", label:'${name}', icon:"st.contact.contact.open", backgroundColor:"#ffa81e")
			state("closed", label:'${name}', icon:"st.contact.contact.closed", backgroundColor:"#79b821")
 		}
        standardTile("zone6", "device.zone6", width: 1, height: 1, canChangeIcon: true, canChangeBackground: true) {
			state("open", label:'${name}', icon:"st.contact.contact.open", backgroundColor:"#ffa81e")
			state("closed", label:'${name}', icon:"st.contact.contact.closed", backgroundColor:"#79b821")
 		}
        standardTile("pirzone1", "device.pirzone1", width: 1, height: 1) {
			state("open", label:'motion', icon:"st.motion.motion.active", backgroundColor:"#53a7c0")
			state("closed", label:'no motion', icon:"st.motion.motion.inactive", backgroundColor:"#ffffff")
		}
        standardTile("pirzone2", "device.pirzone2", width: 1, height: 1) {
			state("open", label:'motion', icon:"st.motion.motion.active", backgroundColor:"#53a7c0")
			state("closed", label:'no motion', icon:"st.motion.motion.inactive", backgroundColor:"#ffffff")
		}
        standardTile("pirzone3", "device.pirzone3", width: 1, height: 1) {
			state("open", label:'motion', icon:"st.motion.motion.active", backgroundColor:"#53a7c0")
			state("closed", label:'no motion', icon:"st.motion.motion.inactive", backgroundColor:"#ffffff")
		}
        standardTile("pirzone4", "device.pirzone4", width: 1, height: 1) {
			state("open", label:'motion', icon:"st.motion.motion.active", backgroundColor:"#53a7c0")
			state("closed", label:'no motion', icon:"st.motion.motion.inactive", backgroundColor:"#ffffff")
		}
        standardTile("pirzone5", "device.pirzone5", width: 1, height: 1) {
			state("open", label:'motion', icon:"st.motion.motion.active", backgroundColor:"#53a7c0")
			state("closed", label:'no motion', icon:"st.motion.motion.inactive", backgroundColor:"#ffffff")
		}
        standardTile("pirzone6", "device.pirzone6", width: 1, height: 1) {
			state("open", label:'motion', icon:"st.motion.motion.active", backgroundColor:"#53a7c0")
			state("closed", label:'no motion', icon:"st.motion.motion.inactive", backgroundColor:"#ffffff")
		}

        
        main (["zone1"])
        details(["zone1","zone2","zone3","zone4","zone5","zone6","pirzone1","pirzone2","pirzone3","pirzone4","pirzone5","pirzone6"])
	}
}

//Map parse(String description) {
def parse(String description) {
    def msg = zigbee.parse(description)?.text
    log.debug "Parse got '${msg}'"

    def parts = msg.split(" ")
    def name  = parts.length>0?parts[0].trim():null
    def value = parts.length>1?parts[1].trim():null

    name = value != "ping" ? name : null
	
    //if (name == "temperature") 
    //{
    //	value = fahrenheitToCelsius(value.toDouble())
    //}
    
    def result = createEvent(name: name, value: value, isStateChange: true)

    log.debug result

    return result
}
