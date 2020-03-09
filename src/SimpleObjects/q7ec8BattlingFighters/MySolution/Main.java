package SimpleObjects.q7ec8BattlingFighters.MySolution;

public class Main {

  public static void main(String[] args) {
    Fighter Joe = new Fighter("Joe","Human Warrior" );
    Fighter Alex = new Fighter("Alex", "Elf Lord");
    GameEngine ge = new GameEngine();
    ge.simulateBattle(Joe, Alex);
  }
}
