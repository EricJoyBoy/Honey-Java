package classes;

public class Bicycle {
        
    // the Bicycle class has
    // three fields
    public int cadence; // giri per minuto
    public int gear; // numero di ruote
    public int speed; // velocità in km/h
        
    // the Bicycle class has
    // one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) { // definisco un costruttore
        gear = startGear; // imposto il numero di ruote
        cadence = startCadence; // imposto i giri per minuto
        speed = startSpeed; // imposto la velocità
    }
        
    // the Bicycle class has
    // four methods
    public void setCadence(int newValue) { // definisco un metodo per impostare i giri per minuto
        cadence = newValue; // imposto i giri per minuto
    }
        
    public void setGear(int newValue) { // definisco un metodo per impostare il numero di ruote
        gear = newValue; // imposto il numero di ruote
    }
        
    public void applyBrake(int decrement) { // definisco un metodo per applicare una frenata
        speed -= decrement; // decremento la velocità
    }
        
    public void speedUp(int increment) { // definisco un metodo per accelerare
        speed += increment; // incremento la velocità
    }
}
