import java.util.ArrayList;
import java.util.List;


/// this class will contain a travel plan that holds a city and that city contains all the location
/// to visit in the city
public class TravelPlan {
    private String name;
    City city;

    public TravelPlan(String name, String cityName) {
        this.name = name;
        city = new City(name);
    }

    /// this method print the distances between two location
    /// method use the Floyd-Warshall/ Roy-Floyd algortihm to search and find the shortest path
    /// between locations. First we compute a matrix that holds the distances between every two location
    /// and then, we will search and try to improve the distances between two location
    ///                       -shortest path-
    public int shortestPathBetween(Location startLocation, Location finishLocation) {
        int startIndex = city.list.indexOf(startLocation);
        int finishIndex = city.list.indexOf(finishLocation);
        int dimensiune = city.list.size();
        int[][] cost = new int[dimensiune][dimensiune];
        int index = 0;

        //iterate between every location to find the cost
        for (int i = 0; i < dimensiune; i++) {
            /// for every location we have to find the distances between it and other locations
            for (String anotherLocation : city.list.get(i).map.keySet()) {
                int costValue = city.list.get(i).map.get(anotherLocation);
                String locationName = anotherLocation;
                for (int j = 0; j < dimensiune; j++)
                    if (city.list.get(j).getName() == locationName) {
                        index = j;
                        cost[i][j] = costValue;
                    }
            }
        }

        /// print the matrix of cost between locations
        for (int i = 0; i < dimensiune; i++) {
            for (int j = 0; j < dimensiune; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println(" ");
        }

        //// now that we have the matrix, perfom the algorithm : Floyd-Warshall/ Roy-Floyd !
        /// this algorithm uses three index, i,j,k to find out if road from i to j can be
        /// improve by the road from i to k and then from k to j
        for (int k = 0; k < dimensiune; k++)
            for (int i = 0; i < dimensiune; i++)
                for (int j = 0; j < dimensiune; j++)
                    if (i != j && cost[i][k] > 0 && cost[k][j] > 0 && (cost[i][j] > cost[i][k] + cost[k][j] || cost[i][j] == 0))
                        cost[i][j] = cost[i][k] + cost[k][j];
        /// now print the matrix after the algorithm

        System.out.println("-----------------");
        for (int i = 0; i < dimensiune; i++) {
            for (int j = 0; j < dimensiune; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println(" ");
        }

        System.out.println("The shortest path between location, conform to algorithm is: ");
        return cost[startIndex][finishIndex];
    }

}
