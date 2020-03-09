package SimpleObjects.qd363BloatedPerson.Mysolution;

public class House {
  private int houseNumber;
  private String address1;
  private String address2;
  // postCode is also the national insuranceNUmber
  private String postCode;

  public House(int houseNumber, String address1, String address2, String postCode) {
    this.houseNumber = houseNumber;
    this.address1 = address1;
    this.address2 = address2;
    this.postCode = postCode;
  }

  public int getHouseNumber() {
    return houseNumber;
  }

  public String getPostCode() {
    return postCode;
  }

  public String getNationalInsuranceNumber() {
    return postCode;
  }

  public String getAddress2() {
    return address2;
  }

  public String getAddress1() {
    return address1;
  }

  public boolean sameAddress(House other) {
    return houseNumber == other.getHouseNumber()
      && address1.equals(other.getAddress1())
      && address2.equals(other.getAddress2())
      && postCode.equals(other.getPostCode());
  }

  @Override
  public String toString() {
    return "Address: " + houseNumber + " " + address1 + ", " + address2 + ", " + postCode + "\n"
      + "NI: " + this.getNationalInsuranceNumber();
  }
}
