package Controller;

public class Main {

    public static final String INSTRUCTION_FILENAME = "game.json";

    public static void main(String[] args) {
        CMonopolyGame monopolyGame = CMonopolyGame.getInstance(INSTRUCTION_FILENAME);
        monopolyGame.start();
    }
}
