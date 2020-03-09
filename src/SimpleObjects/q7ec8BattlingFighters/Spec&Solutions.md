
## 7ec8: *Battling fighters*

In this question you will simulate a battle between fighters
using rules based on the [Fighting Fantasy](https://en.wikipedia.org/wiki/Fighting_Fantasy) adventure game books.

A **fighter** has a *name* (e.g. "Joe"), a *type* (e.g. "Elf Lord"), and
two further attributes: *skill*, an integer initialised to a value between 1 and 18 that remains fixed, and *stamina*, an integer
initialised to a value between 1 and 24.

A battle between two fighters consists of a series of rounds.  In a round, each fighter computes an *attack score*.  This
is obtained by rolling two dice, and adding the result to the fighter's skill.  If both fighters compute the same attack
score, the round results in a draw.  Otherwise the fighter with the higher attack score hits the fighter with the lower
attack score, whose stamina is reduced by two (or set to zero if it is currently set to one).  The battle ends when
one of the fighters' stamina becomes zero.

Your task is to design two classes: `Fighter` and `GameEngine`.

The
`Fighter` class should contain fields to represent the attributes of a fighter, an appropriate constructor, as well as (at least)
the following
methods:

```
// Reduce the fighter's stamina accordingly
public void takeDamage(int damage);

// Return the number of damage points to be inflicted on opponent
public int calculateDamage();

// Calculate an attack score for the fighter using the procedure described above
public int calculateAttackScore();

// Determine whether fighter is still alive
public boolean isDead();
```

With the exception of `calculateAttackScore`, these methods should be
trivial to implement.

The `GameEngine` should contain (at least) the following method:

```
// Simulate battle between two fighters, displaying how the battle
// progresses and who wins
public void simulateBattle(Fighter first, Fighter second) {
```

Finally, you should provide a `Main` class with a `main` method
that creates two fighters and a game engine, and launches the simulated battle.

The output of your program should look something like this:

```
At start of battle, stats are:
Joe - Human Warrior - skill: 16; stamina: 12
Alex - Elf Lord - skill: 18; stamina: 6
------------------------------
Alex hits Joe, stats are:
Joe - Human Warrior - skill: 16; stamina: 10
Alex - Elf Lord - skill: 18; stamina: 6
------------------------------
Joe hits Alex, stats are:
Joe - Human Warrior - skill: 16; stamina: 10
Alex - Elf Lord - skill: 18; stamina: 4
------------------------------
Alex hits Joe, stats are:
Joe - Human Warrior - skill: 16; stamina: 8
Alex - Elf Lord - skill: 18; stamina: 4
------------------------------
Alex hits Joe, stats are:
Joe - Human Warrior - skill: 16; stamina: 6
Alex - Elf Lord - skill: 18; stamina: 4
------------------------------
Joe draws with Alex
------------------------------
Alex hits Joe, stats are:
Joe - Human Warrior - skill: 16; stamina: 4
Alex - Elf Lord - skill: 18; stamina: 4
------------------------------
Alex hits Joe, stats are:
Joe - Human Warrior - skill: 16; stamina: 2
Alex - Elf Lord - skill: 18; stamina: 4
------------------------------
Alex hits Joe, stats are:
Joe - Human Warrior - skill: 16; stamina: 0
Alex - Elf Lord - skill: 18; stamina: 4
------------------------------
End of battle, Alex - Elf Lord - skill: 18; stamina: 4 wins!
```

## Solution to [7ec8](../questions/7ec8): *Battling fighters*

See code at `solutions/code/tutorialquestions/question7ec8`

There are many ways you could model this question.
Take a look at my solution, check you understand it, and compare it with yours.

In my solution, I decided that dice rolling is the responsibility of the game engine,
not of a fighter, so I equipped `GameEngine` with a field `generator` of type `Random`,
used to generate random numbers.  In addition, I made an instance method, `rollDice()`, which uses
`generator` to generate a random integer between 1 and 6.
By making `generator` private, I ensure that clients of `GameEngine` *must*
use the `rollDice()` method to simulate dice rolls: they cannot access the random number
generator directly.  This means that I could use a different scheme for simulating dice rolling.
I could also easily modify `GameEngine` to log the number of times a dice has been rolled.
If `generator` was public, clients could bypass such a logging mechanism.

In the question, you were asked to reduce a fighter's stamina by 2 when a hit occurs.  In my
solution I have documented this by defining a constant, `DAMAGE_VALUE`, inside
`caclulateDamage`.  The constant is set to 2, and `calculateDamage` simply
returns `DAMAGE_VALUE`.  This is slightly preferable to simply returning the magic
number 2, because the named constant adds additional documentation stating the purpose of this
value.

Because `Fighter` needs to roll dice (e.g. in `calculateAttackScore`),
in my solution every `Fighter` has a reference to a `GameEngine` object.
In my solution, `Fighter` objects use a `log` method of `GameWorld`
to log the progress of their battle.  Currently, `log` is implemented by delegating
to `System.out.println`.  To have the progress of a battle displayed in some other manner,
(e.g., on a web page) all I would need to do would be re-implement `log` in `GameWorld`.

While we will have multiple instances of `Fighter`, we might wish there to be a
*single* `GameEngine` object.  This could be achieved using the *singleton*
pattern, as described in the lectures.  Can you extend your or my solution to use the singleton
pattern, ensuring that it is not possible to create multiple game worlds?