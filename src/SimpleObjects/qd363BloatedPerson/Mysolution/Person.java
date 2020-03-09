package SimpleObjects.qd363BloatedPerson.Mysolution;

import java.util.StringTokenizer;

public class Person {

  private String forenames;
  private String surname;

  private DateOfBirth dateOfBirth;
  private House house;

  public Person(String forename, String surname, DateOfBirth dateOfBirth, House house) {
    this.forenames = forename;
    this.surname = surname;
    this.dateOfBirth = dateOfBirth;
    this.house = house;
  }

  public boolean sameAddress(Person other) {
    return house.sameAddress(other.getHouse());
  }

  public House getHouse() {
    return house;
  }

  public String getInitials() {
    String result = "";
    StringTokenizer strTok = new StringTokenizer(forenames);
    while (strTok.hasMoreTokens()) {
      result += strTok.nextToken().charAt(0);
    }
    return result + surname.charAt(0);
  }

  public String toString() {
    return "Name: " + forenames + " " + surname + "\n"
      + dateOfBirth.toString()
      + house.toString();

  }

}
