package compulsory;

import java.util.Scanner;

import compulsory.tspGame.Game;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {

    static final Logger log = Logger.getLogger(Main.class);


    public static void main(String[] args) {
        BasicConfigurator.configure();
        try {
            Scanner input = new Scanner(System.in);
            log.info("Number of players:");

            int nrPlayers = input.nextInt();
            log.info("Number of tokens:");

            int nrTokens = input.nextInt();

            Game game = new Game(nrPlayers, nrTokens);

            game.startGame();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}