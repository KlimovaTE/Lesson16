import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.*;

public class Game {
    List<Player> players = new ArrayList<>();

    public List<Player> register(Player player) {
        players.add(player);
        return players;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).name.equals(playerName1)) {
                player1 = players.get(i);
            }
            if (players.get(i).name.equals(playerName2)) {
                player2 = players.get(i);
            }
        }
        if (player1 == null || player2 == null) {
            throw new NotFoundException(
                    "Нельзя сравнивать незарегистрированных игроков"
            );
        }
        if (player1.strength > player2.strength) {
            return 1;
        }
        if (player1.strength < player2.strength) {
            return 2;
        }
        return 0;
    }
}
