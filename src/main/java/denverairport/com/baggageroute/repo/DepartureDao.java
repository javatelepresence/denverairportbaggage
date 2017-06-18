package denverairport.com.baggageroute.repo;

import java.util.HashMap;
import java.util.Map;

import denverairport.com.baggageroute.domain.FlightInfo;

public class DepartureDao {
   
	public Map<String,FlightInfo> getDepatureStatus(){
		Map<String,FlightInfo> departureMap = new HashMap<String, FlightInfo>();
		departureMap.put("UA10", new FlightInfo("A1", "MIA", "08:00"));
		departureMap.put("UA11", new FlightInfo("A1", "LAX", "09:00"));
		departureMap.put("UA12", new FlightInfo("A1", "JFK", "09:45"));
		departureMap.put("UA13", new FlightInfo("A2", "JFK", "08:30"));
		departureMap.put("UA14", new FlightInfo("A2", "JFK", "09:45"));
		departureMap.put("UA15", new FlightInfo("A2", "JFK", "10:00"));
		departureMap.put("UA16", new FlightInfo("A3", "JFK", "09:00"));
		departureMap.put("UA17", new FlightInfo("A4", "MHT", "09:15"));
		departureMap.put("UA18", new FlightInfo("A5", "LAX", "10:15"));
		return departureMap;
		
	}
}
