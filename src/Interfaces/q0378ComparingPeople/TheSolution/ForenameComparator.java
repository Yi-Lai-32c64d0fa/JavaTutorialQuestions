package Interfaces.q0378ComparingPeople.TheSolution;

public class ForenameComparator implements PersonComparator {

  @Override
  public int compareTo(Person first, Person second) {
    return first.getForename().compareTo(second.getForename());
  }

}
