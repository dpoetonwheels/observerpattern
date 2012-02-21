package impl;

import observer.BrookHavenStation;
import observer.HammondStation;
import observer.KentWoodStation;
import observer.McCombStation;


/**
 * Main class - Entry point
 * 
 * @author devang
 *
 */
public class FlyAircraft {
	
	public static void main( String [] args ) {
						
		// AirPlane starts at 37N 89W
		// use a delay of 1000ms corresponding to a degree change.
		Stations st = new Stations();
		BrookHavenStation bk = new BrookHavenStation(st);
		HammondStation hm = new HammondStation(st);
		KentWoodStation kt = new KentWoodStation(st);
		McCombStation mc = new McCombStation(st);
		
		try {
			System.out.println("Aircraft flying from 37N 89W towards South");
			for(int i = 0; i < 3; i++) {				
				Thread.sleep(1000);				
				st.changeState();		// a one degree move towards south - initial state change
				st.visitStation(bk);
				Thread.sleep(1000);
				st.changeState();		// a one degree move towards south
				st.visitStation(hm);
				Thread.sleep(1000);
				st.changeState();		// a one degree move towards south
				st.visitStation(kt);
				Thread.sleep(1000);
				st.changeState();		// a one degree move towards south
				st.visitStation(mc);				
			}			
		} catch(InterruptedException ie) {
			System.out.println(" ie -> " + ie.getMessage());
		}		
	}	
}
