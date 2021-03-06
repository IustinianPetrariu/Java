import java.time.Duration;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        ///make some location and put some name and some properties
        Location hotel1 = new Hotel("hotelA", "13:00", "14:00");
        Location hotel2 = new Hotel("hotelB", "10:30", "17:20");
        Location hotel3 = new Hotel("hotelC", "09:30", "17:20");
        ///here we make a new hotel, but we don't inroduce the opening hour
        ///and ending hour, so default method in Visitable will set the default timing
        /// to open: 9:30 and end : 21:30
        Location hotel4 = new Hotel("hotelD");
        Location church1 = new Church("Church A", 12.3);
        Location church2 = new Church("Church B", 14);
        Location restaurant1 = new Restaurant("Restaurant A", "11:21", "19:22");

        ///STATIC METHOD IN VISITABLE INTERFACE  REPRESENTING HOW LONG A LOCATION IS OPENED DURING A DAY !
        Duration d1 = Visitable.getVisitingDuration(hotel1);
        // System.out.println(d1.getSeconds());

        ///PROVE that default method set the time for the hotel in a default way, we don't write this hours explicity
        /// so after the cast, the open hour, by default will pe 21:30
          System.out.println(((Visitable) hotel4).getOpenHour());

        ///make a new City that will contain all the location that we just made
        /// make a Plan for a trip, put the name and add a City that will containt some locations
        TravelPlan myPlan = new TravelPlan("FirstPlan", "Iasi");
        myPlan.city.addLocation(hotel1);
        myPlan.city.addLocation(hotel2);
        myPlan.city.addLocation(hotel3);
        myPlan.city.addLocation(church1);
        myPlan.city.addLocation(church2);
        myPlan.city.seeLocations();
        /// add some distances(in minutes) between locations
        hotel1.setDistancesTo(hotel2, 21);
        hotel1.setDistancesTo(hotel3, 11);
        hotel1.setDistancesTo(church1, 8);
        church1.setDistancesTo(church2, 14);
        /// print all the distances between locations in the city
        myPlan.city.seeTimeBetweenLocation();
        /// find the distances between two locations in the city, in minutes
        System.out.println(myPlan.shortestPathBetween(hotel1, church2));



    }
}
