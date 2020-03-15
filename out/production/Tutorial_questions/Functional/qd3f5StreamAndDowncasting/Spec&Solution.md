## d3f5: *Streams and downcasting*

In an `Example` class, write a method `restrictToPositiveIntegers` with the following signature:

      static Stream<Integer> restrictToPositiveIntegers(Stream<Number> numbers);
      
Given a stream of `Number`s, the method should return the substream of this stream comprised of only those numbers of type `Integer` whose integer value is positive.

The body of `restrictToPositiveIntegers` should be a single statement, and it should *not* convert the input stream to a list or any other collection.

Write a `main` method showing that if you create a `List<Number>` called `numbers` populated with various `Integer`, `Float`, `Double` and `Short` values, and then do:

        System.out.println("Positive integers from " + numbers + " are: "
            + restrictToPositiveIntegers(numbers.stream()).collect(Collectors.toList()));

you see precisely the positive integers from your list of numbers being output.

Try creating a `List<Float>` or `List<Integer>` and invoking `restrictToPositiveIntegers` on a stream derived from each of these lists.  You should find that this does not compile.

**Advanced:** Write a method, `restrictToPositiveIntegersBoundedWildcard`, that can take a stream of any type `T` that is `Number` or one of `Number`'s subclasses and return the substream containing only those positive integers from the original stream.

**Hints**

* You will need to use instance testing and downcasting in the implementation of `restrictToPositiveIntegers`.
* For `restrictToPositiveIntegersBoundedWildcard`, the clue is in the name!

## Solution to [d3f5](../questions/d3f5): *Streams and downcasting*

See code at `solutions/code/tutorialquestions/questiond3f5`

Observe the use of `filter` to first filter the stream to get just those elements of type `Integer`, and then `map` to actually get a `Stream<Integer>` instead of a `Stream<Number>`.  The reason we need to use `map` after `filter`, even though `map` is a no-op, is that `filter` takes a `Stream<T>` and returns a `Stream<T>`, so given a `Stream<Number>` it returns a `Stream<Number>`.  If we removed the `map` step, the second `filter`, where we filter those elements whose values are not positive, would not compile since we cannot ask "`n > 0`" when `n` is an arbitrary `Number`.

We are not allowed to invoke `restrictToPositiveIntegers` on a `Stream<Float>` or a `Stream<Integer>` because in Java, if `B` is a subtype of `A` (e.g. `B` is `Float` and `A` is `Number`), it does not follow that `C<B>` is a subtype of `C<A>` -- in particular it does not follow that `Stream<B>` is a subtype of `Stream<A>`, so `Stream<Float>` is not a subtype of `Stream<Integer>`.

The method `restrictToPositiveIntegersBoundedWildcard` has this signature:

      static Stream<Integer> restrictToPositiveIntegersBoundedWildcard(Stream<? extends Number> numbers);

The use of a *bounded wildcard* in the signature of `restrictToPositiveIntegersBoundedWildcard` solves the problem: `Stream<? extends Number>` is compatible with `Stream<Float>` and `Stream<Integer>` because `Float` extends `Number` and `Integer` extends `Number`.

Have a look at the `main` method in the solution and check that your solution exhibits similar behaviour.