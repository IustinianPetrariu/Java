import java.util.HashMap;
import java.util.Map;

public abstract class Location {
    private String name;
    protected Map<String, Integer> map = new HashMap<>();

    public Location(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDistancesTo(Location location, int minutes) {
        this.map.put(location.name, minutes);
    }

    public void getDistances() {

        System.out.println("from " + this.name + " all distances are: ");
        System.out.println(map);
    }
}
