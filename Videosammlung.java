import java.util.ArrayList;

public class Videosammlung {

  private Video[] sammlung;
  private final int n;
  private int verbleibende;

  // Konstruktor
  public Videosammlung(int n) {
    this.n = n;
    this.verbleibende = n;
    this.sammlung = new Video[n];
  }

  // Methoden
  public int addVideo(Video v) {
    for (int i = 0; i < n; i++) {
      if (sammlung[i] == null) {
        sammlung[i] = v;
        verbleibende--;
        return i;
      }
    }
    return -1;
  }

  ///////////////////////////////////// nachher rauslöschen
  public Video[] getVideos() {
    return sammlung;
  }

  public Video verkaufen(int index) {
    if (index >= n || sammlung[index] == null) {
      return null;
    }

    Video help = sammlung[index];
    sammlung[index] = null;
    verbleibende++;
    return help;
  }

  public Video verkaufen(String titel) {
    for (int i = 0; i < n; i++) {
      if (sammlung[i] == null) {
        continue;
      }
      if (sammlung[i].getTitel().equals(titel)) {
        Video help = sammlung[i];
        sammlung[i] = null;
        verbleibende++;
        return help;
      }
    }
    return null;
  }

  public int getVerbleibende() {
    return verbleibende;
  }

  String[] videosInGenre(String genre) {
    ArrayList<String> result = new ArrayList<String>();
    for (int i = 0; i < n; i++) {
      if (sammlung[i] == null) {
        continue;
      }

      String[] genres = sammlung[i].getGenres();
      for (int j = 0; j < genres.length; j++) {
        if (genres[j] == null) {
          continue;
        }
        if (genres[j].equals(genre)) {
          result.add(sammlung[i].getTitel());
        }
      }
    }


    // von ArrayList in ein String Array
    String[] videosingenre = new String[result.size()];
    /*
     * for (int j = 0; j < result.size(); j++) { String vid = result.get(j); videosingenre[j] = vid;
     * }
     */
    return result.toArray(videosingenre);
  }


}
