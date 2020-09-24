

public class Video extends MiniJava {


  // Attribute
  private String titel;
  private int id;
  private String[] genres;
  private static int amount = 0;

  // Konstruktor
  public Video(String titel) {
    this.titel = titel;
    id = amount++;
    genres = new String[5];
  }

  // Methoden
  public String getTitel() {
    return titel;
  }

  public int getId() {
    return id;
  }

  public String[] getGenres() {
    return genres;
  }


  public int addGenre(String genre) {
    int free = 0;
    for (int i = 0; i < genres.length; i++) {
      if (genres[i] == null) {
        free++;
        continue;
      }
      if (genres[i].equals(genre)) {
        return -1;
      }
    }

    for (int i = 0; i < genres.length; i++) {
      if (genres[i] == null) {
        genres[i] = genre;
        free--;
        return 5 - free;
      }
    }
    return -1;
  }
}
