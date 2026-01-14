import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamesTest {

    @Test
    public void testSortByPreisLowToHigh() {

        // Arrange
        Games.gameList.clear();

        Games.gameList.add(new Games("Game A", 12, "Action", 80, 1, false, 30));
        Games.gameList.add(new Games("Game B", 18, "RPG", 90, 1, true, 10));
        Games.gameList.add(new Games("Game C", 6, "Puzzle", 70, 2, false, 20));

        // Act
        Games.gameList.sort((g1, g2) -> Integer.compare(g1.Preis, g2.Preis));

        // Assert
        assertEquals(10, Games.gameList.get(0).Preis);
        assertEquals(20, Games.gameList.get(1).Preis);
        assertEquals(30, Games.gameList.get(2).Preis);

    }
    @Test
    public void testSortByPreisHighToLow() {

        // Arrange
        Games.gameList.clear();

        Games.gameList.add(new Games("Game A", 12, "Action", 80, 1, false, 30));
        Games.gameList.add(new Games("Game B", 18, "RPG", 90, 1, true, 10));
        Games.gameList.add(new Games("Game C", 6, "Puzzle", 70, 2, false, 20));

        // Act (sort High -> Low)
        Games.gameList.sort((g1, g2) -> Integer.compare(g2.Preis, g1.Preis));

        // Assert
        assertEquals(30, Games.gameList.get(0).Preis);
        assertEquals(20, Games.gameList.get(1).Preis);
        assertEquals(10, Games.gameList.get(2).Preis);
    }
    @Test
    public void testCountMultiplayerGames() {

        // Arrange
        Games.gameList.clear();

        Games.gameList.add(new Games("Game A", 12, "Action", 80, 1, true, 30));
        Games.gameList.add(new Games("Game B", 18, "RPG", 90, 1, false, 10));
        Games.gameList.add(new Games("Game C", 6, "Puzzle", 70, 2, true, 20));

        // Act
        long multiplayerCount = Games.gameList.stream()
                .filter(game -> game.multiplayer)
                .count();

        // Assert
        assertEquals(2, multiplayerCount);
    }

}
