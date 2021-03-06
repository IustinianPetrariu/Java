import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    void setOpenHour(String date);

    void setEndingHour(String date);

    /// if you don t implement this, it will return a default hour
    default LocalTime getOpenHour() {
        LocalTime defaultTime;
        defaultTime = LocalTime.parse("09:30");
        return defaultTime;
    }

    ///DEFAULT METHOD :
    ///if we don't specify for a location that implements this interface the avaible hours


    /// this method is optional (the statement does not mention this method) and will set default hour for open and close for a location
    default void setDefaultValues() {
        setOpenHour("10:30");
        setEndingHour("21:30");
    }

    //if you don t implement this, it will return a default hour - according to the statement
    default LocalTime getEndingHour() {
        LocalTime defaultTime;
        defaultTime = LocalTime.parse("21:30");
        return defaultTime;
    }

    //// STATIC METHOD:
    //// static method representing how long a location is opened during a day
    static Duration getVisitingDuration(Location location1) {
        Visitable newLocation = (Visitable) location1;
        LocalTime time1 = newLocation.getOpenHour();
        LocalTime time2 = newLocation.getEndingHour();
        Duration duration1 = Duration.between(time1, time2);
        return duration1;
    }
    ///only some locations will have this properties implemented

}
