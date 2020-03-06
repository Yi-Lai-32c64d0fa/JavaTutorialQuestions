package Recap.q67ddWordCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MySolution {

  public static void main(String[] args) throws IOException {
    int lines = 0;
    int words = 0;
    int chars = 0;

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String line = bf.readLine();
    while (line != null) {
      if (line.length() > 0) {
        lines++;
        words += MySolution.countWords(line);
      }
      chars += MySolution.countChars(line);
      line = bf.readLine();
    }

    System.out.println("Lines: " + lines + "\nWords: " + words + "\nCharacters: " + chars);

  }

  private static int countWords(String line) {
    int words = 0;
    boolean counted = false;
    for (int i = 0; i < line.length(); i++) {
      if (Character.isLetterOrDigit(line.charAt(i))) {
        if (!counted) {
          counted = true;
          words++;
        }
      } else {

        counted = false;
      }
    }
    return words;
  }

    private static int countChars(String line){
      int chars = 0;
      for (int i = 0; i < line.length(); i++) {
        if (Character.isLetterOrDigit(line.charAt(i))) {
          chars++;
        }
      }
      return chars;
    }
  }
