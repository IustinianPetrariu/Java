import java.time.LocalTime;

public class Main {


    public static void main(String[] args) {
        System.out.println("all good!");
        ///make some location and put a name
        Location hotel1 = new Hotel("Hotel A");
        Location museum1 = new Museum("Museum A");
        Location museum2 = new Museum("Museum B");
        Location church1 = new Church("Church A");
        Location church2 = new Church("Church B");
        Location restaurant1 = new Restaurant("Restaurant A");

        /// set the time required to go from one location to another one

        hotel1.setDistancesTo(museum1, 10);
        hotel1.setDistancesTo(museum2, 10);
        museum1.setDistancesTo(museum2, 20);
        museum1.setDistancesTo(church1, 34);
        museum1.setDistancesTo(church2, 34);
        museum2.setDistancesTo(church1, 34);
        church1.setDistancesTo(church2, 34);
        church1.setDistancesTo(restaurant1, 34);
        church2.setDistancesTo(restaurant1, 34);

        ///create a new City that will containt all the various Location stored in a List
        ///the locations ordering is given by their names

        City myCity = new City("Iasi");
        myCity.addLocation(hotel1);
        myCity.addLocation(museum1);
        myCity.addLocation(museum2);
        myCity.addLocation(church1);
        myCity.addLocation(church2);
        myCity.addLocation(restaurant1);

        ///use this method to see all the location in that city
        myCity.seeLocations();
        System.out.println("----");

        ///use this method to show the distances between locations in the city
        myCity.seeTimeBetweenLocation();
        System.out.println("-----");


    }
}
