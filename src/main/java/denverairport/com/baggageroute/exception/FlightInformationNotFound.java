package denverairport.com.baggageroute.exception;

public class FlightInformationNotFound extends  Throwable {

	private static final long serialVersionUID = 1L;

	 public FlightInformationNotFound(String message) {
	        super(message);
	    }
}
