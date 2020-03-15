package Inheritance.qdd4cClocks.MySolution;

public class ClockDemo {

  public static void main(String[] args) throws InterruptedException {
    Clock q = new Clock("q",22, 45,55);
    Clock k = new Clock("k",81955);
    while (true) {
      System.out.print(q);
      System.out.print("    ");
      System.out.print(k);
      System.out.println("");
      q.tick();
      k.tick();
      Thread.sleep(10);
    }
  }
}
