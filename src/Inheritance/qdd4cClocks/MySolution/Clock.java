package Inheritance.qdd4cClocks.MySolution;

public class Clock {

  protected ClockType type;
  protected int hours;
  protected int minutes;
  protected int seconds;
  protected String name;

  public Clock(String name, int hours, int minutes, int seconds) {
    this.name = name;
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
    checkValidTime();
    this.type = ClockType.HOURS;
  }

  public Clock(String name, int seconds) {
    this.name = name;
    this.hours = seconds / 3600;
    this.minutes = (seconds % 3600) / 60;
    this.seconds = (seconds % 3600) % 60;
    checkValidTime();
    this.type = ClockType.SECONDS;

  }

  private void checkValidTime() {
    if (hours < 0 || hours > 24 || minutes < 0 || minutes > 60 || seconds < 0 || seconds > 60) {
      throw new IllegalArgumentException("Invalid Time Input");
    }
  }

  public void tick() {
    seconds += 1;
    if (seconds == 60) {
      seconds = 0;
      minutes += 1;
    }
    if (minutes == 60) {
      minutes = 0;
      hours += 1;
    }
    if (hours == 24) {
      hours = 0;
    }
  }

  protected int calculateTotalSeconds() {
    return hours * 3600 + minutes * 60 + seconds;
  }

  @Override
  public String toString() {
    if (type == ClockType.SECONDS) {
      return "Clock " + name + " shows: " + calculateTotalSeconds() + " seconds since midnight.";
    } else {
      return "Clock " + name + " shows: " + hours + ":" + minutes + ":" + seconds;
    }
  }
}
