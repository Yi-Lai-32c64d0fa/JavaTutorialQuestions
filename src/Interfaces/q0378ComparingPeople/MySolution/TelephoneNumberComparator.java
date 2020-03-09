package Interfaces.q0378ComparingPeople.MySolution;

public class TelephoneNumberComparator implements PersonComparator {

  public TelephoneNumberComparator() {
  }

  @Override
  public int CompareTo(Person person1, Person person2) {
    return person1.getTelephoneNo().compareTo(person2.getTelephoneNo());
  }

}
