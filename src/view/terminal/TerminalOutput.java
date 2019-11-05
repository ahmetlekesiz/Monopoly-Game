package view.terminal;

import model.Instruction;
import model.JSONReader;

public class TerminalOutput {
    private Instruction currentInstruction;

    private TerminalOutput() {
        JSONReader objJsonReader = new JSONReader("game.json");
        currentInstruction = Instruction.getInstance();
    }

}
