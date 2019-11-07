package UI;

import Controller.CInstruction;
import Controller.CTerminal;
import DAL.DInstruction;
import DAL.DPlayer;

public class UITerminal {

    CTerminal cTerminal = new CTerminal();

    public void printCurrentJSONFile() {
        cTerminal.printCurrentJSONFile();
    }

    public void printBeforeRollDice(DPlayer dPlayer) {
        cTerminal.printBeforeRollDice(dPlayer);
    }

    public void printAfterRollDice(DPlayer dPlayer){
        cTerminal.printAfterRollDice(dPlayer);
    }
}
