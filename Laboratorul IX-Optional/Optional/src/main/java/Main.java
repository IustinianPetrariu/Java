import controller.*;
import entity.ActorJPA;
import dao.DirectorJDBC;
import factory.AbstractFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("all good!");

        try {
            Scanner scanner = new Scanner(new File("E:\\FII\\Semestrul IV\\Programare avansata\\Laboratorul IX\\Optional\\config.txt"));
            String result = scanner.nextLine();
            AbstractFactory abstractFactory = AbstractFactory.getMethod(result);

            ActorJPA actorJPA = abstractFactory.getArtistByName("Ion");
            System.out.println(actorJPA.getName());


        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }


        ///make the controllers for JDBC
//        GenreControllerJDBC genreControllerJDBC = new GenreControllerJDBC();
//        MovieControllerJDBC movieControllerJDBC = new MovieControllerJDBC();
//        ActorControllerJDBC actorControllerJDBC = new ActorControllerJDBC();
//        DirectorControllerJDBC directorControllerJDBC = new DirectorControllerJDBC();

        ///make the controllers for JPA
//        ActorControllerJPA actorControllerJPA = new ActorControllerJPA(FactoryManager.getConnection());
//        AbstractController<ActorControllerJPA, ActorJPA> controller = new AbstractController<>(FactoryManager.getConnection());


        ///make instances of object in order to work with controllers

//        DirectorJDBC directorA = new DirectorJDBC(1, "Vlad", "Romania", "Spartans");
//        ActorJPA actorJPA = new ActorJPA();
//        actorJPA.setCountry("Rusia");
//        actorJPA.setName("Vladimir");
        /// now we only use controller in order to create instances in database
//        controller.create(actorJPA);


//        actorJPA = actorControllerJPA.findByid(1);
//        System.out.println(actorJPA.getCountry());
//        actorJPA = actorControllerJPA.findByName("Johnu");
//        System.out.println(actorJPA.getName());


//        artistJohn.setCountry("Italia");
//        artistJohn.setName("Johnu");
//        actorJPA.create(artistJohn);


//        directors.add(director1);

//        ActorJDBC actor1 = new ActorJDBC(1, "James", "England");
//        actors.add(actor1);


//        MovieJDBC movie1 = new MovieJDBC(1,"Titanic",2003,145,9.0);
//        movies.add(movie1);


//        List<MovieJDBC> movieList = new ArrayList<>();
//        movieList = movies.getAllMovies();


    }
}
