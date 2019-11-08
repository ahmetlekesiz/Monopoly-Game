package BL;

import Controller.CTerminal;
import DAL.DInstruction;
import DAL.DPlayer;

import java.util.ArrayList;

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


