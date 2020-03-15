package AbstractClassAndInterface.q8a61IntSet.MySolution;

import java.util.HashSet;
import java.util.Set;

public class MemoryEfficientIntSet implements IntSet {

  private Set<Integer> integers;

  public MemoryEfficientIntSet() {
    integers = new HashSet<>();
  }

  @Override
  public void add(int x) {
    integers.add(x);
  }

  @Override
  public boolean remove(int x) {
    return integers.remove(x);
  }

  @Override
  public boolean isEmpty() {
    return integers.isEmpty();
  }

  @Override
  public boolean contains(int x) {
    return integers.contains(x);
  }
}
