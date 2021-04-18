import com.opencsv.CSVReader;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        System.out.println("all good!");

        GenreController genres = new GenreController();
        MovieController movies = new MovieController();
        ActorController actors = new ActorController();
        DirectorController directors = new DirectorController();
        //// comenzi pentru interactiunea cu baza de date

//        List<Movie> movieList = new ArrayList<>();
//        movieList = movies.getAllMovies();
//        System.out.println(movieList.size());
//        directors.add(33, "Alex Timofte","Romania", "Vine trenul");
//        directors.findById(33);
//        actors.findById(21);
//        actors.findByName("John");
//        actors.add(21,"John","Germany");
//        movies.populateWithData();
//        AssociationController association = new AssociationController();
//        System.out.println( association.findByIdMovie(55) );
//        association.create(55,21);
//        movies.add(55,"Fast and Furious 5", 2012,215,7.8);
//        movies.add(57,"Fast and Furious 6", 2014,201,8.1);
//        movies.add(61,"Fast and Furious 7", 2017,220,9.0);
//        genres.create(21,"Action");
//        genres.create(14,"Drama");
//        genres.create(21,"Thriller");
//        genres.create(33,"Comedy");
//        System.out.println( genres.findByName("Action") );
//        System.out.println(  genres.findById(33) );
//        movies.findByName("Fast and Furious 5");
//        movies.findById(55);

    }
}
