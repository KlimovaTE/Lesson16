import java.util.HashMap;

public class Game {
    HashMap<String, Player> registeredPlayers = new HashMap<>();

    public HashMap register(Player player) {
        registeredPlayers.put(player.name, player);
        return registeredPlayers;
    }

    public int round(String playerName1, String playerName2) {
        boolean has1 = registeredPlayers.containsKey(playerName1);
        boolean has2 = registeredPlayers.containsKey(playerName2);
        if (has1 && has2) {
            Player player1InRound = registeredPlayers.get(playerName1);
            Player player2InRound = registeredPlayers.get(playerName2);
            if (player1InRound.strength > player2InRound.strength) {
                return 1;
            }
            if (player1InRound.strength < player2InRound.strength) {
                return 2;
            }
            return 0;
        } else {
            throw new NotFoundException(
                    "Нельзя сравнивать незарегистрированных игроков"
            );

        }
    }
}
