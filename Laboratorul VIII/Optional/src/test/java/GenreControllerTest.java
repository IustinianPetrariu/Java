import org.junit.Test;

import static org.junit.Assert.*;

public class GenreControllerTest {

    @Test
    public void findByName() {
        GenreController genre = new GenreController();
        assertEquals("Action 21", genre.findByName("Action"));

    }

    @Test
    public void findById() {
        GenreController genre = new GenreController();
        assertEquals("Comedy 33", genre.findById(33));
    }
}