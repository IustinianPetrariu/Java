import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * This class will solve the problem that you just made with de Problem Class. That is, you just make your own problem
 * and then you call this class that will give you the answer
 */
public class Solution {

    /// implement a solution using Greedy method

    /**
     * This main method will solve the problem by using a Greedy method.
     * First, method test to see if supply and demands constraints cand be satisified,
     * then implement the algorithm that will give the proper answer.
     * The Greedy approach is to search for the lowest cost relationship in the matrix and
     * for this type of relation the algorithm takes the maximum supply that can satisy the demand and so on
     * to the next minimum cost
     * @param p1 p1 holds the problem that you just made, including sources and destination and matrix of costs
     */


    ///p1 is the problem that you just create problem1 -> p1 - for simplicity
     public void solve(Problem p1) {
         int totalCost = 0;
         System.out.println("Solving the problem ...");
         Arrays.sort(p1.arrayOfCost);
         int supply = 0;
         int demand = 0;
         /// verify if we can satisfy the supply and demand constraints!
         for (int i = 0; i < p1.numberOfSources; i++)
             supply += p1.sources[i].getCapacity();
         for (int j = 0; j < p1.numberOfDestinations; j++)
             demand += p1.destinations[j].getDemand();
         if (supply < demand) {
             System.out.println("Constraints about the supply and demand cannot pe satisfy");
         } else {

             for (int k = 0; k < p1.numberOfDestinations * p1.numberOfSources; k++) {
                 /// parse the matrix to find the minimum cost
                 for (int i = 0; i < p1.numberOfSources; i++)
                     for (int j = 0; j < p1.numberOfDestinations; j++) {
                         if (p1.cost[i][j] == p1.arrayOfCost[k]) {
                             if (p1.destinations[j].getDemand() >= p1.sources[i].getCapacity() && p1.sources[i].getCapacity() > 0) {
                                 totalCost += p1.sources[i].getCapacity() * p1.cost[i][j];
                                 System.out.println("Total cost is: " + totalCost);
                                 p1.destinations[j].setDemand(p1.destinations[j].getDemand() - p1.sources[i].getCapacity());
                                 System.out.print(p1.sources[i].getName() + " - > " + p1.destinations[j].getName() + " transfer: ");
                                 System.out.println(p1.sources[i].getCapacity());
                                 p1.sources[i].setCapacity(0);
                             } else if (p1.destinations[j].getDemand() < p1.sources[i].getCapacity() && p1.destinations[j].getDemand() > 0) {
                                 totalCost += p1.destinations[j].getDemand() * p1.cost[i][j];
                                 System.out.println("Total cost is: " + totalCost);
                                 System.out.print(p1.sources[i].getName() + " - > " + p1.destinations[j].getName() + " transfer: ");
                                 System.out.println(p1.destinations[j].getDemand());
                                 p1.destinations[j].setDemand(0);
                             }
                         }
                     }
             }
             System.out.println("Total cost, as final result is: " + totalCost);
         }
     }

}