package SimpleObjects.qbec2MusicCollection.MySolution;

import SimpleObjects.qbec2MusicCollection.MySolution.Record.Genre;
import java.util.ArrayList;

public class Artist {
  private String name;
  private ArrayList<Record> records;
  private Genre mainGenre;

  // Add a record of the given name to the artist's catalogue
  // Use the artist's main genre as the record's genre
  public void addRecord(String name){
    records.add(new Record(name, mainGenre));
  };

  // Add a record of the given name and genre to the artist's
// catalogue
  public void addRecord(String name, Genre genre){
    records.add(new Record(name, genre));
  };

  // Display the artist's catalogue
  public void showCatalogue(){
    System.out.println(records.toString());
  };

  // Display the subset of artist's catalogue that falls into
// the given genre
  public void showGenre(Genre genre){
    for (Record record : records) {
      if (record.getGenre() == genre) {
        System.out.println(record);
      }
    }
  };

}
