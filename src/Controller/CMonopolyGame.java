package Controller;

import BL.BMonopolyGame;
import DAL.Instruction;
import DAL.JSONReader;
import UI.TerminalOutput;

class CMonopolyGame {

    private CMonopolyGame(String JSONInstructionFileName) {
        JSONReader objJsonReader = new JSONReader(JSONInstructionFileName);
        objJsonReader.initInstructionObject();
        TerminalOutput terminalOutput = new TerminalOutput();
        terminalOutput.printCurrentJSONFile();
    }

    static CMonopolyGame createMonopolyGameUsingJSONFile(String JSONInstructionFileName) {
        return new CMonopolyGame(JSONInstructionFileName);
    }
    static void start(){

        new BMonopolyGame().startGame(Instruction.getInstance());
    }

}
