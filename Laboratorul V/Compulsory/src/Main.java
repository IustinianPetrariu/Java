public class Main {


    public static void main(String[] args) {
        System.out.println("all good!");

        /// set the preferences and construct the items
        /// you can make new songs and books

        try {
            Item song1 = new Song("All of me!", "E:\\FII\\Semestrul III\\Engleza\\AlinaEremia.mp3", 2010);
            Item book1 = new Book("Homosapiens", "E:\\FII\\Semestrul III\\Engleza\\Taboo.pdf", 2019);


            ///provide the method in order to add those items in the catalog !
            /// for your catalog, insert a name and insert a path ( where to store the catalog)
            /// then u can add items to catalog
            Catalog catalog = new Catalog("catalogA", "E:\\FII\\Semestrul IV\\Programare avansata\\Catalog\\cat4.ser");
            Catalog catalog2 = new Catalog("catalogB", "E:\\FII\\Semestrul IV\\Programare avansata\\Catalog\\cat5.ser");
            catalog.add(song1);
            catalog.add(book1);

            /// you can display your item, that are store in your catalog
            catalog.listItems();

            /// you can play every item within your catalog with this function!
            catalog.play(book1);
            //  catalog.play(song1);

            // you cand save your work where u input the path!
            catalog.save();
            // with this method u can load a catalog from another path - from an external file
            //  catalog.listItems();
            catalog2.load("E:\\FII\\Semestrul IV\\Programare avansata\\Catalog\\cat4.ser");
            catalog2.listItems();

            try {
                song1.setReleaseYear(2035);
                song1.setReleaseYear(2000);
                song1.setPath("asdas");

            } catch (InvalidYearException exception) {
                System.out.println(exception.getMessage());
            } catch (InvalidPathException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InvalidYearException exception) {
            System.out.println(exception.getMessage());
        } catch (InvalidPathException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
