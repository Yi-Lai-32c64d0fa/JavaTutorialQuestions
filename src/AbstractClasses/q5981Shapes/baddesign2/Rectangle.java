package AbstractClasses.q5981Shapes.baddesign2;

/**
 * This class illustrates a POOR DESIGN for the shapes question.
 * DO NOT CONFUSE THIS WITH THE SAMPLE SOLUTION!!!
 */
public class Rectangle extends Shape {

  private int width;
  private int height;

  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

}