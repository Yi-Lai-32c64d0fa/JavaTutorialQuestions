package Inheritance.qdd4cClocks.MySolution;

public class RadioAlarmClock extends AlarmClock {

  private RadioStation station;

  public RadioAlarmClock(String name, int hours, int minutes, int seconds,
    Alarm alarm, RadioStation station) {
    super(name, hours, minutes, seconds, alarm);
    this.station = station;
  }

  public RadioAlarmClock(String name, int seconds, Alarm alarm, RadioStation station)  {
    super(name, seconds, alarm);
    this.station = station;
  }

}
