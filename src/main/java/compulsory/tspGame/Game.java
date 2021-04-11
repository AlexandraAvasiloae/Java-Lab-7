package compulsory.tspGame;

import compulsory.exceptions.InvalidInput;
import lombok.*;
import org.apache.log4j.BasicConfigurator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Game {
    static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Game.class);

    private int nrPlayers;
    private int nrTokens;
    private List<Player> players;
    private List<Token> tokens;
    ExecutorService executor;

    /**
     * Constructor
     * @param nrPlayers
     * @param nrTokens
     * @throws InvalidInput
     */
    public Game(int nrPlayers, int nrTokens) throws InvalidInput {
        if (nrPlayers <= 0) {
            throw new InvalidInput(nrPlayers + " is wrong number of players!");
        }
        if (nrTokens <= 0) {
            throw new InvalidInput(nrTokens + " is wrong number of tokens!");
        }
        this.nrPlayers = nrPlayers;
        this.nrTokens = nrTokens;
        players = new ArrayList<>(nrPlayers);
        tokens = new CopyOnWriteArrayList<>();
        executor = Executors.newFixedThreadPool(nrPlayers);
    }


    /**
     * This method add tokens in the game
     */
    public void addTokens() {
        for (int i = 1; i <= nrTokens; i++) {
            Random rand = new Random();
            int j = rand.nextInt(nrTokens) + 1;
            tokens.add(new Token(i, j));
        }
    }
    /**
     * This mathod add players in the game
     */
    public void addPlayers() {
        for (int i = 0; i < nrPlayers; i++) {
            players.add(new Player("compulsory.tspGame.Player" + i));
        }
    }

    /**
     * This method play the game in turns
     */
    public synchronized void playGame() {
        while (tokens.size() > 0) {
            for (int i = 0; i < nrPlayers; i++) {
                if (tokens.size() > 0) {
                    executor.execute(new Turn(players.get(i), tokens));
                }
            }
        }
    }
    /**
     * Method to start the game
     */
    public void startGame() {
        addPlayers();
        addTokens();
        playGame();
        printResult();
    }
    /**
     * This method print the result after the game is finished
     */
    public void printResult() {
        BasicConfigurator.configure();
        log.info("The game is over. ");
        for (Player player : players) {
            player.printAllTokens();
        }
    }

}