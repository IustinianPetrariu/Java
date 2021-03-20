import java.io.Serializable;

public class Book extends Item {

    private int cod;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }


    public Book(String nume, String path, int releaseYear) {
        super(nume, path, releaseYear);
    }
}
