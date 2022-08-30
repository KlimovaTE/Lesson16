import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class GameTest {

    Game game = new Game();
    Player player1 = new Player(1, "name1", 10);
    Player player2 = new Player(2, "name2", 10);
    Player player3 = new Player(3, "name3", 20);
    Player player4 = new Player(4, "name4", 30);
    Player player5 = new Player(5, "name5", 1);
    Player player6 = new Player(6, "name6", 90);


    @Test
    public void registerTest() {
        game.register(player1);
        game.register(player2);
        game.register(player4);
        game.register(player3);

        HashMap<String, Player> actual = game.registeredPlayers;
        HashMap<String, Player> expected = new HashMap<>() {{
            put("name1", player1);
            put("name2", player2);
            put("name3", player3);
            put("name4", player4);
        }};

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundTest1() {
        game.register(player1);
        game.register(player2);
        game.register(player4);
        game.register(player3);

        int actual = 2;
        int expected = game.round("name1", "name3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundTest2() {
        game.register(player1);
        game.register(player2);
        game.register(player4);
        game.register(player3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("name1", "name6");
        });
    }

    @Test
    public void roundTest3() {
        game.register(player1);
        game.register(player2);
        game.register(player4);
        game.register(player3);

        int actual = 1;
        int expected = game.round("name4", "name1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundTest4() {
        game.register(player1);
        game.register(player2);
        game.register(player4);
        game.register(player3);

        int actual = 0;
        int expected = game.round("name1", "name1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundTest5() {
        game.register(player1);
        game.register(player2);
        game.register(player4);
        game.register(player3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("name5", "name6");
        });
    }
}
