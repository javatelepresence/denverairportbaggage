package denverairport.com.baggageroute.domain;

public class FlightInfo {

	private String flightgate;
	private String destination;
	private String time;

	public FlightInfo(String flightgate, String destination, String time) {
		super();
		this.flightgate = flightgate;
		this.destination = destination;
		this.time = time;
	}

	public String getFlightgate() {
		return flightgate;
	}

	public String getDestination() {
		return destination;
	}

	public String getTime() {
		return time;
	}

}
