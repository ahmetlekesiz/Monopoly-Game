package BL;

import DAL.DPlayer;

public class BPlayer implements BPlayerObserver {

    private DPlayer dPlayer;

    public BPlayer(DPlayer dPlayer) {
        this.dPlayer = dPlayer;
    }

    @Override
    public void checkPlayer(int currentDiceValue, BSquare currentSquare) {
        dPlayer.setTotalDiceValue(dPlayer.getTotalDiceValue() + currentDiceValue);
        if (isPlayerCrossTheGoSquare()) {
            dPlayer.setRoundValue(dPlayer.getRoundValue() + 1);
            new BGoSquare().performOnLand(dPlayer);
        }
        switch (currentSquare.getSQUARE_TYPE()) {
            // For further implementation
            case "REGULAR_SQUARE": break;
            case "TAX_SQUARE": new BTaxSquare().performOnLand(dPlayer);
        }
    }

    private boolean isPlayerCrossTheGoSquare() {
        return (int) Math.floor(dPlayer.getTotalDiceValue() / 40f) != dPlayer.getRoundValue();
    }

    public DPlayer getDPlayer() {
        return dPlayer;
    }
}
