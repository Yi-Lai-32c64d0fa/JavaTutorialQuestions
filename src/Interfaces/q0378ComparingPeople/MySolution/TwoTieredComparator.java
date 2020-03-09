package Interfaces.q0378ComparingPeople.MySolution;

public class TwoTieredComparator implements PersonComparator {

  private PersonComparator first;
  private PersonComparator second;

  public TwoTieredComparator(PersonComparator first,
    PersonComparator second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public int CompareTo(Person person1, Person person2) {
    int result = first.CompareTo(person1, person2);
    if (result == 0) {
      result = second.CompareTo(person1, person2);
    }
    return result;
  }
}
