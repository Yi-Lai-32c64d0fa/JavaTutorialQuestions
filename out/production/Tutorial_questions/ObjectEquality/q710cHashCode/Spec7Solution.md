## 710c: *The consequences of overriding `equals`*

If all you did in [question 5235](5235.md) was override `equals` then you can run into some interesting problems.
The `Object` class provides another method, `hashCode`, which returns an integer derived from the object on which the method is invoked.
Java requires that `hashCode` should return the same hash code for any two objects `o1` and `o2` such that
`o1.equals(o2)` holds.  It is the programmer's responsibility to enforce this: if you override `equals` then
you must also override `hashCode` such that `o1.equals(o2)` => `o1.hashCode()` `== o2.hashCode()`.

Let us try creating a `Set` of `Point`s.  We write:

```
Set<Point> pointSet = new HashSet<Point>();
```

to make such a set.  This gives us an object conforming to the `Set<Point>` interface (the object's
*apparent* type); the created object is actually a `HashSet` (the object's *actual* type).
A hash set permits efficient lookup by using an object's hash code to assign it to one of a number of *buckets*.
Determining whether an object belongs to the set involves finding the bucket corresponding to the object, and then
looking through the bucket.  For the above to work, you must import `java.util.HashSet` and `java.util.Set`.

Demonstrate the problems that can ensue from this scenario by writing a Java program that creates two identical points `p`
and `q`, and adds `p` to `pointSet`.  Get your program to print a message confirming whether `p.equals(q)`
holds (it should), and whether `pointSet.contains(q)` holds.  The latter should *intuitively* be true, but if you have not overridden
`hashCode`, it will not.

Now override `hashCode` in a manner that ensures that two equal points get the same hash code.  A high quality hash function should also try
to make sure that non-equal points get different hash codes whenever possible.  Writing a high quality hash code is challenging and interesting -- feel
free to experiment with this (there are a lot of good tutorials online on this topic) but any technically correct hash coding scheme is fine for this
exercise.  By *technically correct*, I mean an implementation of `hashCode` that satisfies:

```
o1.equals(o2) => o1.hashCode() == o2.hashCode()
```

However you decide to implement `hashCode`, confirm that it solves the problem you identified above: `pointSet.contains(q)` should
become *true*.

Now consider the `ColouredPoint` class.  Is it necessary to override `hashCode` in this class, given that
you have overridden `equals`?  If not, is there any benefit to doing so?
## Solution to [710c](../questions/710c): *The consequences of overriding `equals`*

See code at `solutions/code/tutorialquestions/question710c`

Look at `nohashcode/PointHash``CodeDemo.java` to see what can go wrong if you override `equals`
but do not override `hashCode`.

To see an acceptable implementation of `hashCode` for `Point`, look at `hashcode/Point.java`.
In this implementation, I use each `double` field of `Point` to make a `Double` object,
and call `hashCode` on the resulting objects.  The `Point`'s hash code is then constructed by combining
these hash codes using the bitwise exclusive-or operator (`^`).  There are many other acceptable ways to implement
`hashCode`, in terms of meeting the requirements of `equals`.  You could simply return a constant (stupid,
but acceptable in this context), or you could add up the `double` fields and return the result, cast to an `int`.

You do *not* need to override `hashCode` in `ColouredPoint` for the requirements of `equals` to be
met: if two coloured points are equal then certainly they are equal when regarded as points, and thus `Point` will give them
the same hash code.

However, in practice, it is beneficial to use the additional *colour* field of a `ColouredPoint` to make `ColouredPoint`s'
hash codes more diverse.  You will see in `hashcode/ColouredPoint.java` that I've overidden `hashCode` to return the existing
`Point` hash code, xor-ed with the hash code of the `colour` field (which in my implementation is an enum).
