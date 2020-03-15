package AbstractClassAndInterface.q8a61IntSet.MySolution;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Demo {

  public static IntSet readIntegers(int n) throws IOException {
    IntSet set;
    if (n > 10) {
      set = new MemoryEfficientIntSet();
    } else {
      set = new SpeedEfficientIntSet();
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    while (line != null) {
      set.add(Integer.parseInt(line));
      line = br.readLine();
    }

    return set;
  }

}
