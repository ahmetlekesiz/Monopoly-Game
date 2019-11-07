package BL;

import Controller.CTerminal;
import DAL.DInstruction;
import DAL.DPlayer;

import java.util.ArrayList;

public class BTerminal {

    private CTerminal cTerminal = new CTerminal();

    public void printBeforeRollDice(DPlayer dPlayer) {
        cTerminal.printBeforeRollDice(dPlayer);
    }

    public void printDicesFaces(int[] diceValues){
        cTerminal.printDicesFaces(diceValues);
    }

    public void printLocationType(String squareLocation){
        cTerminal.printLocationType(squareLocation);
    }

    public void printAfterRollDice(DPlayer dPlayer){
        cTerminal.printAfterRollDice(dPlayer);
    }

    public void printWinnerPlayer(DPlayer dPlayer){
        cTerminal.printWinnerPlayer(dPlayer);
    }

    public void printGameOver(ArrayList eliminatedList){
        cTerminal.printGameOver(eliminatedList);
    }
}


