package Inheritance.q0f05ColouredPoints.MySolution;

public class Point {

  private final Double CoOrdX;
  private final Double CoOrdY;
  private final Double CoOrdZ;

  public Point(Double coOrdX, Double coOrdY, Double coOrdZ) {
    CoOrdX = coOrdX;
    CoOrdY = coOrdY;
    CoOrdZ = coOrdZ;
  }

  public Point(int coOrdX, int coOrdY, int coOrdZ) {
    this.CoOrdX = (double) coOrdX;
    this.CoOrdY = (double) coOrdY;
    this.CoOrdZ = (double) coOrdZ;

  }

  public Double calculateDistance(Point other) {
    return Math.sqrt(distance(this.CoOrdX, other.CoOrdX)
      + distance(this.CoOrdY, other.CoOrdY)
      + distance(this.CoOrdZ, other.CoOrdZ));
  }

  private static Double distance(Double p1, Double p2) {
    return Math.pow(p1 - p2, 2);
  }

  public Point getOrigin() {
    return new Point((double) 0, (double) 0, (double) 0);
  }

  public Double getMagnitude() {
    return this.calculateDistance(getOrigin());
  }

  @Override
  public String toString() {
    return "Point ("+ CoOrdX +
      ", " + CoOrdY +
      ", " + CoOrdZ +
      ')';
  }
}
