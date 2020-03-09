package Functional.q68e6UsingStreamReduce;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MySolution {

  static List<Integer> concatenate(List<List<Integer>> lists) {
    return lists.stream()
      .reduce(Collections.emptyList(),
        (fst, snd) -> {
          List<Integer> result = new ArrayList<>(fst);
          result.addAll(snd);
          return result;
        });
  }

  static int findMin(List<Integer> numbers) {
    return numbers.stream()
      .reduce(Integer.MAX_VALUE, Math::min);
  }

  static int findMinOrZero(List<Integer> numbers) {
    return numbers.stream()
      .reduce(Math::min)
      .orElse(0);
  }

  static int findMax(List<Integer> numbers) {
    return numbers.stream()
      .reduce(Integer.MIN_VALUE, (fst, snd) -> Math.max(fst, snd));
  }

  static int findMaxOrZero(List<Integer> numbers) {
    return numbers.stream()
      .reduce((fst, snd) -> Math.max(fst, snd))
      .orElse(0);
  }

  static int findMinOfMaxes(List<List<Integer>> listOfLists) {
    return findMin(listOfLists.stream()
      .map(MySolution::findMax)
      .collect(Collectors.toList()));
  }

  public static void main(String[] args) {
    final List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 9);
    final List<Integer> list2 = Arrays.asList(1, 10, 100, 1000, 10000);
    final List<Integer> list3 = Arrays.asList(6, 7, 8);
    final List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

    final List<Integer> allIntegers = concatenate(listOfLists);
    final int maxList1 = findMax(list1);
    final int minList2 = findMin(list2);
    final int maxEmpty = findMax(Collections.emptyList());
    final int minEmpty = findMin(Collections.emptyList());
    final int maxOrZeroEmpty = findMinOrZero(Collections.emptyList());
    final int minOrZeroEmpty = findMaxOrZero(Collections.emptyList());
    final int minOfMaxes = findMinOfMaxes(listOfLists);
    final int minOfMaxesEmpty = findMinOfMaxes(Collections.emptyList());
    final int minOfMaxesListOfEmptyLists = findMinOfMaxes(
      Arrays.asList(Collections.emptyList(), Collections.emptyList()));

    System.out.println("Concatenation of all the integer lists: " + allIntegers);
    System.out.println("Max of list 1: " + maxList1);
    System.out.println("Min of list 2: " + minList2);
    System.out.println("Max of empty list: " + maxEmpty);
    System.out.println("Min of empty list: " + minEmpty);
    System.out.println("Max-or-zero of empty list: " + maxOrZeroEmpty);
    System.out.println("Min-or-zero of empty list: " + minOrZeroEmpty);
    System.out.println("Min of maxes: " + minOfMaxes);
    System.out.println("Min of maxes of empty list: " + minOfMaxesEmpty);
    System.out.println("Min of maxes of list of empty lists: " + minOfMaxesListOfEmptyLists);
  }

}
