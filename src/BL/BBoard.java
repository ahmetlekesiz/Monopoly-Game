package BL;

import DAL.Instruction;

public class BBoard {

    private static final int SQUARE_NUMBER = 40;
    private BSquare[] squares;
    private static BBoard boardInstance;
    private Instruction instructionInstance;
    private int turnCounter;

    private BBoard() {
        instructionInstance = Instruction.getInstance();
        squares = new BSquare[SQUARE_NUMBER];
        initSquares();
    }

    private void initSquares() {
        for (int i = 0; i < SQUARE_NUMBER; ++i) {
            squares[i] = new BRegularSquare();
        }

    }

    public static BBoard getInstance() {
        return boardInstance;
    }
}
