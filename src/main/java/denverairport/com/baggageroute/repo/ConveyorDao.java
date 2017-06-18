package denverairport.com.baggageroute.repo;

import org.psjava.ds.graph.MutableDirectedWeightedGraph;

public class ConveyorDao {

	public MutableDirectedWeightedGraph<String, Integer> getConveyorDetails(){
		MutableDirectedWeightedGraph<String, Integer> conveyorDetails = MutableDirectedWeightedGraph.create();
		  conveyorDetails.insertVertex("A1");
		  conveyorDetails.insertVertex("A2");
		  conveyorDetails.insertVertex("A3");
		  conveyorDetails.insertVertex("A4");
		  conveyorDetails.insertVertex("A5");
		  conveyorDetails.insertVertex("A6");
		  conveyorDetails.insertVertex("A7");
		  conveyorDetails.insertVertex("A8");
		  conveyorDetails.insertVertex("A9");
		  conveyorDetails.insertVertex("A10");
		  conveyorDetails.insertVertex("Concourse_A_Ticketing");
		  
		  conveyorDetails.addEdge("A5", "A10", 4);
		  conveyorDetails.addEdge("A5", "A1", 6);
		  conveyorDetails.addEdge("A1", "A2", 1);
		  conveyorDetails.addEdge("A2", "A3", 1);
		  conveyorDetails.addEdge("A3", "A4", 1);
		  conveyorDetails.addEdge("A10", "A9", 1);
		  conveyorDetails.addEdge("A9", "A8", 1);
		  conveyorDetails.addEdge("A8", "A7", 1);
		  conveyorDetails.addEdge("A7", "A6", 1);
		  conveyorDetails.addEdge("Concourse_A_Ticketing", "A5", 5);
		  return conveyorDetails;

	}
}
