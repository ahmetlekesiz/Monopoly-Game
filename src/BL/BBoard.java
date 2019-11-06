package BL;

import DAL.DInstruction;
import com.sun.org.apache.bcel.internal.generic.Instruction;

public class BBoard {

    private static final int SQUARE_NUMBER = 40;
    private BSquare[] squares;
    private static BBoard boardInstance;
    private DInstruction instructionInstance;
    private int countOfTaxSquares;

    private BBoard() {
        instructionInstance = DInstruction.getInstance();
        squares = new BSquare[SQUARE_NUMBER];
        countOfTaxSquares = (int) instructionInstance.countOfTaxSquares;
        initSquares();
    }

    private void initSquares() {
        int[] taxSquareLocations = new int[countOfTaxSquares];
        int temp;
        // TODO May return same number optimise
        for(int i = 0; i < countOfTaxSquares; i++){
            temp = (int) (Math.random() * SQUARE_NUMBER);
            taxSquareLocations[i] = temp;
        }
        for (int i = 0; i < SQUARE_NUMBER; ++i) {
            squares[i] = new BRegularSquare();
        }
        for(int i = 0; i < countOfTaxSquares; i++) {
            squares[taxSquareLocations[i]] = new BTaxSquare();
        }
        squares[0] = new BGoSquare();
    }

    public BSquare[] getSquares() {
        return squares;
    }

    public static BBoard getInstance() {
        if(boardInstance == null){
            boardInstance = new BBoard();
        }
        return boardInstance;
    }
}