## c2b8: *Irresponsible rectangle*

Inspect the Java classes listed below, and identify any design flaws you can
see.
Rewrite the classes in a way that does not change their behaviour,
such that these design flaws are fixed.  The process of improving the
design of software without changing its behaviour is called *refactoring*.

In the following code it is assumed that rectangles are oriented such that the
coordinate (0,0) is at the top-left of some drawing area, the *x*-axis extends to the right,
and the *y*-axis extends downward.  This is common in computer software, even though it is
contrary to the usual mathematical setting where the *y*-axis extends upwards.

Note that `DrawingEngine.java` is indicative of a class that could
represent the state of a drawing program.  Obviously this class is incomplete:
currently it simply stores a set of rectangles.  This incompleteness is *not*
one of the design flaws this question aims to illustrate!

* [Point.java](../qc2b8IrresponsibleRectangle/Examples/Point.java)
* [Rectangle.java](../qc2b8IrresponsibleRectangle/Examples/Rectangle.java)
* [DrawingEngine.java](../qc2b8IrresponsibleRectangle/Examples/DrawingEngine.java)
* [DrawingEngineDemo.java](../qc2b8IrresponsibleRectangle/Examples/DrawingEngineDemo.java)

## Solution to [c2b8](../questions/c2b8): *Irresponsible rectangle*

See code at `solutions/code/tutorialquestions/questionc2b8`

There is a clue in the title of this
question.  The problem with the design of these classes is that class `Rectangle`
should be responsible for operations on rectangles, including calculating a rectangle's
area, checking containment between rectangles, and retrieving the bottom-right coordinates
of a rectangle.  However, in the given classes, methods implementing these services form
part of the `DrawingEngine` class.  The `Rectangle` class is *irresponsible*
because it lets anther class implement its functionality.

Notice that in `DrawingEngine`'s implementation of, e.g., `area`, no reference
is made to any fields of `DrawingEngine`.  This is a little suspicious: a method *usually*
queries or updates data fields of the object on which is invoked.  This "bad smell" is known as
*feature envy*: where a method seems more interested in a class other than the one it belongs
to.  We can say here that `DrawingEngine` *envies* `Rectangle`: it has
stolen some of its features.

In the sample solution, you will see that the rectangle-centric methods of `DrawingEngine` have all
been moved into the `Rectangle` class.  The clumsily named `rectangleToString`
method of `DrawingEngine` has been removed, and instead the `toString` method
has been implemented in `Rectangle`, with the same behaviour.  Notice that `maxArea`
stays where it is: this method computes the maximum area among all the rectangles stored in a
`DrawingEngine`, so `DrawingEngine` is the right place for this method.  Notice further,
however, that the implementation of `maxArea` has changed, so that it calls the `area`
method of `Rectangle`, rather than the old `area` method of `DrawingEngine`.

Why is it a bad idea for `DrawingEngine` to provide methods that should belong to `Rectangle`?
Because we may very well wish to make use of rectangles in other contexts.  For instance, a `Page`
class might use a `Rectangle` to represent its drawing region.  Suppose an instance method of
`Page` requires the area of the page's drawing region.  If the `area` method belongs to `DrawingEngine`,
then `Page` will need to get a reference to a `DrawingEngine` object and invoke `area` on
this object, passing the drawing region rectangle of interest.  This means that `Page` is dependent on
`DrawingEngine`, even though there may be no intuitive relationship between these classes.  This bad
design can lead to an ugly application that is hard to understand and maintain.