package AbstractClasses.q0c21Properties.MySolution;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PropertyCollection {

  private Set<Property> propertySet;

  public PropertyCollection() {
    propertySet = new HashSet<>();
  }

  // Add a property to the collection
  public void addProperty(Property p){
    propertySet.add(p);
  }

  // Return the set of all houses in the collection
  public Set<House> getHouses(){
    Set<House> houses = propertySet.stream()
      .filter(item -> item instanceof House)
      .map(item -> (House) item)
      .collect(Collectors.toSet());
    return houses;
  }

  // Return the set of all bungalows in the collection
  public Set<Bungalow> getBungalows(){
    Set<Bungalow> bungalows = propertySet.stream()
      .filter(item -> item instanceof Bungalow)
      .map(item -> (Bungalow) item)
      .collect(Collectors.toSet());
    return bungalows;
  }

  // Return the set of all flats in the collection
  public Set<Flat> getFlats(){
    Set<Flat> flats = propertySet.stream()
      .filter(item -> item instanceof Flat)
      .map(item -> (Flat) item)
      .collect(Collectors.toSet());
    return flats;
  }

  // Return the set of all maisonettes in the collection
  public Set<Maisonette> getMaisonettes(){
    Set<Maisonette> maisonettes = propertySet.stream()
      .filter(item -> item instanceof Maisonette)
      .map(item -> (Maisonette) item)
      .collect(Collectors.toSet());
    return maisonettes;
  }
  // Return the set of all terraced houses in the collection
  public Set<TerracedHouse> getTerracedHouses(){
    Set<TerracedHouse> terracedHouses = propertySet.stream()
      .filter(item -> item instanceof TerracedHouse)
      .map(item -> (TerracedHouse) item)
      .collect(Collectors.toSet());
    return terracedHouses;
  }
}
