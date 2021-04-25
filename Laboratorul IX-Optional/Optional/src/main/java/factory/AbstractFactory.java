package factory;

import entity.ActorJPA;

public abstract class AbstractFactory implements Model {

    ///we have to choose between these two implementation:

    private static final ManagerJDBC managerJDBC = new ManagerJDBC();
    private static final ManagerJPA managerJPA = new ManagerJPA();

    public static AbstractFactory getMethod(String method) {
        AbstractFactory abstractFactory = null;
        if (method.equals("JPA"))
            abstractFactory = managerJPA;
        else {
            abstractFactory = managerJDBC;
        }
        return abstractFactory;
    }
//    public abstract void createArtist(String name, String country);
//    public abstract <T> T getArtistByName(String name);


}
