package BL;

import Controller.CTerminal;
import DAL.DInstruction;
import DAL.DPlayer;

public class BTerminal {

    private CTerminal cTerminal = new CTerminal();

    public void printBeforeRollDice(DPlayer dPlayer) {
        cTerminal.printBeforeRollDice(dPlayer);
    }

    public void printAfterRollDice(DPlayer dPlayer){
        cTerminal.printAfterRollDice(dPlayer);
    }
}
