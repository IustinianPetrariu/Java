import org.junit.Test;

import static org.junit.Assert.*;

public class AssociationControllerTest {

    @Test
    public void findByIdMovie() {
        AssociationController association = new AssociationController();
        //association.findByIdMovie(55);
        assertEquals("Id-ul filmului:55,id-ul genului:21", association.findByIdMovie(55));
    }

    @Test
    public void findByIdGender() {
        AssociationController association = new AssociationController();
        //association.findByIdMovie(55);
        assertEquals("Id-ul filmului:55,id-ul genului:21", association.findByIdGender(21));
    }

}