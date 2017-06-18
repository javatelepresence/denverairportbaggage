package denverairport.com.baggageroute;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;

import denverairport.com.baggageroute.exception.FlightInformationNotFound;
import denverairport.com.baggageroute.exception.NotValidRoute;

public class OptimizedRoute {

	private DenverBaggageClaim denverBaggageClaim;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testOPtimizedRoute() throws NotValidRoute  {
		 denverBaggageClaim = new DenverBaggageClaim();
		 MutableDirectedWeightedGraph<String, Integer> graph = denverBaggageClaim.getConveyorDetails().getConveyorDetails();
		String startPoint="A5";
		String destination="A4";
		String destinationData = denverBaggageClaim.displayoptimizedroute(graph, startPoint, destination);
		String pathString = "A1 A2 A3 A4 : 9";
	    assertEquals(pathString, destinationData);
	}
	
	
	@Test  (expected=NotValidRoute.class)
	public void testOPtimizedRouteNot() throws NotValidRoute  {
		 denverBaggageClaim = new DenverBaggageClaim();
		 MutableDirectedWeightedGraph<String, Integer> graph = denverBaggageClaim.getConveyorDetails().getConveyorDetails();
		String startPoint="A2";
		String destination="A1";
		String destinationData = denverBaggageClaim.displayoptimizedroute(graph, startPoint, destination);
		String pathString = "A1 A2 A3 A4 : 9";
	    assertEquals(pathString, destinationData);
	}

}
