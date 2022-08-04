package it.honeyjava.adapter;

import lombok.var;

/**
 * Hello world!
 *
 */

public final  class App {


  /**
   * Program entry point.
   *
   * @param args command line args
   */
  public static void main(final String[] args) { // Program entry point.
    // The captain can only operate rowing boats but with adapter he is able to
    // use fishing boats as well
    var captain = new Captain(new FishingBoatAdapter());
    captain.row();
  }


}
