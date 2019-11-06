package BL;

import DAL.DPlayer;

public class BPlayer implements BPlayerObserver {

    private DPlayer dPlayer;

    public BPlayer(DPlayer dPlayer) {
        this.dPlayer = dPlayer;
    }

    @Override
    public void checkPlayer(int currentDiceValue, BSquare currentSquare) {
        if (isPlayerBankrupted()) {
            dPlayer.setBankruptFlag(true);
        }
        dPlayer.setTotalDiceValue(dPlayer.getTotalDiceValue() + currentDiceValue);
        if (isPlayerCrossTheGoSquare()) {
            dPlayer.setRoundValue(dPlayer.getRoundValue() + 1);
            new BGoSquare().performOnLand(dPlayer);
        }
        currentSquare.performOnLand(dPlayer);
    }

    public int rollDice(){
        int[] diceVal;
        int dice1Val,dice2Val;

        diceVal = this.getDPlayer().getPlayerDice().rollDice();
        dice1Val = diceVal[0];
        dice2Val = diceVal[1];
        this.getDPlayer().setCurrentDiceVal(dice1Val+dice2Val);
        return dice1Val + dice2Val;
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
