package Controller;

import DAL.DPiece;
import DAL.DPlayer;
import spring.config.squares.GoSquareConfiguration;
import spring.consumer.SquareConsumer;
import spring.factory.BeanCreator;

/**
 * <h>Main</h>
 *
 * <p>Main class of Monopoly Game. Creating controller object of Monopoly Game and getting instructions.
 * Then, starting game by using Monopoly Game object.</p>
 *
 * @author Ahmet LEKESİZ
 * @version 1.0
 */
public class Main {

    public static final String INSTRUCTION_FILENAME = "game.json";
    public static final Integer PLACE_NUMBER = 40;
    // User can change this value.
    public static final Integer ROUND_LIMIT = 10000;

    public static void main(String[] args) {
        CMonopolyGame monopolyGame = CMonopolyGame.getInstance(INSTRUCTION_FILENAME);
        /*BeanCreator.instance.createBean(GoSquareConfiguration.class, SquareConsumer.class).conductAction(
                new DPlayer(DPiece.PieceType.BATTLESHIP, 1000)
        );*/
        monopolyGame.start();
    }
}
