package ObjectEquality.q5235EqualityBetweenPoints.MySolution;


import Inheritance.q0f05ColouredPoints.TheSolution.Colour;
import Inheritance.q0f05ColouredPoints.TheSolution.Point;

public class ColouredPoint extends Point {

  private final Colour colour;

  public ColouredPoint(double coordX, double coordY, double coordZ, Colour colour) {
    super(coordX, coordY, coordZ);
    this.colour = colour;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ColouredPoint)) {
      return false;
    }
    ColouredPoint cp = (ColouredPoint) other;
    return cp.colour == this.colour
    && super.equals(other);
  }

  @Override
  public String toString() {
    return "(" + super.toString() + ", " + colour + ")";
  }

}