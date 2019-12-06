package Controller;


import BL.BPlayer;
import BL.squares.BPropertySquare;
import BL.squares.BSquare;
import DAL.DPlayer;
import UI.UITerminal;

import java.util.ArrayList;

/**
 * <h>CTerminal</h>
 *
 * <p>Controller for Terminal class which is used for during process of getting player data and printing them.</p>
 *
 * @author Ahmet LEKESİZ
 * @version 1.0
 */
public class CTerminal {

    private UITerminal uiTerminal = UITerminal.getInstance();

    public void printBeforeRollDice(BPlayer bPlayer) {
        uiTerminal.printBeforeRollDice(bPlayer);
    }

    public void printDicesFaces(int[] diceValues, BPlayer bPlayer){
        uiTerminal.printDicesFaces(diceValues, bPlayer);
    }

    public void printLuckCard(String nameOfCard){
        uiTerminal.printLuckCard(nameOfCard);
    }

    public void printAfterRollDice(BPlayer bPlayer, BSquare bSquare){
        uiTerminal.printAfterRollDice(bPlayer, bSquare);
    }

    public void printRentProcess(DPlayer dPlayer, BSquare bSquare){
        uiTerminal.printRentProcess(dPlayer,bSquare);
    }

    public void printBuyProcess(BPlayer bPlayer, BSquare bSquare){
        uiTerminal.printBuyProcess(bPlayer,bSquare);
    }

    public void printWinnerPlayer(BPlayer bPlayer){
        uiTerminal.printWinnerPlayer(bPlayer);
    }

    public void printGameOver(ArrayList eliminatedList){
        uiTerminal.printGameOver(eliminatedList);
    }

}