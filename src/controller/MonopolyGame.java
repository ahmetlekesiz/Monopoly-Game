package controller;

class MonopolyGame {

    private MonopolyGame(String JSONInstructionFileName) {
        System.out.printf("Monopoly game created according to [%s].\n", JSONInstructionFileName);
    }

    static MonopolyGame createMonopolyGameUsingJSONFile(String JSONInstructionFileName) {
        return new MonopolyGame(JSONInstructionFileName);
    }
}
