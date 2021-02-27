public class Main {
   /// once you set your own sources and destination and also, the matrix of cost
    /// you are ready to see your result with this method who print on the screen ,
    /// in a simple and clearly way , the problem that you just made.
    static void printMatrix(Problem p1) {

        System.out.print("          ");
        for (int i = 0; i < p1.numberOfDestinations; i++)
            System.out.print(p1.destinations[i].getName() + " ");
        System.out.print("Supply");
        System.out.println("          ");
        for (int i = 0; i < p1.numberOfSources; i++) {
            for (int j = 0; j < p1.numberOfDestinations; j++) {
                if (j == 0) System.out.print(p1.sources[i].getName() + "         ");
                System.out.print(p1.cost[i][j] + "  ");
                if (j == p1.numberOfDestinations - 1)
                    System.out.print(p1.sources[i].getCapacity());
            }
            System.out.println(" ");
        }
        System.out.print("Demand:    ");
        for (int i = 0; i < p1.numberOfDestinations; i++)
            System.out.print(p1.destinations[i].getDemand() + " ");
    }

    public static void main(String[] args) {
        /// make a source and set different values, name for it
        /// and similar for destinations
        Source source1 = new Source(TypeOfSource.FACTORY);
        System.out.println("S1 is a : " + source1.typeSource);
        Source source2 = new Source(TypeOfSource.WAREHOUSE);
        System.out.println("S2 is a : " + source2.typeSource);
        Source source3 = new Source(TypeOfSource.WAREHOUSE);
        System.out.println("S2 is a : " + source3.typeSource);
        Destination destination1 = new Destination(20);
        Destination destination2 = new Destination(20);
        Destination destination3 = new Destination(25);
        source1.setCapacity(10);
        System.out.println(source1.getCapacity());
        source2.setCapacity(35);
        source3.setCapacity(25);
        source1.setName("S1");
        source2.setName("S2");
        source3.setName("S3");
        destination1.setName("D1");
        destination2.setName("D2");
        destination3.setName("D3");
        System.out.println(source1.toString());
        System.out.printf(destination1.toString());
        Problem p1 = new Problem();
        p1.setSource(source1, source2, source3);
        System.out.println(p1.sources[1].getCapacity());
        p1.setDestination(destination1, destination2, destination3);
        System.out.println(p1.destinations[0].getDemand());
        p1.setCost(2, 3, 1, 5, 4, 8, 5, 6, 8);
        System.out.println("the matrix of cost is: ");
        printMatrix(p1);

    }
}
