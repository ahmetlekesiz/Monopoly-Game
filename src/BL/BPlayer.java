package BL;

import BL.squares.BGoSquare;
import BL.squares.BPropertySquare;
import BL.squares.BSquare;
import BL.squares.PropertyType;
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
            new BGoSquare(PropertyType.NOCOLOR).performOnLand(getDPlayer());
            if (currentSquare instanceof BGoSquare) return;
        }
        currentSquare.performOnLand(getDPlayer());

        if (isPlayerBankrupted()) {
            if(!tryToSellProperty(currentSquare)){
                dPlayer.setBankruptFlag(true);
            }
        }
    }

    private boolean tryToSellProperty(BSquare currentSquare) {
        if (!dPlayer.getPropertySquares().isEmpty()) {
            int debt = currentSquare.getRent();
            int currentPrice = this.getDPlayer().getBalance();
            for (int i = 0; i < dPlayer.getPropertySquares().size() && currentPrice < debt; ++i) {
                currentPrice += dPlayer.getPropertySquares().get(i).getPrice();
                sellSquare(dPlayer.getPropertySquares().get(i));
            }
            return currentPrice >= debt;
        } else {
            return false;
        }
    }

    private void sellSquare(BSquare square) {
        square.setOwnerOfSquare(null);
        this.getDPlayer().setBalance(this.getDPlayer().getBalance() + square.getPrice());
    }

    /**
     * Rolls a dice. Faces cannot be the same.
     * @return int
     */
    int rollDice(){
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

    void buy(BPropertySquare currentSquare){
            int price = currentSquare.getPrice();
            this.getDPlayer().setBalance(this.getDPlayer().getBalance() - price);
            this.getDPlayer().addPropertySquares(currentSquare);
            this.sortSquares();
    }

    boolean isAbleToBuy(BPropertySquare currentSquare){
        int price = currentSquare.getPrice();
        if(this.getDPlayer().getBalance() < 2*price){
            return false;
        }
            return true;
    }

    private void sortSquares(){
        this.getDPlayer().getPropertySquares().sort((firstSquare, secondSquare) -> {
            if (firstSquare.getPrice() == secondSquare.getPrice())
                return 0;
            return firstSquare.getPrice() > secondSquare.getPrice() ? -1 : 1;
        });
    }

    public DPlayer getDPlayer() {
        return dPlayer;
    }
}
