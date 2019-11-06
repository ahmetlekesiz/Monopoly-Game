package Controller;

import DAL.JSONReader;

class CMonopolyGame {

    private CMonopolyGame(String JSONInstructionFileName) {
        JSONReader objJsonReader = new JSONReader(JSONInstructionFileName);
        objJsonReader.initInstructionObject();
    }

    static CMonopolyGame createMonopolyGameUsingJSONFile(String JSONInstructionFileName) {
        return new CMonopolyGame(JSONInstructionFileName);
    }
}
