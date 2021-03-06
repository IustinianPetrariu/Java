public class Hotel extends Location implements Visitable, Classifiable {
    String openingHour;
    String endingingHour;
    double rank;

    public Hotel(String name) {
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

    public void setRank(double rank) {
        this.rank = rank;
    }

    public void getRank() {
        System.out.println(this.rank);
    }
}
