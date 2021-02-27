import java.util.Objects;

/**
 * By the help of this class you cand create and customize your own destination.
 * You are allowed to create a Destination using this class and set a name or a demand for it;
 * Be careful, you are not allow to create the same Destination object twice!
 */
public class Destination {
    public static Destination[] instances = new Destination[1000];
    public static int numberOfInstances = 0;
    private String name;
    private int demands;
    /// each destination will have a certain amount of commodities;

    /**
     * here is a ovveride to test not to instantiate the same object twice
     *
     * @param o is an object of type Destination
     * @return true or false if the instance of the destination already exist or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return demands == that.demands && Objects.equals(name, that.name);
    }

    /**
     * This function test not to instantiate two object in a similar way
     *
     * @param name   you define your own name and set it for the Destination
     * @param amount you define your own amount and set it for the Destination
     * @throws Exception "You are not allow to add the same destination again!"
     */
    public Destination(String name, int amount) throws Exception {
        this.name = name;
        this.demands = amount;
        for (int i = 0; i < numberOfInstances; i++)
            if (equals(instances[i])) {
                throw new Exception("You are not allow to add the same source again!");
            }
        instances[numberOfInstances] = this;
        Destination.numberOfInstances++;

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

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", demands=" + demands +
                '}';
    }
}
