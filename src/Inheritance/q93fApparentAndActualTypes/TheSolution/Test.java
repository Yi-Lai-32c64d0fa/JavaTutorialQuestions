package Inheritance.q93fApparentAndActualTypes.TheSolution;

public class Test {

  public static void main(String[] args) {

    B myB = new B();

    C myC = new D();
    myC.accept(myB);

    D myD = new D();
    myD.accept(myB);

  }

}
