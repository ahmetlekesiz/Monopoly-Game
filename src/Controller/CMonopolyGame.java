package Controller;

import BL.BMonopolyGame;
import DAL.DInstruction;
import DAL.DJSONReader;
import DAL.DPlayer;
import UI.UITerminal;

public class CMonopolyGame {

    UITerminal uiTerminal = new UITerminal();

    public CMonopolyGame(DPlayer dPlayer){
        uiTerminal.printBeforeRollDİce(dPlayer);
        uiTerminal.printAfterRollDice(dPlayer);
    }

    private UITerminal UITerminal;

    private CMonopolyGame(String JSONInstructionFileName) {
        DJSONReader objDJSONReader = new DJSONReader(JSONInstructionFileName);
        objDJSONReader.initInstructionObject();
        UITerminal = new UITerminal();
        UITerminal.printCurrentJSONFile();
    }

    static CMonopolyGame createMonopolyGameUsingJSONFile(String JSONInstructionFileName) {
        return new CMonopolyGame(JSONInstructionFileName);
    }

    void start() {
        BMonopolyGame.getInstance().startGame(DInstruction.getInstance());
    }

}
