public class ListCommand implements Commands {

    public void executeCommand(Catalog catalog) {

        System.out.println("the catalog will be displayed");

        if (catalog.list.size() > 0) {
            for (int i = 0; i < catalog.list.size(); i++) {
                System.out.print(catalog.list.get(i).getName() + " ");
                System.out.println(catalog.list.get(i).getPath() + " ");
            }
            System.out.println(" ");
        } else {
            System.out.println("your catalog is empty for moment!");
        }


    }
}
