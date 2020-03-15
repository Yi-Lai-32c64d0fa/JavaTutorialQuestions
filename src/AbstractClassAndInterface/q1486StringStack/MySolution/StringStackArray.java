package AbstractClassAndInterface.q1486StringStack.MySolution;


import java.util.Arrays;

public class StringStackArray implements StringStack {

  private String[] stringArray;
  private static final int MAX_SIZE = 100;

  public StringStackArray() {
    stringArray = new String[MAX_SIZE];
  }

  // If the stack is full, does nothing.
// Otherwise, pushes the given String on to the top of the stack
  @Override
  public void push(String s) {
    if (stringArray[99] != null) {
      boolean added = false;
      for (int i = 0; i < MAX_SIZE; i++) {
        if (stringArray[i] == null && !added) {
          stringArray[i] = s;
          added = true;
        }
      }
    }
  }

  // If the stack is empty, leaves the stack unchanged and returns
// null.  Otherwise, removes the string that is on the top of
// the stack and returns it
  @Override
  public String pop() {
    String result = stringArray[0];
    for (int i = 0; i < MAX_SIZE - 1; i++) {
      stringArray[i] = stringArray[i + 1];
    }
    stringArray[MAX_SIZE - 1] = null;
    return result;
  }

  // Returns true iff the stack is empty
  @Override
  public boolean isEmpty() {
    return stringArray[0] == null;
  }

  public static void main(String[] args) {
    String[] k = new String[10];
  }

  @Override
  public String toString() {
    return Arrays.toString(stringArray);
  }
}
