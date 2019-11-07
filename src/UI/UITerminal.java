package UI;

import BL.BPlayer;
import DAL.DInstruction;
import DAL.DPlayer;

import java.util.ArrayList;
import java.util.Iterator;

public class UITerminal {

    public void printCurrentJSONFile() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("PROPERTIES OF THE GAME");
        System.out.println("---------------------------------------------------------------------");
        System.out.println(DInstruction.getInstance());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("MONOPOLY GAME");
        System.out.println("---------------------------------------------------------------------");
    }

    public void printBeforeRollDice(DPlayer dPlayer) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Player Type :" + dPlayer.getPiece_type());
        System.out.println("Player Turn Counter :" + dPlayer.getPiece_type().getValue());
        System.out.println("Player Cycle Counter :" + dPlayer.getCycleCounter());
        System.out.println("Location Square :" + dPlayer.getLocation());
        System.out.println("Player Current Balance :" + dPlayer.getBalance());
        System.out.println("---------------------------------------------------------------------");
    }

    public void printDicesFaces(int[] diceValues){
        System.out.println("Rolling Dice : " + diceValues[0] + "+" + diceValues[1] + "=" + (diceValues[0] + diceValues[1]));
    }

    public void printLocationType(String squareLocation){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Square Type :" + squareLocation);
    }

    public void printAfterRollDice(DPlayer dPlayer){
        System.out.println("Player Location :" + dPlayer.getLocation());
        System.out.println("Player Balance After Rolling Dice :" + dPlayer.getBalance());
        System.out.println("---------------------------------------------------------------------");
    }

    public void printWinnerPlayer(DPlayer dPlayer){
        System.out.println("*************************************************************************");
        System.out.println("GAME OVER!!!");
        System.out.println("*************************************************************************");
        System.out.println("WINNER PLAYER!!!");
        System.out.println("*************************************************************************");
        System.out.println("Player Name :" + dPlayer.getPiece_type());
        System.out.println("Player Location :" + dPlayer.getLocation());
        System.out.println("Player Balance :" + dPlayer.getBalance());
        System.out.println("*************************************************************************");
    }

    public void printGameOver(ArrayList eliminatedList){
        System.out.println("ELIMINATED PLAYERS!!!");
        System.out.println("*************************************************************************");
        for (Iterator<BPlayer> iterator = eliminatedList.iterator(); iterator.hasNext();) {
            BPlayer eliminatedPlayer = iterator.next();
            System.out.println("Player Name :" + eliminatedPlayer.getDPlayer().getPiece_type());
            System.out.println("Player Location :" + eliminatedPlayer.getDPlayer().getLocation());
            System.out.println("Player Balance :" + eliminatedPlayer.getDPlayer().getBalance());
            System.out.println("*************************************************************************");
        }
    }
}