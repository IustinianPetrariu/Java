import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    private String name;

    protected List<Item> list = new ArrayList<>();
    private Path path;

    public List<Item> getList() {
        return list;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void add(Item item1) {
        list.add(item1);
    }

    public void listItems() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getName() + " ");
            System.out.print(list.get(i).getPath() + " ");
            System.out.println(list.get(i).getReleaseYear());
        }
    }

    public void play(Item item) {
        try {
            File u = new File(item.getPath());
            Desktop desktop = Desktop.getDesktop();
            desktop.open(u);
        } catch (Exception e) {
            System.out.println("ups");
        }
    }

    ///implement this method to save the catalog into a file!
    public void save() {
        try {
            File file = new File(path.toString());
            FileOutputStream fileOut = new FileOutputStream(file);
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                for (Item i1 : list) {
                    out.writeObject(i1);
                }
            }
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String path) {
        Item e = null;
        try {
            File file = new File(path);
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (true) {
                try {
                    e = (Item) in.readObject();
                    System.out.println(e.getName());
                    list.add(e);

                } catch (EOFException e1) {
                    break;
                }
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Item class not found");
            c.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", list=" + list +
                ", path=" + path +
                '}';
    }
}










