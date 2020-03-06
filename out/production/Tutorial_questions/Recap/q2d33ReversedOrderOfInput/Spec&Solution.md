
## 2d33: *Reversed order of input*

Write a program that reads a series of lines from standard input,
then prints out these lines in reversed order.

You should first implement a version of this program that reads lines of input into an array of strings,
making the assumption that input will consist of 100 lines or fewer.  You should then implement a more flexible
version of this program where the number of input lines is not bounded, by storing input in a `Deque` object
as explained below.

You can read from standard input one line at a time using a `BufferedReader` object.  To create a `BufferedReader`, add:

```
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
```

to the top of your Java file, and then write:

```
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```

in your `main` method.

To read a line from standard input into a string, `line`, do:

```
line = br.readLine();
```

Because it is possible, in exceptional cases, for input reading to go wrong, the `readLine` method can throw an *exception*.
We will cover exceptions later in the course.  For now, to allow your program to compile, you should declare `main` as follows:

```
public static void main(String[] args) throws IOException { ...
```

This means that if an exception does occur due to `readLine`, your program will exit and details of the exception will be displayed on the terminal.

The `readLine` method will return `null` when the end of input is reached.  So, to loop until all input has been consumed, you can
write something like:

```
public static void main(String[] args) throws IOException {

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String line = br.readLine();
  while (line != null) {
    ... /* Do something with 'line' */
    line = br.readLine();
  }

}
```

For the second part of the question, you can use the `Deque` interface from the Java library, which must be imported:

```
import java.util.Deque;
```

*Deque* (pronounced "deck") stands for *double-ended queue*, and provides the functionality of a *stack*:
*push* and *pop* operations, to add/remove an item to/from the front of the queue are supported.
`Deque` is a *generic* interface: it makes sense to have a deque of integers, a deque of strings, a deque of cars, etc.
`Deque` is implemented by various classes, including `ArrayDeque`, which you should use for this example.
To create an empty deque of strings, you can do:

```
Deque<String> myDeque = new ArrayDeque<>();
```

Remember that the `<String>` part of this definition specifies that the data to be stored in this deque has type `String`.

To add a string to the top of the deque, call `push`.  E.g.:

```
myDeque.push("Hello");
String myString = "Another String";
myDeque.push(myString);
```

To copy the top element of the deque into a variable, and have it removed from the deque, call `pop`.  E.g.:

```
String myString = myDeque.pop();
```

## Solution to [2d33](../questions/2d33): *Reversed order of input*

See code at `solutions/code/tutorialquestions/question2d33`

[ReversedOrderOfInputArray.java](code/tutorialquestions/question2d33/ReversedOrderOfInputArray.java) shows how this problem can be solved
using an array in the case where the maximum input size is 100.  Note that the
number 100 is represented as a local constant.

Check that you understand how the `BufferedReader` class is used in this
example.  (The beauty of encapsulation is that you don't need to worry about how
`BufferedReader` *works*, you just need to know how to *use* it.)

Notice that the condition for the `while` loop is:

```
line != null && counter < max
```

That is, the loop exits when the end of the input is reached *or* the maximum input size is reached.

[ReversedOrderOfInputStack.java](code/tutorialquestions/question2d33/ReversedOrderOfInputStack.java) shows how a `Deque` can be used to
eliminate the need for the input size to be bounded.  Of course, the input size is still
bounded: by the amount of memory available to the Java Virtual Machine!

Check that you are comfortable with the way generics have been used to construct a
`Deque` of strings.  The line:

```
Deque<String> dq = new ArrayDeque<>();
```

might look a bit mysterious at first.  You will be able to fully comprehend this in due course when
we cover *interfaces*.  Until then: `Deque` is an *interface* that is *implemented*
by `ArrayDeque`.  Thus we specify `Deque<String>` as the *apparent* type for `dq`,
but construct (using `new`) an instance of `ArrayDeque<String>`, which is the *actual* type
of `dq`.