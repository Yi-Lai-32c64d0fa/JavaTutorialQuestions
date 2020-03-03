package Recap.q98e3OneFourTwoOne;

import java.util.ArrayList;

public class MySolution {

    public static int next (int x) {
        if (x % 2 == 0) {
            return x / 2;
        } else {
            return 3 * x + 1;
        }
    }

    public static void main(String[] args) {
        int integer = Integer.parseInt(args[0]);
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(integer);
        while (integer != 1) {
            integer = MySolution.next(integer);
            numberList.add(integer);
        }
        System.out.println(numberList);
    }
}
