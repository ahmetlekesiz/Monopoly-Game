package model;

public class Instruction {

    private static Instruction instance = new Instruction();

    private Instruction() {

    }

    public static Instruction getInstance() {
        return instance;
    }
}
