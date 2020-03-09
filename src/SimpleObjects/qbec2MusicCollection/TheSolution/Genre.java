package SimpleObjects.qbec2MusicCollection.TheSolution;

public enum Genre {
  ROCK, POP, JAZZ;

  @Override
  public String toString() {
    switch (this) {
      case ROCK:
        return "Rock";
      case POP:
        return "Pop";
      case JAZZ:
        return "Jazz";
      default:
        assert false : "Unknown genre";
        return null;
    }
  }

}
