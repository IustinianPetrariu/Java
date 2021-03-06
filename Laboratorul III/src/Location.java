import java.util.HashMap;
import java.util.Map;


//// this class will help us to store the location because locations have some common properties ( such as description
/// or name, etc ) so is easy to use an abstract class to help store a location based on this common properties
/// further more we will make a specific cast in order to obtain some properties that are only specific to some locations

public abstract class Location {
    private String name;
    /// each location containt this map to store the distances to other locations
    private Map<String, Integer> map = new HashMap<>();

    public Location(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    ///this method set a distance to a specific location that we want
    public void setDistancesTo(Location location, int minutes) {
        this.map.put(location.name, minutes);
    }

    public void getDistances() {
        System.out.println("from " + this.name + " all distances are: ");
        System.out.println(map);
    }


}
