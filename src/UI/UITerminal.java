package UI;


import Controller.CMonopolyGame;
import DAL.DInstruction;

public class UITerminal {

    CMonopolyGame cMonopolyGame = new CMonopolyGame();

    public void printCurrentJSONFile() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("PROPERTIES OF THE GAME");
        System.out.println(DInstruction.getInstance());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("MONOPOLY GAME");
    }

    public void printBeforeRollDİce() {

    }

    public void printAfterRollDice(){

    }
}
