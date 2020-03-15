package Inheritance.q845dBooksandDictionaries.MySolution;

public class Demo {

  static int compareByType(Book b1, Book b2) {
    return (b1 instanceof Dictionary) ? (b2 instanceof Dictionary ? 0 : 1)
      : (b2 instanceof Dictionary ? -1 : 0);
  }



  public static void main(String[] args) {
    Book a = new Book("1", "apple tree", 29);
    Book b = new Book("2", "bad apple", 99);
    Book c = new Dictionary("3", "Eng dic", 79, "English", "Spanish", 55);
    Dictionary d = new Dictionary("4", "4th Dic", 980, "Chinese", "Japanese", 889);
    Dictionary e = new Dictionary("5", "oows", 56, "kas", "sdad", 88);
    Book f = new Book("6", "nmsl", 55);

    BookShelf bs = new BookShelf();
    bs.addBookOnRightSide(a);
    bs.addBookOnRightSide(b);
    bs.addBookOnRightSide(d);
    bs.addBookOnRightSide(e);
    bs.addBookOnRightSide(c);
    bs.addBookOnRightSide(f);

    bs.books.sort(Demo::compareByType);

    bs.printRightToLeft();
  }
}
