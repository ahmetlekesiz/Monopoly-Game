package BL;

import DAL.DPlayer;

/***
 *BPlayer is player class in Business Layer.
 * All methods of players implemented here.
 *
 * @author Mücahit Tanacıoğlu
 * @version 1.0
 * @since 11.
 */

public class BPlayer implements BPlayerObserver {

    private DPlayer dPlayer;
    private BTerminal bTerminal = new BTerminal();

    public BPlayer() {

    }

    public BPlayer(DPlayer dPlayer) {
        this.dPlayer = dPlayer;
    }

    /**
     *<p>This method get calls after each player roll dice, it takes current dice value of player and the square player going to move.</p>
     * <p>Checks player whether bankrupted or not and calls corresponding performOnLand method for currentSquare.</p>
     *
     * @param currentDiceValue The  total dice value after player roll dice.
     * @param currentSquare A BSquare object which is player going to move.
     *
     * @return void
     */
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

    /**
     *
     * @return int
     */
    public int rollDice(){
        int[] diceValues;
        diceValues = this.getDPlayer().getPlayerDice().rollDice();
        this.getDPlayer().setCurrentDiceVal(diceValues[0] + diceValues[1]);

        bTerminal.printDicesFaces(diceValues);
        return diceValues[0] + diceValues[1];
    }
    /**
     *<p>Checks whether player pass the start square.</p>
     * @return boolean
     */
    private boolean isPlayerCrossTheGoSquare() {
        return (int) Math.floor(dPlayer.getTotalDiceValue() / 40f) != dPlayer.getRoundValue();
    }

    /**
     * <p>Checks whether player bankrupted or not.</p>
     * @return boolean
     */
    private boolean isPlayerBankrupted() {
        return dPlayer.getBalance() < 0;
    }

    private boolean buy(int price,boolean isBuyable){
        if(isBuyable){
            if(this.getDPlayer().getBalance() < price)
                return false;
            this.getDPlayer().setBalance(this.getDPlayer().getBalance() - price);
            return true;
        }else
            return  false;
    }

    public DPlayer getDPlayer() {
        return dPlayer;
    }
}
