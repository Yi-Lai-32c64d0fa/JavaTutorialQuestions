package Interfaces.qe6fdBitSets.MySolution;

import java.util.HashSet;
import java.util.Set;

public class BitSet8 implements BitSet {

  private byte number;
  private static final int MAX_VALUE = 7;
  private Set<Integer> bitSet;

  public BitSet8() {
    number = 0;
    bitSet = new HashSet<>();
  }

  @Override
  public void add(int x) {
    if (!inRange(x)) {
      throw new RuntimeException("Value" + x + "is not in range.");
    }
    number |= ((byte) 1 << (byte) x);
    bitSet.add(x);
  }
  private boolean inRange(int value){
    return 0 <= value && value <= MAX_VALUE;
  }

  @Override
  public void remove(int x) {
    if (inRange(x)) {
      number &= (~((byte) 1 << (byte) x));
      bitSet.remove(x);
    }
  }

  @Override
  public boolean contains(int x) {
    if(!inRange(x)) {
      return false;
    }
    return (((byte) 1 << (byte) x) & number) != 0;
  }

  @Override
  public void intersectWith(BitSet s) {
    if (s instanceof BitSet8) {
      number &= ((BitSet8) s).number;
    } else {
      for (int x = 0; inRange(x); x++) {
        if (!s.contains(x)) {
          remove(x);
        }
      }
    }

  }

  @Override
  public int maxStorableValue() {
    return MAX_VALUE;
  }

  @Override
  public String toString() {
    return bitSet.toString();
  }
}
