## dc38: *Email management system*

Imagine you are designing an email management system that needs to manage email addresses.  There are two types of email address: an *individual* address, which identifies a single email inbox, and a *group* address which acts as a container for other addresses.  A group can be a member of other groups; furthermore, a (group or single) address can be a member of several groups.

Write a set of Java classes that models individual and group email addresses.  Your classes should fulfil the following requirements:

* Every email address (individual or group) should have an associated string identifier
* Two email addresses should be regarded as equal if they have the same identifier.  Don't forget that if you override `equals()`, you must also override `hashCode()`
* On construction, a group email address should initially have no members
* It should be possible to add an email address to a group email address
* All email addresses should support a method, `getTargets()`.  When invoked on email address `a`, this method should return the set of individual addresses to which an email addressed to `a` must be sent

First, assume that all group memberships are acyclic; that is, no group can contain itself (directly or indirectly) as a member.

Once you have a working solution for the acyclic scenario, write an extended version that will work even in the presence of cycles.

You should also write a demonstration program to show your classes in action.

## Solution to [dc38](../questions/dc38): *Email management system*

See code at `solutions/code/tutorialquestions/questiondc38`

The solution assuming that group relationships are acyclic is given in the `acyclic` package.  I have used an abstract class, `EmailAddress`,
to hold an email address's identifier (common to individual and group addresses), and to implement `toString()` and `equals()`, which are purely
based on this identifier.  Because I have overridden `equals()` I have dutifully overridden `hashCode()` too.

I have declared `getTargets()` abstract in `EmailAddress`:

```
public abstract Set<EmailAddress> getTargets();
```

Then I have made two subclasses, `IndividualEmailAddress` and `GroupEmail``Address`.  `IndividualEmailAddress` simply overrides `getTargets()` by returning a set
containing the individual email address. `GroupEmailAddress` keeps a set of email addresses, `members` to store members of the group.  The `getTargets()` method is overridden
by recursively calling `getTargets()` on each member, and constructing a set that is the union of all these results.  (Note that the group email address is not itself added to the result of `getTargets()`;
this method was required to include only individual email addresses.)

Think about the interplay between recursion and polymorphism in the implementation of `getTargets()` in `GroupEmailAddress`.

Package `cyclic` shows how I have adapted the implementation of `getTargets()` to handle cyclic relationships.  I have done this by implementing `getTargets()` in
the *abstract* class `EmailAddress`, and making this implementation `final` so that I do not accidentally override it elsewhere.  This `getTargets()` method calls
a helper method:

```
protected abstract Set<EmailAddress> getTargets(Set<EmailAddress> alreadySeen);
```

whose purpose is to find all targets recursively, but to stop recursing when an email address in the set `alreadySeen` is encountered.  This method
is abstract because it needs to be implemented differently in `IndividualEmailAddress` and `GroupEmailAddress`.  It is protected so that
it cannot be accessed by classes outside the `EmailAddress` inheritance hierarchy.
Unfortunately this is not true: because protected visibility is
more visible than package visibility this method can be seen by any classes in the `cyclic` package.  But it is the best we can do in Java!

The implementation of `getTargets(alreadySeen)` in `cyclic.IndividualEmail``Address` is identical to that for `getTargets()` in
`acyclic.IndividualEmailAddress`.

The implementation of `getTargets(alreadySeen)` in `cyclic.GroupEmailAddress` is similar to that for `getTargets()` in `acyclic.GroupEmailAddress`
except that it adds the following lines at the start:

```
if(alreadySeen.contains(this)) {
  return result;
}

alreadySeen.add(this);
```

These lines ensure that we do not get into an infinite recursive loop when the relationship between email groups is cyclic.
