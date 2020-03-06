## f79b: *Perfect palindromic cubes*

A number *x* is a *perfect palindromic cube* if it is a perfect cube (i.e., *x*=*y*<sup>3</sup> for some integer *y*), and it is a palindrome when
written in decimal (i.e., it appears the same backwards).  For example, 1030301 is a perfect palindromic cube: it is clearly a palindrome, and 101<sup>3</sup> = 1030301.

Write a program that enumerates the first 1500 non-negative integers, and indicates which integers yield palindromic numbers when they are cubed.  The output of your program should begin:

```
0 cubed is 0
1 cubed is 1
2 cubed is 8
7 cubed is 343
```

Think about whether or not your program would work properly if you continued significantly larger non-negative integers.  If it would not, why not?

**Hints:**  You may find the `length` and `charAt` methods of the `String` class useful.
These are *instance methods*: you invoke them on a `String` object.  Also,
you may find the `String.valueOf` method helpful to turn an `int` into a `String`.  This is
a *class method* (also called a *global method* or *static method*): you invoke it independently of a `String`
object.  See the Java documentation for more details.


## Solution to [f79b](../questions/f79b): *Perfect palindromic cubes*

See code at `solutions/code/tutorialquestions/questionf79b`

The solution involves a method:

```
static boolean isPalindrome(String number);
```

which determines whether the `String` parameter `number` (named so as in this question it is intended to store the String representation of a number) is a palindrome.  The method is recursive.  As a base case, strings of length 0 and 1 are (trivially) palindromes; we use the method `length()` of `String` to determine this.
For a string of greater length, we check whether its first and last characters are the same.  This is achieved using the `charAt(int index)` method,
which returns the character at position `index` of the string.

Armed with `isPalindrome`, we enumerate the first 2000 cubes using a `for` loop.  For each cube, we turn it into a string using
`String.valueOf`, and test the resulting string using `isPalindrome`.

An alternative approach to `isPalindrome` is to take the number as an `int` and use arithmetic operations (based on the `/` and `%` operators) to determine whehter successive pairs of digits are equal, working from the outside in.  However, such a solution is less readable than the simple String-based solution given here, and it is best to favour readability over efficienty when programming, unless there is an urgent need for efficiency.

Regarding the problem of running the program for larger numbers: integers in Java are 32-bit, and the largest positive integer representable in Java is 2<sup>31</sup>-1 = 2147483647.  The largest integer that, when cubed, is less than or equal to this limit, is 1290: 1290<sup>3</sup> = 2146689000.  Although mathematically, 1291<sup>3</sup> = 2151685171, when computed in a Java program one gets the answer -2143282125, which is 2151685171 - 2<sup>32</sup>.  This is because the result wraps around.

Representing integers using the java.math.BigInteger class would avoid this problem - try it out!