import java.util.Objects;
/*
enum typeOfSource
{
    WAREHOUSE, FACTORY;
}
 */

/**
 * This is an abstract class used to create object od type: Warehouses and Factories.
 * By the help of this class you cand create and customize your own Source.
 * You are allowed to create a Source using this class and set a name or a supply for it;
 * Be careful, you are not allow to create the same Source object twice!
 */
public abstract class Source {

    public static Source[] instances = new Source[1000];
    public static int numberOfInstances = 0;
    private String name;
    private int capacity;
    //typeOfSource typeSource;
    /// make a constructor de set the type of the source

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return capacity == source.capacity && Objects.equals(name, source.name);
    }

    /**
     * This function test not to instantiate two object in a similar way
     *
     * @param name     you define your own name and set it for the Source
     * @param capacity you define your own capacity and set it for the Source
     * @throws Exception "You are not allow to add the same source again!"
     */
    public Source(String name, int capacity) throws Exception {
        //this.typeSource=myType;
        this.name = name;
        this.capacity = capacity;
        for (int i = 0; i < numberOfInstances; i++)
            if (equals(instances[i])) {
                throw new Exception("You are not allow to add the same source again!");
            }
        instances[numberOfInstances] = this;
        Source.numberOfInstances++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
