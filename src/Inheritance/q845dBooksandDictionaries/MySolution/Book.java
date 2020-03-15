package Inheritance.q845dBooksandDictionaries.MySolution;

public class Book {

  protected String isbn;
  protected String title = "";
  protected int pages = 0;

  public Book(String isbn, String title, int pages) {
    this.isbn = isbn;
    this.title = title;
    this.pages = pages;
  }

  @Override
  public String toString() {
    return title + ", ISBN: " + isbn + ", pages: " + pages;
  }

}