package Controller;

import BL.BMonopolyGame;
import BL.BPlayer;
import DAL.DInstruction;
import DAL.DJSONReader;
import UI.UITerminal;

public class CMonopolyGame {

    public CMonopolyGame(){
        BPlayer bPlayer = new BPlayer();

    }

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
        new BMonopolyGame().startGame(DInstruction.getInstance());
    }

}
