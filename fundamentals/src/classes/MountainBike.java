package classes;

public class MountainBike extends Bicycle {
        
    // the MountainBike subclass has
    // one field
    public int seatHeight; // altezza della sedia

    // the MountainBike subclass has
    // one constructor
    public MountainBike(int startHeight, int startCadence, 
                        int startSpeed, int startGear) { // definisco un costruttore
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }   
        
    // the MountainBike subclass has
    // one method
    public void setHeight(int newValue) { // definisco un metodo per impostare l'altezza della sedia
        seatHeight = newValue;
    }   
}
