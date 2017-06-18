package denverairport.com.baggageroute;

import org.junit.Test;

import denverairport.com.baggageroute.exception.FlightInformationNotFound;

import static org.junit.Assert.*;

import org.junit.*;

public class DepatureTest  {
	
   private DenverBaggageClaim denverBaggageClaim;
	
	  @Test
	  public void UA10ArrivalGate() throws FlightInformationNotFound {
		  denverBaggageClaim = new DenverBaggageClaim();
		 String destination = denverBaggageClaim.getDestination("UA10");
	     assertEquals("A1", destination);
	    }
	 
	 @Test (expected=FlightInformationNotFound.class)
	  public void testFlightInformation() throws FlightInformationNotFound {
		  denverBaggageClaim = new DenverBaggageClaim();
		 String destination = denverBaggageClaim.getDestination("UA190");
	     assertNotNull(destination);
	    }
	 
	 
	 @Test (expected=NullPointerException.class)
	  public void testdenverBaggageClaimDown() throws FlightInformationNotFound {
		 String destination = denverBaggageClaim.getDestination("UA190");
	     assertNotNull(destination);
	    }

	

}
