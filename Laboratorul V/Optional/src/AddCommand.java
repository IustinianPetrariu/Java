import java.io.File;
import java.util.Arrays;
import java.util.List;

public class AddCommand implements Commands {

    private String name;
    private String path;
    private String type;


    public void setType(String type) {

        List<String> valid = Arrays.asList("song", "book");
        boolean check = valid.contains(type);
        if (!check) throw new MyInvalidArgumentException("you cand add only a book or a song!");
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPath(String path) {

        File file = new File(path);
        if (!file.exists()) throw new InvalidPathException(path);
        this.path = path;
    }

    public String getPath() {
        return path;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void parse(List<String> command) {
        setName(command.get(2));
        setPath(command.get(3));
        setType(command.get(1));
    }

    public void executeCommand(Catalog catalog) {
        switch (type) {
            case "song":
                Item song = new Song(this.name, this.path);
                catalog.add(song);
                break;
            case "book":
                Item book = new Book(this.name, this.path);
                catalog.add(book);
                break;
            default:

        }
        System.out.println("Done!");
    }
}
