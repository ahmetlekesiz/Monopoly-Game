package Controller;


import BL.BPlayer;
import DAL.DPlayer;
import UI.UITerminal;

import java.util.ArrayList;

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