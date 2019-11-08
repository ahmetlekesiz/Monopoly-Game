package Controller;


import BL.BPlayer;
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

    private UITerminal uiTerminal = new UITerminal();

    public void printBeforeRollDice(BPlayer bPlayer) {
        uiTerminal.printBeforeRollDice(bPlayer);
    }

    public void printDicesFaces(int[] diceValues){
        uiTerminal.printDicesFaces(diceValues);
    }

    public void printLocationType(String squareLocation){
        uiTerminal.printLocationType(squareLocation);
    }

    public void printAfterRollDice(BPlayer bPlayer){
        uiTerminal.printAfterRollDice(bPlayer);
    }

    public void printWinnerPlayer(BPlayer bPlayer){
        uiTerminal.printWinnerPlayer(bPlayer);
    }

    public void printGameOver(ArrayList eliminatedList){
        uiTerminal.printGameOver(eliminatedList);
    }

}