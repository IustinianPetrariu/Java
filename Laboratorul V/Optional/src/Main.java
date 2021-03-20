import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;

public class Main {
    //                       Comenzi shell
    //    list        -- this will display the catalog content
    //    play $name$ -- this will open the specific file
    //    add   $type {book, song} $    $name$     $path$
    //    save $path$
    //    load $path$

    public static void main(String[] args) {
        System.out.println("all good!");
        /// The idea of the application is :
        /// once you run the application you already have a catalog
        /// and you can make some operation and then save it anywhere you want
        /// or also you can load a catalog that already exist on your computer and start working on it
        Catalog catalog = new Catalog();
        ListCommand listCatalog = new ListCommand();
        AddCommand addCatalog = new AddCommand();
        PlayCommand playItem = new PlayCommand();
        SaveCommand saveCatalog = new SaveCommand();
        LoadCommand loadCatalog = new LoadCommand();
        System.out.println("Shell is ready for use:Type your command : ");
        boolean keepRunning = true;
        try {
            ///prepare to read in "shell"
            while (keepRunning) {
                System.out.print("shell>>");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String line = reader.readLine();
                /// now tokenize the string from client
                List<String> command = new ArrayList<>();
                command = Arrays.asList(line.split("\\s+"));
                /// The application will signal the commands that are not valid using custom exception
                /// valid commands: add, list, save, load, play
                List<String> valid = Arrays.asList("add", "list", "save", "load", "play", "quit");
                boolean check = valid.contains(command.get(0));
                if (!check)
                    throw new MyInvalidArgumentException("Exception : wrong type of command!");
                //// prepocesare pe string

                switch (command.get(0)) {
                    case "list":
                        listCatalog.executeCommand(catalog);
                        break;
                    case "add":
                        addCatalog.parse(command);
                        addCatalog.executeCommand(catalog);
                        break;
                    case "play":
                        playItem.setName(command.get(1));
                        playItem.executeCommand(catalog);
                        break;
                    case "save":
                        saveCatalog.setPath(command.get(1));
                        saveCatalog.executeCommand(catalog);
                        break;
                    case "load":
                        loadCatalog.setPath(command.get(1));
                        loadCatalog.executeCommand(catalog);
                        break;
                    case "quit":
                        System.out.println("see you soon!");
                        exit(0);
                        break;
                    default:
                        System.out.println("unknown command!");
                }
            }

        } catch (IOException | MyInvalidArgumentException | InvalidPathException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
