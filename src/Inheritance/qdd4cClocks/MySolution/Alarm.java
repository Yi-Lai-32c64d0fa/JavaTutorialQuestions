package Inheritance.qdd4cClocks.MySolution;

public class Alarm {
  private int hours;
  private int minutes;
  private int seconds;

  public Alarm(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
    checkValidTime();
  }

  public Alarm(String name, int seconds) {
    this.hours = seconds / 3600;
    this.minutes = (seconds % 3600) / 60;
    this.seconds = (seconds % 3600) % 60;
    checkValidTime();

  }

  private void checkValidTime() {
    if (hours < 0 || hours > 24 || minutes < 0 || minutes > 60 || seconds < 0 || seconds > 60) {
      throw new IllegalArgumentException("Invalid Time Input");
    }
  }

  public int calculateTotalSeconds() {
    return hours * 3600 + minutes * 60 + seconds;
  }

  public int getHours() {
    return hours;
  }

  public int getMinutes() {
    return minutes;
  }

  public int getSeconds() {
    return seconds;
  }
}
