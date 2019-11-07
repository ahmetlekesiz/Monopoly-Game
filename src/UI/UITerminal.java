package UI;

import DAL.DInstruction;
import DAL.DPlayer;

public class UITerminal {

    public void printCurrentJSONFile() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("PROPERTIES OF THE GAME");
        System.out.println(DInstruction.getInstance());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("MONOPOLY GAME");
    }

    public void printBeforeRollDice(DPlayer dPlayer) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Player Type :" + dPlayer.getPiece_type());
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
        System.out.println("Player Location:" + dPlayer.getLocation());
        System.out.println("Player Balance After Rolling Dice:" + dPlayer.getBalance());
        System.out.println("---------------------------------------------------------------------");
    }
}