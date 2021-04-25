package dao;

public class ActorJDBC {

    private String country;
    private int id;
    private String name;

    public ActorJDBC() {
    }

    public ActorJDBC(int id, String name, String country) {
        this.country = country;
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
