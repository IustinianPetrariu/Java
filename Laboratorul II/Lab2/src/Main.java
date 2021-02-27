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
        Source Source1 = new Source(TypeOfSource.FACTORY);
        System.out.println("S1 is a : " + Source1.typeSource);
        Source Source2 = new Source(TypeOfSource.WAREHOUSE);
        System.out.println("S2 is a : " + Source2.typeSource);
        Source Source3 = new Source(TypeOfSource.WAREHOUSE);
        System.out.println("S2 is a : " + Source3.typeSource);
        Destination Destination1 = new Destination(20);
        Destination Destination2 = new Destination(20);
        Destination Destination3 = new Destination(25);
        Source1.setCapacity(10);
        System.out.println(Source1.getCapacity());
        Source2.setCapacity(35);
        Source3.setCapacity(25);
        Source1.setName("S1");
        Source2.setName("S2");
        Source3.setName("S3");
        Destination1.setName("D1");
        Destination2.setName("D2");
        Destination3.setName("D3");
        System.out.println(Source1.toString());
        System.out.printf(Destination1.toString());
        Problem p1 = new Problem();
        p1.setSource(Source1, Source2, Source3);
        System.out.println(p1.sources[1].getCapacity());
        p1.setDestination(Destination1, Destination2, Destination3);
        System.out.println(p1.destinations[0].getDemand());
        p1.setCost(2, 3, 1, 5, 4, 8, 5, 6, 8);
        System.out.println("the matrix of cost is: ");
        printMatrix(p1);

    }
}
