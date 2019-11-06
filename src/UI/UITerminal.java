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

    public void printBeforeRollDİce(DPlayer dPlayer) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Player Type:"+dPlayer.getPiece_type());
        System.out.println("Player Round Value:"+dPlayer.getRoundValue());
        System.out.println("Player Location:"+dPlayer.getLocation());
        System.out.println("---------------------------------------------------------------------");
    }

    public void printAfterRollDice(DPlayer dPlayer){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Player Location:"+dPlayer.getLocation());
        System.out.println("Player Balance:"+dPlayer.getBalance());
        System.out.println("---------------------------------------------------------------------");
    }
}
