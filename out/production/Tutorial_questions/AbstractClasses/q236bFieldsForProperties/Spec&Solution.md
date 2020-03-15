## 236b: *Fields for properties*

Extend the classes you designed in [question 0c21](0c21.md) with data fields that capture the following
information for each property:

* the number of bedrooms
* the number of reception rooms
* the number of bathrooms
* the square footage of the property

You can assume that all of this information will be present for all property types.
You should carefully determine which class/classes should store this information.
Explain why you chose to model this data as you did.

## Solution to [236b](../questions/236b): *Fields for properties*

See code at `solutions/code/tutorialquestions/question236b`

The key point here is that all of these fields are relevant
to all types of property, thus they should belong in the abstract `Property` superclass.
If you used a `Property` interface, rather than an abstract class, then you may need to adapt
your design a bit to allow these fields to be represented at an abstract level.

In the sample solution I have simply redefined `Property`, providing it with the new fields
with `protected` visibility (so that these fields are visible to subclasses of `Property`).
