package Inheritance.qdd4cClocks.MySolution;

public class AlarmClock extends Clock {

  private Alarm alarm;
  private boolean isSounding = false;
  private static final int ALARM_DURATION = 60;

  public AlarmClock(String name, int hours, int minutes, int seconds, Alarm alarm) {
    super(name, hours, minutes, seconds);
    this.alarm = alarm;
  }

  public AlarmClock(String name, int seconds, Alarm alarm) {
    super(name, seconds);
    this.alarm = alarm;
  }

  private boolean isAlarmDuration() {
    return alarm.calculateTotalSeconds() <= this.calculateTotalSeconds()
      && this.calculateTotalSeconds() <= alarm.calculateTotalSeconds() + ALARM_DURATION;
  }

  @Override
  public void tick() {
    super.tick();
    if (isAlarmDuration()) {
      isSounding = true;
    }
  }

  @Override
  public String toString(){
    String result = super.toString();
    if (isSounding) {
      result += " BEEP!";
    }
    return result;
  }
}
