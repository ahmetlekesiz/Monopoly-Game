package view.terminal;

import model.Instruction;
import model.JSONReader;

public class TerminalOutput {
    private Instruction currentInstruction;

    private TerminalOutput(String JSONFileName) {
        JSONReader objJsonReader = new JSONReader(JSONFileName);
        objJsonReader.initInstructionObject();
        currentInstruction = Instruction.getInstance();
    }

    public static TerminalOutput createTerminalOutput(String JSONFileName) {
        return new TerminalOutput(JSONFileName);
    }

    public void printTerminalOutput() {
        System.out.println(currentInstruction.toString());
    }

}
