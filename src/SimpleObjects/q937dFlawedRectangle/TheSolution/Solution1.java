package SimpleObjects.q937dFlawedRectangle.TheSolution;

public class Solution1 {

  private int width;
  private int height;

  public Solution1(int width, int height) {
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

  public int getArea() {
    return width * height;
  }

}
