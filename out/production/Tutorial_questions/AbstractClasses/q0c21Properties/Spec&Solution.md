## 0c21: *Properties*

Suppose you have been contracted to build a property catalougue application
for an estate agent.  The application should manage the following types of properties:

* houses, which are either detached, semidetached or terraced
* bungalows, which are one storey houses and are also either detached, semidetached or terraced
* flats
* maisonettes, which are flats that take up more than one floor of a house

Write a set of skeleton Java classes and/or interfaces to model the entities in this
application domain.  The idea is to create appropriate classes and interfaces, and define the
relationship between them.  You do *not* need to add any methods to these classes/interfaces,
and you do not need to add any fields *unless* you believe the relationship between the
classes should be captured through composition.

**Hint:** at the top of your inheritance hierarchy there should be a class, `Property`,
from which all properties are descended.

Explain the choices behind your design.

Next, write a `PropertyCollection` class.  An instance of `PropertyCollection` should
hold a set of properties.  `PropertyCollection` should support these methods (at least; you can add
corresponding methods for other property types if you wish):

```
// Add a property to the collection
public void addProperty(Property p);

// Return the set of all houses in the collection
public Set<House> getHouses();

// Return the set of all bungalows in the collection
public Set<Bungalow> getBungalows();

// Return the set of all flats in the collection
public Set<Flat> getFlats();

// Return the set of all maisonettes in the collection
public Set<Maisonette> getMaisonettes();

// Return the set of all terraced houses in the collection
public Set<TeracedHouse> getTerracedHouses();
```

There are two ways you can implement these methods.  One way is to use `instanceof`
to test the type of each property.  The other way is to add (possibly abstract) methods `isHouse()`, `isBungalow()`,
`isFlat()`, etc., to `Property` and then override these methods in the various property subclasses
to return appropriate boolean values.  Explain the pros and cons of each approach, decide which to use, and write a justification
of your choice.

Finally, write a `PropertyDemo` class with a `main` method.
The `main` method should create a property collection, and add to it
the following:

* 1000 semi-detached houses
* 1000 terraced houses
* 100 detached houses
* 100 semi-detached bungalows
* 100 flats
* 20 maisonettes
* 20 detached bungalows
* 20 terraced bungalows

where the houses and flats are not bungalows or maisonettes, respectively.

After this, the `main` method should use the methods you have
implemented in `PropertyCollection` to check (using assertions) that the collection
contains:

* 2240 houses
* 140 bungalows
* 120 flats
* 20 maisonettes
* 1020 terraced houses

where bungalows and maisonettes are regarded as being houses and flats,
respectively.

## Solution to [0c21](../questions/0c21): *Properties*

See code at `solutions/code/tutorialquestions/question0c21`

The point of this question was to demonstrate that thinking about inheritance hierarchies, and specifically
how to map them to a single-inheritance language like Java, can be challenging.  There are multiple feasible
solutions to this question.

First, let us consider in some sense the "ideal" class diagram for the desired inheritance hierarchy:

![Original class diagram](../diagrams/0c21_original.png "Inheritance hierarchy for Properties, assuming we can use multiple inheritance.  Abstract classes are indicated by italics.")

The hierarchy captures the "is-a" relationships described in
the question.  `Property`, `House` and `Bungalow` are abstract, because
the question indicated that all houses and bungalows should be one one of *detached*, *semi-detached*
or *terraced*.  Note that `Flat` is *not* abstract: the question indicated that a maisonette
is a special kind of flat, but this implied that regular flats should exist.

Multiple inheritance creeps in because `DetachedBungalow` inherits from both `DetachedHouse`
and `Bungalow`.

Because we cannot have multiple inheritance in Java, we need to find a way to simulate this using interfaces.
In my mind there are two reasonable ways to do this:

* Make `Bungalow` an interface, which the bungalow properties implement, as well as extending their respective
`House` subclasses.  This is what the sample solution does; the class diagram is shown below and the Java
classes are available in the `instanceofsolution` package (the name of this package reflects a later part of the solution; see below).

* Make interfaces `Detached`, `SemiDetached` and `Terraced`.  Keep `Bungalow` as an abstract
class that extends `House`.  Then have `DetachedHouse` extend `House` and implement `Detached`,
and have `DetachedBungalow` extend `Bungalow` and implement `Detached` (the setup for the semi-detached
and terraced property types is analogous).  You might benefit from drawing a class diagram for this arrangement.

![Solution class diagram](../diagrams/0c21_solution.png "Inheritance hierarchy for Properties that would be realisable in Java.  Note that an interface has been used to simulate multiple inheritance.")

In the sample solution I have implemented `PropertyCollection` methods in two ways: using `instnaceof`
to test the actual types of properties (see package `instanceofsolution`) and by adding methods
`isHouse()`, `isBungalow()`,
`isFlat()`, etc., to `Property` and using these methods to test the type of a property.

The `instanceof` approach has the advantage that it does not pollute the `Property` class
hierarchy with lots of extra methods.  It seems a shame for an arbitrary property to have to provide
a method saying whether or not it is a maisonette!  On the other hand, the method-based approach is more flexible, and provides
better encapsulation.
Suppose we wished to change our inheritance hierarchy a bit, by adding or removing some classes, or by changing their names.
This would cause client code that queries object types using `instanceof` to break, while calls to the `isHouse()`, etc.,
method would still work (because these methods are defined at the abstract level of `Property`).
