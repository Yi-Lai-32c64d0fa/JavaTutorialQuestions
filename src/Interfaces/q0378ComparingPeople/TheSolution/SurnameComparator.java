package Interfaces.q0378ComparingPeople.TheSolution;

public class SurnameComparator implements PersonComparator {

  @Override
  public int compareTo(Person first, Person second) {
    return first.getSurname().compareTo(second.getSurname());
  }

}
