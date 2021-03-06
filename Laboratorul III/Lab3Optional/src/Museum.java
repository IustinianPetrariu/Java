import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable {
    private LocalTime inHour;
    private LocalTime endHour;
    private double price;

    public Museum(String name, String openHour, String endingHour) {
        super(name);
        this.inHour = LocalTime.parse(openHour);
        this.endHour = LocalTime.parse(endingHour);
    }

    public Museum(String name) {
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

    public void setTicketPrice(double price) {
        this.price = price;
    }

    public void getTicketPrice() {
        System.out.println(this.price);
    }

}
