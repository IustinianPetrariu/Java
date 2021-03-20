import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayCommand implements Commands {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void executeCommand(Catalog catalog) {
        boolean gasit = false;
        for (int i = 0; i < catalog.list.size(); i++) {
            if (this.name.equals(catalog.list.get(i).getName())) {
                gasit = true;
                try {
                    File u = new File(catalog.list.get(i).getPath());
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(u);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        if (gasit == false) {
            System.out.println("You enter an invalid name!");
        }
        System.out.println("Done!");
    }
}
