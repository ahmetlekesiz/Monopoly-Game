package BL;

import DAL.DPlayer;

public class BPlayer implements BPlayerObserver {

    private DPlayer dPlayer;

    public BPlayer() {
    }

    public BPlayer(DPlayer dPlayer) {
        this.dPlayer = dPlayer;
    }

    @Override
    public void checkAndUpdatePlayer(int currentDiceValue, BSquare currentSquare, boolean isFirstRound) {
        if (isPlayerBankrupted()) {
            dPlayer.setBankruptFlag(true);
        }
        dPlayer.setTotalDiceValue(dPlayer.getTotalDiceValue() + currentDiceValue);

        if (isFirstRound && !(currentSquare instanceof BTaxSquare)) return;
            if (isPlayerCrossTheGoSquare()) {
                dPlayer.setRoundValue(dPlayer.getRoundValue() + 1);
                new BGoSquare().performOnLand(dPlayer);
                return;
            }
            currentSquare.performOnLand(dPlayer);

    }

    public int rollDice(){
        int[] diceValues;
        diceValues = this.getDPlayer().getPlayerDice().rollDice();
        this.getDPlayer().setCurrentDiceVal(diceValues[0] + diceValues[1]);
        System.out.println("Rolling Dices : "+diceValues[0]+"+"+diceValues[1]+"="+(diceValues[0]+diceValues[1]));
        return diceValues[0] + diceValues[1];
    }

    private boolean isPlayerCrossTheGoSquare() {
        return (int) Math.floor(dPlayer.getTotalDiceValue() / 40f) != dPlayer.getRoundValue();
    }

    private boolean isPlayerBankrupted() {
        return dPlayer.getBalance() <= 0;
    }

    public DPlayer getDPlayer() {
        return dPlayer;
    }
}
