package it.honeyjava.adapter;




/**
 * Device class (adaptee in the pattern). We want to reuse this class. Fishing boat moves by
 * sailing.
 */

final class FishingBoat {

  void sail() {
    System.out.println("Fishing boat is sailing");
  }

}