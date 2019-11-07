package Controller;

import BL.BTerminal;
import DAL.DPlayer;

public class CTerminal {

    BTerminal bTerminal = new BTerminal();

    public CTerminal(){
    }

    public void printCurrentJSONFile(){
        bTerminal.printCurrentJSONFile();
    }

    public void printBeforeRollDice(DPlayer dPlayer) {
        bTerminal.printBeforeRollDice(dPlayer);
    }

    public void printAfterRollDice(DPlayer dPlayer){
        bTerminal.printAfterRollDice(dPlayer);
    }

}
