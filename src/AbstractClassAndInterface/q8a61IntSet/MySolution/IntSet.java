package AbstractClassAndInterface.q8a61IntSet.MySolution;

public interface IntSet {
  // Adds the integer x to the set
  public void add(int x);

  // If the integer x belongs to the set, it is removed and 'true'
// is returned.  Otherwise 'false' is returned
  public boolean remove(int x);

  // Returns true iff the set is empty
  public boolean isEmpty();

  // Returns true iff the set contains the integer x
  public boolean contains(int x);

}
