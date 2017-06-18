package denverairport.com.baggageroute.repo;

import java.util.ArrayList;
import java.util.List;

import denverairport.com.baggageroute.domain.BagInfo;

public class BagDao {
   public List<BagInfo> getBaggageList(){
	   List<BagInfo> baggageList = new ArrayList<BagInfo>();
	   baggageList.add(new BagInfo("0001", "Concourse_A_Ticketing", "UA12"));
	   baggageList.add(new BagInfo("0002", "A5", "UA17"));
	   baggageList.add(new BagInfo("0003", "A2", "UA10"));
	   baggageList.add(new BagInfo("0004", "A8", "UA18"));
	   return baggageList;
   }
}
