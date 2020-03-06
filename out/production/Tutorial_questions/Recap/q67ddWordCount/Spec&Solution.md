## 67dd: *Word count*

Write a Java program that reads from standard input, printing the number of lines, words and alpha-numeric characters
that have been encountered when the end of input is reached.  A word is defined to be a continuous sequence of alpha-numeric characters, so that
`Dog`, `1955` and `a2ps` are each words, while `type-based` is two words.

For example, given the following input:

```
People love me at parties
when they ask me "Oh, you are a computer guy?
Can you fix my laptop?"
And I respond...
"Computer Science is no more about computers
than astronomy is about telescopes"
```

your program should print:

```
Lines: 6
Words: 35
Characters: 149
```

## Solution to [67dd](../questions/67dd): *Word count*

See code at `solutions/code/tutorialquestions/question67dd`

The sample source code solution should be fairly straightforward: check that you understand it.
The solution illustrates quite an ugly construct in Java: the expression

```
(line = br.readLine()) != null
```

which has the effect of calling `readLine()` on `br`, returning the result into `line`,
then comparing `line` with `null`.  This use of expressions that produce side-effects is
quite poor programming style in general: it can make code difficult to understand.  However, it is frequently
used when processing input, as follows (where `br` is a `BufferedReader`):

```
String line;
while((line = br.readLine()) != null) {
   ...
}
```

You can see that this is a bit more concise than the equivalent form that does not use a
side-effecting expression:

```
String line = br.readLine();
while(line != null) {
   ...
   line = br.readLine();
}
```

You will see the more concise form a lot in practice.
