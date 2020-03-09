package Interfaces.q0378ComparingPeople.MySolution;

public class Person {

  private String surname;
  private String forename;
  private String telephoneNo;

  public Person(String surname, String forename, String telephoneNo) {
    this.surname = surname;
    this.forename = forename;
    this.telephoneNo = telephoneNo;
  }

  public String getSurname() {
    return surname;
  }

  public String getForename() {
    return forename;
  }

  public String getTelephoneNo() {
    return telephoneNo;
  }

  public String toString() {
    return  forename + " " + surname
      + " Telephone Number: " + telephoneNo;
  }
}
