public class Destination {
    private String name;
    private int demands;

    /// each destination will have a certain amount of commodities;
    /// and this method help to create your own type of Destination
    /// with different values for amount
    public Destination(int amount) {
        this.demands = amount;
    }

    public void setDemand(int amount) {
        this.demands = amount;
    }

    public int getDemand() {
        return this.demands;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //// like the method from Source, this method print precious information about Destination that you create
    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", demands=" + demands +
                '}';
    }
}
