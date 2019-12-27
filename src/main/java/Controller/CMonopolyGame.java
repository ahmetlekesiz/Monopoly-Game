package main.java.Controller;

import main.java.BL.BMonopolyGame;
import main.java.DAL.DInstruction;
import DAL.DJSONReader;
import UI.UITerminal;

/**
 * <h>CMonopolyGame</h>
 *
 * <p>Controller for MonopolyGame class which is used during getting data from Data Layer in User Interface and
 * starting game on Main class.</p>
 *
 * @author Ahmet LEKESİZ
 * @version 1.0
 */
public class CMonopolyGame {

    public UITerminal UITerminal;
    private static CMonopolyGame instance;

    private CMonopolyGame(String JSONInstructionFileName) {
        DJSONReader objDJSONReader = new DJSONReader(JSONInstructionFileName);
        objDJSONReader.initInstructionObject();
        UITerminal = UI.UITerminal.getInstance();
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

    /**
     * <p>Starts the game by getting Instructions from Data Layer by using business layer.</p>
     * @return void
     */
    void start() {
        BMonopolyGame.getInstance().startGame(DInstruction.getInstance());
    }

}
