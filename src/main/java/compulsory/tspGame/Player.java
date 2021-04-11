package compulsory.tspGame;

import lombok.*;
import org.apache.log4j.BasicConfigurator;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Player {
    static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Player.class);
    private String name;
    private List<Token> playersTokens;

    /**
     * Constructor
     * @param name
     */
    public Player(String name) {
        this.name = name;
        this.playersTokens = new ArrayList<>();
    }

    /**
     * This method add chosen token to the player's token list
     * @param token
     */
    public void addToken(Token token) {
        playersTokens.add(token);
    }

    /**
     * This method  print player's tokens
     */
    public void printAllTokens() {

        BasicConfigurator.configure();

        log.info( "The" + name +"'s tokens: " );
        for (Token token : playersTokens) {
            log.info("[" + token.getIndex() + "," + token.getValue() + "]");
        }
    }
}