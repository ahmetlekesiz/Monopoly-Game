package Controller;

import BL.BMonopolyGame;
import DAL.DInstruction;
import DAL.DJSONReader;
import UI.UITerminal;

class CMonopolyGame {

    private CMonopolyGame(String JSONInstructionFileName) {
        DJSONReader objDJSONReader = new DJSONReader(JSONInstructionFileName);
        objDJSONReader.initInstructionObject();
        UITerminal UITerminal = new UITerminal();
        UITerminal.printCurrentJSONFile();
    }

    static CMonopolyGame createMonopolyGameUsingJSONFile(String JSONInstructionFileName) {
        return new CMonopolyGame(JSONInstructionFileName);
    }
    static void start(){
        System.out.println("Try It");
        System.out.println("Try It");
        new BMonopolyGame().startGame(DInstruction.getInstance());
    }

}
