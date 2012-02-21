package subject;

import observer.StationObserver;

/**
 * The subject(airplane)
 *  
 * @author devang
 *
 */
public interface AircraftObservable {
	 public String aircraftID = "N407A"; 
	 public void addObserver( StationObserver st );
     public void removeObserver( StationObserver st );
}
