package Inheritance.q0f05ColouredPoints.MySolution;

public class ColouredPoint extends Point {

  private Colour colour;

  public ColouredPoint(Double coOrdX, Double coOrdY, Double coOrdZ, Colour colour) {
    super(coOrdX, coOrdY, coOrdZ);
    this.colour = colour;
  }

  public ColouredPoint(int coOrdX, int coOrdY, int coOrdZ, Colour colour) {
    super(coOrdX, coOrdY, coOrdZ);
    this.colour = colour;
  }

  @Override
  public String toString() {
    return super.toString() + " Colour: " + colour;
  }

}
