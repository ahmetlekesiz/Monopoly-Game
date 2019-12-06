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

    void printBeforeRollDice(BPlayer bPlayer) {
        cTerminal.printBeforeRollDice(bPlayer);
    }

    void printDicesFaces(int[] diceValues){
        cTerminal.printDicesFaces(diceValues);
    }

    void printLocationType(String squareLocation){
        cTerminal.printLocationType(squareLocation);
    }

    void printAfterRollDice(BPlayer bPlayer){
        cTerminal.printAfterRollDice(bPlayer);
    }

    void printWinnerPlayer(BPlayer bPlayer){ cTerminal.printWinnerPlayer(bPlayer); }

    void printGameOver(ArrayList eliminatedList){
        cTerminal.printGameOver(eliminatedList);
    }
}


