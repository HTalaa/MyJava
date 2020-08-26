package Opt;

import java.util.Optional;

public class Song {
    private Genre  genre;
    private int nbrEcoute;
    private String titre;

    public Song(Genre genre, int nbrEcoute, String titre) {
        this.genre = genre;
        this.nbrEcoute = nbrEcoute;
        this.titre = titre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getNbrEcoute() {
        return nbrEcoute;
    }

    public void setNbrEcoute(int nbrEcoute) {
        this.nbrEcoute = nbrEcoute;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "genre=" + genre +
                ", nbrEcoute=" + nbrEcoute +
                ", titre='" + titre + '\'' +
                '}';
    }
    public void play(){
        System.out.println(getTitre());
    }

}
