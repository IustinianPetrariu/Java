import controller.GenreControllerJDBC;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenreControllerTest {

    @Test
    public void findByName() {
        GenreControllerJDBC genre = new GenreControllerJDBC();
        assertEquals("Action 21", genre.findByName("Action"));

    }

    @Test
    public void findById() {
        GenreControllerJDBC genre = new GenreControllerJDBC();
        assertEquals("Comedy 33", genre.findById(33));
    }
}