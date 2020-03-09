package SimpleObjects.q7ec8BattlingFighters.MySolution;

import java.util.Random;

public class Fighter {
  private String name;
  private String type;
  private final int skill;
  private int stamina;
  private static final int SKILL_RANGE = 18;
  private static final int STAMINA_RANGE = 24;
  private static final int DAMAGE_VALUE = 2;
  private static final int DICE_FACES = 6;
  private Random generator = new Random();


  public Fighter(String name, String type) {
    this.name =name;
    this.type = type;
    skill = generator.nextInt(SKILL_RANGE) + 1;
    stamina = generator.nextInt(STAMINA_RANGE) + 1;
  }

  public void takeDamage(){
    this.stamina = Math.max(stamina - DAMAGE_VALUE, 0);
  }
  // Reduce the fighter's stamina accordingly
  public void takeDamage(int damage) {
    this.stamina = Math.max(stamina - damage, 0);

  };

  // Return the number of damage points to be inflicted on opponent
  public int calculateDamage(){
    return DAMAGE_VALUE;
  };

  // Calculate an attack score for the fighter using the procedure described above
  public int calculateAttackScore(){
    return skill+ this.rollDice()+ this.rollDice();
  };

  protected int rollDice(){
    return generator.nextInt(DICE_FACES) + 1;
  }

  // Determine whether fighter is still alive
  public boolean isDead() {
    return stamina == 0;
  };

  @Override
  public String toString() {
    return name + " - " + type + " - skill: " + skill+ "; stamina: " + stamina;
  }

  public String getName() {
    return name;
  }


}
