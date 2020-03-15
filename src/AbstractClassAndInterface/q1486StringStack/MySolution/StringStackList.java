package AbstractClassAndInterface.q1486StringStack.MySolution;


import java.util.ArrayList;
import java.util.List;

public class StringStackList implements StringStack{

  private List<String> stringList;

  // Creates an empty string stack
  public StringStackList(){
    stringList = new ArrayList<>();
  }

  // If the stack is full, does nothing.
// Otherwise, pushes the given String on to the top of the stack
  @Override
  public void push(String s) {
    stringList.add(s);
  }

  // If the stack is empty, leaves the stack unchanged and returns
// null.  Otherwise, removes the string that is on the top of
// the stack and returns it
  @Override
  public String pop(){
    if(stringList.isEmpty()) {
      return null;
    }
    String result = stringList.get(0);
    stringList.remove(0);
    return result;
  }

  // Returns true iff the stack is empty
  @Override
  public boolean isEmpty(){
    return stringList.isEmpty();
  }

  @Override
  public String toString(){
    return stringList.toString();
  }
}
