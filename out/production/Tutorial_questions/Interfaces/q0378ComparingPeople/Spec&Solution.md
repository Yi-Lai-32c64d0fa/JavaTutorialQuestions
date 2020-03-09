## 0378: *Comparing people*

Write a simple class, `Person`, comprised of three fields:
surname, forename and telephone number, all of which should
be strings.  (Why does it make sense to represent telephone
number as a string rather than an integer?)  Write a constructor which
creates a `Person` from these components, and add a getter
method for each field.  Implement `toString` so that a
`Person` can be represented as a string in some appropriate
way.

Now write an interface, `PersonComparator`, declaring a
single method signature, `compareTo`.  This method should
accept two `Person` references as parameters and return an
`int`.

A class implementing `PersonComparator` should implement the
`compareTo` method to realise some notion of ordering
between `Person` objects.

* If `compareTo` returns -1, this indicates that the object referenced by the first parameter is "less than" the object referenced by the second parameter.
* If `compareTo` returns 1, this indicates that the object referenced by the first parameter is "greater than" the object referenced by the second parameter.
* In all other cases, `compareTo` should return 0.

Note that if `compareTo` returns 0, this does not
necessarily mean that the parameters refer to equal objects; all it
means is that the objects are not distinguished by the ordering that
is being implemented.

Write three distinct classes implementing `PersonComparator`:

* `SurnameComparator`: compares `Person` objects based on their surname field, using dictionary order
* `ForenameComparator`: compares `Person` objects based on their forename field, using dictionary order
* `TelephoneNumberComparator`: compares `Person` objects based on their telephone number field, using dictionary order

Make a `Demo` class, and write a `main` method to check that your comparators behave correctly on a selection of `Person` objects.

Add to `Demo` a `findMin` method with the following signature:

```
public static Person findMin(Set<Person> people,
                             PersonComparator comparator);
```

Given a set of `Person` objects, this method should return an element of the set that is regarded as minimal according to the given comparator.  (Note that for any of the above comparators, there could be multiple, non-equal objects that would all be regarded as minimal, because the comparators distinguish between objects using a single field each.)

Test that your implementation of `findMin` works as expected on an example set of `Person` objects.

Your implementation of `findMin` is **polymorphic**.  Do you understand what this means?

**And now the really cool part:** The above comparators
allow us to compare `Person` objects according to surname,
**or** according to forename, **or** according to telephone
number.  We might reasonably want to compare objects using a tiered
scheme, where we first compare according to one field (surname, say),
and if the result is 0 then compare according to another field
(forename, say).  If the result is again 0, we might want to go
further and compare according to the remaining field (in this case,
telephone number).

One approach to this would be to design a number of specialised
`PersonComparator` implementations to cover all the cases we
care about: we could have:

* a `SurnameThenForenameComparator`,
* a `TelephoneNumberThenSurnameComparator`,
* or even a `SurnameThenForenameThenTelephoneNumberComparator`!

This would be
pretty painful.  Let's investigate a more flexible and elegant
approach based on *composition*.

Make a new class, `TwoTieredComparator`, implementing
`PersonComparator.`  This class should have two fields,
`first` and `second`.  Each of these fields should itself have type
`PersonComparator`.  A `TwoTieredComparator`
should be constructed from a pair of objects that implement the
`PersonComparator` interface.

Implement the `compareTo` method of
`TwoTieredComparator` so that the given `Person`
objects are compared using the `first` comparator.  If the
result is non-zero, the result should simply be returned.  Otherwise,
the result of comparing the objects using the `second`
comparator should be returned.

Now extend the `main` method of your `Demo` class
to experiment with the following comparators:

* A comparator that first compares with respect to surname, then with respect to forename
* A comparator that first compares with respect to surname, then with respect to forename, then with respect to telephone number

Note that although the second of these comparators is a
*three*-tiered comparator, it can be realised using your
`TwoTieredComparator` implementation.

What are the advantages of this compositional approach compared with writing separate classes for each kind of multi-tiered comparator?  Does the "separate classes" approach have any advantages over the compositional approach?

## Solution to [0378](../questions/0378): *Comparing people*

See code at `solutions/code/tutorialquestions/question0378`

For the `Person` class, have a look at the model solution code.  Do you understand the significance of `@Override` on the `toString` method?

The `PersonComparator` interface is simple: see the sample code.

The three concrete comparators, `SurnameComparator`, `ForenameComparator` and `TelephoneNumberComparator` are very similar: they simply compare the relevant `String` field.  I did this using the `compareTo` method provided by the `String` class; you might have implemented a dictionary-based comparison directly.  This is fine and educational, but in practical software development it is better to reuse an existing implementation if possible.

For the `findMin` method see the sample solution.  There's not much difficult about this; the key thing is that this method is *polymorphic*: it is a *single* method that works for *any* type of `PersonComparator`.

Inspect the sample code for the `TwoTieredComparator`.  It should make reference only to the `PersonComparator` interface.  The `Demo` code shows how this two-tiered comparator can be used, and how you can nest two-tiered comparators to build a three-tiered comparator.

The advantages of the compositional approach are:

* A smaller number of classes, meaning less code to maintain
* The possibility to combine comparators in arbitrary ways, not being restricted to the ways that were predicted at design time
* The possibility of being able to modify comparators at runtime by re-configuring them (this would be possible if a two-tiered comparator supported resetting the `first` and `second` fields)
* It is possible to write additional comparators and compose them with existing comparators

The disadvantages are:

* It might be that certain combinations of comparators would be undesirable.  With the compositional approach, arbitrary combinations are possible, including any that would be undesirable.  For instance, it would be very unusual in practice to compare people based on their first name, then telephone number, then surname.  With the compositional approach, this arrangement could be created by accident.
* It could be *slightly* more efficient to use a predefined multi-tiered comparator, as the compiler might be able to do a good job of optimising the class, given the complete picture of what the class should do.  Fewer optimisations are possible with the compositional approach.  However, I regard this as a negligible benefit, unless comparing people would be the bottleneck of an application.