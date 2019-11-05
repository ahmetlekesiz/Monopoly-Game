package Controller;

import UI.TerminalOutput;

class CMonopolyGame {

    private CMonopolyGame(String JSONInstructionFileName) {
        TerminalOutput terminalOutput = TerminalOutput.createTerminalOutput(JSONInstructionFileName);
        terminalOutput.printTerminalOutput();
    }

    static CMonopolyGame createMonopolyGameUsingJSONFile(String JSONInstructionFileName) {
        return new CMonopolyGame(JSONInstructionFileName);
    }
}
