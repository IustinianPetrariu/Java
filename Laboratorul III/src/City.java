import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class City {
    public String name;
    ///this list will store all the location in the city
    public List<Location> list = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public void addLocation(Location locatie) {
        list.add(locatie);
    }

    public void seeLocations() {
        ///we override compare method to sort the location based on their names
        /// and also we use the compareTo method in order to achieve sorting

        Collections.sort(list, new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        /// once the location are sorted, we will print them on the screen

        System.out.println("All locations in the city are: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }

    public void seeTimeBetweenLocation() {
        /// we list all the location and for every location we print the distances to other location in the city

        for (int i = 0; i < list.size(); i++) {
            list.get(i).getDistances();
        }

    }

}
