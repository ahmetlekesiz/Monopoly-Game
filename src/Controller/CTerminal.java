package Controller;

import BL.BTerminal;
import DAL.DPlayer;
import UI.UITerminal;

public class CTerminal {

    private UITerminal uiTerminal = new UITerminal();

    public void printBeforeRollDice(DPlayer dPlayer) {
        uiTerminal.printBeforeRollDice(dPlayer);
    }

    public void printAfterRollDice(DPlayer dPlayer){
        uiTerminal.printAfterRollDice(dPlayer);
    }

}
