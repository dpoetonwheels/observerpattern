package observer;

import impl.Stations;
import subject.AircraftObservable;

/**
 * Class containing information pertaining to KentWoodStation
 * 
 * @author devang
 *
 */
public class KentWoodStation implements StationObserver {
	//private Stations st;
	private int relativex;
	private int relativey;
	public KentWoodStation(Stations st) {
		// TODO Auto-generated constructor stub
		st.addObserver(this);
		relativex = 0;
		relativey = 0;
	}

	public int getRelativeX() {
		return relativex;
	}
	
	public int getRelativeY() {
		return relativey;
	}
	
	@Override
	public String stationLocation() {
		// TODO Auto-generated method stub
		return "32N 89W";
	}

	@Override
	public boolean update(StationObserver ar, int x, int y) {
		// TODO Auto-generated method stub
		boolean isOutdated = false;

		StationUtils.latitude(stationLocation());
		StationUtils.longitude(stationLocation());
		
		relativex = StationUtils.relativeX(x);
		relativey = StationUtils.relativeY(y);		
		
		if(Math.abs(StationUtils.relativeX(x)) <=2) {
			System.out.println("State Changed: New Flight Location -> " + x + "N " + y + "W");
			//System.out.println("New Flight Location -> " + x + "N " + y + "W");
			if(ar instanceof KentWoodStation) {
				System.out.println("Current Location -> Springfield");
				System.out.println("KentWood Station reports " + AircraftObservable.aircraftID + " at " +
						stationLocation() + " (" + StationUtils.relativeX(x) +
						"," + StationUtils.relativeY(y) + ")" + " relative.");
				//x =
				
			}
			if(Math.abs(StationUtils.relativeX(x)) == 0) {
				isOutdated = true;
			}
			if(x==30) {
				System.exit(1);
			}
		}
		return isOutdated;
	}

}
