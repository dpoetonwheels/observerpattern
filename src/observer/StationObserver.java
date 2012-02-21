package observer;

import impl.Stations;

/**
 *  Interface StationObserver for stationLocation and generic update() function
 *  to be implemented by each station.
 *  
 * @author devang
 *
 */
public interface StationObserver {
	public boolean update(StationObserver stations, int x, int y);
	public String stationLocation();
}
