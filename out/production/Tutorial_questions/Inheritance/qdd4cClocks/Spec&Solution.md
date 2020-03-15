## dd4c: *Clocks*

Write a class, `Clock`, that records a moment in time during a day, in the granularity of seconds,
together with a mode in which the time should be shown.  The mode should be one of:

* 24-hour format, i.e., *hh:mm:ss*
* number of seconds since midnight, e.g., 03:24:52 is 12292 seconds since midnight

Your class should allow a clock to be constructed either by specifying a single integer, the number of seconds
since midnight (in which case this is the display mode to be used), or three integers, representing the current
hour, minute and seconds (in which case 24-hour format should be used as the display mode).

Your class should provide a method, `tick()`, that advances the time stored by a `Clock` object by one second.  In
addition, you should override `toString()` so that a `Clock` is represented as a string according
to the appropriate display mode.

Write a Java program, say in `ClockDemo.java`, to demo your `Clock` class
by creating a few clocks, then updating their time
once per second.  You can do this by using Java's `Thread.sleep(x)` method, which causes execution
to pause for `x` milliseconds.  This method of timing is not precise, but suffices for
this exercise.  Because `Thread.sleep(x)` can throw an `InterruptedException`, you will need
to specify that your `main` method `throws` this exception.  The output of your program should
look something like this:

```
Clock 1 shows: 0 seconds since midnight.  Clock 2 shows: 23:59:53
Clock 1 shows: 1 seconds since midnight.  Clock 2 shows: 23:59:54
Clock 1 shows: 2 seconds since midnight.  Clock 2 shows: 23:59:55
Clock 1 shows: 3 seconds since midnight.  Clock 2 shows: 23:59:56
Clock 1 shows: 4 seconds since midnight.  Clock 2 shows: 23:59:57
Clock 1 shows: 5 seconds since midnight.  Clock 2 shows: 23:59:58
Clock 1 shows: 6 seconds since midnight.  Clock 2 shows: 23:59:59
Clock 1 shows: 7 seconds since midnight.  Clock 2 shows: 00:00:00
Clock 1 shows: 8 seconds since midnight.  Clock 2 shows: 00:00:01
Clock 1 shows: 9 seconds since midnight.  Clock 2 shows: 00:00:02
...
```

Now design a class, `AlarmClock`, which extends `Clock` by storing a specific time
at which an alarm should sound.  An `AlarmClock` should also include a `boolean` field determining whether the alarm is
currently sounding; this should initially be *false*.  `AlarmClock` should provide appropriate constructors so that
one can create an `AlarmClock` with a specified 24-hour time and alarm, or a "seconds since
midnight" time and alarm.

Override the `tick()` method to behave as for `Clock`, but to additionally control the alarm.
If the alarm time is reached, the alarm should be turned on, and should remain on for 60 seconds.

Also override the `toString()` method to indicate whether the alarm is currently sounding.

Write a program, `AlarmClockDemo.java` to demo your `AlarmClock` class, similarly
to `Clock.java` above.  For a single clock, initialised to 23:59:50 with the alarm set to
go off at 23:59:58, the output of your program should be something like:

```
Clock says: 23:59:50
Clock says: 23:59:51
Clock says: 23:59:52
Clock says: 23:59:53
Clock says: 23:59:54
Clock says: 23:59:55
Clock says: 23:59:56
Clock says: 23:59:57
Clock says: 23:59:58 BEEP!
Clock says: 23:59:59 BEEP!
Clock says: 00:00:00 BEEP!
...
Clock says: 00:00:55 BEEP!
Clock says: 00:00:56 BEEP!
Clock says: 00:00:57 BEEP!
Clock says: 00:00:58
Clock says: 00:00:59
Clock says: 00:01:00
Clock says: 00:01:01
Clock says: 00:01:02
```

Finally, write a class called `RadioAlarmClock` which extends `AlarmClock`.
A `RadioAlarmClock` should have a `station` field, which either has a special
value `None`, or the value of a radio station.  You should choose, or make up, a number
of suitable radio stations.  If the `station` field is `None`, a `RadioAlarmClock`
should behave exactly as an `AlarmClock`.  Otherwise, instead of displaying `BEEP!` when the
alarm is sounding, an appropriate message representative of the given radio station should be shown.

Write an `RadioAlarmClockDemo.java` program to demonstrate this.  For example, given three radio
alarm clocks, each initialised to 23:59:50 with the alarm set to go off at 23:59:58, and tuned to no station,
*Radio 4* and *Five Live*, respectively, your program should display something like:

