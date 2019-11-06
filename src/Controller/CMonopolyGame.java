package Controller;

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


}
