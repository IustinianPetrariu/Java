import java.net.http.HttpClient;
import java.time.LocalTime;

public class Hotel extends Location implements Visitable, Classifiable {
    private LocalTime inHour;
    private LocalTime endHour;
    private double rank;

    public Hotel(String name, String openHour, String endingHour) {
        super(name);
        this.inHour = LocalTime.parse(openHour);
        this.endHour = LocalTime.parse(endingHour);
    }

    public Hotel(String name) {
        super(name);
        setDefaultValues();
    }

    public void setOpenHour(String date) {
        this.inHour = LocalTime.parse(date);
    }

    public void setEndingHour(String date) {
        this.inHour = LocalTime.parse(date);
    }

    public LocalTime getOpenHour() {
        // System.out.println(inHour);
        return this.inHour;
    }

    public LocalTime getEndingHour() {
        // System.out.println(inHour);
        return this.endHour;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public void getRank() {
        System.out.println(this.rank);
    }
}
