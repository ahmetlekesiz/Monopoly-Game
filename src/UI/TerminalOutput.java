package UI;

import DAL.DInstruction;
import DAL.JSONReader;

public class TerminalOutput {
    private DInstruction currentInstruction;

    private TerminalOutput(String JSONFileName) {
        JSONReader objJsonReader = new JSONReader(JSONFileName);
        objJsonReader.initInstructionObject();
        currentInstruction = DInstruction.getInstance();
    }

    public static TerminalOutput createTerminalOutput(String JSONFileName) {
        return new TerminalOutput(JSONFileName);
    }

    public void printTerminalOutput() {
        System.out.println(currentInstruction.toString());
    }

}
