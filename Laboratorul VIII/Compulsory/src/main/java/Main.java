import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        System.out.println("all good!");

        GenreController genres = new GenreController();
        MovieController movies = new MovieController();
        AssociationController association = new AssociationController();
        /// comenzi pentru interactiunea cu baza de date :

        System.out.println(association.findByIdMovie(55));
//        association.create(55,21);
//        movies.add(55,"Fast and Furious 5", 2012,215,7.8);
//        movies.add(57,"Fast and Furious 6", 2014,201,8.1);
//        movies.add(61,"Fast and Furious 7", 2017,220,9.0);
//        genres.create(21,"Action");
//        genres.create(14,"Drama");
//        genres.create(21,"Thriller");
//        genres.create(33,"Comedy");
 //         System.out.println( genres.findByName("Action") );
//        System.out.println(  genres.findById(33) );
//        movies.findByName("Fast and Furious 5");
//        movies.findById(55);


    }
}
