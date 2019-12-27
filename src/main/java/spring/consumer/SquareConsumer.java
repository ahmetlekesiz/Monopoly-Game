package spring.consumer;

import DAL.DPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import BL.squares.BSquare;
import spring.log.Logger;

@Component
public class SquareConsumer {

    private BSquare square;

    @Autowired
    public void setSquare(BSquare square) {
        this.square = square;
    }

    public void conductAction(DPlayer dPlayer) {
        Logger.instance.LOGGER.log(Logger.DEFAULT_LEVEL, String.format(
                "Before: Name: [%s], Balance: [%d], Turn: [%d], Square: [%s]", dPlayer.getPieceType(),
                dPlayer.getBalance(), dPlayer.getRoundValue(), square.getSQUARE_TYPE()
        ));
        square.performOnLand(dPlayer);
        Logger.instance.LOGGER.log(Logger.DEFAULT_LEVEL, String.format(
                "Before: Name: [%s], Balance: [%d], Turn: [%d]", dPlayer.getPieceType(), dPlayer.getBalance(),
                dPlayer.getRoundValue()
        ));
    }
}
