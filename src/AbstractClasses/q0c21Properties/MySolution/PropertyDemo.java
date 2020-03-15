package AbstractClasses.q0c21Properties.MySolution;

public class PropertyDemo {

  public static void main(String[] args) {
    PropertyCollection pc = new PropertyCollection();
    int i = 0;
    while(i < 1000) {
      if (i < 20) {
        pc.addProperty(new Maisonette());
        pc.addProperty(new DetachedBungalow());
        pc.addProperty(new TerracedBungalow());
      }
      if (i < 100) {
        pc.addProperty(new DetachedHouse());
        pc.addProperty(new SemiDetachedBungalow());
        pc.addProperty(new Flat());
      }
      pc.addProperty(new SemiDetachedHouse());
      pc.addProperty(new TerracedHouse());
      i++;
    }

    System.out.println("number of houses: " + pc.getHouses().size());
    System.out.println("number of bungalows: " + pc.getBungalows().size());
    System.out.println("number of Flats: " + pc.getFlats().size());
    System.out.println("number of maisonettes: " + pc.getMaisonettes().size());
    System.out.println("number of terraced houses: " + pc.getTerracedHouses().size());


  }
}
