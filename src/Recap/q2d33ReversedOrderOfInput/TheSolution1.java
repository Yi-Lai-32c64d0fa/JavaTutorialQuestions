package Recap.q2d33ReversedOrderOfInput;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//ReversedOrderOfInputArray
public class TheSolution1 {

  private static final int max = 100;

  /**
   * Main method for I/O example.
   */
  public static void main(String[] args) throws IOException {

    String[] input = new String[max];

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();

    int counter = 0;

    while (line != null && counter < max) {
      input[counter] = line;
      counter++;
      line = br.readLine();
    }

    for (int i = counter - 1; i >= 0; i--) {
      System.out.println(input[i]);
    }

  }

}
