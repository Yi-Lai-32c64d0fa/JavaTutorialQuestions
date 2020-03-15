package Inheritance.q845dBooksandDictionaries.MySolution;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class BookShelf {

  public List<Book> books;

  public BookShelf() {
    books = new LinkedList<>();
  }

  // Returns the number of books on the bookshelf
  public int size() {
    return books.size();
  }

  // Adds a book on the left side of the shelf.
// Shifts all other books one position to the right
  public void addBookOnLeftSide(Book b) {
    books.add(0, b);
  }

  // Adds a book on the right side of the shelf.
  public void addBookOnRightSide(Book b) {
    books.add(size(), b);
  }

  // Adds book in position i counting from the left, starting
// from zero, and shifts all other books one position to the right.
// Hence addBook(0, b) is equivalent to addBookOnLeftSide(b), and
// addBook(size(), b) is equivalent to addBookOnRightSide(b)
  public void addBook(int i, Book b) {
    books.add(i, b);
  }

  // Removes book from position i, shifting all books with position
// greater than i to the left
  public Book remove(int i) {
    return books.remove(i);
  }

  // Prints all details of books from left to right
  public void printLeftToRight() {
    for (Book book : books) {
      System.out.println(book.toString());
    }
  }

  // Prints all details of books from right to left
  public void printRightToLeft() {
    ListIterator<Book> it = books.listIterator(books.size());
    while (it.hasPrevious()) {
      System.out.println(it.previous());
    }
  }
}
