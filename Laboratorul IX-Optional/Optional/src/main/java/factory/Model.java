package factory;

interface Model {

    /// all table should implements or should have this method
    /// in order to interact with database properly

    public void createArtist(String name, String country);

    public <T> T getArtistByName(String nume);
}
