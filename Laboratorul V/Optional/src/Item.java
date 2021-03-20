import java.io.File;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Item implements Serializable {

    private String name;
    private String path;
    private int releaseYear;

    public void setReleaseYear(int releaseYear) {

        if (releaseYear < 1800) throw new InvalidYearException(releaseYear);
        if (releaseYear > 2020) throw new InvalidYearException(releaseYear);
        File file = new File(path);

        if (!file.exists()) throw new InvalidPathException(path);
        this.releaseYear = releaseYear;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Item(String nume, String path) {
        // if (releaseYear < 1800) throw new InvalidYearException(releaseYear);
        //  if(releaseYear > 2020) throw new InvalidYearException(releaseYear);
        this.name = nume;
        this.path = path;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        File file = new File(path);

        if (!file.exists()) throw new InvalidPathException(path);
        this.path = path;
    }


}
