package compulsory.tspGame;

import lombok.*;

import java.util.List;
import java.util.Random;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Turn implements Runnable {
    private Player player;
    private List<Token> tokens;

    /**
     * Constructor
     * @param player
     * @param tokens
     */
    public Turn(Player player, List<Token> tokens) {
        this.player = player;
        this.tokens = tokens;
    }

    @Override
    public void run() {
        Random rand = new Random();
        Token token = tokens.get(rand.nextInt(tokens.size()));
        player.addToken(token);
    }
}