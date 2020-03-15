package Functional.qd3f5StreamAndDowncasting.MySolution;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

  static Stream<Integer> restrictToPositiveIntegers(Stream<Number> numbers){
    return numbers
      .filter(number -> number instanceof Integer)
      .filter(number -> ((Integer) number > 0))
      .map(number -> (Integer) number);
  }

  static Stream<Integer> restrictToPositiveIntegersBoundedWildcard(Stream<? extends Number> numbers) {
    return numbers
      .filter(number -> number instanceof Integer)
      .filter(number -> ((Integer) number > 0))
      .map(number -> (Integer) number);
  }

  public static void main(String[] args) {
    List<Integer> numbers = new LinkedList<>();
    numbers.add(1);
    numbers.add(11);
    numbers.add(-6);
    numbers.add(22);
    numbers.add(-882);
    numbers.add(213);
    numbers.add(-78);

    List<Double> list = Arrays.asList(10.0,222.2);

    System.out.println("Positive integers from " + numbers + " are: "
      + restrictToPositiveIntegersBoundedWildcard(numbers.stream()).collect(Collectors.toList()));
  }
}
