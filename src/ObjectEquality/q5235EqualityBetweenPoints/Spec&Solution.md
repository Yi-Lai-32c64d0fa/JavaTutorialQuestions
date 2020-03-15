## 5235: *Equality between points*

Recall class `Point` from [question 0f05](0f05.md).  If you construct two `Point` objects
with identical coordinates, should they be regarded as *equal*?  This depends on the context in which
you use `Point`, but very likely the answer is *yes*: instances of `Point`
are immutable *value* objects, so that if two `Point`s look identical, they should be regarded
as the same.  (Remember that we call such objects *value* objects because they have some of the
attractive properties of primitive values: in particular, aliasing of value objects is not problematic.  However,
value objects *are still objects*, and comparing two identical value objects with `==` may return
*false*.)

As you know from the lectures, if we construct two identical `Point` objects and compare them
with the `==` operator, the operator will yield *false*, because the points being compared
are not the same object.

What happens if you construct two points, `p` and `q` with identical coordinates, and compare them by testing
whether `p.equals(q)` holds?  Try it.  You should find that the result is also *false*.  Why is this?

Implement `Point` equality testing by overriding the `equals` method from `Object`.  Remember the
recipe for constructing a basic `equals` method:

* Check that the incoming object has the right type, using `instanceof`
* If it does, cast the incoming object to this type
* Compare fields

Test that your implementation works by confirming that a selection of identical points are regarded as being equal,
and that points with differing coordinates are not.

Now create two instances of `ColouredPoint` that have identical coordinates, but *different* colours.
Does your implementation of `equals` regard these objects as being equal, and why does it behave in
this way?  If the `ColouredPoint` objects are regarded as being equal then you should fix this by overriding
`equals` appropriately in `ColouredPoint`.

Finally, consider comparing a (non-coloured) `Point` with a `ColouredPoint.`  Construct a
`Point` `p` and a `ColouredPoint` `cp` such that `p.equals(cp)`
holds, but `cp.equals(p)` *does not* hold.  In other words, demonstrate that the `equals` relation you
have defined is not *symmetric* in the presence of subclasses.  We will return to this issue in [question aa68](aa68.md).

## Solution to [5235](../questions/5235): *Equality between points*

See code at `solutions/code/tutorialquestions/question5235`

With a plain old `Point` class, before overriding `equals`, you should find that
comparing identical points represented by distinct objects with `equals` yields false.
`DemoWithoutEquals.java` gives an example of this.

Implementing `equals` for points is straightforward using the recipe given in the lectures.
See `pointequality/Point.java` for the implementation.

The main method in `pointequality/PointEqualityDemo.java` shows that having overridden
`equals` for `Point`, we now have a problem with `ColouredPoint`.  Declaring:

```
ColouredPoint cp = new ColouredPoint(1.2, 2.3, 3.4, Colour.Red);
ColouredPoint cq = new ColouredPoint(1.2, 2.3, 3.4, Colour.Blue);
```

we find that `cp.equals(cq)` holds, even though these points have different colours.

To fix this, you were asked to override `equals` in `ColouredPoint`.  Look at
`colouredpointequality/ColouredPoint.java` to see how this can be done.  Most interesting
is the last line of the `equals` method:

```
return super.equals(thatPoint) && colour == thatPoint.colour;
```

Notice that `super` is used to check first whether the coloured points are equal when
regarded as plain old points.  Additionally, for them to be regarded as equal as coloured points,
their colours must match.

Finally, the asymmetry of `equals` is illustrated in `colouredpointequality/PointEqualityDemo.java`:
the last thing `main` prints is:

```
Points p = (1.2, 2.3, 3.4) and cp = ((1.2, 2.3, 3.4), Red) are equal
Points cp = ((1.2, 2.3, 3.4), Red) and p = (1.2, 2.3, 3.4) are not equal
```