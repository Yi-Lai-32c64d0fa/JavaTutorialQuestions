package Inheritance.q845dBooksandDictionaries.MySolution;

public class Dictionary extends Book {

  private final String sourceLanguage;
  private final String targetLanguage;
  private int numDefinitions;

  public Dictionary(String isbn,
    String title,
    int pages,
    String sourceLanguage,
    String targetLanguage,
    int numDefinitions) {
    super(isbn, title, pages);
    this.sourceLanguage = sourceLanguage;
    this.targetLanguage = targetLanguage;
    this.numDefinitions = numDefinitions;
  }

  @Override
  public String toString() {
    return "Dictionary{" +
      "sourceLanguage='" + sourceLanguage + '\'' +
      ", targetLanguage='" + targetLanguage + '\'' +
      ", numDefinitions=" + numDefinitions +
      ", isbn='" + isbn + '\'' +
      ", title='" + title + '\'' +
      ", pages=" + pages +
      '}';
  }
}
