package SimpleObjects.qd363BloatedPerson.TheSolution;


public class Address {

  private final int houseNumber;
  private final String address1;
  private final String address2;
  private final String postCode;

  public Address(int houseNumber, String address1, String address2, String postCode) {
    this.houseNumber = houseNumber;
    this.address1 = address1;
    this.address2 = address2;
    this.postCode = postCode;
  }

  @Override
  public boolean equals(Object that) {
    if (!(that instanceof Address)) {
      return false;
    }
    Address thatAddress = (Address) that;
    return houseNumber == thatAddress.houseNumber
      && address1.equals(thatAddress.address1)
      && address2.equals(thatAddress.address2)
      && postCode.equals(thatAddress.postCode);

  }

  @Override
  public int hashCode() {
    return 17 * houseNumber ^ address1.hashCode() ^ address2.hashCode() ^ postCode.hashCode();
  }

  @Override
  public String toString() {
    return houseNumber + " " + address1 + ", " + address2 + ", " + postCode;
  }

  public static void main(String[] args) {
    Address h = new Address(22,"kkl","oop","ssd aq5");
    System.out.println(h.hashCode());
  }

}
