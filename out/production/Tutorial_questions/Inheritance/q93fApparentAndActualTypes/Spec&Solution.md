## e93f: *Apparent and actual types*

Consider the following classes:

```
public class A {

}

public class B extends A {

}

public class C {

  public void accept(A a) {
    System.out.println("Accepted object of type A.");
  }

}

public class D extends C {

  public void accept(B b) {
    System.out.println("Accepted object of type B.");
  }

}
```

Does the `accept` method in `D` override the `accept` method in `C`?  Explain your answer.

What will the following code print?

```
public class Test {

  public static void main(String[] args) {

    B b = new B();

    C c = new D();
    c.accept(b);

    D d = new D();
    d.accept(b);

  }

}
```

**Note:** The point of this question is that you should try to figure this out
*without* simply typing in the program and running it!  (Though you can of course
do this to check your answer.)
## Solution to [e93f](../questions/e93f): *Apparent and actual types*

See code at `solutions/code/tutorialquestions/questione93f`

The `accept` method in `D` does *not* override the `accept` method in `C`.
The reason is that `accept` in `C` has a parameter of type `A`, while `accept`
in `D` has a parameter of type `B`.

As a result, `accept` in `D` *overloads* `accept` in `C`.
  That is, an object of type `D` has two distinct methods called `accept`:

```
public void accept(A a) { ... } // (1) inherited from C

public void accept(B b) { ... } // (2) added in D
```

If we call `accept` on an object reference with apparent type `D`, the Java compiler will choose one of the
above methods: the method with the most *specific* applicable type.  So, for example, if we write:

```
D d = new D();
A a = new A();
d.accept(a);
```

method (1) will be called, whereas if we write:

```
D d = new D();
B b = new B();
d.accept(b);
```

then method (2) will be called, because although `b` has type `A` *and* type `B`, `B` is more specific.

Things get more tricky when references have different actual vs.~apparent types.  For example, in this case:

```
C d = new D();
B b = new B();
d.accept(b);
```

method (1) will be called!  This is because overloading is resolved by the compiler using *apparent* types.
At the call site, `d.accept(b)`, `d` has apparent type `C`, thus the `accept` method
of `C` is selected.  Variable `b` is an acceptable argument for this version of `accept`, since `b` has
type `A` (because it has type `B`, which is a subclass of `A`).

Similarly, in this case:

```
D d = new D();
A b = new B();
d.accept(b);
```

method (1) will also be called!  Here the compiler knows that `d`'s apparent type is `D`, so there are two choices for
`accept`.  The choice is decided based on the *apparent* type of argument `b`, which is `A`.

From this discussion, it should be clear that the `main` method given in the question will print:

```
Accepted an object of type A.
Accepted an object of type B.
```
