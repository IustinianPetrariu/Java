package factory;

import controller.ActorControllerJDBC;
import dao.ActorJDBC;
import entity.ActorJPA;

public class ManagerJDBC extends AbstractFactory implements Model {
    @Override
    public void createArtist(String name, String country) {
        ActorControllerJDBC actorControllerJDBC = new ActorControllerJDBC();
        ActorJDBC actorJDBC = new ActorJDBC();
        actorJDBC.setCountry(country);
        actorJDBC.setName(name);
        actorControllerJDBC.add(actorJDBC);

    }

    @Override
    public ActorJPA getArtistByName(String name) {
        return null;
    }
}
