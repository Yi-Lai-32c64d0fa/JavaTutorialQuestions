package Interfaces.q0378ComparingPeople.MySolution;

public class ForenameComparator implements PersonComparator {

  public ForenameComparator() {
  }

  @Override
  public int CompareTo(Person person1, Person person2) {
    return person1.getForename().compareTo(person2.getForename());
  }
}
