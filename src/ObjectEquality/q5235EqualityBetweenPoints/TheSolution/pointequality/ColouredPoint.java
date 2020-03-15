package ObjectEquality.q5235EqualityBetweenPoints.TheSolution.pointequality;

import ObjectEquality.q5235EqualityBetweenPoints.TheSolution.Colour;

public class ColouredPoint extends Point {

  private final Colour colour;

  public ColouredPoint(double coordX, double coordY, double coordZ, Colour colour) {
    super(coordX, coordY, coordZ);
    this.colour = colour;
  }

  @Override
  public String toString() {
    return "(" + super.toString() + ", " + colour + ")";
  }

}
