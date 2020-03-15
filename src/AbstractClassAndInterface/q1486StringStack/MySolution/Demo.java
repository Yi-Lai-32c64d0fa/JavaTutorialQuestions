package AbstractClassAndInterface.q1486StringStack.MySolution;

public class Demo {
  public static void transferStacks(StringStack dst, StringStack src){
    while (!src.isEmpty()) {
      dst.push(src.pop());
    }
  }

  public static void main(String[] args) {
    StringStack sa = new StringStackArray();
    StringStack sl = new StringStackList();
    sa.push("apple");
    sa.push("banana");
    sa.push("cat");
    sl.push("xenia");
    sl.push("huxley");
    sl.push("shefield");
    System.out.println(sa.toString());
    System.out.println(sl.toString());
    Demo.transferStacks(sl,sa);
    assert sl.isEmpty();
    System.out.println(sl.toString());
  }
}
