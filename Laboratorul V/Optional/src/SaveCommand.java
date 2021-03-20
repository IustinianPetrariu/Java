import java.io.*;

public class SaveCommand implements Commands {

    private String path;

    public void setPath(String path) {

        this.path = path;
    }

    public String getPath() {
        return path;
    }


    public void executeCommand(Catalog catalog) {
        try {
            FileOutputStream fileOut = new FileOutputStream(this.path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            System.out.println("Your catalog is saved in " + path);
            out.writeObject(catalog);
            out.close();
            fileOut.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
