package Interfaces.q0378ComparingPeople.MySolution;


public class SurnameComparator implements PersonComparator {

  public SurnameComparator() {
  }

  @Override
  public int CompareTo(Person person1, Person person2) {
    return person1.getSurname().compareTo(person2.getSurname());
  }
    /*
    String name1 = person1.getSurname().toLowerCase();
    String name2 = person2.getSurname().toLowerCase();
    int result = 0;
    for (int i = 0; i < Math.min(name1.length(), name2.length()); i++) {
      char letter1 = name1.charAt(i);
      char letter2 = name2.charAt(i);
      if (letter1 < letter2 ) {
        result = -1;
        break;
      } else if (letter1 > letter2){
        result = 1;
        break;
      }
    }
    if (result == 0) {
      if (name1.length() < name2.length()) {
        result = -1;
      }
      if (name1.length() > name2.length()) {
        result =  1;
      }
    }
    return result;
  }
  */
}
