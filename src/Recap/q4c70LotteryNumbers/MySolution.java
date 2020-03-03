package Recap.q4c70LotteryNumbers;

import java.util.ArrayList;
import java.util.Random;

public class MySolution {

  public static void main(String[] args) {
    Random generator = new Random();
    ArrayList<Integer> numberList = new ArrayList<>();
    final int numberOfLotteryNumbers = 7;
    final int lotteryNumberRange = 49;
    // generator.nextInt() between 0 (inclusive) and the argument number(exclusive)

    for (int i = 0; i < numberOfLotteryNumbers; i++) {
      int x = generator.nextInt(lotteryNumberRange) + 1;
      if (!numberList.contains(x)) {
        numberList.add(x);
      } else {
        i -= 1;
      }
    }

    for (int j = 0; j < numberOfLotteryNumbers - 1; j++) {
      System.out.println("Number " + (j + 1) + ": " + numberList.get(j));
    }
    System.out.println("Bonus Number: " + numberList.get(numberOfLotteryNumbers - 1));


  }
}
