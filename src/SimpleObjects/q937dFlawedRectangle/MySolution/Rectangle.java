package SimpleObjects.q937dFlawedRectangle.MySolution;

public class Rectangle {

  private int width;
  private int height;
  private int area;

  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
    this.area = width * height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
    updateArea();
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
    updateArea();
  }

  public int getArea() {
    return area;
  }

  private void updateArea(){
    this.area = width * height;
  }

}