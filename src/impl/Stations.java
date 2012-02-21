package impl;

import java.util.ArrayList;
import java.util.Iterator;

import observer.StationObserver;

import subject.AircraftObservable;

/**
 * A class that contains the list of stations and notifies each observer(station)
 * 
 * @author devang
 *
 */

public class Stations implements AircraftObservable {
	private ArrayList list = new ArrayList();
    private ArrayList observers = new ArrayList();
    private int x = 0;
    private int y = 0;
    
    public Stations() {
    	x = 37;
    	y = 89;
    }
    
    public int getX() {
    	return x;
    }
    
    /**
     * Add Observers(Stations)
     * 
     * @param i
     */
    public void visitStation( StationObserver st ) {
    	list.add(st);
        notifyObservers();
    }
    
    /**
     * Iterator for Observers(Stations)
     * 
     * @return
     */
    public Iterator iterator() {
        return list.iterator();
    }
    
    /**
     * Remove Observers(Stations)
     * 
     * @param index
     * @return
     */
    public Integer leaveStation( StationObserver st ) {
      if( list.size()>0 ) {
    	  list.remove( st );
            notifyObservers();
            return 0;
      } else {
    	  return null;
      }
    }
  
	@Override
	public void addObserver(StationObserver st) {
		// TODO Auto-generated method stub
		observers.add( st );
		//add(st);		
	}

	@Override
	public void removeObserver(StationObserver st) {
		// TODO Auto-generated method stub
		observers.remove(st);
	}
	
	public void changeState() {
		x = x - 1;
		y = y + 1;
		//notifyObservers();
	}
	
    private void notifyObservers() {
          // loop through and notify each observer
          Iterator i = observers.iterator();
          while( i.hasNext() ) {
        	  	StationObserver o = ( StationObserver ) i.next();
        	  	System.out.println("Updating");
                o.update( o , x, y);
          }
    }

}
