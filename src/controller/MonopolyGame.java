package controller;

import view.terminal.TerminalOutput;

class MonopolyGame {

    private MonopolyGame(String JSONInstructionFileName) {
        TerminalOutput terminalOutput = TerminalOutput.createTerminalOutput(JSONInstructionFileName);
        terminalOutput.printTerminalOutput();
    }

    static MonopolyGame createMonopolyGameUsingJSONFile(String JSONInstructionFileName) {
        return new MonopolyGame(JSONInstructionFileName);
    }
}
