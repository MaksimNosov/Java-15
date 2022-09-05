import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.org.Game;
import ru.netology.org.NotRegisteredException;
import ru.netology.org.Player;

public class GameTest {
    Player player1 = new Player("Igrok 1", 100);
    Player player2 = new Player("Igrok 2", 202);
    Player player3 = new Player("Igrok 3", 330);
    Player player4 = new Player("Igrok 4", 202);

    Game game = new Game();

    @BeforeEach
    public void setUp() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void shouldWinGamer1() {

        int expected = 1;
        int actual = game.round("Igrok 3", "Igrok 2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinGamer2() {

        int expected = 2;
        int actual = game.round("Igrok 1", "Igrok 2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() {

        int expected = 0;
        int actual = game.round("Igrok 2", "Igrok 4");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noRegistrationGamer1() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Igrok 8", "Igrok 2");
        });
    }

    @Test
    public void noRegistrationGamer2() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Igrok 3", "Igrok 5");
        });
    }
}
