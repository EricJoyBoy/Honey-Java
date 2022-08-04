package it.honeyjava.adapter;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Captain uses {@link RowingBoat} to sail. <br> This is the client in the pattern.
 */
@Setter // Lombok annotation to generate getters and setters
@NoArgsConstructor // Lombok annotation to generate constructor without arguments
@AllArgsConstructor // Lombok annotation to generate constructor with arguments
public final class Captain {

  private RowingBoat rowingBoat;
 
  void row() {
    rowingBoat.row();
  }

}