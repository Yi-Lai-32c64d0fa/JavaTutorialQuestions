package Recap.q2d33ReversedOrderOfInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class TheSolution2 {

  //public class ReversedOrderOfInputStack

  /**
   * Main method for stack-based I/O example.
   */
  public static void main(String[] args) throws IOException {

    Deque<String> dq = new ArrayDeque<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();

    while (line != null) {
      dq.push(line);
      line = br.readLine();
    }

    while (!dq.isEmpty()) {
      System.out.println(dq.pop());
    }

  }

}

