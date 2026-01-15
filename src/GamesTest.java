import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamesTest {

    @Test
    void initObjects() { Games.initObjects();
        assertEquals(3, Games.gameList.size());
    }




}
