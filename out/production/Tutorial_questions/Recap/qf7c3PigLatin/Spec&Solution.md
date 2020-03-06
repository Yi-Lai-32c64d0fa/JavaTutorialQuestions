## f7c3: *Pig Latin*

An English word is translated into *Pig Latin* as follows: if the word begins with a consonant, this is moved to the end of the word and "ay" is appended to the word.  Otherwise
the word begins with a vowel, in which case "way" is simply added to the word.  Letters are re-capitalized appropriately to stick to standard English language rules, and punctuation, numbers and whitespace are left intact.  For instance, the following sentence:

> How are you on January 1st?  I am fine, thanks.

becomes:

> Owhay areway ouyay onway Anuaryjay 1st?  Iway amway inefay, hankstay.

This is actually a slight simplification of the true rules of Pig Latin: in practice, "consonant clusters", not just the leading consonant, should be moved to the end of a word, so that, e.g., "question" becomes "estionquay".  We will ignore this complexity, so that "question" is translated to "uestionqay".

Write a Java program that reads text from standard input and translates it into Pig Latin.  Reading from standard input can be performed as in question [2d33](questions/2d33.md).
Translating a single word into Pig Latin is quite easy.  The challenge in this question is in how to decompose lines of input into individual words.

**Hints:** The `String` class provides a `substring` method which you will find useful for this
question.  To correctly preserve capitalisation and punctuation in your solution, and to handle numbers, you may find the `static` methods
`isUpperCase`, `toLowerCase` and `isDigit` from the `Character` class useful.  Refer to the Java documentation
to learn more about these methods.

## Solution to [f7c3](../questions/f7c3): *Pig Latin*

See code at `solutions/code/tutorialquestions/questionf7c3`

The sample code solution declares a method `translateToPigLatin` that
translates a string, assumed to be alpha-numeric, into Pig Latin.  Static method `isDigit` of
the `Character` class, and
the `charAt` instance method of `String` are used to check whether the first character of
the input string is a digit; if this is the case the string is returned unchanged.  Otherwise, the
Pig Latin transformation is performed relatively straightforwardly using a helper method, `isVowel`.
The solution illustrates the use of the `substring` method on strings, and Java's *ternary*
operator:

```
b ? e1 : e2
```

which evaluates to `e1` if Boolean expression `b` holds,
and to `e2` otherwise.

Method `translateLineToPigLatin` is responsible for splitting up a line into individual words,
which are processed by `translateToPigLatin`.  The `main` method uses a `BufferedReader`
to process lines from standard input.