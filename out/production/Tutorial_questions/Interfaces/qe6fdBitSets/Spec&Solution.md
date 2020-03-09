## e6fd: *Bit sets*

An *n*-bit binary number can be used to represent a set of integers in
the range [0,*n*-1].  This can be achieved by setting bit *i* of the
number to 1 if and only if *i* belongs to the set.  Such a
representation of a set is called a *bit set*.

For example, if *n*=8, some sets and their bit set representations are as follows:

| *Set*                      | *Binary bit set representation* |
|:--------------------------:|:-------------------------------:|
| { }                        | `00000000`                  |
| { 0 }                      | `00000001`                  |
| { 1 }                      | `00000010`                  |
| { 2 }                      | `00000100`                  |
| { 7 }                      | `10000000`                  |
| { 0, 2, 4, 6 }             | `01010101`                  |
| { 0, 1, 2, 3, 4, 5, 6, 7 } | `11111111`                  |

Bit sets are attractive because they are very space-efficient (an
element of a set is represented by just one bit), and because various
set operations are cheap to compute.  Some example operations that are easy to compute on bit sets are:

| *Operation*  | *Bit set implementation* | *Java implementation* |
|--------------|--------------------------|-----------------------|
| Check whether *x* belongs to *S*    | Check whether bit *x* is 1 | `return ((1 << x) & S) != 0;` |
| Add *x* to *S*                      | Set bit *x* to 1           | `S = S \| (1 << x);` |
| Compute intersection of *S* and *T* | Return set where bit *x* is 1 if and only if bit *x* is 1 in both *S* and *T* | `return S & T;` |
| Compute union of *S* and *T*        | Return set where bit *x* is 1 if and only if *x* is 1 in at least one of *S* and *T* | `return S \| T;` |

This table uses the following Java operators:

* Left shift, `<<`: `a << b` returns the result of shifting the bits of `a` to the left `b` places, inserting zeroes on the right.
* Bitwise and, `&`: `a & b` returns the number whose binary has a `1` in each position where both `a` and `b` have a `1`, and a `0` everywhere else.
* Bitwise or, `|`: `a | b` returns the number whose binary has a `1` in each position where at least one of `a` and `b` has a 1, and a `0` everywhere else.

In this question you might also find the "bitwise not", `~`, operator useful: `~a` is the number obtained by inverting all the bits in `a`.

**Your task:** Make a Java interface for a bit set as follows:

```
public interface BitSet {

  // Add x to the bit set
  // Throw a runtime exception if x is not in range
  void add(int x);

  // If x belongs to the bit set, remove it
  void remove(int x);

  // Return true iff x belongs to the bit set
  boolean contains(int x);

  // Update the bit set to contain only those values
  // also present in s
  void intersectWith(BitSet s);

  // Return the maximum value that the bit set
  // can represent
  int maxStorableValue();

}
```

Write an implementation of `BitSet`, `BitSet8`,
which uses a `byte` to represent a bit set.  Such a bit set
can store values between 0 and 7 inclusive.

Write another implementation, `BitSet64`, which uses a
`long` as its representation.  This sort of bit set can
store values between 0 and 63 inclusive.

The `intersectWith` methods of your implementations should
behave optimally when the argument is a bit set of the same size as
the bit set on which `intersectWith` is invoked.

Write a demo class that makes two bit sets: a `BitSet8` and
a `BitSet64`.  Are you able to intersect these bit sets with
each other?

**Advanced:** Finally, write an implementation `BitSetArray` of `BitSet`.  This class should be constructed with an integer *x* specifying that the bit set should be capable of representing numbers in the range [0, *x*-1].  An instance of `BitSetArray` should use an array of `long`s to mimic a binary number large enough to represent elements of up to the given size.  This array should be no longer than necessary.  This bit set implementation is quite fiddly to get right!

Extend your demo class to experiment with your `BitSetArray`, to check that it is working.  (Mine did *not* work for quite some time!)

## Solution to [e6fd](../questions/e6fd): *Bit sets*

See code at `solutions/code/tutorialquestions/questione6fd`

The sample code solution is fairly intricate: study it in depth.  I'll describe the `remove` method of the `BitSet8` class in some detail here:

```
@Override
public void remove(int value) {
  if (inRange(value)) {
    representation &= (~((byte) 1 << (byte) value));
  }
}
```

The `@Override` annotation is used to indicate that a method of the `BitSet` interface is being implemented.

The `inRange` method checks whether it is possible for `value` to be in the bit set at all.  If it is not, there is no need to remove `value` as it is guaranteed to not be present.

The expression `(byte) 1 << (byte) value` yields the binary number with zeros everywhere except bit `value`.  Applying the `~` operator to this binary number gives the binary number with ones everywhere except bit `value`.  The `representation` field, which stores the current state of the bit set, is then updated to be the bitwise and of itself and the shifted, negated expression.  This "masks off" bit `value`: if it was not set, it will remain not set; if it was set, it will no longer be set.  This has the effect of removing `value` from the set.

Notice that the `remove` method of `BitSet64` is almost identical.  Unfortunately it is *not* possible to avoid this duplication, because the `representation` fields of these classes have different types.

The `BitSetArray` class uses an array of `long` values to store an arbitrarily large bit set.  Method `index` determines which array element contains the bits relevant to a number `value`.  Once this element has been found, `bitWithinCell` is used to work out the bit of this array element corresponding to `value`.

Have a look at the `intersectWith` methods of all three bit set implementations.  They each do an `instanceof` check to decide whether the incoming bit set has the same type as the receiving bit set.  If this is the case, intersection can be performed very efficiently.  Otherwise, a default intersection algorithm is used.  The default algorithm is duplicated between the implementations.  It would be possible to avoid this duplication using an abstract class.  Try this out as an exercise.

The `Demo` class shows the bit sets in action, and demonstrates that intersection between different sorts of bit sets is possible.