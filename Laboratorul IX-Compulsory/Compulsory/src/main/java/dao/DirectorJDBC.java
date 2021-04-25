package dao;

public class DirectorJDBC {
    private int id;
    private String name;
    private String country;
    private String movie;

    public DirectorJDBC() {
    }

    public DirectorJDBC(int id, String name, String country, String movie) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.movie = movie;
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

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }


}