```
Clocks say: 23:59:50 - 23:59:50 - 23:59:50
Clocks say: 23:59:51 - 23:59:51 - 23:59:51
Clocks say: 23:59:52 - 23:59:52 - 23:59:52
Clocks say: 23:59:53 - 23:59:53 - 23:59:53
Clocks say: 23:59:54 - 23:59:54 - 23:59:54
Clocks say: 23:59:55 - 23:59:55 - 23:59:55
Clocks say: 23:59:56 - 23:59:56 - 23:59:56
Clocks say: 23:59:57 - 23:59:57 - 23:59:57
Clocks say: 23:59:58 BEEP! - 23:59:58 Blah, blah, blah - 23:59:58 ...and it's a GOAL!!
Clocks say: 23:59:59 BEEP! - 23:59:59 Blah, blah, blah - 23:59:59 ...and it's a GOAL!!
Clocks say: 00:00:00 BEEP! - 00:00:00 Blah, blah, blah - 00:00:00 ...and it's a GOAL!!
...
Clocks say: 00:00:01 BEEP! - 00:00:01 Blah, blah, blah - 00:00:01 ...and it's a GOAL!!
Clocks say: 00:00:56 BEEP! - 00:00:56 Blah, blah, blah - 00:00:56 ...and it's a GOAL!!
Clocks say: 00:00:57 BEEP! - 00:00:57 Blah, blah, blah - 00:00:57 ...and it's a GOAL!!
Clocks say: 00:00:58 - 00:00:58 - 00:00:58
Clocks say: 00:00:59 - 00:00:59 - 00:00:59
Clocks say: 00:01:00 - 00:01:00 - 00:01:00
Clocks say: 00:01:01 - 00:01:01 - 00:01:01
Clocks say: 00:01:02 - 00:01:02 - 00:01:02
```

## Solution to [dd4c](../questions/dd4c): *Clocks*

See code at `solutions/code/tutorialquestions/questiondd4c`

Some notes on the sample code solution:

*The Clock class.*
The two display modes are represented by an enum, `DisplayMode`.  They could be represented using
a boolean.  The advantage of an enum is that it allows us to easily add further display modes.

I decided to use "seconds since midnight" as the canonical representation for a `Clock`.
My `Clock` class has a **private** constructor that takes a "seconds since midnight" value
and a `DisplayMode`.  There are two public constructors, as required in the question, which
both delegate to the private constructor:

```
public Clock(int secondsSinceMidnight);
```

simply uses `this(...)` to call the private `Clock` constructor with the given number of seconds since midnight and the
`SecondsSinceMidnight` display mode.

```
public Clock(int hh, int mm, int ss);
```

uses method `twentyFourHourToSecondsSinceMidnight` to convert the given hours, minutes and seconds into
a "seconds since midnight value", and uses `this(...)` to call the private constructor with the
resulting value and the `TwentyFourHour`
display mode.

The helper method `twentyFourHourToSecondsSinceMidnight` is **static**.  This makes sense because the
method computes a straightforward function of its arguments: it does not depend on the state of any `Clock`
object.

I have used some constants, such as `SECONDS_IN_A_MINUTE` and `MINUTES_IN_AN_``HOUR` to make the
code easy to read.  You might argue that I have gone overboard here, but I personally approve of using constants
instead of "magic numbers" wherever
possible, even for very well-known magic numbers.

Take a look at the `toString` method and check you understand it, in particular the way the
`padding` helper method is used to properly format the clock display.

*The AlarmClock class.*  Observe that `AlarmClock` has two public constructors,
corresponding to the public constructors for `Clock`.  Each adds new fields to represent the time
at which the alarm is set to go off.  Each constructor first uses `super(...)` to call the appropriate
constructor of `Clock`, then assigns to the new "alarm" fields.  Notice also that `AlarmClock`
uses a boolean flag to decide whether the alarm is currently sounding; this is initialised to *false*.

Check that you understand the (slightly complex) logic used in `tick()` to determine whether the
alarm is sounding or not.

Look at the use of `super` in `toString`, to avoid duplicating code for displaying a
`Clock` in `AlarmClock`.  Also check you understand the use of the ternary operator in
`toString`:

```
(alarmSounding ? " " + beep() : "")
```

If `alarmSounding` is *true*, this operator returns a space followed by the result of method
`beep()`.  Otherwise, the operator returns the empty string.

*The RadioAlarmClock class.*  I have modelled radio stations using an enumeration, `RadioStation`.  This class (remember, an enum is a class) represents four different radio stations, and includes
a special `None` value to model the case where a `RadioAlarmClock` is not tuned to any station.

The constructors for `RadioAlarmClock` mirror the constructors for `AlarmClock` (which in turn
mirror the public constructors for `Clock`).  Each constructor takes a time of day, an alarm time, and
a `RadioStation`.

Notice that I have *not* overridden `toString()` to change the way a `RadioAlarm``Clock` is
displayed.  The `toString` method in `AlarmClock` calls a method, `beep()`, which
returns the string `BEEP!`.  In `RadioAlarmClock` I have overridden `beep()`.  This means that
when `toString()` is called on an instance of `RadioAlarmClock`, the `toString()` method
in `AlarmClock` will execute.  This method calls `beep()`, but because `RadioAlarmClock`
overrides `beep()` it is this overridden version of `beep()` that will be called.

Now consider the implementation of `beep()` in `RadioAlarmClock`.  If the radio station field
of the radio alarm clock is `None` then `beep()` uses `super` to invoke `beep()`
in `AlarmClock`.  Otherwise the `getNoise()` method is called on the radio alarm clock's `station`
field.  This illustrates the fact that enum classes can have instance methods.  Look at the implementation of `getNoise()`
in `RadioStation`.