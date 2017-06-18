package denverairport.com.baggageroute;

import java.util.List;
import java.util.Map;

import org.psjava.algo.graph.shortestpath.DijkstraAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodDijkstraAlgorithm;

import denverairport.com.baggageroute.domain.BagInfo;
import denverairport.com.baggageroute.domain.FlightInfo;
import denverairport.com.baggageroute.exception.FlightInformationNotFound;
import denverairport.com.baggageroute.exception.NotValidRoute;
import denverairport.com.baggageroute.repo.BagDao;
import denverairport.com.baggageroute.repo.ConveyorDao;
import denverairport.com.baggageroute.repo.DepartureDao;

public class DenverBaggageClaim {
	private Map<String, FlightInfo> departureMap;
	private ConveyorDao conveyorDetails;
	private BagDao bagDao;

	public DenverBaggageClaim() {
		this.departureMap = new DepartureDao().getDepatureStatus();
		this.conveyorDetails = new ConveyorDao();
		this.bagDao = new BagDao();
	}

	public void displayBaggage() {
		DenverBaggageClaim denverBaggageClaim = new DenverBaggageClaim();
		List<BagInfo> bagList = getBagDao().getBaggageList();
		for (BagInfo bag : bagList) {
			String destination;
			try {
				destination = getDestination(bag.getFlightId());
				String baggageRoute = denverBaggageClaim.displayoptimizedroute(
						denverBaggageClaim.getConveyorDetails().getConveyorDetails(), bag.getEntryPoint(), destination);
				StringBuffer bagDetailSb = new StringBuffer();
				bagDetailSb.append(bag.getBagNumber()).append(" ").append(bag.getEntryPoint()).append(" ")
						.append(baggageRoute);
				System.out.println(bagDetailSb.toString());
			} catch (FlightInformationNotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotValidRoute e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
	}

	

	public String getDestination(String flightId) throws FlightInformationNotFound {
		String destination = "";
		if (departureMap.containsKey(flightId)) {
			destination = departureMap.get(flightId).getFlightgate();
		} else {
             throw new FlightInformationNotFound("Flight ID " + flightId + " not found");
		}
		return destination;
	}

	public String displayoptimizedroute(MutableDirectedWeightedGraph<String, Integer> graph, String startPoint,
			String destination) throws NotValidRoute {
		StringBuilder routeDetails = new StringBuilder();
		IntegerNumberSystem NS = IntegerNumberSystem.getInstance();
		DijkstraAlgorithm dijkstra = GoodDijkstraAlgorithm.getInstance();

		SingleSourceShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> result = dijkstra
				.calc(graph, startPoint, NS);

		boolean isreachable = result.isReachable(destination);

		if (isreachable) {
			int distance = result.getDistance(destination);

			for (DirectedWeightedEdge<String, Integer> routePoint : result.getPath(destination)) {
				routeDetails.append(routePoint.to()).append(" ");
			}

			routeDetails.append(":").append(" ").append(distance);
		} else{
			throw new NotValidRoute("There is no connection beteween " + startPoint + " and " + destination);
		}

		return routeDetails.toString();
	}

	public Map<String, FlightInfo> getDepartureMap() {
		return departureMap;
	}

	public ConveyorDao getConveyorDetails() {
		return conveyorDetails;
	}

	public BagDao getBagDao() {
		return bagDao;
	}
	
	public static void main(String[] args) {
		DenverBaggageClaim denverBaggageClaim = new DenverBaggageClaim();
		denverBaggageClaim.displayBaggage();

	}

}
