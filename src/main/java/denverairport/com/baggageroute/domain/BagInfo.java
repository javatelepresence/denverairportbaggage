package denverairport.com.baggageroute.domain;

public class BagInfo {
	private String bagNumber;
	private String entryPoint;
	private String flightId;

	public BagInfo(String bagNumber, String entryPoint, String flightId) {
		super();
		this.bagNumber = bagNumber;
		this.entryPoint = entryPoint;
		this.flightId = flightId;
	}

	public String getBagNumber() {
		return bagNumber;
	}

	public String getEntryPoint() {
		return entryPoint;
	}

	public String getFlightId() {
		return flightId;
	}

}
