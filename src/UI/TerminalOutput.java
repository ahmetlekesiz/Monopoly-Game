package UI;


public class TerminalOutput {

    private TerminalOutput(String JSONFileName) {

    }

    public static TerminalOutput createTerminalOutput(String JSONFileName) {
        return new TerminalOutput(JSONFileName);
    }

}
