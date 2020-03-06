package Recap.qf7c3PigLatin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MySolution {

  public static String translateToPigLatin(String english) {
    if (Character.isDigit(english.charAt(0))) {
      return english;
    } else if (MySolution.isVowel(english.charAt(0))) {
        return english + "way";
    } else {
        return null;
    }
  }

  private static boolean isVowel(Character character) {
    ArrayList<Character> vowels = new ArrayList<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    return vowels.contains(character);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

  }

}
