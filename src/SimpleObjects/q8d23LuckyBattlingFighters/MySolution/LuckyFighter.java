package SimpleObjects.q8d23LuckyBattlingFighters.MySolution;

import SimpleObjects.q7ec8BattlingFighters.MySolution.Fighter;

public class LuckyFighter extends Fighter {

  private final int luck;
  private final Attribute strategy;

  public LuckyFighter(String name, String type, int luck, Attribute strategy) {
    super(name, type);
    this.luck = luck;
    this.strategy = strategy;
  }

  public void testLuck(){
    int diceValue = super.rollDice() + super.rollDice();
  }




  public enum Attribute{
    // aggressive -> try use luck to inflict more damage
    AGGRESSIVE,
    // defensive -> try use luck to resist damage
    DEFENSIVE,
    // use in both cases when odds of being lucky is high
    AVERAGE,

  }

}
