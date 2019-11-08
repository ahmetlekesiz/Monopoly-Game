package UI;

import BL.BPlayer;
import Controller.CInstruction;

import java.util.ArrayList;
import java.util.Iterator;

public class UITerminal {

    public void printCurrentJSONFile() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("PROPERTIES OF THE GAME");
        System.out.println("---------------------------------------------------------------------");
        System.out.println(CInstruction.getDInstruction());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("MONOPOLY GAME");
        System.out.println("---------------------------------------------------------------------");
    }

    public void printBeforeRollDice(BPlayer bPlayer) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Player Type :" + bPlayer.getDPlayer().getPieceType());
        System.out.println("Player Turn Counter :" + bPlayer.getDPlayer().getPieceType().getValue());
        System.out.println("Player Cycle Counter :" + bPlayer.getDPlayer().getCycleCounter());
        System.out.println("Location Square :" + bPlayer.getDPlayer().getLocation());
        System.out.println("Player Current Balance :" + bPlayer.getDPlayer().getBalance());
        System.out.println("---------------------------------------------------------------------");
    }

    public void printDicesFaces(int[] diceValues){
        System.out.println("Rolling Dice : " + diceValues[0] + "+" + diceValues[1] + "=" + (diceValues[0] + diceValues[1]));
    }

    public void printLocationType(String squareLocation){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Square Type :" + squareLocation);
    }

    public void printAfterRollDice(BPlayer bPlayer){
        System.out.println("Player Location :" + bPlayer.getDPlayer().getLocation());
        System.out.println("Player Balance After Rolling Dice :" + bPlayer.getDPlayer().getBalance());
        System.out.println("---------------------------------------------------------------------");
    }

    public void printWinnerPlayer(BPlayer bPlayer){
        System.out.println("*************************************************************************");
        System.out.println("GAME OVER!!!");
        System.out.println("*************************************************************************");
        System.out.println("WINNER PLAYER!!!");
        System.out.println("*************************************************************************");
        System.out.println("Player Name :" + bPlayer.getDPlayer().getPieceType());
        System.out.println("Player Location :" + bPlayer.getDPlayer().getLocation());
        System.out.println("Player Balance :" + bPlayer.getDPlayer().getBalance());
        System.out.println("*************************************************************************");
    }

    public void printGameOver(ArrayList eliminatedList){
        System.out.println("ELIMINATED PLAYERS!!!");
        System.out.println("*************************************************************************");
        for (Iterator<BPlayer> iterator = eliminatedList.iterator(); iterator.hasNext();) {
            BPlayer eliminatedPlayer = iterator.next();
            System.out.println("Player Name :" + eliminatedPlayer.getDPlayer().getPieceType());
            System.out.println("Player Location :" + eliminatedPlayer.getDPlayer().getLocation());
            System.out.println("Player Balance :" + eliminatedPlayer.getDPlayer().getBalance());
            System.out.println("*************************************************************************");
        }
    }
}