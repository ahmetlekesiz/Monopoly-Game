package spring.consumer;

import BL.squares.BPropertySquare;
import DAL.DPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import BL.squares.BSquare;
import spring.log.Logger;

/**
 * A common Consumer class for objects in type of BSquare.
 * BSquare is an abstract method and it has numerous
 * offspring designed for various functionality.
 *
 * @author Muhammed Bera KOÇ
 * @since 1.3
 */
@Component
public class SquareConsumer {

    private BSquare square;

    @Autowired
    public void setSquare(BSquare square) {
        this.square = square;
    }

    public void conductAction(DPlayer dPlayer) {
        Logger.instance.LOGGER.log(Logger.DEFAULT_LEVEL, String.format(
                "Before: Name: [%s], Balance: [%d], Turn: [%d], Square: [%s], Square Name: [%s]", dPlayer.getPieceType(),
                dPlayer.getBalance(), dPlayer.getRoundValue(), square.getSQUARE_TYPE() ,square.name
        ));
        square.performOnLand(dPlayer);
        Logger.instance.LOGGER.log(Logger.DEFAULT_LEVEL, String.format(
                "After: Name: [%s], Balance: [%d], Turn: [%d]", dPlayer.getPieceType(), dPlayer.getBalance(),
                dPlayer.getRoundValue()
        ));
    }
}
