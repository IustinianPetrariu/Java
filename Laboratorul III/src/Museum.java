public class Museum extends Location implements Visitable, Payable {
    String openingHour;
    String endingingHour;
    double fee;

    public Museum(String name) {
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

    public void setEntryFee(double fee) {
        this.fee = fee;
    }

    public void getEntryFee() {
        System.out.println(this.fee);
    }

}
