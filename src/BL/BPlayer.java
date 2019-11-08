package BL;

import DAL.DPlayer;

public class BPlayer implements BPlayerObserver {

    private DPlayer dPlayer;
    private BTerminal bTerminal = new BTerminal();

    public BPlayer() {
    }

    public BPlayer(DPlayer dPlayer) {
        this.dPlayer = dPlayer;
    }

    @Override
    public void checkAndUpdatePlayer(int currentDiceValue, BSquare currentSquare) {
        if (isPlayerCrossTheGoSquare()) {
            dPlayer.setRoundValue(dPlayer.getRoundValue() + 1);
            new BGoSquare().performOnLand(dPlayer);
            return;
        }
        currentSquare.performOnLand(dPlayer);
        if (isPlayerBankrupted()) {
            dPlayer.setBankruptFlag(true);
        }
    }

    public int rollDice(){
        int[] diceValues;
        diceValues = this.getDPlayer().getPlayerDice().rollDice();
        this.getDPlayer().setCurrentDiceVal(diceValues[0] + diceValues[1]);
        bTerminal.printDicesFaces(diceValues);
        return diceValues[0] + diceValues[1];
    }

    private boolean isPlayerCrossTheGoSquare() {
        return (int) Math.floor(dPlayer.getTotalDiceValue() / 40f) != dPlayer.getRoundValue();
    }

    private boolean isPlayerBankrupted() {
        return dPlayer.getBalance() < 0;
    }

    public DPlayer getDPlayer() {
        return dPlayer;
    }
}
