
## 0f05: *Coloured points*

Write a class, `Point`, representing a point in 3-dimensional Euclidean space.  You should ensure that objects of type
`Point` are *immutable*.  That is, once a `Point` has been created, its fields cannot be modified further.

Your class should provide the following:

* a method that takes a `Point` parameter and returns the Euclidean distance between
this parameter and the `Point` on which the method is called

* a method that returns a `Point` representing the origin

* a method that returns the *magnitude* of a `Point` -- that is, its distance from the origin

In addition, you should override the `toString()` method provided by `Object` to provide
an appropriate string representation of a `Point`.

Write some tests to make sure your class is working as expected.

Now write a new class, `ColouredPoint`, that extends `Point` to provide an additional
*colour* field.  It is up to you whether you represent colour using an enumeration of several permissible
colours, using integer values for *red*, *green* and *blue*, or some other way.  You should override `toString()` to represent
a `ColouredPoint` as a string by showing its coordinates followed by a string representation of its colour value.  You should *not* repeat the
code used to represent a point's coordinates as a string: this string representation should be achieved via
the `toString()` method in `Point`.

## Solution to [0f05](../questions/0f05): *Coloured points*

See code at `solutions/code/tutorialquestions/question0f05`

Inspect the sample solution carefully and check you understand it.  Note that in the
constructor of `ColouredPoint`, `super(coordX, coordY, coordZ)` is used to invoke
the constructor of `Point`, after which `this.colour = colour`
assigns to the additional `colour` field.  This pattern of building subclass
constructors is standard.

Look at the `toString` method in `ColouredPoint`.  Observe that
`@Override` has been used to indicate that this should override a superclass
method.  If we accidentally mis-spelled `toString`, thus *not* overriding
the parent method, the use of `@Override` would generate a useful compiler error.
Look at the way `super.toString()` is used in the body of `toString()`.