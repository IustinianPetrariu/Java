import controller.*;
import entity.ActorJPA;
import dao.DirectorJDBC;


public class Main {

    public static void main(String[] args) {
        System.out.println("all good!");

        GenreControllerJDBC genres = new GenreControllerJDBC();
        MovieControllerJDBC movies = new MovieControllerJDBC();
        ActorControllerJDBC actors = new ActorControllerJDBC();
        DirectorControllerJDBC directors = new DirectorControllerJDBC();
        DirectorJDBC director1 = new DirectorJDBC(1, "Vlad", "Romania", "Spartans");
        ActorControllerJPA actorControllerJPA = new ActorControllerJPA(FactoryManager.getConnection());
        ActorJPA actorJPA = new ActorJPA();
        actorJPA = actorControllerJPA.findByName("Vladimir");
        System.out.println(actorJPA.getName());


        ///interactiunea cu baza de date + teste
//        System.out.println(actorJPA.getName());

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


    }
}
