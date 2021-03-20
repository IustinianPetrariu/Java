import java.io.Serializable;

public class Song extends Item {
    private String artist;

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }


    public Song(String nume, String path, int releaseYear) {
        super(nume, path, releaseYear);
    }
}
