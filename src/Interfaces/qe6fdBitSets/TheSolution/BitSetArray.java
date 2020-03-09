package Interfaces.qe6fdBitSets.TheSolution;

public class BitSetArray implements BitSet {

  private int maxValue;
  private long[] representation;

  public BitSetArray(int maxValue) {
    if (maxValue < 0) {
      throw new RuntimeException("Negative max value provided for bit set");
    }
    this.maxValue = maxValue;
    representation = new long[index(maxValue) + 1];
  }

  @Override
  public void add(int value) {
    if (!inRange(value)) {
      throw new RuntimeException("Value " + value + " too large for bit set");
    }
    representation[index(value)] |= bitWithinCell(value);
  }

  @Override
  public void remove(int value) {
    representation[index(value)] &= (~bitWithinCell(value));
  }

  @Override
  public boolean contains(int value) {
    if (!inRange(value)) {
      return false;
    }
    return (bitWithinCell(value) & representation[index(value)]) != 0;
  }

  @Override
  public void intersectWith(BitSet other) {
    if (other instanceof BitSetArray) {
      for (int i = 0;
        i <= Math.min(maxStorableValue(), ((BitSetArray) other).maxStorableValue()) / Long.SIZE;
        i++) {
        representation[i] &= ((BitSetArray) other).representation[i];
      }
    } else {
      for (int x = 0; inRange(x); x++) {
        if (!other.contains(x)) {
          remove(x);
        }
      }
    }
  }

  @Override
  public int maxStorableValue() {
    return maxValue;
  }

  @Override
  public String toString() {
    String result = "{ ";
    boolean first = true;
    for (int x = 0; inRange(x); x++) {
      if (contains(x)) {
        if (first) {
          first = false;
        } else {
          result += ", ";
        }
        result += x;
      }
    }
    return result + " }";
  }

  private boolean inRange(int x) {
    return x >= 0 && x < maxStorableValue();
  }

  private int remainder(int x) {
    return x % Long.SIZE;
  }

  private int index(int x) {
    return x / Long.SIZE;
  }

  private long bitWithinCell(int x) {
    return (long) 1 << (long) remainder(x);
  }
}
