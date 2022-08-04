package it.honeyjava.adapter;


public class FishingBoatAdapter implements RowingBoat { 

    private final FishingBoat boat = new FishingBoat(); 
  
    public final void row() {
      boat.sail();
    }
  }
