package BL;

import Controller.CTerminal;

import java.util.ArrayList;

/**
 * <h>BTerminal</h>
 *
 * <p>We use the class to transfer CTerminal print values.</p>
 *
 * @author Salih ÖZYURT
 * @version 1.0
 */
public class BTerminal {

    private CTerminal cTerminal = new CTerminal();

    public void printBeforeRollDice(BPlayer bPlayer) {
        cTerminal.printBeforeRollDice(bPlayer);
    }

    public void printDicesFaces(int[] diceValues){
        cTerminal.printDicesFaces(diceValues);
    }

    public void printLocationType(String squareLocation){
        cTerminal.printLocationType(squareLocation);
    }

    public void printAfterRollDice(BPlayer bPlayer){
        cTerminal.printAfterRollDice(bPlayer);
    }

    public void printWinnerPlayer(BPlayer bPlayer){ cTerminal.printWinnerPlayer(bPlayer); }

    public void printGameOver(ArrayList eliminatedList){
        cTerminal.printGameOver(eliminatedList);
    }
}


