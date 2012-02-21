package observer;

/**
 * Utility class for Stations
 * 
 * @author devang
 *
 */
public final class StationUtils {
	
	private static int LATITUDE = 0;
	private static int LONGITUDE = 0;
	
	public static int latitude(String location) {
		LATITUDE = Integer.parseInt(location.substring(0, location.indexOf("N")));; 
		return LATITUDE;
	}
	
	public static int longitude(String location) {
		LONGITUDE = Integer.parseInt(location.substring((location.indexOf("N")+2),location.length()-1));
		return LONGITUDE;
	}
	
	public static int relativeX(int x) {
		return LATITUDE - x;
	}
	
	public static int relativeY(int y) {
		return LONGITUDE - y;
	}
}
