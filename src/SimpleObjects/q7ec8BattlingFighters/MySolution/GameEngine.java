package SimpleObjects.q7ec8BattlingFighters.MySolution;

public class GameEngine {

  public GameEngine(){}
  // Simulate battle between two fighters, displaying how the battle
// progresses and who wins
  public void simulateBattle(Fighter first, Fighter second) {
    String firstName = first.getName();
    String secondName = second.getName();
    //Start of the game
    log("At start of battle, stats are:");
    log(first.toString());
    log(second.toString());
    log("------------------------------");

    // game progress
    while (!first.isDead() && !second.isDead()) {
      int firstAttackScore = first.calculateAttackScore();
      int secondAttackScore = second.calculateAttackScore();
      int damage = Math.abs(firstAttackScore - secondAttackScore);

      switch (GameEngine.compareTo(firstAttackScore, secondAttackScore)) {
        case 1:
          log(firstName + " hits " + secondName + ", stats are:");
          second.takeDamage();
          log(first.toString());
          log(second.toString());
          break;
        case 0:
          log(firstName + " draws with " + secondName);
          break;
        case -1:
          log(secondName + " hits " + firstName + ", stats are:");
          first.takeDamage();
          log(first.toString());
          log(second.toString());
          break;
      }
      System.out.println("------------------------------");
  }
  // end of the game
    if(first.isDead()) {
      log("End of Battle, " + second.toString() + " wins!");
    } else {
      log("End of Battle, " + first.toString() + " wins!");
    }
}

  private static int compareTo(int firstAttackScore, int secondAttackScore) {
    return Integer.compare(firstAttackScore, secondAttackScore);
  }

  private void log(String msg) {
    System.out.println(msg);
  }
}
