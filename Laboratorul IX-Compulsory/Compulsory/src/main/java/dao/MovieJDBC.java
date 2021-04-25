package dao;

public class MovieJDBC {

    private int id;
    private String title;
    private int releaseDate;
    private int durationTime;
    private double score;

    public MovieJDBC(int id, String title, int releaseDate, int durationTime, double score) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.durationTime = durationTime;
        this.score = score;
    }

    public MovieJDBC() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }
}
