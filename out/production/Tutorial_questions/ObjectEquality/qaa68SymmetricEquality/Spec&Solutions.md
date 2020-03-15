## aa68: *Symmetric equality testing*

Recall from the end of [question 5235](5235.md) that you have implemented `equals` in a manner that
is *asymmetric* in the presence of subclasses: you constructed a `Point` `p`
and a `ColouredPoint` `cp` such that `p.equals(cp)` holds, but `cp.equals(p)`
does not.

Think for a while about how to make `equals` work symmetrically in the
presence of subclasses.  If you manage to find an elegant working solution you should feel very happy, as this
confounded Object Oriented Programming practitioners for some time!  If you get stuck, then look at this excellent
article on writing equality methods in Java:

* [How to Write an Equality Method in Java](https://www.artima.com/lejava/articles/equality.html)

The tutorial describes the "can equal" approach to defining `equals` in the presence of subclasses.
This is the approach taken by the Scala programming language.  There is a Java school of thought that believes that
one should not override `equals` for classes that may have subclasses.  According to this school of thought,
what are the only kinds of classes for which `equals` should be overridden?

## Solution to [aa68](../questions/aa68): *Symmetric equality testing*

See code at `solutions/code/tutorialquestions/questionaa68`

[This online tutorial](https://www.artima.com/lejava/articles/equality.html) illustrates a very clever trick.  We equip `Point`
with a method, `canEqual`, which tells us the conditions an object must satisfy for it to even be *considered*
as being `equal` to a `Point`.  In the case of a `Point`, the condition is that the given object
should be an instance of `Point`.  Thus we implement `canEqual` as follows:

```
public boolean canEqual(Object that) {
  return that instanceof Point;
}
```

Now in the `equals` method of `Point`, we test whether the incoming object is an instance of `Point` as before
(except that to avoid duplication, we do this by calling `canEqual`).  Then we cast the incoming object to a `Point`, and
ask whether it *can equal* the `Point` on which `equals` is being invoked.  If this test succeeds, we conclude by comparing
fields as before.

Checking `canEqual` in both directions is what allows us to restore the *symmetric* property that we require `equals`
to satisfy.  In `ColouredPoint` we *override* `canEqual`, strengthening the criterion to being an instance of
`ColouredPoint`, not just of `Point`:

```
@Override
public boolean canEqual(Object that) {
  return that instanceof ColouredPoint;
}
```

Note that it is *usually* bad practice to override a method and make no reference to `super`.  This is an exception (though note that if the overridden version of `canEqual` returns *true*, the superclass version would be guaranteed to do the same).

The implementation of `equals` in `ColouredPoint` is now adapted analogously to how `equals` was adapted for `Point`: we check that the `ColouredPoint` on which `equals` is being invoked `canEqual` the incoming object.  We then cast the incoming object to a `ColouredPoint`, and test whether this `ColouredPoint` `canEqual` the `ColouredPoint` on which `equals` is being invoked.  Finally, we test superclass equality, and compare on the `colour` fields, as before.

The crucial missing property that `canEqual` has added is that if we compare a plain old `Point` with a `ColouredPoint` we are *guaranteed* to get the result `false`.  Thus the asymmetry identified in [question 5235](../questions/5235.md) cannot occur.
