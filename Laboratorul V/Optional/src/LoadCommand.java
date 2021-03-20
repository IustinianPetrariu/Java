import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand implements Commands {

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public void executeCommand(Catalog catalog) {
        Catalog auxiliar = new Catalog();
        try {
            FileInputStream fileIn = new FileInputStream(this.path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            auxiliar = (Catalog) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Catalog class not found!");
            c.printStackTrace();
            return;
        }
        catalog = auxiliar;
    }

}
