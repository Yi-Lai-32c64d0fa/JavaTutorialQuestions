## 937d: *Flawed rectangle*

The class below models a rectangle shape, which has a particular area.
For the purposes of this question, the inheritance hierarchy that `Rectangle`
is part of is not important.  Can you detect a design flaw in the class?
Explain what the problem is, and present a better version of the class that fixes
the problem.

* [Rectangle.java](../q937dFlawedRectangle/Example/Rectangle.java)

**Hint:** this class should enforce an important invariant that you should
identify.  How does the fact that `width`, `height` and
`area` can all be modified allow this invariant to be broken?

## Solution to [937d](../questions/937d): *Flawed rectangle*

See code at `solutions/code/tutorialquestions/question937d`

The `Rectangle` class should enforce an invariant that the value of
`area` must be equal to `width*height`.  The methods `setWidth`,
`setHeight` and `setArea` allow this invariant to be broken:
clients. (A *client* of a class `A` is a class `B` that uses methods or fields provided by `A`.)  Note that it is possible for `A` to be
 a client of `B` *and* `B` a client of `A`} can arbitrarily change `width`, `height` and `area` using
these methods.  The clients of `Rectangle` should not have to worry about its invariants; therefore the
clients are likely to change the value of `width` or `height` without updating the value of `area`.  This will
invalidate the invariant of `Rectangle` and is likely to cause bugs.

The easiest solution is to simply get rid of the `area` field from `Rectangle`, and to
make `getArea` freshly compute a rectangle's area each time it is invoked.  This
is clearly robust to changes in `width` and `height`.
This solution is presented in
the `afterfixingandrefactoring` sub-package.  The disadvantage of this approach is that it leads to redundant
computation if we ask for the area of a rectangle many times *without* changing its fields in-between.  For
such a simple method call this almost certainly does not matter, but this may be a concern if this design issue
arises in a more complex scenario, where the equivalent of `area` is a more expensive operation.
The solution also requires removing the `setArea`
method, but arguably this method made little sense: given a new area, how should a corresponding width and height be
chosen in a meaningful way?

Another possibility is to ensure that the fields cannot be changed, by making `Rectangle` *immutable*
as discussed in the lectures and demonstrated in the `fixedrectangle2` sub-package.  Clearly this solution is
not applicable if the fields *must* be changed during a rectangle's lifetime.