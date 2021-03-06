public class Church extends Location implements Payable {
    private double priceTicket;

    public Church(String nume, double price) {
        super(nume);
        this.priceTicket = price;
    }

    public void setTicketPrice(double price) {
        this.priceTicket = price;
    }

    public void getTicketPrice() {
        System.out.println(this.priceTicket);
    }

}
