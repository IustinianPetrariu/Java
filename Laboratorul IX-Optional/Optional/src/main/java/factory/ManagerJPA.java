package factory;

import controller.AbstractController;
import controller.ActorControllerJPA;
import controller.FactoryManager;
import entity.ActorJPA;

public class ManagerJPA extends AbstractFactory  implements Model{

    public void createArtist(String name, String country)
    {
        ActorJPA actor =  new ActorJPA();
        actor.setName(name);
        actor.setCountry(country);
        AbstractController<ActorControllerJPA, ActorJPA> controller = new AbstractController<>(FactoryManager.getConnection());
        controller.create(actor);
    }

    @Override
    public ActorJPA getArtistByName(String name) {

          //AbstractController<ActorControllerJPA,ActorJPA> controller = new AbstractController<>(FactoryManager.getConnection());
           ActorControllerJPA actorControllerJPA = new ActorControllerJPA(FactoryManager.getConnection());
          return  actorControllerJPA.findByName(name);
    }


}
