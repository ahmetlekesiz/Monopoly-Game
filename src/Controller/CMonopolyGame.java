package Controller;

import BL.BMonopolyGame;
import DAL.DInstruction;
import DAL.DJSONReader;
import UI.UITerminal;

class CMonopolyGame {

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
