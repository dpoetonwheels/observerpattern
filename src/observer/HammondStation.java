package observer;

import impl.Stations;
import subject.AircraftObservable;

/**
 * Class containing information pertaining to HammondStation
 * 
 * @author devang
 *
 */
public class HammondStation implements StationObserver {
	
	//private Stations st;
	private int relativex;
	private int relativey;
    public HammondStation(Stations st) {
          st.addObserver(this);
          relativex = 0;
          relativey = 0;
    }
    
	@Override
	public String stationLocation() {
		// TODO Auto-generated method stub
		return "31N 89W";
	}
	
	public int getRelativeX() {
		return relativex;
	}
	
	public int getRelativeY() {
		return relativey;
	}
	@Override
	public boolean update(StationObserver ar, int x, int y) {
		// TODO Auto-generated method stub
		//if(ar instanceof StationObserver) {
		boolean isOutdated = false;
		
		StationUtils.latitude(stationLocation());
		StationUtils.longitude(stationLocation());
				
		relativex = StationUtils.relativeX(x);
		relativey = StationUtils.relativeY(y);
						
		if(Math.abs(StationUtils.relativeX(x)) <=2) {

			System.out.println("State Changed: New Flight Location -> " + x + "N " + y + "W");
			if(ar instanceof HammondStation) {
				System.out.println("Current Location -> LA");
				System.out.println("Hammond Station reports " + AircraftObservable.aircraftID + " at " +
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
