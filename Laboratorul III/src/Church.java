public class Church extends Location implements Visitable {
    String openingHour;
    String endingingHour;

    public Church(String name) {
        super(name);
    }

    public void setOpenHour(String date) {
        this.openingHour = date;
    }

    public void setEndingHour(String date) {
        this.endingingHour = date;
    }

    public void getOpenHour() {
        System.out.println(this.openingHour);
    }

    public void getEndingHour() {
        System.out.println(this.endingingHour);
    }
}
