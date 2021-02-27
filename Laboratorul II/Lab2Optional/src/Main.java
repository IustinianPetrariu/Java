/**
 * The main class implements the features of the problem and allow you to create problem and solve them
 * This is the solution for the Lab2 on Advanced Programming using Java
 * @author Petrariu Florin-Iustinian, 2B3, UAIC INFORMATICA
 * @since 2021-02-22
 */
public class Main {
    /**
     * This method is used to print on the screen the matrix of cost that user just made
     * by adding some source and some destination
     * @param p1 p1 holds the problem that you create and it depends on the number of sources and destination
     */
    ///p1 is the problem that you just create problem1 -> p1 - for simplicity
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

          try {
                    Source source1=new Factories("S1", 10);
                    Source source2=new Warehouses("S2", 35);
                    Source source3=new Warehouses("S3",25);
                    Destination destination1= new Destination("D1", 20);
                    Destination destination2= new Destination("D2", 25);
                    Destination destination3= new Destination("D3", 25);
                    Problem myProblem= new Problem();
                    myProblem.setSource(source1,source2,source3);
                    myProblem.setDestination(destination1,destination2,destination3);
                    myProblem.setCost(2,3,1,5,4,8,5,6,8);
                    Solution solution= new Solution();
                    solution.solve(myProblem);

              } catch (Exception exc)
              {
              System.out.println(exc.toString());
              }


    }
}
