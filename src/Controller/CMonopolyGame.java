package Controller;

import BL.BMonopolyGame;
import DAL.DInstruction;
import DAL.DJSONReader;
import DAL.DPlayer;
import UI.UITerminal;

public class CMonopolyGame {

    public UITerminal UITerminal;
    private static CMonopolyGame instance;

    private CMonopolyGame(String JSONInstructionFileName) {
        DJSONReader objDJSONReader = new DJSONReader(JSONInstructionFileName);
        objDJSONReader.initInstructionObject();
        UITerminal = new UITerminal();
        UITerminal.printCurrentJSONFile();
    }

    public static CMonopolyGame getInstance() {
        return instance;
    }

    public static CMonopolyGame getInstance(String JSONInstructionFileName) {
        if (instance == null) {
            instance = new CMonopolyGame(JSONInstructionFileName);
        }
        return instance;
    }

    void start() {
        BMonopolyGame.getInstance().startGame(DInstruction.getInstance());
    }

}
