import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class City {
    private String name;
    public List<Location> list = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public void addLocation(Location locatie) {
        list.add(locatie);
    }

    public void seeLocations() {
        /// we will print the locations sorting by their names
        /// so we override compare method and also we use comparoTo method

        Collections.sort(list, new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("All locations in the city are (order by their names): ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }

    /// this method will display all the distances(in time) between this location and other
    public void seeTimeBetweenLocation() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).getDistances();
        }
    }

    void displayVisitable() {
        /// here we save just the location that are Visitable and put them in a new list
        /// in order to display them accordingly
        List<Location> listAux = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Visitable && !(list.get(i) instanceof Payable)) {
                listAux.add(list.get(i));
            }
        }
        /// this method overrite the "compare" method in order to sort the location
        /// based on ther opening hours; also we use the compareTo method in order to achieve this sorting
        Collections.sort(listAux, new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {

                Visitable newLoc1 = (Visitable) o1;
                Visitable newLoc2 = (Visitable) o2;
                LocalTime time1 = newLoc1.getOpenHour();
                LocalTime time2 = newLoc2.getOpenHour();
                return time1.compareTo(time2);
            }
        });
        ///once we have sorted the list we are able now to display the list in predefine order
        /// sorted by their opening hours
        for (int i = 0; i < listAux.size(); i++) {
            System.out.println(listAux.get(i).getName());
        }


    }


}
